package main.Model.Sorter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import main.Model.Components.*;

public class SortPerformance {
  
  public List<CPU> sortCPUByPerformance(List<CPU> cpus) {
    return cpus.stream().sorted(Comparator.comparingInt(CPU::getCoreCount).reversed().thenComparing(Comparator.comparingDouble(CPU::getClockSpeed).reversed())).collect(Collectors.toList());
  }

  public List<GPU> sortGPUByPerformance(List<GPU> gpus) {
    return gpus.stream().sorted(Comparator.comparingInt(GPU::getMemory).reversed()).collect(Collectors.toList());
  }

  public List<Ram> sortRamByPerformance(List<Ram> rams) {
    return rams.stream().sorted(Comparator.comparingInt(Ram::getCapacity).reversed()).collect(Collectors.toList());
  }

}
