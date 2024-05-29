package main.Model.Components;

import main.Model.Components.*;
import java.util.List;
import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {
    String fileName = "/home/marky/Documents/GitHub/HUB/main/Resources/data/cpu.csv";
    List<CPU> readCPUs = CPU.readCPUFromCSV(fileName);

    for (CPU cpu : readCPUs) {
      System.out.println(cpu.toString());
    }
  }
}
