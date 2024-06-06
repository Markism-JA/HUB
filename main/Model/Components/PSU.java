package main.Model.Components;

import java.util.List;

import main.Model.CSVUtil;

public class PSU extends CSVUtil{
  private String brand, model, rate;
  private double price;
  private int wattage;
  private boolean status;

      public PSU(String brand, String model, double price, String rate, int wattage, boolean status) {
          this.brand = brand;
          this.model = model;
          this.price = price;
          this.rate = rate;
          this.wattage = wattage;
          this.status = status;
      }

      public String getBrand() { return brand; }
      public void setBrand(String brand) { this.brand = brand; }

      public String getModel() { return model; }
      public void setModel(String model) { this.model = model; }

      public double getPrice() { return price; }
      public void setPrice(double price) { this.price = price; }

      public String getRate() { return rate; }
      public void setRate(String rate) { this.rate = rate; }

      public int getWattage() { return wattage; }
      public void setWattage(int wattage) { this.wattage = wattage; }

      public boolean getStatus() { return status; }
      public void setStatus(boolean status) { this.status = status; }

      @Override
      public String toString() {
          return "PSU{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", price=" + price + ", rate='" + rate + '\'' + ", wattage=" + wattage + ", status=" + status + '}';
      }

      public static List<PSU> readPSUFromCSV(String fileName) {
          return readFromCSV(fileName, data -> new PSU(data[0], data[1], Double.parseDouble(data[2]), data[3], Integer.parseInt(data[4]), Boolean.parseBoolean(data[5])));
      }

      public String toCSVString() {
          return String.join(",", brand, model, Double.toString(price), rate, Integer.toString(wattage), Boolean.toString(status));
      }

      public static void writePSUToCSV(String fileName, List<PSU> psus) {
          writeToCSV(fileName, psus, PSU::toCSVString);
      }

}
