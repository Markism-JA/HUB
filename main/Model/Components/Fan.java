package main.Model.Components;

import java.util.List;

import main.Model.CSVUtil;

public class Fan extends CSVUtil{
  private int id;
  private String brand, model;
  private int wattage, size;
  private double price;
  private boolean status;

  public Fan(int id, String brand, String model, int wattage, int size, double price, boolean status) {
      this.id = id;
      this.brand = brand;
      this.model = model;
      this.wattage = wattage;
      this.size = size;
      this.price = price;
      this.status = status;
  }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

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
      return "Fan{" + "id=" + id + ", brand='" + brand + '\'' + ", model='" + model + '\'' + ", wattage=" + wattage + ", size=" + size + ", price=" + price + ", status=" + status + '}';
  }

  public static List<Fan> readFanFromCSV(String fileName) {
      return readFromCSV(fileName, data -> new Fan(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Double.parseDouble(data[5]), Boolean.parseBoolean(data[6])));
  }
  

  public String toCSVString() {
      return String.join(",", Integer.toString(id), brand, model, Integer.toString(wattage), Integer.toString(size), Double.toString(price), Boolean.toString(status));
  }

  public static void writeFanToCSV(String fileName, List<Fan> fans) {
      writeToCSV(fileName, fans, Fan::toCSVString);
  }

  public static void main(String[] args) {
    readFanFromCSV("main/Resources/data/fan.csv");
  }
  
}
