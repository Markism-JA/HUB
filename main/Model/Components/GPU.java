package main.Model.Components;

import java.util.List;

import main.Model.CSVUtil;

public class GPU extends CSVUtil{
  private String chipset, brand;
  private int memory, wattage;
  private double price;
  private boolean status;

      public GPU(String chipset, String brand, int memory, double price, int wattage, boolean status) {
          this.chipset = chipset;
          this.brand = brand;
          this.memory = memory;
          this.price = price;
          this.wattage = wattage;
          this.status = status;
      }

      public String getChipset() { return chipset; }
      public void setChipset(String chipset) { this.chipset = chipset; }

      public String getBrand() { return brand; }
      public void setBrand(String brand) { this.brand = brand; }

      public int getMemory() { return memory; }
      public void setMemory(int memory) { this.memory = memory; }

      public double getPrice() { return price; }
      public void setPrice(double price) { this.price = price; }

      public int getWattage() { return wattage; }
      public void setWattage(int wattage) { this.wattage = wattage; }

      public boolean getStatus() { return status; }
      public void setStatus(boolean status) { this.status = status; }

      @Override
      public String toString() {
          return "GPU{" + "chipset='" + chipset + '\'' + ", brand='" + brand + '\'' + ", memory=" + memory + ", price=" + price + ", wattage=" + wattage + ", status=" + status + '}';
          }

      public static List<GPU> readGPUFromCSV(String fileName) {
          return readFromCSV(fileName, data -> new GPU(data[0], data[1],Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), Boolean.parseBoolean(data[5])));
          }

      public String toCSVString() {
          return String.join(",", chipset, brand, Integer.toString(memory), Double.toString(price), Integer.toString(wattage), Boolean.toString(status));
      }

      public static void writeGPUToCSV(String fileName, List<GPU> gpus) { 
          writeToCSV(fileName, gpus, GPU::toCSVString);
      }

}
