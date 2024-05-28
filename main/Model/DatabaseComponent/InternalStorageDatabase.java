package main.Model.DatabaseComponent;

import java.util.List;

import main.Model.CSVUtil;

public class InternalStorageDatabase extends CSVUtil{
  private String name,type,interfaces;
  private int capacity ;
  

      public InternalStorageDatabase(String name, int capacity, String type, String interfaces ) {
          this.name = name;
          this.capacity = capacity;
          this.type = type;
          this.interfaces = interfaces;
    
      }

      public String getName() { return name; }
      public void setName(String name) { this.name = name; }
  
      public String getType() { return type; }
      public void setType(String type) { this.type = type; }
  
      public String getInterfaces() { return interfaces; }
      public void setInterfaces(String interfaces) { this.interfaces = interfaces; }
  
      public int getCapacity() { return capacity; }
      public void setCapacity(int capacity) { this.capacity = capacity; }
  
      @Override
      public String toString() {
          return "InternalStorageDatabase{" + "name='" + name + '\'' + ", capacity=" + capacity + ", type='" + type + '\'' + ", interfaces='" + interfaces + '\'' + '}';
      }
  
      public static List<InternalStorageDatabase> readInternalStorageFromCSV(String fileName) {
          return readFromCSV(fileName, data -> new InternalStorageDatabase( data[0], Integer.parseInt(data[1]), data[2], data[3] ));
      }

      public String toCSVString() {
        return String.join(",", name, Integer.toString(capacity), type, interfaces);
    }
      public static void writeHDDToCSV(String fileName, List<InternalStorageDatabase> hdds) {
          writeToCSV(fileName, hdds, InternalStorageDatabase::toCSVString);
      }
}
