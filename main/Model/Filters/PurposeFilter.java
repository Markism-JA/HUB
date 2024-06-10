package main.Model.Filters;

import main.Model.Components.*;
import java.util.List;
import java.util.stream.Collectors;

public class PurposeFilter {

    private void validatePurpose(String purpose) {
        if (purpose == null || purpose.trim().isEmpty()) {
            throw new IllegalArgumentException("Purpose cannot be null or empty");
        }
    }

    public List<CPU> filterCPUsByPurpose(List<CPU> cpus, String purpose) {
        validatePurpose(purpose);
        if (cpus == null) {
            throw new IllegalArgumentException("CPU list cannot be null");
        }

        try {
            switch (purpose.toLowerCase()) {
                case "gaming":
                    return cpus.stream().filter(cpu -> cpu.getClockSpeed() >= 3.5 && cpu.getCoreCount() >= 4).collect(Collectors.toList());
                case "workstation":
                    return cpus.stream().filter(cpu -> cpu.getCoreCount() >= 8).collect(Collectors.toList());
                case "general":
                    return cpus.stream().filter(cpu -> cpu.getClockSpeed() >= 2.0).collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Invalid primary purpose: " + purpose);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering CPUs by purpose", e);
        }
    }

    public List<GPU> filterGPUsByPurpose(List<GPU> gpus, String purpose) {
        validatePurpose(purpose);
        if (gpus == null) {
            throw new IllegalArgumentException("GPU list cannot be null");
        }

        try {
            switch (purpose.toLowerCase()) {
                case "gaming":
                    return gpus.stream().filter(gpu -> gpu.getMemory() >= 4).collect(Collectors.toList());
                case "workstation":
                    return gpus.stream().filter(gpu -> gpu.getMemory() >= 8).collect(Collectors.toList());
                case "general":
                    return gpus.stream().filter(gpu -> gpu.getPrice() <= 8000).collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Invalid primary purpose: " + purpose);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering GPUs by purpose", e);
        }
    }

    public List<Ram> filterRAMsByPurpose(List<Ram> rams, String purpose) {
        validatePurpose(purpose);
        if (rams == null) {
            throw new IllegalArgumentException("RAM list cannot be null");
        }

        try {
            switch (purpose.toLowerCase()) {
                case "gaming":
                    return rams.stream().filter(ram -> ram.getCapacity() >= 16).collect(Collectors.toList());
                case "workstation":
                    return rams.stream().filter(ram -> ram.getCapacity() >= 32).collect(Collectors.toList());
                case "general":
                    return rams.stream().filter(ram -> ram.getCapacity() >= 8).collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Invalid primary purpose: " + purpose);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering RAMs by purpose", e);
        }
    }
}
