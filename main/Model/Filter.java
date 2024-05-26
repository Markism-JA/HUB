package main.Model;

import main.Model.Components.*;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Filter {


    //Note: Filtering by Price
    public List<CPU> filterCPUByPrice(List<CPU> cpus, String priceRange) {
        switch(priceRange) {
            case "High":
                return cpus.stream().filter(cpu -> cpu.getPrice() >= 15000).collect(Collectors.toList());
            case "Middle":
                return cpus.stream().filter(cpu -> cpu.getPrice() >= 8000).collect(Collectors.toList());
            case "Low":
                return cpus.stream().filter(cpu -> cpu.getPrice() < 8000).collect(Collectors.toList());
        }
    }

    public List<GPU> filterGPUByPrice(List<GPU> gpus, String priceRange) {
        switch(priceRange) {
            case "High":
                return gpus.stream().filter(gpu -> gpu.getPrice() >= 20000).collect(Collectors.toList());
            case "Middle":
                return gpus.stream().filter(gpu -> gpu.getPrice() >= 10000).collect(Collectors.toList());
            case "Low":
                return gpus.stream().filter(gpu -> gpu.getPrice() < 10000).collect(Collectors.toList());
        }
    }

    public List<SSD> filterSSDByPrice (List<SSD> ssds, String priceRange) {
        switch(priceRange) {
            case "High":
                return ssds.stream().filter(SSD -> SSD.getPrice() >= 6000).collect(Collectors.toList());
            case "Middle":
                return ssds.stream().filter(SSD -> SSD.getPrice() >= 2500).collect(Collectors.toList());
            case "Low":
                return ssds.stream().filter(SSD -> SSD.getPrice() < 2500).collect(Collectors.toList());
        }
    }

    public List<HDD> filterHddByPrice (List<HDD> hdds, String priceRange) {
        switch(priceRange) {
            case "High":
                return hdds.stream().filter(HDD -> HDD.getPrice() >= 6000).collect(Collectors.toList());
            case "Middle":
                return hdds.stream().filter(HDD -> HDD.getPrice() >= 3000).collect(Collectors.toList());
            case "Low":
                return hdds.stream().filter(HDD -> HDD.getPrice() < 3000).collect(Collectors.toList());
        }
    }

    public List<MotherBoard> filterMotherBoardsByPrice (List<MotherBoard> motherBoards, String priceRance) {
        switch(priceRance) {
            case "High":
                return motherBoards.stream().filter(motherBoard -> motherBoard.getPrice() >= 10000).collect(Collectors.toList());
            case "Middle":
                return motherBoards.stream().filter(motherBoard -> motherBoard.getPrice() >= 3500).collect(Collectors.toList());
            case "Low":
                return motherBoards.stream().filter(motherBoard -> motherBoard.getPrice() < 3500).collect(Collectors.toList());
        }
    }

    public List<InternalStorage> filterInternalStorageByPrice (List<InternalStorage> internalStorages, String priceRange) {
        switch(priceRange) {
            case "High":
                return internalStorages.stream().filter(internalStorage -> internalStorage.getPrice() >= 7000).collect(Collectors.toList());
            case "Middle":
                return internalStorages.stream().filter(internalStorage -> internalStorage.getPrice() >= 3500).collect(Collectors.toList());
            case "Low":
                return internalStorages.stream().filter(internalStorage -> internalStorage.getPrice() < 3500).collect(Collectors.toList());
        }
    }

    public List<Ram> filterRamByPrice(List<Ram> rams, String priceRange) {
        switch(priceRange) {
            case "High":
                return rams.stream().filter(cpu -> cpu.getPrice() >= 7500).collect(Collectors.toList());
            case "Middle":
                return rams.stream().filter(cpu -> cpu.getPrice() >= 2500).collect(Collectors.toList());
            case "Low":
                return rams.stream().filter(cpu -> cpu.getPrice() < 2500).collect(Collectors.toList());
            }
    }

    public List<PSU> filterPSUByPrice(List<PSU> psus, String priceRange) {
        switch(priceRange) {
            case "High":
                return psus.stream().filter(PSU -> PSU.getPrice() >= 5000).collect(Collectors.toList());
            case "Middle":
                return psus.stream().filter(PSU -> PSU.getPrice() >= 2000).collect(Collectors.toList());
            case "Low":
                return psus.stream().filter(PSU -> PSU.getPrice() < 2000).collect(Collectors.toList());
        }
    }

    public List<Case> filterCaseByPrice(List<Case> cases, String priceRange) {
        switch(priceRange) {
            case "High":
                return cases.stream().filter(Case -> Case.getPrice() >= 5000).collect(Collectors.toList());
            case "Middle":
                return cases.stream().filter(Case -> Case.getPrice() >= 2000).collect(Collectors.toList());
            case "Low":
                return cases.stream().filter(Case -> Case.getPrice() < 2000).collect(Collectors.toList());
        }
    }

    public List<Fan> filterFansByPrice(List<Fan> fans, String priceRange) {
        switch(priceRange) {
            case "High":
            return fans.stream().filter(Fan -> Fan.getPrice() >= 4000).collect(Collectors.toList());
            case "Middle":
            return fans.stream().filter(Fan ->  Fan.getPrice() >= 1500).collect(Collectors.toList());
            case "Low":
            return fans.stream().filter(Fan -> Fan.getPrice() < 1500).collect(Collectors.toList());

        }
    }


    //FilterByPurpose
    public List<CPU> filterCPUsByPurpose(List<CPU> cpus, String purpose) {
        switch (purpose) {
            case "Gaming":
                return cpus.stream().filter(cpu -> cpu.getClockSpeed() >= 3.5 && cpu.getCoreCount() >= 4).collect(Collectors.toList());
            case "Workstation":
                return cpus.stream().filter(cpu -> cpu.getCoreCount() >= 8).collect(Collectors.toList());
            case "General Use":
                return cpus.stream().filter(cpu -> cpu.getClockSpeed() >= 2.0).collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Invalid primary purpose: " + purpose);
        }
    }

    public List<GPU> filterGPUsByPurpose(List<GPU> gpus, String purpose) {
        switch (purpose) {
            case "Gaming":
                return gpus.stream().filter(gpu -> gpu.getMemory() >= 4).collect(Collectors.toList());
            case "Workstation":
                return gpus.stream().filter(gpu -> gpu.getMemory() >= 8).collect(Collectors.toList());
            case "General Use":
                return gpus.stream().filter(gpu -> gpu.getPrice() <= 8000).collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Invalid primary purpose: " + purpose);
        }
    }

    public List<Ram> filterRAMsByPurpose(List<Ram> rams, String purpose) {
        switch (purpose) {
            case "Gaming":
                return rams.stream().filter(ram -> ram.getCapacity() >= 16).collect(Collectors.toList());
            case "Workstation":
                return rams.stream().filter(ram -> ram.getCapacity() >= 32).collect(Collectors.toList());
            case "General Use":
                return rams.stream().filter(ram -> ram.getCapacity() >= 8).collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Invalid primary purpose: " + purpose);
        }
    }

    public List<InternalStorage> filterStoragesByPurpose(List<InternalStorage> storages, String purpose) {
        switch (purpose) {
            case "Gaming":
                return storages.stream().filter(storage -> storage.getStorageSize() >= 512).collect(Collectors.toList());
            case "Workstation":
                return storages.stream().filter(storage -> storage.getType().equalsIgnoreCase("SSD")).collect(Collectors.toList());
            case "General Use":
                return storages.stream().filter(storage -> storage.getType().equalsIgnoreCase("SSD") || storage.getType().equalsIgnoreCase("HDD")).collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Invalid primary purpose: " + purpose);
        }
    }

    public List<Component> filterByBrand(List<Component> components, String brand) {
        if (brand.equalsIgnoreCase("No Preference")) {
            return components;
        }
        return components.stream().filter(component -> component.getBrand().equalsIgnoreCase(brand)).collect(Collectors.toList());
    }

    public List<InternalStorage> filterByStorageNeeds(List<InternalStorage> storages, int storageNeeds) {
        return storages.stream().filter(storage -> storage.getCapacity() == storageNeeds).collect(Collectors.toList());
    }

    public List<Ram> filterByRAMNeeds(List<Ram> rams, int ramNeeds) {
        return rams.stream().filter(ram -> ram.getCapacity() == ramNeeds).collect(Collectors.toList());
    }
}
