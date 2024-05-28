package main.Model.Sorter;

import java.util.Comparator;
import java.util.List;

import main.Model.Components.Case;
import main.Model.Components.Fan;
import main.Model.Components.MotherBoard;


//TODO: Storage - Size
//TODO: PSU - wattage
public class SortPrice {

  public List<Case> sortCasesByPriceDescending(List<Case> cases) {
    cases.sort(Comparator.comparingDouble(Case::getPrice).reversed());
    return cases;
  }

  public List<Fan> sortFansByPriceDescending(List<Fan> fans) {
    fans.sort(Comparator.comparingDouble(Fan::getPrice).reversed());
    return fans;
  }

  public List<MotherBoard> sortMotherBoardDescending(List<MotherBoard> motherBoards) {
    motherBoards.sort(Comparator.comparingDouble(MotherBoard::getPrice).reversed());
    return motherBoards;
  }
}
