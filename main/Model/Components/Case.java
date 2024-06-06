package main.Model.Components;

import java.util.List;

import main.Model.CSVUtil;

public class Case extends CSVUtil{
  private int id;
  private String brand, model, formFactor;
  private double price;
  private boolean status;

  public Case(int id, String brand, String model, String formFactor, double price, boolean status) {
      this.id = id;
      this.brand = brand;
      this.model = model;
      this.formFactor = formFactor;
      this.price = price;
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

  public double getPrice() { return price; }
  public void setPrice(double price) { this.price = price; }

  public boolean getStatus() { return status; }
  public void setStatus(boolean status) { this.status = status; }

  @Override
  public String toString() {
      return "Case{" + "id=" + id + ", brand='" + brand + '\'' + ", model='" + model + '\'' + ", formFactor='" + formFactor + '\'' + ", price=" + price + ", status=" + status + '}';
      }

  public static List<Case> readCaseFromCSV(String fileName) {
      return readFromCSV(fileName, data -> new Case(Integer.parseInt(data[0]), data[1], data[2], data[3], Double.parseDouble(data[4]), Boolean.parseBoolean(data[5])));
      }

  public String toCSVString() {
      return String.join(",", Integer.toString(id), brand, model, formFactor, Double.toString(price), Boolean.toString(status));
  }

  public static void writeCaseToCSV(String fileName, List<Case> cases) {
    writeToCSV(fileName, cases, Case::toCSVString);
  }

  public static void main(String[] args) {
  }
}
