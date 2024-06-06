package main.Model.Components;

import java.util.List;

import main.Model.CSVUtil;

//TODO: Add Integrated GPU Data Field

public class CPU extends CSVUtil {
  private String model, brand, socket, type;
  private double price;
  private int wattage;
  private boolean status;
  private double clockSpeed;
  private int coreCount;

      public CPU(String model, String brand, double price, String socket, String type, int wattage, boolean status, double clockSpeed, int coreCount) {
          this.model = model;
          this.brand = brand;
          this.price = price;
          this.socket = socket;
          this.type = type;
          this.wattage = wattage;
          this.status = status;
          this.clockSpeed = clockSpeed;
          this.coreCount = coreCount;
      }

      public String getModel() { return model; }
      public void setModel(String model) { this.model = model;}

      public String getBrand() { return brand; }
      public void setBrand(String model) { this.model = model;}

      public double getPrice() { return price; }
      public void setPrice(double price) { this.price = price; }

      public String getSocket() { return socket; }
      public void setSocket(String socket) { this.socket = socket; }

      public String getType() { return type; }
      public void setType(String type) { this.type = type; }

      public int getWattage() { return wattage; }
      public void setWattage(int wattage) { this.wattage = wattage; }

      public boolean getStatus() { return status; }
      public void setStatus(boolean status) { this.status = status; }

      public double getClockSpeed() { return clockSpeed; }
      public void setClockSpeed(double clockSpeed) { this.clockSpeed = clockSpeed; }

      public int getCoreCount() { return coreCount; }
      public void setCoreCount(int coreCount) { this.coreCount = coreCount; }

      @Override
      public String toString() {
          return "CPU{" + "model='" + model + '\'' + ", brand='" + brand + '\'' + ", price=" + price + ", socket='" + socket + '\'' + ", type=" + type + '\'' + ", wattage=" + wattage + ", status=" + status + ", clockSpeed=" + clockSpeed + ", coreCount=" + coreCount + '}';
          }

      public static List<CPU> readCPUFromCSV(String fileName) {
          return readFromCSV(fileName, data -> new CPU(data[0], data[1], Double.parseDouble(data[2]), data[3], data[4], Integer.parseInt(data[5]), Boolean.parseBoolean(data[6]), Double.parseDouble(data[7]), Integer.parseInt(data[8])));
          }

      public String toCSVString() {
          return String.join(",", model, brand, Double.toString(price), socket, type, Integer.toString(wattage), Boolean.toString(status), Double.toString(clockSpeed), Integer.toString(coreCount));
      }

      public static void writeCPUToCSV(String fileName, List<CPU> cpus) { 
          writeToCSV(fileName, cpus, CPU::toCSVString);
      }
}
