package main.Model.DatabaseComponent;

import java.util.List;

import main.Model.CSVUtil;

public class GPUDataBase extends CSVUtil{
  private String name, chipset;
  private int memory;
 

      public GPUDataBase(String name, String chipset, int memory ) {
          this.name = name;
          this.chipset = chipset;
          this.memory = memory;

      }
      public String getName() { return name; }
      public void setName(String name) { this.name = name; }

      public String getChipset() { return chipset; }
      public void setChipset(String chipset) { this.chipset = chipset; }

      public int getMemory() { return memory; }
      public void setMemory(int memory) { this.memory = memory; }

      @Override
      public String toString() {
          return "GPU{" + "name='" + name + '\'' + ", chipset='" + chipset + '\'' + ", memory=" + memory + '}';
          }

      public static List<GPUDataBase> readGPUFromCSV(String fileName) {
          return readFromCSV(fileName, data -> new GPUDataBase(data[0], data[1],Integer.parseInt(data[2])));
          }

      public String toCSVString() {
          return String.join(",",name, chipset,  Integer.toString(memory));
      }

      public static void writeGPUToCSV(String fileName, List<GPUDataBase> gpus) { 
          writeToCSV(fileName, gpus, GPUDataBase::toCSVString);
      }

}
