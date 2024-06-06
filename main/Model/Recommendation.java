package main.Model;

import java.util.List;
import java.util.Map;

import main.Model.Components.*;
import main.Model.Filters.*;
import main.Model.Sorter.*;
import main.Model.CompatibilityChecker;
import main.Model.PCBuild.PCBuild;
import main.Model.UserPreferences;

public class Recommendation {
    private DataManager dataManager;
    private UserPreferences userPreferences;

    private PriceFilter priceFilter;
    private PurposeFilter purposeFilter;
    private BrandFilter brandFilter;
    private OtherFilter otherFilter;
    private StorageFilter storageFilter;

    private SortPerformance sortPerformance;
    private SortPrice sortPrice;
    private SortSpecificAttributes sortSpecificAttributes;

    private CompatibilityChecker compatibilityChecking;
    
    private PCBuild PCBuild;

    public Recommendation(DataManager dataManager, UserPreferences userPreferences) {
        this.dataManager = dataManager;
        this.userPreferences = userPreferences;

        this.priceFilter = new PriceFilter();
        this.purposeFilter = new PurposeFilter();
        this.brandFilter = new BrandFilter();
        this.otherFilter = new OtherFilter();
        this.storageFilter = new StorageFilter();

        this.sortPerformance = new SortPerformance();
        this.sortPrice = new SortPrice();
        this.sortSpecificAttributes = new SortSpecificAttributes();
        this.compatibilityChecking = new CompatibilityChecker();
        
        this.PCBuild = new PCBuild(null, null, null, null, null, null, null, null, null, null);
    }

