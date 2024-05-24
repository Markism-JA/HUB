package main.Model.Components;

import java.util.List;

import main.Model.CSVUtil;

public class SSD extends CSVUtil{
  private String brand;
  private int storageSize, wattage;
  private double price;
  private boolean status;

      public SSD (String brand, int storageSize, int wattage, double price, boolean status) {
          this.brand = brand;
          this.storageSize = storageSize;
          this.wattage = wattage;
          this.price = price;
          this.status = status;
      }

      public String getBrand() { return brand; }
      public void setBrand(String brand) { this.brand = brand; }

      public int getStorageSize() { return storageSize; }
      public void setStorageSize(int storageSize)  { this.storageSize = storageSize; }

      public int getWattage() { return wattage; }
      public void setWattage(int wattage) { this.wattage = wattage; } 

      public double getPrice() { return price; }
      public void setPrice(double price) { this.price = price; }

      public boolean getStatus() { return status; }
      public void setStatus(boolean status) { this.status = status; }

      @Override
      public String toString() {
        return "SDD{" + "brand='" + brand + '\'' + ", storageSize=" + storageSize + ", wattage=" + wattage +  ", price=" + price + ", status=" + status + '}';
      }

      public static List<SSD> readSDDFromCSV(String fileName) {
        return readFromCSV(fileName, data -> new SSD(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Double.parseDouble(data[3]), Boolean.parseBoolean(data[4])));
      } 
          
      public String toCSVString() {
          return String.join(",", brand, Integer.toString(storageSize), Integer.toString(wattage), Double.toString(price), Boolean.toString(status));
      }

      public static void writeSSDToCSV(String fileName, List<SSD> sdds) {
        writeToCSV(fileName, sdds, SSD::toCSVString);
      }
}
