package main.Model.Components;

import java.util.List;

import main.Model.CSVUtil;

public class CPU extends CSVUtil {
  private String model, brand, socket;
  private double price;
  private int wattage;
  private boolean status;

      public CPU(String model, String brand, double price, String socket, int wattage, boolean status) {
          this.model = model;
          this.brand = brand;
          this.price = price;
          this.socket = socket;
          this.wattage = wattage;
          this.status = status;
      }

      public String getModel() { return model; }
      public void setModel(String model) { this.model = model;}

      public String getBrand() { return brand; }
      public void setBrand(String model) { this.model = model;}

      public double getPrice() { return price; }
      public void setPrice(double price) { this.price = price; }

      public String getSocket() { return socket; }
      public void setSocket(String socket) { this.socket = socket; }

      public int getWattage() { return wattage; }
      public void setWattage(int wattage) { this.wattage = wattage; }

      public boolean getStatus() { return status; }
      public void setStatus(boolean status) { this.status = status; }

      @Override
      public String toString() {
          return "CPU{" + "model='" + model + '\'' + ", brand='" + brand + '\'' + ", price=" + price + ", socket='" + socket + '\'' + ", wattage=" + wattage + ", status=" + status + '}';
          }

      public static List<CPU> readCPUFromCSV(String fileName) {
          return readFromCSV(fileName, data -> new CPU(data[0], data[1], Double.parseDouble(data[2]), data[3], Integer.parseInt(data[4]), Boolean.parseBoolean(data[5])));
          }

      public String toCSVString() {
          return String.join(",", model, brand, Double.toString(price), socket, Integer.toString(wattage), Boolean.toString(status));
      }

      public static void writeCPUToCSV(String fileName, List<CPU> cpus) { 
          writeToCSV(fileName, cpus, CPU::toCSVString);
      }
}
