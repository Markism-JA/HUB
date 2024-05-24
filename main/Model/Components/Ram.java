package main.Model.Components;

import java.util.List;

import main.Model.CSVUtil;

public class Ram extends CSVUtil{
  private String brand, model;
  private double price;
  private int wattage; 
  private float frequency;
  private boolean status;

      public Ram(String brand, String model, double price, int wattage, float frequency, boolean status) {
          this.brand = brand;
          this.model = model;
          this.price = price;
          this.wattage = wattage;
          this.frequency = frequency;
          this.status = status;
      }

      public String getBrand() { return brand; }
      public void setBrand(String brand) { this.brand = brand; }

      public String getModel() { return model; }
      public void setModel (String model) { this.model = model; }

      public double getPrice() { return price; }
      public void setPrice(double price) { this.price = price; };

      public int getWattage() { return wattage; }
      public void setWattage (int wattage) { this.wattage = wattage; }

      public float getFrequency() { return frequency; }
      public void setFrequency (float frequency) { this.frequency = frequency; }

      public boolean getStatus() { return status; }
      public void setStatus(boolean status) { this.status = status; }

      @Override
      public String toString() {
          return "Ram{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", price=" + price + ", wattage=" + wattage + ", frequency=" + frequency + ", status=" + status + '}';
      }

      public static List<Ram> readRamFromCSV(String fileName) {
          return readFromCSV(fileName, data -> new Ram(data[0], data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]), Float.parseFloat(data[4]), Boolean.parseBoolean(data[5])));
      }

      public String toCSVString() {
          return String.join(",", brand, model, Double.toString(price), Integer.toString(wattage), Float.toString(frequency), Boolean.toString(status));
      }

      public static void writeRamToCSV(String fileName, List<Ram> rams) {
          writeToCSV(fileName, rams, Ram::toCSVString);
      }
}
