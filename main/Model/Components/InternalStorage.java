package main.Model.Components;

import java.util.List;

import main.Model.CSVUtil;

public class InternalStorage extends CSVUtil{
  private int id;
  private String brand;
  private int storageSize, wattage;
  private double price;
  private boolean status;

  public InternalStorage(int id, String brand, int storageSize, int wattage, double price, boolean status) {
      this.id = id;
      this.brand = brand;
      this.storageSize = storageSize;
      this.wattage = wattage;
      this.price = price;
      this.status = status;
  }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

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
      return "InternalStorage{" + "id=" + id + ", brand='" + brand + '\'' + ", storageSize=" + storageSize + ", wattage=" + wattage +", price=" + price + ", status=" + status + '}';
  }

  public static List<InternalStorage> readInternalStorageFromCSV(String fileName) {
      return readFromCSV(fileName, data -> new InternalStorage(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[4]), Boolean.parseBoolean(data[5])));
  }

  public String toCSVString() {
      return String.join(",", Integer.toString(id), brand, Integer.toString(storageSize), Integer.toString(wattage), Double.toString(price), Boolean.toString(status));
  }

  public static void writeInternalStorageToCSV(String fileName, List<InternalStorage> internalStorages) {
      writeToCSV(fileName, internalStorages, InternalStorage::toCSVString);
  }

  public static void main(String[] args) {
    readInternalStorageFromCSV("main/Resources/data/internalstorage.csv");
    
  }
}
