package main.Model.Filters;

import main.Model.Components.*;
import java.util.List;
import java.util.stream.Collectors;

public class PriceFilter {
public List<CPU> filterCPUByPrice(List<CPU> cpus, String priceRange) {
        switch(priceRange) {
            case "High":
                return cpus.stream().filter(cpu -> cpu.getPrice() >= 15000).collect(Collectors.toList());
            case "Middle":
                return cpus.stream().filter(cpu -> cpu.getPrice() >= 8000).collect(Collectors.toList());
            case "Low":
                return cpus.stream().filter(cpu -> cpu.getPrice() < 8000).collect(Collectors.toList());
        }
        return cpus;
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
        return gpus;
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
        return ssds;
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
        return hdds;
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
        return motherBoards;
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
        return internalStorages;
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
        return rams;
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
        return psus;
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
        return cases;
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
        return fans;
    }
}
