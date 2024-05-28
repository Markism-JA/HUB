package main.Model.Filters;

import java.util.List;
import java.util.stream.Collectors;

import main.Model.Components.*;
public class OtherFilter {

  //FilterByRam
  public List<Ram> filterByRAMNeeds(List<Ram> rams, int ramNeeds) {
    return rams.stream().filter(ram -> ram.getCapacity() == ramNeeds).collect(Collectors.toList());
  }
  
  //FilterByFormFactorCase
  public List<Case> filterByFormFactor(List<Case> cases, String formFactor) {
    switch (formFactor) {
      case "ATX":
        return cases.stream().filter(Case -> Case.getFormFactor().equalsIgnoreCase("ATX")).collect(Collectors.toList());
      case "Micro-ATX":
        return cases.stream().filter(Case -> Case.getFormFactor().equalsIgnoreCase("Micro-ATX")).collect(Collectors.toList());
      case "Mini-ITX":
        return cases.stream().filter(Case -> Case.getFormFactor().equalsIgnoreCase("Mini-ITX")).collect(Collectors.toList()); 
      default:
        throw new IllegalArgumentException("Invalid formFactor");
    }
  }

}
