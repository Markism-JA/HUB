package main.Model.DatabaseComponent;

import java.util.List;

import main.Model.CSVUtil;

public class MotherBoardDatabase extends CSVUtil {
  private String name, form_factor, socket;
  private int memory_slots;
 

  public MotherBoardDatabase(String name, String socket, String form_factor, int memory_slots) {
      this.name = name;
      this.socket = socket;
      this.form_factor = form_factor;
      this.memory_slots = memory_slots;
    
  }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getSocket() { return socket; }
  public void setSocket(String socket) { this.socket = socket; }

  public String getFormFactor() { return form_factor; }
  public void setFormFactor(String form_factor) { this.form_factor = form_factor; }

  public int getMemorySlots() { return memory_slots; }
  public void setMemorySlots(int memory_slots) { this.memory_slots = memory_slots; }

 
  @Override
  public String toString() {
      return "MotherBoard{" + "name='" + name + '\'' + ", socket='" + socket + '\'' + ", formFactor='" + form_factor + '\'' + ", memory_slots='" + memory_slots + '}';
      }
      
  public static List<MotherBoardDatabase> readMotherBoardFromCSV(String fileName) {
      return readFromCSV(fileName, data -> new MotherBoardDatabase(data[0], data[1], data[2], Integer.parseInt(data[3])));
      }

  public String toCSVString() {
      return String.join(",", name, socket, form_factor, Integer.toString(memory_slots));
  }

  public static void writeMotherBoardToCSV(String fileName, List<MotherBoardDatabase> motherBoards) {
      writeToCSV(fileName, motherBoards, MotherBoardDatabase::toCSVString);
  }
}
