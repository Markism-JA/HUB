package main.Model.Filters;

import main.Model.Components.*;
import java.util.List;
import java.util.stream.Collectors;

public class PurposeFilter {

      //FilterByPurpose CPU, GPU, Ram, InternalStorage, SSD/HDD
    public List<CPU> filterCPUsByPurpose(List<CPU> cpus, String purpose) {
        switch (purpose) {
            case "Gaming":
                return cpus.stream().filter(cpu -> cpu.getClockSpeed() >= 3.5 && cpu.getCoreCount() >= 4).collect(Collectors.toList());
            case "Workstation":
                return cpus.stream().filter(cpu -> cpu.getCoreCount() >= 8).collect(Collectors.toList());
            case "General":
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
          case "General":
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
          case "General":
              return rams.stream().filter(ram -> ram.getCapacity() >= 8).collect(Collectors.toList());
          default:
              throw new IllegalArgumentException("Invalid primary purpose: " + purpose);
      } 
    }
}
