package main.Model.Sorter;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import main.Model.Components.Case;
import main.Model.Components.Fan;
import main.Model.Components.MotherBoard;

public class SortPrice {

    public List<Case> sortCasesByPriceDescending(List<Case> cases) {
        Objects.requireNonNull(cases, "Case list cannot be null");
        cases.sort(Comparator.comparingDouble(Case::getPrice).reversed());
        return cases;
    }

    public List<Fan> sortFansByPriceDescending(List<Fan> fans) {
        Objects.requireNonNull(fans, "Fan list cannot be null");
        fans.sort(Comparator.comparingDouble(Fan::getPrice).reversed());
        return fans;
    }

    public List<MotherBoard> sortMotherBoardDescending(List<MotherBoard> motherBoards) {
        Objects.requireNonNull(motherBoards, "Motherboard list cannot be null");
        motherBoards.sort(Comparator.comparingDouble(MotherBoard::getPrice).reversed());
        return motherBoards;
    }
}
