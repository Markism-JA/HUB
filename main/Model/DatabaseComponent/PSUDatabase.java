package main.Model.DatabaseComponent;

import java.util.List;

import main.Model.CSVUtil;

public class PSUDatabase extends CSVUtil{
  private String name, rate;
  private int wattage;


      public PSUDatabase(String name, String rate,  int wattage ) {
          this.name = name;
          this.rate = rate;
          this.wattage = wattage;
      }

      public String getName() { return name; }
      public void setName(String name) { this.name = name; }

      public String getRate() { return rate; }
      public void setRate(String rate) { this.rate = rate; }

      public int getWattage() { return wattage; }
      public void setWattage(int wattage) { this.wattage = wattage; }

      @Override
      public String toString() {
          return "PSU{" + "name='" + name + '\'' + ", rate='" + rate + '\'' + ", wattage=" + wattage + '}';
      }

      public static List<PSUDatabase> readPSUFromCSV(String fileName) {
          return readFromCSV(fileName, data -> new PSUDatabase(data[0], data[1], Integer.parseInt(data[2])));
      }

      public String toCSVString() {
          return String.join(",", name, rate, Integer.toString(wattage));
      }

      public static void writePSUToCSV(String fileName, List<PSUDatabase> psus) {
          writeToCSV(fileName, psus, PSUDatabase::toCSVString);
      }

}
