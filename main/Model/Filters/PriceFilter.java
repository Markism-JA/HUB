package main.Model.Filters;

import main.Model.Components.*;
import java.util.List;
import java.util.stream.Collectors;

public class PriceFilter {

    private void validatePriceRange(String priceRange) {
        if (priceRange == null || priceRange.trim().isEmpty()) {
            throw new IllegalArgumentException("Price range cannot be null or empty");
        }
        if (!priceRange.equalsIgnoreCase("High") && 
            !priceRange.equalsIgnoreCase("Middle") && 
            !priceRange.equalsIgnoreCase("Low")) {
            throw new IllegalArgumentException("Invalid price range: " + priceRange);
        }
    }

    public List<CPU> filterCPUByPrice(List<CPU> cpus, String priceRange) {
        validatePriceRange(priceRange);
        if (cpus == null) {
            throw new IllegalArgumentException("CPU list cannot be null");
        }

        try {
            switch(priceRange.toLowerCase()) {
                case "high":
                    return cpus.stream().filter(cpu -> cpu.getPrice() >= 15000).collect(Collectors.toList());
                case "middle":
                    return cpus.stream().filter(cpu -> cpu.getPrice() >= 8000 && cpu.getPrice() < 15000).collect(Collectors.toList());
                case "low":
                    return cpus.stream().filter(cpu -> cpu.getPrice() < 8000).collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Unexpected value: " + priceRange);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering CPUs by price", e);
        }
    }

    public List<GPU> filterGPUByPrice(List<GPU> gpus, String priceRange) {
        validatePriceRange(priceRange);
        if (gpus == null) {
            throw new IllegalArgumentException("GPU list cannot be null");
        }

        try {
            switch(priceRange.toLowerCase()) {
                case "high":
                    return gpus.stream().filter(gpu -> gpu.getPrice() >= 20000).collect(Collectors.toList());
                case "middle":
                    return gpus.stream().filter(gpu -> gpu.getPrice() >= 10000 && gpu.getPrice() < 20000).collect(Collectors.toList());
                case "low":
                    return gpus.stream().filter(gpu -> gpu.getPrice() < 10000).collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Unexpected value: " + priceRange);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering GPUs by price", e);
        }
    }

    public List<SSD> filterSSDByPrice(List<SSD> ssds, String priceRange) {
        validatePriceRange(priceRange);
        if (ssds == null) {
            throw new IllegalArgumentException("SSD list cannot be null");
        }

        try {
            switch(priceRange.toLowerCase()) {
                case "high":
                    return ssds.stream().filter(ssd -> ssd.getPrice() >= 6000).collect(Collectors.toList());
                case "middle":
                    return ssds.stream().filter(ssd -> ssd.getPrice() >= 2500 && ssd.getPrice() < 6000).collect(Collectors.toList());
                case "low":
                    return ssds.stream().filter(ssd -> ssd.getPrice() < 2500).collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Unexpected value: " + priceRange);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering SSDs by price", e);
        }
    }

    public List<HDD> filterHDDByPrice(List<HDD> hdds, String priceRange) {
        validatePriceRange(priceRange);
        if (hdds == null) {
            throw new IllegalArgumentException("HDD list cannot be null");
        }

        try {
            switch(priceRange.toLowerCase()) {
                case "high":
                    return hdds.stream().filter(hdd -> hdd.getPrice() >= 6000).collect(Collectors.toList());
                case "middle":
                    return hdds.stream().filter(hdd -> hdd.getPrice() >= 3000 && hdd.getPrice() < 6000).collect(Collectors.toList());
                case "low":
                    return hdds.stream().filter(hdd -> hdd.getPrice() < 3000).collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Unexpected value: " + priceRange);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering HDDs by price", e);
        }
    }

    public List<MotherBoard> filterMotherBoardsByPrice(List<MotherBoard> motherBoards, String priceRange) {
        validatePriceRange(priceRange);
        if (motherBoards == null) {
            throw new IllegalArgumentException("MotherBoard list cannot be null");
        }

        try {
            switch(priceRange.toLowerCase()) {
                case "high":
                    return motherBoards.stream().filter(motherBoard -> motherBoard.getPrice() >= 10000).collect(Collectors.toList());
                case "middle":
                    return motherBoards.stream().filter(motherBoard -> motherBoard.getPrice() >= 3500 && motherBoard.getPrice() < 10000).collect(Collectors.toList());
                case "low":
                    return motherBoards.stream().filter(motherBoard -> motherBoard.getPrice() < 3500).collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Unexpected value: " + priceRange);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering MotherBoards by price", e);
        }
    }

