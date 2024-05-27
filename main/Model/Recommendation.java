package main.Model;
import java.util.*;
import java.util.stream.Collectors;

import main.Model.Components.*;

public class Recommendation {
  
  private DataManager dataManager;
  
  public Recommendation(DataManager dataManager) {
    this.dataManager = dataManager;
  }
  
  public List<Component> recommendComponents(List<Component> components, String priceRange, String primaryPurpose, String cpuBrand, String gpuBrand, String storageNeeds, String ramNeeds, String formFactor) {
    
    //Filter components based on price range
    Map<String, List<Component>> categorizedComponents = categorizeComponentsByPrice(components);

    //Filter components based on primary purpose
    categorizedComponents = filterComponentsByPrimaryPurpose(categorizedComponents, primaryPurpose);

    //Filter components based on user preferences
    List<CPU> filteredCPUs = filterByBrand(categorizedComponents.get("CPU"), cpuBrand);
    List<GPU> filteredGPUs = filterByBrand(categorizedComponents.get("GPU"), gpuBrand);
    List<InternalStorage> filteredStorages = filterByStorageNeeds(categorizedComponents.get("Storage"), storageNeeds);
    List<Ram> filteredRAMs = filterByRAMNeeds(categorizedComponents.get("RAM"), ramNeeds);

  }
}
