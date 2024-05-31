package main.Model.Components;
import main.Resources.*;
import main.Model.Components.*;
import main.Model.Components.CPU;
import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    String fileName = "main/Resources/data/case.csv";
    List<Fan> readCPUs = Fan.readFanFromCSV(fileName);

    for (Fan cpu : readCPUs) {
      System.out.println(cpu.toString());
    }
    
  }
}