package main.Model.DatabaseComponent;

import java.util.List;

import main.Model.CSVUtil;

public class FanDatabase extends CSVUtil{
  private String name;
  private int size;
  
  public FanDatabase(String name,  int size ) {
      this.name = name;
      this.size = size;
  }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public int getSize() { return size; }
  public void setSize(int size) { this.size = size; }


  @Override
  public String toString() {
      return "Fan{" + "name='" + name + '\'' + ", size='" + size + '}';
  }

  public static List<FanDatabase> readFanFromCSV(String fileName) {
      return readFromCSV(fileName, data -> new FanDatabase(data[0], Integer.parseInt(data[1]) ));
  }
  

  public String toCSVString() {
      return String.join(",", name, Integer.toString(size));
  }

  public static void writeFanToCSV(String fileName, List<FanDatabase> fans) {
      writeToCSV(fileName, fans, FanDatabase::toCSVString);
  }

}

