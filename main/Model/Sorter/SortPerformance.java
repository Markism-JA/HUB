package main.Model.Sorter;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import main.Model.Components.CPU;
import main.Model.Components.GPU;
import main.Model.Components.Ram;

public class SortPerformance {

    public List<CPU> sortCPUByPerformance(List<CPU> cpus) {
        Objects.requireNonNull(cpus, "CPU list cannot be null");
        return cpus.stream()
                .sorted(Comparator.comparingInt(CPU::getCoreCount).reversed()
                        .thenComparing(Comparator.comparingDouble(CPU::getClockSpeed).reversed()))
                .collect(Collectors.toList());
    }

    public List<GPU> sortGPUByPerformance(List<GPU> gpus) {
        Objects.requireNonNull(gpus, "GPU list cannot be null");
        return gpus.stream()
                .sorted(Comparator.comparingInt(GPU::getMemory).reversed())
                .collect(Collectors.toList());
    }

    public List<Ram> sortRamByPerformance(List<Ram> rams) {
        Objects.requireNonNull(rams, "RAM list cannot be null");
        return rams.stream()
                .sorted(Comparator.comparingInt(Ram::getCapacity).reversed())
                .collect(Collectors.toList());
    }

}