    public void recommendComponents() {
        dataManager.loadData();
        String priceRange = userPreferences.getBudget();

        double totalBudget = totalBudget(priceRange);
        String primaryPurpose = userPreferences.getPurpose();

        Map<String, Double> budgetAllocation = allocateBudget(totalBudget, primaryPurpose);

        // Filtering & Sorting List based on purpose & budget
        List<CPU> filteredCPUs = filterAndSortCPUs();
        List<GPU> filteredGPUs = filterAndSortGPUs();
        List<Ram> filteredRAMs = filterAndSortRAMs();
        List<InternalStorage> filteredInternalStorages = filterAndSortInternalStorages();
        List<HDD> filteredHDDs = filterAndSortHDDs();
        List<SSD> filteredSSDs = filterAndSortSSDs();
        List<Case> filteredCases = filterAndSortCases();
        List<PSU> filteredPSUs = filterAndSortPSUs();
        List<Fan> filteredFans = filterAndSortFans();
        List<MotherBoard> filteredMotherBoards = filterAndSortMotherBoards();

        // For Bottleneck
        double clockSpeed = highestClockSpeed(dataManager.getCpus());
        double coreCount = highestCoreCount(dataManager.getCpus());
        double vram = highestVRAM(dataManager.getGpus());

        // Further processing or selection logic for the final PC build
        for (CPU cpu : filteredCPUs) {
            if (cpu.getPrice() <= budgetAllocation.get("CPU")) {
                for (MotherBoard motherboard : filteredMotherBoards) {
                    if (compatibilityChecking.SocketCompatibility(cpu, motherboard)) {
                        for (GPU gpu : filteredGPUs) {
                            if (gpu.getPrice() <= budgetAllocation.get("GPU") &&
                                compatibilityChecking.BottleneckChecker(gpu, cpu, clockSpeed, coreCount, vram)) {
                                for (Ram ram : filteredRAMs) {
                                    if (ram.getPrice() <= budgetAllocation.get("RAM") &&
                                        compatibilityChecking.MemoryCompatibility(ram, motherboard)) {
                                        if (priceRange.equalsIgnoreCase("low")) { // Split the flow into low and middle/high
                                            if (recommendLowBuild(cpu, gpu, ram, motherboard, budgetAllocation, filteredInternalStorages, filteredHDDs, filteredCases, filteredFans, filteredPSUs)) {
                                                return;
                                            }
                                        } else if (priceRange.equalsIgnoreCase("middle") || priceRange.equalsIgnoreCase("high")) {
                                            if (recommendMidHighBuild(cpu, gpu, ram, motherboard, budgetAllocation, filteredInternalStorages, filteredHDDs, filteredSSDs, filteredCases, filteredFans, filteredPSUs)) {
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("No compatible components found within the specified budget.");
    }

    private boolean recommendLowBuild(CPU cpu, GPU gpu, Ram ram, MotherBoard motherboard, Map<String, Double> budgetAllocation,
                                      List<InternalStorage> filteredInternalStorages, List<HDD> filteredHDDs, List<Case> filteredCases,
                                      List<Fan> filteredFans, List<PSU> filteredPSUs) {
        for (InternalStorage storage : filteredInternalStorages) {
            if (storage.getPrice() <= budgetAllocation.get("Storage")) {
                for (HDD hdd : filteredHDDs) {
                    if (hdd.getPrice() + storage.getPrice() <= budgetAllocation.get("Storage")) {
                        for (Case pcCase : filteredCases) {
                            if (compatibilityChecking.FormFactorCompatibility(pcCase, motherboard)) {
                                for (Fan fan : filteredFans) {
                                    if (fan.getPrice() <= budgetAllocation.get("Fan") && compatibilityChecking.FanCaseCompatibility(fan, pcCase)) {
                                        for (PSU psu : filteredPSUs) {
                                            if (psu.getPrice() <= budgetAllocation.get("PSU") && compatibilityChecking.WattsComputationLow(cpu, gpu, motherboard, ram, storage, hdd, fan, psu)) {

                                                // Components are compatible and within budget
                                                // Display or return the recommended components
                                                System.out.println("Recommended components:");
                                                System.out.println(cpu.toString());
                                                System.out.println(motherboard.toString());
                                                System.out.println(gpu.toString());
                                                System.out.println(ram.toString());
                                                System.out.println(storage.toString());
                                                System.out.println(hdd.toString());
                                                System.out.println(pcCase.toString());
                                                System.err.println(fan.toString());
                                                System.out.println(psu.toString());

                                                //setPCBuild
                                                PCBuild.setCpu(cpu);
                                                PCBuild.setMotherBoard(motherboard);
                                                PCBuild.setGPU(gpu);
                                                PCBuild.setRam(ram);
                                                PCBuild.setInternalStorage(storage);
                                                PCBuild.setHDD(hdd);
                                                PCBuild.setCase(pcCase);
                                                PCBuild.setFan(fan);
                                                PCBuild.setSSD(null);
                                                PCBuild.setPowerSupply(psu);
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean recommendMidHighBuild(CPU cpu, GPU gpu, Ram ram, MotherBoard motherboard, Map<String, Double> budgetAllocation,
                                          List<InternalStorage> filteredInternalStorages, List<HDD> filteredHDDs, List<SSD> filteredSSDs,
                                          List<Case> filteredCases, List<Fan> filteredFans, List<PSU> filteredPSUs) {
        for (InternalStorage storage : filteredInternalStorages) {
            if (storage.getPrice() <= budgetAllocation.get("Storage")) {
                for (HDD hdd : filteredHDDs) {
                    if (hdd.getPrice() + storage.getPrice() <= budgetAllocation.get("Storage")) {
                        for (SSD ssd : filteredSSDs) {
                            if (storage.getPrice() + hdd.getPrice() + ssd.getPrice() <= budgetAllocation.get("Storage")) {
                                for (Case pcCase : filteredCases) {
                                    for (Fan fan : filteredFans) {
                                        if (fan.getPrice() <= budgetAllocation.get("Fan") && compatibilityChecking.FanCaseCompatibility(fan, pcCase)) {
                                            if (compatibilityChecking.FormFactorCompatibility(pcCase, motherboard)) {
                                                for (PSU psu : filteredPSUs) {
                                                    if (psu.getPrice() <= budgetAllocation.get("PSU") && compatibilityChecking.WattsComputationHigh(cpu, gpu, motherboard, ram, storage, ssd, hdd, fan, psu)) {

                                                        // Components are compatible and within budget
                                                        // Display or return the recommended components
                                                        System.out.println("Recommended components:");
                                                        System.out.println(cpu.toString());
                                                        System.out.println(motherboard.toString());
                                                        System.out.println(gpu.toString());
                                                        System.out.println(ram.toString());
                                                        System.out.println(storage.toString());
                                                        System.out.println(hdd.toString());
                                                        System.out.println(ssd.toString());
                                                        System.out.println(pcCase.toString());
                                                        System.out.println(psu.toString());


                                                        PCBuild.setCase(pcCase);
                                                        PCBuild.setCpu(cpu);
                                                        PCBuild.setGPU(gpu);
                                                        PCBuild.setMotherBoard(motherboard);
                                                        PCBuild.setRam(ram);
                                                        PCBuild.setInternalStorage(storage);
                                                        PCBuild.setHDD(hdd);
                                                        PCBuild.setSSD(ssd);
                                                        PCBuild.setFan(fan);
                                                        PCBuild.setPowerSupply(psu);
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    private Map<String, Double> allocateBudget(double totalBudget, String purpose) {
        switch (purpose.toLowerCase()) {
            case "gaming":
                return Map.of(
                    "CPU", totalBudget * 0.25,
                    "GPU", totalBudget * 0.40,
                    "RAM", totalBudget * 0.15,
                    "Storage", totalBudget * 0.10,
                    "PSU", totalBudget * 0.05,
                    "Case", totalBudget * 0.05
                );
            case "workstation":
                return Map.of(
                    "CPU", totalBudget * 0.30,
                    "GPU", totalBudget * 0.25,
                    "RAM", totalBudget * 0.20,
                    "Storage", totalBudget * 0.15,
                    "PSU", totalBudget * 0.05,
                    "Case", totalBudget * 0.05
                );
            case "general":
                return Map.of(
                    "CPU", totalBudget * 0.20,
                    "GPU", totalBudget * 0.20,
                    "RAM", totalBudget * 0.20,
                    "Storage", totalBudget * 0.20,
                    "PSU", totalBudget * 0.10,
                    "Case", totalBudget * 0.10
                );
            default:
                throw new IllegalArgumentException("Invalid purpose");
        }
    }

    private double totalBudget(String priceRange) {
        double baseBudget;
        switch (priceRange.toLowerCase()) {
            case "low":
                baseBudget = 25000;
                break;
            case "middle":
                baseBudget = 50000;
                break;
            case "high":
                baseBudget = 70000;
                break;
            default:
                throw new IllegalArgumentException("Invalid price range: " + priceRange);
        }
        return baseBudget;
        //return adjustBudget(baseBudget, userPreferences);
    }

    //private double adjustBudget(double baseBudget, UserPreferences userPreferences) {
        //if (userPreferences.needsHighEndCooling()) {
            //baseBudget += 5000;
        //}
        //if (userPreferences.needsRGBLighting()) {
            //baseBudget += 3000;
        //}
        //if (userPreferences.needsWiFi()) {
            //baseBudget += 2000;
        //}
        //if (userPreferences.needsBluetooth()) {
            //baseBudget += 1500;
       //}

        //return baseBudget;
    //}

    private List<CPU> filterAndSortCPUs() {
        List<CPU> cpus = priceFilter.filterCPUByPrice(dataManager.getCpus(), userPreferences.getBudget());
        cpus = purposeFilter.filterCPUsByPurpose(cpus, userPreferences.getPurpose());
        cpus = brandFilter.CPUfilterByBrand(cpus, userPreferences.getCpuBrand());
        return sortPerformance.sortCPUByPerformance(cpus);
    }



    private List<GPU> filterAndSortGPUs() {
        List<GPU> gpus = priceFilter.filterGPUByPrice(dataManager.getGpus(), userPreferences.getBudget());
        gpus = purposeFilter.filterGPUsByPurpose(gpus, userPreferences.getPurpose());
        gpus = brandFilter.GPUfilterByBrand(gpus, userPreferences.getGpuBrand());
        return sortPerformance.sortGPUByPerformance(gpus);
    }

    private List<Ram> filterAndSortRAMs() {
        List<Ram> rams = priceFilter.filterRamByPrice(dataManager.getRams(), userPreferences.getBudget());
        rams = purposeFilter.filterRAMsByPurpose(rams, userPreferences.getPurpose());
        rams = otherFilter.filterByRAMNeeds(rams, userPreferences.getRam());
        return sortPerformance.sortRamByPerformance(rams);
    }

    private List<InternalStorage> filterAndSortInternalStorages() {
        List<InternalStorage> storages = priceFilter.filterInternalStorageByPrice(dataManager.getInternalStorages(), userPreferences.getBudget());
        storages = storageFilter.filterInternalStorageByPurposeAndBudget(storages, userPreferences.getPurpose(), userPreferences.getBudget(), userPreferences.getStorage());
        return sortSpecificAttributes.sortInternalStorageByStorage(storages);
    }

    private List<HDD> filterAndSortHDDs() {
        List<HDD> hdds = priceFilter.filterHddByPrice(dataManager.getHdds(), userPreferences.getBudget());
        hdds = storageFilter.filterHDDByPurposeAndBudget(hdds, userPreferences.getPurpose(), userPreferences.getBudget(), userPreferences.getStorage());
        return sortSpecificAttributes.sortHDDbyStorage(hdds);
    }

    private List<SSD> filterAndSortSSDs() {
        List<SSD> ssds = priceFilter.filterSSDByPrice(dataManager.getSsds(), userPreferences.getBudget());
        ssds = storageFilter.filterSSDByPurposeAndBudget(ssds, userPreferences.getPurpose(), userPreferences.getBudget(), userPreferences.getStorage());
        return sortSpecificAttributes.sortSSDbyStorage(ssds);
    }

    private List<Case> filterAndSortCases() {
        List<Case> cases = priceFilter.filterCaseByPrice(dataManager.getCases(), userPreferences.getBudget());
        cases = otherFilter.filterByFormFactor(cases, userPreferences.getFormFactor());
        return sortPrice.sortCasesByPriceDescending(cases);
    }

    private List<PSU> filterAndSortPSUs() {
        List<PSU> psus = priceFilter.filterPSUByPrice(dataManager.getPsus(), userPreferences.getBudget());
        return sortSpecificAttributes.sortPSUbyWattage(psus);
      }
  
      private List<Fan> filterAndSortFans() {
          List<Fan> fans = priceFilter.filterFansByPrice(dataManager.getFans(), userPreferences.getBudget());
          return sortPrice.sortFansByPriceDescending(fans);
      }
  
      private List<MotherBoard> filterAndSortMotherBoards() {
          List<MotherBoard> motherBoards = priceFilter.filterMotherBoardsByPrice(dataManager.getMotherboards(), userPreferences.getBudget());
          return sortPrice.sortMotherBoardDescending(motherBoards);
      }


    private double highestClockSpeed(List<CPU> cpus) {
        return cpus.stream().mapToDouble(CPU::getClockSpeed).max().orElse(0.0);
    }

    private double highestCoreCount(List<CPU> cpus) {
        return cpus.stream().mapToInt(CPU::getCoreCount).max().orElse(0);
    }

    private double highestVRAM(List<GPU> gpus) {
        return gpus.stream().mapToDouble(GPU::getMemory).max().orElse(0.0);
    }
}
