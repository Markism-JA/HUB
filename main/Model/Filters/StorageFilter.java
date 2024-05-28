package main.Model.Filters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import main.Model.Components.HDD;
import main.Model.Components.InternalStorage;
import main.Model.Components.SSD;

public class StorageFilter {

  public List<InternalStorage> filterInternalStorageByPurposeAndBudget(List<InternalStorage> internalStorages, String purpose, String budget, int storageNeed) {
      List<String> validPurposes = Arrays.asList("Gaming", "Workstation", "General");
      int storageSize;

      if (!validPurposes.contains(purpose)) {
          throw new IllegalArgumentException("Invalid purpose");
      }

      switch (budget) {
          case "low":
              storageSize = 256;
              break;
          case "middle":
              storageSize = 500;
              break;
          case "high":
              storageSize = 1000;
              break;
          default:
              throw new IllegalArgumentException("Invalid budget");
      }

      return internalStorages.stream().filter(InternalStorage -> InternalStorage.getStorageSize() == storageSize || InternalStorage.getStorageSize() >= storageNeed).collect(Collectors.toList());
  }

  public List<SSD> filterSSDByPurposeAndBudget(List<SSD> ssds, String purpose, String budget, int storageNeed) {
      List<String> validPurposes = Arrays.asList("Gaming", "Workstation", "General");
      int storageSize;

      if (!validPurposes.contains(purpose)) {
          throw new IllegalArgumentException("Invalid purpose");
      }

      switch (budget) {
          case "middle":
              storageSize = 1000;
              break;
          case "high":
              storageSize = 2000;
              break;
          default:
              throw new IllegalArgumentException("Invalid budget");
      }

      return ssds.stream().filter(SSD -> SSD.getStorageSize() == storageSize || SSD.getStorageSize() >= storageNeed).collect(Collectors.toList());
  }

  public List<HDD> filterHDDByPurposeAndBudget(List<HDD> hdds, String purpose, String budget, int storageNeed) {
      List<String> validPurposes = Arrays.asList("Gaming", "Workstation", "General");
      int storageSize;

      if (!validPurposes.contains(purpose)) {
          throw new IllegalArgumentException("Invalid purpose");
      }

      switch (budget) {
          case "low":
              storageSize = 1000;
              break;
          case "middle":
              storageSize = 2000;
              break;
          case "high":
              storageSize = 4000;
              break;
          default:
              throw new IllegalArgumentException("Invalid budget");
      }

      return hdds.stream().filter(HDD -> HDD.getStorageSize() == storageSize || HDD.getStorageSize() >= storageNeed).collect(Collectors.toList());
  }

}
