package main.Model;

import java.util.List;
import main.Model.Components.*;
import main.Model.Filters.*;
import main.Model.Sorter.*;
import main.Model.CompatibilityChecker;
import java.util.Map;


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
    }

    public void recommendComponents() {
        dataManager.loadData();
        String priceRange = userPreferences.getBudget();

        double totalBudget = totalBudget(priceRange, userPreferences);
        String primaryPurpose = userPreferences.getPurpose();

        Map<String, Double> budgetAllocation = allocateBudget(totalBudget, primaryPurpose);

        //Filtering & Sorting List based on purpose & budget
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

        //For Bottleneck
        double clockSpeed = highestClockSpeed(dataManager.getCpus());
        double coreCount = highestCoreCount(dataManager.getCpus());
        double vram = highestVRAM(dataManager.getGpus());


// Further processing or selection logic for the final PC build
for (CPU cpu : filteredCPUs) {
    if (cpu.getPrice() <= budgetAllocation.get("CPU")) {
        for (MotherBoard motherboard : filteredMotherBoards) {
            if (compatibilityChecking.SocketCompatibility(cpu, motherboard)) {
                for (GPU gpu : filteredGPUs) {
                    if (gpu.getPrice() <= budgetAllocation.get("GPU") && compatibilityChecking.BottleneckChecker(gpu, cpu, clockSpeed, coreCount, vram)) {
                        for (Ram ram : filteredRAMs) {
                            if (ram.getPrice() <= budgetAllocation.get("RAM") && compatibilityChecking.MemoryCompatibility(ram, motherboard)) {
                                if (priceRange.equalsIgnoreCase("low")) {
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
                                } else if (priceRange.equalsIgnoreCase("middle") || priceRange.equalsIgnoreCase("high")) {
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

System.out.println("No compatible components found within the specified budget.");
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

    private double totalBudget(String priceRange, UserPreferences userPreferences) {
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

      //getMaxDataField
      private double highestClockSpeed(List <CPU> input) {
        List<CPU> cpus = input;
        double MAX = 0.0;
        for (CPU cpu: cpus) {
            if (cpu.getClockSpeed() > MAX) {
                return MAX = cpu.getClockSpeed();
            }
        }
        return MAX;
    }

    private double highestCoreCount(List <CPU> input) {
        List<CPU> cpus = input;
        double MAX = 0.0;
        for (CPU cpu: cpus) {
            if (cpu.getCoreCount() > MAX) {
                return MAX = cpu.getCoreCount();
            }
        }
        return MAX;
    }

    private double highestVRAM(List <GPU> input) {
        List<GPU> gpus = input;
        double MAX = 0.0;
        for (GPU gpu: gpus) {
            if (gpu.getMemory() > MAX) {
                return MAX = gpu.getMemory();
            }
        }
        return MAX;
    }
}
