package main.Model;

import java.util.List;
import java.util.Map;

import main.Model.Components.*;
import main.Model.Filters.*;
import main.Model.Sorter.*;
import main.Model.CompatibilityChecker;
import main.Model.PCBuild;
import main.Model.UserPreferences;


public class Recommendation {
    private DataManager dataManager;
    private UserPreferences userPreferences;

    private SortPerformance sortPerformance;
    private SortPrice sortPrice;
    private SortSpecificAttributes sortSpecificAttributes;

    private CompatibilityChecker compatibilityChecking;

    public Recommendation(DataManager dataManager, UserPreferences userPreferences) {
        this.dataManager = dataManager;
        this.userPreferences = userPreferences;

        this.sortPerformance = new SortPerformance();
        this.sortPrice = new SortPrice();
        this.sortSpecificAttributes = new SortSpecificAttributes();
        this.compatibilityChecking = new CompatibilityChecker();
    }

    public PCBuild recommendComponents() {
        dataManager.loadData();
        String priceRange = userPreferences.getBudget();

        double totalBudget = totalBudget(priceRange);
        String primaryPurpose = userPreferences.getPurpose();

        Map<String, Double> budgetAllocation = allocateBudget(totalBudget, primaryPurpose);

        List<CPU> filteredCPUs = filterAndSortCPUs();
        List<GPU> filteredGPUs = filterAndSortGPUs();
        List<Ram> filteredRAMs = filterAndSortRAMs();
        List<InternalStorage> filteredInternalStorages = filterAndSortInternalStorages();
        List<Case> filteredCases = filterAndSortCases();
        List<PSU> filteredPSUs = filterAndSortPSUs();
        List<Fan> filteredFans = filterAndSortFans();
        List<MotherBoard> filteredMotherBoards = filterAndSortMotherBoards();

        double clockSpeed = highestClockSpeed(filteredCPUs);
        double coreCount = highestCoreCount(filteredCPUs);
        double vram = highestVRAM(filteredGPUs);

        if (filteredCPUs.isEmpty() || filteredGPUs.isEmpty() || filteredRAMs.isEmpty() ||
            filteredInternalStorages.isEmpty() || filteredCases.isEmpty() || filteredPSUs.isEmpty() ||
            filteredFans.isEmpty() || filteredMotherBoards.isEmpty()) {
            System.out.println("No compatible components found within the specified budget and criteria.");
            return null;
        }

        try {
            boolean foundComponents = false;
        
            for (CPU cpu : filteredCPUs) {
                if (cpu.getPrice() <= budgetAllocation.get("CPU")) {
                    for (MotherBoard motherboard : filteredMotherBoards) {
                        if (compatibilityChecking.SocketCompatibility(cpu, motherboard)) {
                            for (GPU gpu : filteredGPUs) {
                                if (gpu.getPrice() <= budgetAllocation.get("GPU") && compatibilityChecking.BottleneckChecker(gpu, cpu, clockSpeed, coreCount, vram)) {
                                    for (Ram ram : filteredRAMs) {
                                        if (ram.getPrice() <= budgetAllocation.get("RAM") && compatibilityChecking.MemoryCompatibility(ram, motherboard)) {
                                            for (Case pCase : filteredCases) {
                                                if (pCase.getPrice() <= budgetAllocation.get("Case")) {
                                                    for (Fan fan : filteredFans) {
                                                        if (fan.getPrice() <= budgetAllocation.get("Fan") && compatibilityChecking.FanCaseCompatibility(fan, pCase)) {
                                                            for (PSU psu : filteredPSUs) {
                                                                if (psu.getPrice() <= budgetAllocation.get("PSU") && compatibilityChecking.WattsComputation(cpu, gpu, motherboard, ram, psu)) {
                                                                    // Found compatible components
                                                                    foundComponents = true;
                                                                    //System.out.println(psu.toString());
                                                                    //System.out.println(cpu.toString());
                                                                    //System.out.println(gpu.toString());
                                                                    //System.out.println(ram.toString());
                                                                    //System.out.println(motherboard.toString());
                                                                    //System.out.println(pCase.toString());
                                                                    //System.out.println(fan.toString());
        
                                                                    // Return the compatible PCBuild
                                                                    return new PCBuild(cpu, gpu, pCase, motherboard, ram, fan, psu);
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
                        if (foundComponents) {
                            break; // Break out of the motherboard loop
                        }
                    }
                    if (foundComponents) {
                        break; // Break out of the CPU loop
                    }
                }
                if (foundComponents) {
                    break; // Break out of the main loop
                }
            }
        
            if (!foundComponents) {
                System.out.println("No compatible components found within the specified budget.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while recommending components: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null; // Return null if no compatible components are found
    }        
    
private Map<String, Double> allocateBudget(double totalBudget, String purpose) {
    switch (purpose.toLowerCase()) {
        case "gaming":
            return Map.of(
                    "CPU", totalBudget * 0.25,
                    "GPU", totalBudget * 0.40,
                    "RAM", totalBudget * 0.15,
                    "PSU", totalBudget * 0.05,
                    "Case", totalBudget * 0.04,  // Reduced allocation for case
                    "Fan", totalBudget * 0.01  // Budget for a basic fan
            );
        case "workstation":
            return Map.of(
                    "CPU", totalBudget * 0.30,
                    "GPU", totalBudget * 0.20,
                    "RAM", totalBudget * 0.25,  // Increased allocation for RAM
                    "PSU", totalBudget * 0.05,
                    "Case", totalBudget * 0.04,  // Reduced allocation for case
                    "Fan", totalBudget * 0.01  // Budget for a basic fan
            );
        case "general":
            return Map.of(
                    "CPU", totalBudget * 0.20,
                    "GPU", totalBudget * 0.20,
                    "RAM", totalBudget * 0.20,
                    "PSU", totalBudget * 0.10,  // Increased allocation for PSU
                    "Case", totalBudget * 0.08,  // Increased allocation for case
                    "Fan", totalBudget * 0.02  // Budget for a decent fan
            );
        default:
            throw new IllegalArgumentException("Invalid purpose");
    }
}

    
    private double totalBudget(String priceRange) {
        double baseBudget;
        switch (priceRange.toLowerCase()) {
            case "low":
                baseBudget = 35000;
                break;
            case "middle":
                baseBudget = 70000;
                break;
            case "high":
                baseBudget = 90000;
                break;
            default:
                throw new IllegalArgumentException("Invalid price range: " + priceRange);
        }
        return baseBudget;
    }

    private List<CPU> filterAndSortCPUs() {
        //List<CPU> cpus = priceFilter.filterCPUByPrice(dataManager.getCpus(), userPreferences.getBudget());
        List<CPU> cpus = dataManager.getCpus();
        //cpus = purposeFilter.filterCPUsByPurpose(cpus, userPreferences.getPurpose());
        //cpus = brandFilter.CPUfilterByBrand(cpus, userPreferences.getCpuBrand());
        return sortPerformance.sortCPUByPerformance(cpus);
    }



    private List<GPU> filterAndSortGPUs() {
        //List<GPU> gpus = priceFilter.filterGPUByPrice(dataManager.getGpus(), userPreferences.getBudget());
        List<GPU> gpus = dataManager.getGpus();
        //gpus = purposeFilter.filterGPUsByPurpose(gpus, userPreferences.getPurpose());
        //gpus = brandFilter.GPUfilterByBrand(gpus, userPreferences.getGpuBrand());
        return sortPerformance.sortGPUByPerformance(gpus);
    }

    private List<Ram> filterAndSortRAMs() {
        //List<Ram> rams = priceFilter.filterRamByPrice(dataManager.getRams(), userPreferences.getBudget());
        List<Ram> rams = dataManager.getRams();
        //rams = purposeFilter.filterRAMsByPurpose(rams, userPreferences.getPurpose());
        //rams = otherFilter.filterByRAMNeeds(rams, userPreferences.getRam());
        return sortPerformance.sortRamByPerformance(rams);
    }

    private List<InternalStorage> filterAndSortInternalStorages() {
        //List<InternalStorage> storages = priceFilter.filterInternalStorageByPrice(dataManager.getInternalStorages(), userPreferences.getBudget());
        List<InternalStorage> storages = dataManager.getInternalStorages();
        //storages = storageFilter.filterInternalStorageByPurposeAndBudget(storages, userPreferences.getPurpose(), userPreferences.getBudget(), userPreferences.getStorage());
        return sortSpecificAttributes.sortInternalStorageByStorage(storages);
    }

    private List<Case> filterAndSortCases() {
        //List<Case> cases = priceFilter.filterCaseByPrice(dataManager.getCases(), userPreferences.getBudget());
        List<Case> cases = dataManager.getCases();
        //cases = otherFilter.filterByFormFactor(cases, userPreferences.getFormFactor());
        return sortPrice.sortCasesByPriceDescending(cases);
    }

    private List<PSU> filterAndSortPSUs() {
        //List<PSU> psus = priceFilter.filterPSUByPrice(dataManager.getPsus(), userPreferences.getBudget());
        List<PSU> psus = dataManager.getPsus();
        return sortSpecificAttributes.sortPSUbyWattage(psus);
      }
  
      private List<Fan> filterAndSortFans() {
          //List<Fan> fans = priceFilter.filterFansByPrice(dataManager.getFans(), userPreferences.getBudget());
          List<Fan> fans = dataManager.getFans();
          return sortPrice.sortFansByPriceDescending(fans);
      }
  
      private List<MotherBoard> filterAndSortMotherBoards() {
          //List<MotherBoard> motherBoards = priceFilter.filterMotherBoardsByPrice(dataManager.getMotherboards(), userPreferences.getBudget());
          List<MotherBoard> motherBoards = dataManager.getMotherboards();
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
