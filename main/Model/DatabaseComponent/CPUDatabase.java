package main.Model.DatabaseComponent;

import java.util.List;

import main.Model.CSVUtil;

public class CPUDatabase extends CSVUtil {
  private String name;
  private double core_clock,boost_clock;
  private int core_count;


      public CPUDatabase(String name, int core_count, double core_clock, double boost_clock){
          this.name = name;
          this.core_count = core_count;
          this.core_clock = core_clock;
          this.boost_clock = boost_clock;
      }

      public String getModel() { return name; }
      public void setModel(String name) { this.name = name;}

      public int getCore_count() { return core_count; }
      public void setCore_count(int core_count) { this.core_count = core_count;}

      public double getCore_clock() { return core_clock; }
      public void setCore_clock(double core_clock) { this.core_clock = core_clock; }

      public double getBoost_clock() { return boost_clock; }
      public void setBoost_clock(double boost_clock) { this.boost_clock = boost_clock; }

     
      @Override
      public String toString() {
          return "CPU{" + "name='" + name + '\'' + ", core_count='" + core_count + '\'' + ", core_clock=" + core_clock + ", boost_clock='" + boost_clock  + '}';
          }

      public static List<CPUDatabase> readCPUFromCSV(String fileName) {
          return readFromCSV(fileName, data -> new CPUDatabase(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3])));
          }

      public String toCSVString() {
          return String.join(",", name, Integer.toString(core_count), Double.toString(core_clock), Double.toString(boost_clock));
      }

      public static void writeCPUToCSV(String fileName, List<CPUDatabase> cpus) { 
          writeToCSV(fileName, cpus, CPUDatabase::toCSVString);
      }
}
