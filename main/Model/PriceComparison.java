package main.Model;

import java.util.ArrayList;
import java.util.List;
import main.Model.Components.*;

public class PriceComparison {
  private String userDecision;

  public PriceComparison(String userDecision) {
      this.userDecision = userDecision;
  }

  public void comparePricesCPU() {
      DataManager dataManager = new DataManager("./data/");
      List<CPU> cpus = dataManager.getCpus();

      List<CPU> highEnd = new ArrayList<>();
      List<CPU> midEnd = new ArrayList<>();
      List<CPU> lowEnd = new ArrayList<>();

      for (CPU component : cpus) {
          double price = component.getPrice();

          if (price >= 1 && price <= 30) {
              highEnd.add(component);
          } else if (price > 30 && price <= 60) {
              midEnd.add(component);
          } else {
              lowEnd.add(component);
          }
      }

      if ("High".equalsIgnoreCase(userDecision)) {
          listCPU(highEnd, "High End Components");
      } else if ("Mid".equalsIgnoreCase(userDecision)) {
          listCPU(midEnd, "Mid End Components");
      } else {
          listCPU(lowEnd, "Low End Components");
      }
  }

  private void listCPU(List<CPU> components, String category) {
      System.out.println(category + ":");
      for (CPU component : components) {
          System.out.println(component);
      }
  }

  public void comparePricesGPU() {
      DataManager dataManager = new DataManager("./data/");
      List<GPU> gpus = dataManager.getGpus();

      List<GPU> highEnd = new ArrayList<>();
      List<GPU> midEnd = new ArrayList<>();
      List<GPU> lowEnd = new ArrayList<>();

      for (GPU component : gpus) {
          double price = component.getPrice();

          if (price >= 1 && price <= 30) {
              highEnd.add(component);
          } else if (price > 30 && price <= 60) {
              midEnd.add(component);
          } else {
              lowEnd.add(component);
          }
      }

      if ("High".equalsIgnoreCase(userDecision)) {
          listGPU(highEnd, "High End Components");
      } else if ("Mid".equalsIgnoreCase(userDecision)) {
          listGPU(midEnd, "Mid End Components");
      } else {
          listGPU(lowEnd, "Low End Components");
      }
  }

  private void listGPU(List<GPU> components, String category) {
      System.out.println(category + ":");
      for (GPU component : components) {
          System.out.println(component);
      }
  }
  public void comparePricesCase() {
      DataManager dataManager = new DataManager("./data/");
      List<Case> cases = dataManager.getCases();

      List<Case> highEnd = new ArrayList<>();
      List<Case> midEnd = new ArrayList<>();
      List<Case> lowEnd = new ArrayList<>();

      for (Case component : cases) {
          double price = component.getPrice();

          if (price >= 1 && price <= 30) {
              highEnd.add(component);
          } else if (price > 30 && price <= 60) {
              midEnd.add(component);
          } else {
              lowEnd.add(component);
          }
      }

      if ("High".equalsIgnoreCase(userDecision)) {
          listCase(highEnd, "High End Components");
      } else if ("Mid".equalsIgnoreCase(userDecision)) {
          listCase(midEnd, "Mid End Components");
      } else {
          listCase(lowEnd, "Low End Components");
      }
  }

  private void listCase(List<Case> components, String category) {
      System.out.println(category + ":");
      for (Case component : components) {
          System.out.println(component);
      }
  }
  public void comparePricesMotherBoard() {
      DataManager dataManager = new DataManager("./data/");
      List<MotherBoard> MotherBoard = dataManager.getMotherboards();

      List<MotherBoard> highEnd = new ArrayList<>();
      List<MotherBoard> midEnd = new ArrayList<>();
      List<MotherBoard> lowEnd = new ArrayList<>();

      for (MotherBoard component : MotherBoard) {
          double price = component.getPrice();

          if (price >= 1 && price <= 30) {
              highEnd.add(component);
          } else if (price > 30 && price <= 60) {
              midEnd.add(component);
          } else {
              lowEnd.add(component);
          }
      }

      if ("High".equalsIgnoreCase(userDecision)) {
          listMotherBoard(highEnd, "High End Components");
      } else if ("Mid".equalsIgnoreCase(userDecision)) {
          listMotherBoard(midEnd, "Mid End Components");
      } else {
          listMotherBoard(lowEnd, "Low End Components");
      }
  }

  private void listMotherBoard(List<MotherBoard> components, String category) {
      System.out.println(category + ":");
      for (MotherBoard component : components) {
          System.out.println(component);
      }
  }
}