    public List<InternalStorage> filterInternalStorageByPrice(List<InternalStorage> internalStorages, String priceRange) {
        validatePriceRange(priceRange);
        if (internalStorages == null) {
            throw new IllegalArgumentException("InternalStorage list cannot be null");
        }

        try {
            switch(priceRange.toLowerCase()) {
                case "high":
                    return internalStorages.stream().filter(internalStorage -> internalStorage.getPrice() >= 7000).collect(Collectors.toList());
                case "middle":
                    return internalStorages.stream().filter(internalStorage -> internalStorage.getPrice() >= 3500 && internalStorage.getPrice() < 7000).collect(Collectors.toList());
                case "low":
                    return internalStorages.stream().filter(internalStorage -> internalStorage.getPrice() < 3500).collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Unexpected value: " + priceRange);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering InternalStorage by price", e);
        }
    }

    public List<Ram> filterRamByPrice(List<Ram> rams, String priceRange) {
        validatePriceRange(priceRange);
        if (rams == null) {
            throw new IllegalArgumentException("RAM list cannot be null");
        }

        try {
            switch(priceRange.toLowerCase()) {
                case "high":
                    return rams.stream().filter(ram -> ram.getPrice() >= 7500).collect(Collectors.toList());
                case "middle":
                    return rams.stream().filter(ram -> ram.getPrice() >= 2500 && ram.getPrice() < 7500).collect(Collectors.toList());
                case "low":
                    return rams.stream().filter(ram -> ram.getPrice() < 2500).collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Unexpected value: " + priceRange);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering RAM by price", e);
        }
    }

    public List<PSU> filterPSUByPrice(List<PSU> psus, String priceRange) {
        validatePriceRange(priceRange);
        if (psus == null) {
            throw new IllegalArgumentException("PSU list cannot be null");
        }

        try {
            switch(priceRange.toLowerCase()) {
                case "high":
                    return psus.stream().filter(psu -> psu.getPrice() >= 5000).collect(Collectors.toList());
                case "middle":
                    return psus.stream().filter(psu -> psu.getPrice() >= 2000 && psu.getPrice() < 5000).collect(Collectors.toList());
                case "low":
                    return psus.stream().filter(psu -> psu.getPrice() < 2000).collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Unexpected value: " + priceRange);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering PSUs by price", e);
        }
    }

    public List<Case> filterCaseByPrice(List<Case> cases, String priceRange) {
        validatePriceRange(priceRange);
        if (cases == null) {
            throw new IllegalArgumentException("Case list cannot be null");
        }

        try {
            switch(priceRange.toLowerCase()) {
                case "high":
                    return cases.stream().filter(caseObj -> caseObj.getPrice() >= 5000).collect(Collectors.toList());
                case "middle":
                    return cases.stream().filter(caseObj -> caseObj.getPrice() >= 2000 && caseObj.getPrice() < 5000).collect(Collectors.toList());
                case "low":
                    return cases.stream().filter(caseObj -> caseObj.getPrice() < 2000).collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Unexpected value: " + priceRange);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering Cases by price", e);
        }
    }

    public List<Fan> filterFansByPrice(List<Fan> fans, String priceRange) {
        validatePriceRange(priceRange);
        if (fans == null) {
            throw new IllegalArgumentException("Fan list cannot be null");
        }

        try {
            switch(priceRange.toLowerCase()) {
                case "high":
                    return fans.stream().filter(fan -> fan.getPrice() >= 4000).collect(Collectors.toList());
                case "middle":
                    return fans.stream().filter(fan -> fan.getPrice() >= 1500 && fan.getPrice() < 4000).collect(Collectors.toList());
                case "low":
                    return fans.stream().filter(fan -> fan.getPrice() < 1500).collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Unexpected value: " + priceRange);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering Fans by price", e);
        }
    }
}
