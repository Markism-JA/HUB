package main.Model.Components;

import java.util.List;

import main.Model.CSVUtil;

public class Ram extends CSVUtil{
  private int id;
  private String brand, model, ddr;
  private double price;
  private int wattage; 
  private float frequency;
  private boolean status;
  private int capacity;

      public Ram(int id, String brand, String model, String ddr, double price, int wattage, float frequency, boolean status, int capacity) {
          this.id = id;
          this.brand = brand;
          this.model = model;
          this.ddr = ddr;
          this.price = price;
          this.wattage = wattage;
          this.frequency = frequency;
          this.status = status;
          this.capacity = capacity;
      }

      public int getId() { return id; }
      public void setId(int id) { this.id = id; }

      public String getBrand() { return brand; }
      public void setBrand(String brand) { this.brand = brand; }

      public String getModel() { return model; }
      public void setModel (String model) { this.model = model; }

      public String getDDR() { return ddr; }
      public void setDDR(String ddr) { this.ddr = ddr; }

      public double getPrice() { return price; }
      public void setPrice(double price) { this.price = price; };

      public int getWattage() { return wattage; }
      public void setWattage (int wattage) { this.wattage = wattage; }

      public float getFrequency() { return frequency; }
      public void setFrequency (float frequency) { this.frequency = frequency; }

      public boolean getStatus() { return status; }
      public void setStatus(boolean status) { this.status = status; }

      public int getCapacity() { return capacity; }
      public void setCapacity(int capacity) { this.capacity = capacity; }

      @Override
      public String toString() {
          return "Ram{" + "id=" + id + ", brand='" + brand + '\'' + ", model='" + model + '\'' + ", price=" + price + ", wattage=" + wattage + ", frequency=" + frequency + ", status=" + status + '}';
      }

      public static List<Ram> readRamFromCSV(String fileName) {
          return readFromCSV(fileName, data -> new Ram(Integer.parseInt(data[0]), data[1], data[2], data[3], Double.parseDouble(data[4]), Integer.parseInt(data[5]), Float.parseFloat(data[6]), Boolean.parseBoolean(data[7]), Integer.parseInt(data[8])));
      }

      public String toCSVString() {
          return String.join(",", Integer.toString(id), brand, model, ddr, Double.toString(price), Integer.toString(wattage), Float.toString(frequency), Boolean.toString(status), Integer.toString(capacity));
      }

      public static void writeRamToCSV(String fileName, List<Ram> rams) {
          writeToCSV(fileName, rams, Ram::toCSVString);
      }
}
