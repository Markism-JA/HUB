package main.Model.DatabaseComponent;

import java.util.List;

import main.Model.CSVUtil;

public class RamDatabase extends CSVUtil{
  private String name;

      public RamDatabase(String name) {
          this.name = name;
      }

      public String getName() { return name; }
      public void setName(String name) { this.name = name; }
      
      @Override
      public String toString() {
          return "Ram{" + "name='" + name+ '}';
      }

      public static List<RamDatabase> readRamFromCSV(String fileName) {
          return readFromCSV(fileName, data -> new RamDatabase(data[0]));
      }

      public String toCSVString() {
          return String.join(",", name);
      }

      public static void writeRamToCSV(String fileName, List<RamDatabase> rams) {
          writeToCSV(fileName, rams, RamDatabase::toCSVString);
      }
}
