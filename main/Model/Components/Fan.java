package main.Model.Components;

import java.util.List;

import main.Model.CSVUtil;

public class Fan extends CSVUtil{
  private String brand, model;
  private int wattage, size;
  private double price;
  private boolean status;

  public Fan(String brand, String model, int wattage, int size, double price, boolean status) {
      this.brand = brand;
      this.model = model;
      this.wattage = wattage;
      this.size = size;
      this.price = price;
      this.status = status;
  }

  public String getBrand() { return brand; }
  public void setBrand(String brand) { this.brand = brand; }

  public String getModel() { return model; }
  public void setModel(String model) { this.model = model; }

  public int getWattage() { return wattage; }
  public void setWattage(int wattage) { this.wattage = wattage; }

  public int getSize() { return size; }
  public void setSize(int size) { this.size = size; }

  public double getPrice() { return price; }
  public void setPrice(double price) { this.price = price; }

  public boolean getStatus() { return status; }
  public void setStatus(boolean status) { this.status = status; }

  @Override
  public String toString() {
      return "Fan{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", wattage=" + wattage + ", size=" + size + ", price=" + price + ", status=" + status + '}';
  }

  public static List<Fan> readFanFromCSV(String fileName) {
      return readFromCSV(fileName, data -> new Fan(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[4]), Boolean.parseBoolean(data[5])));
  }
  

  public String toCSVString() {
      return String.join(",", brand, model, Integer.toString(wattage), Integer.toString(size), Double.toString(price), Boolean.toString(status));
  }

  public static void writeFanToCSV(String fileName, List<Fan> fans) {
      writeToCSV(fileName, fans, Fan::toCSVString);
  }

  
}

