package main.Model.Filters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import main.Model.Components.HDD;
import main.Model.Components.InternalStorage;
import main.Model.Components.SSD;

public class StorageFilter {

    public List<InternalStorage> filterInternalStorageByPurposeAndBudget(List<InternalStorage> internalStorages,
    String purpose, String budget, int storageNeed) {
List<String> validPurposes = Arrays.asList("gaming", "workstation", "general");
int storageSize;

String purposeLower = purpose.toLowerCase();
String budgetLower = budget.toLowerCase();

if (!validPurposes.contains(purposeLower)) {
    throw new IllegalArgumentException("Invalid purpose");
}

switch (budgetLower) {
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

if (storageNeed == 0) {
    return internalStorages;
}

return internalStorages.stream()
        .filter(storage -> storage.getStorageSize() == storageSize || storage.getStorageSize() >= storageNeed)
        .collect(Collectors.toList());
}

public List<SSD> filterSSDByPurposeAndBudget(List<SSD> ssds, String purpose, String budget, int storageNeed) {
List<String> validPurposes = Arrays.asList("gaming", "workstation", "general");
int storageSize;

String purposeLower = purpose.toLowerCase();
String budgetLower = budget.toLowerCase();

if (!validPurposes.contains(purposeLower)) {
    throw new IllegalArgumentException("Invalid purpose");
}

switch (budgetLower) {
    case "low":
        return ssds; // Return the original list without filtering
    case "middle":
        storageSize = 1000;
        break;
    case "high":
        storageSize = 2000;
        break;
    default:
        throw new IllegalArgumentException("Invalid budget");
}

if (storageNeed == 0) {
    return ssds;
}

return ssds.stream()
        .filter(storage -> storage.getStorageSize() == storageSize || storage.getStorageSize() >= storageNeed)
        .collect(Collectors.toList());
}

public List<HDD> filterHDDByPurposeAndBudget(List<HDD> hdds, String purpose, String budget, int storageNeed) {
List<String> validPurposes = Arrays.asList("gaming", "workstation", "general");
int storageSize;

String purposeLower = purpose.toLowerCase();
String budgetLower = budget.toLowerCase();

if (!validPurposes.contains(purposeLower)) {
    throw new IllegalArgumentException("Invalid purpose");
}

switch (budgetLower) {
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

if (storageNeed == 0) {
    return hdds;
}

return hdds.stream()
        .filter(storage -> storage.getStorageSize() >= storageSize || storage.getStorageSize() >= storageNeed)
        .collect(Collectors.toList());
}

}
