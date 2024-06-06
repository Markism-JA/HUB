package main.Model.Components;

import java.util.List;

import main.Model.CSVUtil;

public class MotherBoard extends CSVUtil {
  private int id;
  private String brand, model, formFactor, socket, ddr;
  private double price;
  private int wattage;
  private boolean status;

  public MotherBoard(int id, String brand, String model, String formFactor, String socket, String ddr, double price, int wattage, boolean status) {
      this.id = id;
      this.brand = brand;
      this.model = model;
      this.formFactor = formFactor;
      this.socket = socket;
      this.ddr = ddr;
      this.price = price;
      this.wattage = wattage;
      this.status = status;
  }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getBrand() { return brand; }
  public void setBrand(String brand) { this.brand = brand; }

  public String getModel() { return model; }
  public void setModel(String model) { this.model = model; }

  public String getFormFactor() { return formFactor; }
  public void setFormFactor(String formFactor) { this.formFactor = formFactor; }

  public String getSocket() { return socket; }
  public void setSocket(String socket) { this.socket = socket; }

  public String getDDR() { return ddr; }
  public void setDDR(String ddr) { this.ddr = ddr; }

  public double getPrice() { return price; }
  public void setPrice(double price) { this.price = price; }

  public int getWattage() { return wattage; }
  public void setWattage(int wattage) { this.wattage = wattage; }

  public boolean getStatus() { return status; }
  public void setStatus(boolean status) { this.status = status; }

  @Override
  public String toString() {
      return "MotherBoard{" + "id=" + id + ", brand='" + brand + '\'' + ", model='" + model + '\'' + ", formFactor='" + formFactor + '\'' + ", socket='" + socket + '\'' + ", ddr='" + ddr + '\'' + ", price=" + price + ", wattage=" + wattage + ", status=" + status + '}';
      }
      
  public static List<MotherBoard> readMotherBoardFromCSV(String fileName) {
      return readFromCSV(fileName, data -> new MotherBoard(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], Double.parseDouble(data[6]), Integer.parseInt(data[7]), Boolean.parseBoolean(data[8])));
      }

  public String toCSVString() {
      return String.join(",", Integer.toString(id), brand, model, formFactor, socket, ddr, Double.toString(price), Integer.toString(wattage), Boolean.toString(status));
  }

  public static void writeMotherBoardToCSV(String fileName, List<MotherBoard> motherBoards) {
      writeToCSV(fileName, motherBoards, MotherBoard::toCSVString);
  }
}
