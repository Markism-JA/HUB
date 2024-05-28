package main.Model.DatabaseComponent;

import java.util.List;

import main.Model.CSVUtil;

public class MotherBoard extends CSVUtil {
  private String brand, model, formFactor, socket;
  private double price;
  private int wattage;
  private boolean status;

  public MotherBoard(String brand, String model, String formFactor, String socket, double price, int wattage, boolean status) {
      this.brand = brand;
      this.model = model;
      this.formFactor = formFactor;
      this.socket = socket;
      this.price = price;
      this.wattage = wattage;
      this.status = status;
  }

  public String getBrand() { return brand; }
  public void setBrand (String brand) { this.brand = brand; }

  public String getModel() { return model; }
  public void setModel (String model) { this.model = model; }

  public String getFormFactor() { return formFactor; }
  public void setFormFactor (String formFactor) { this.formFactor = formFactor; }

  public String getSocket() { return socket; }
  public void setSocket (String socket) { this.socket = socket; }

  public double getPrice() { return price; }
  public void setPrice( double price) { this.price = price; };

  public int getWattage() { return wattage; }
  public void setWattage (int wattage) { this.wattage = wattage; }

  public boolean getStatus() { return status; }
  public void setStatus(boolean status) { this.status = status; }

  @Override
  public String toString() {
      return "MotherBoard{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", formFactor='" + formFactor + '\'' + ", socket='" + socket + '\'' + ", price=" + price + ", wattage=" + wattage + ", status=" + status + '}';
      }
      
  public static List<MotherBoard> readMotherBoardFromCSV(String fileName) {
      return readFromCSV(fileName, data -> new MotherBoard(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]), Integer.parseInt(data[5]), Boolean.parseBoolean(data[6])));
      }

  public String toCSVString() {
      return String.join(",", brand, model, formFactor, socket, Double.toString(price), Integer.toString(wattage), Boolean.toString(status));
  }

  public static void writeMotherBoardToCSV(String fileName, List<MotherBoard> motherBoards) {
      writeToCSV(fileName, motherBoards, MotherBoard::toCSVString);
  }
}
