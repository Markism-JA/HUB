package main.Model.Components;

import java.util.List;

import main.Model.CSVUtil;

//TODO: Add Integrated GPU Data Field

public class CPU extends CSVUtil {
  private int id;
  private String model, brand, socket, type;
  private double price;
  private int wattage;
  private boolean status;
  private double clockSpeed;
  private int coreCount;

  public CPU(int id, String model, String brand, double price, String socket, String type, int wattage, boolean status, double clockSpeed, int coreCount) {
      this.id = id;
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

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getModel() { return model; }
  public void setModel(String model) { this.model = model; }

  public String getBrand() { return brand; }
  public void setBrand(String brand) { this.brand = brand; }

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
      return "CPU{" + "id=" + id + ", model='" + model + '\'' + ", brand='" + brand + '\'' + ", price=" + price + ", socket='" + socket + '\'' + ", type=" + type + '\'' + ", wattage=" + wattage + ", status=" + status + ", clockSpeed=" + clockSpeed + ", coreCount=" + coreCount + '}';
      }

  public static List<CPU> readCPUFromCSV(String fileName) {
      return readFromCSV(fileName, data -> new CPU(Integer.parseInt(data[0]), data[1], data[2], Double.parseDouble(data[3]), data[4], data[5], Integer.parseInt(data[6]), Boolean.parseBoolean(data[7]), Double.parseDouble(data[8]), Integer.parseInt(data[9])));
      }

  public String toCSVString() {
      return String.join(",", Integer.toString(id), model, brand, Double.toString(price), socket, type, Integer.toString(wattage), Boolean.toString(status), Double.toString(clockSpeed), Integer.toString(coreCount));
  }

  public static void writeCPUToCSV(String fileName, List<CPU> cpus) {
    writeToCSV(fileName, cpus, CPU::toCSVString);
  }

  public static void main(String[] args) {
    readCPUFromCSV("main/Resources/data/cpu.csv");
  }
}
