package main.Model;
import java.util.ArrayList;
import java.util.List;

import main.Model.Components.*;


public class DataManager {
  private List<CPU> cpus;
  private List<GPU> gpus;
  private List<Case> cases;
  private List<MotherBoard> motherboards;
  private List<Ram> rams;
  private List<PSU> psus;
  private List<HDD> hdds;
  private List<SSD> ssds;
  private List<Fan> fans;

  //User
  private List<User> users;

  public DataManager(String basePath) {
      cpus = loadCPU(basePath + "cpu.csv");
      gpus = loadGPU(basePath + "gpu.csv");
      cases = loadCase(basePath + "case.csv");
      motherboards = loadMotherBoard(basePath + "motherboard.csv");
      rams = loadRam(basePath + "ram.csv");
      psus = loadPSU(basePath + "psu.csv");
      hdds = loadHDD(basePath + "hdd.csv");
      ssds = loadSSD(basePath + "ssd.csv");
      fans = loadFan(basePath + "fan.csv");
      users = loadUsers(basePath + "user.csv");
  }


  private List<CPU> loadCPU(String filePath) {
      try {
          return CPU.readCPUFromCSV(filePath);
      } catch (Exception e) {
          // Handle exception
          return new ArrayList<>();
      }
  }

  private List<GPU> loadGPU(String filePath) {
      try {
          return GPU.readGPUFromCSV(filePath);
      } catch (Exception e) {
          // Handle exception
          return new ArrayList<>();
      }
  }

  private List<Case> loadCase(String filePath) {
      try {
          return Case.readCaseFromCSV(filePath);
      } catch (Exception e) {
          // Handle exception
          return new ArrayList<>();
      }
  }

  private List<MotherBoard> loadMotherBoard(String filePath) {
      try {
          return MotherBoard.readMotherBoardFromCSV(filePath);
      } catch (Exception e) {
          // Handle exception
          return new ArrayList<>();
      }
  }

  private List<Ram> loadRam(String filePath) {
      try {
          return Ram.readRamFromCSV(filePath);
      } catch (Exception e) {
          // Handle exception
          return new ArrayList<>();
      }
  }

  private List<PSU> loadPSU(String filePath) {
      try {
          return PSU.readPSUFromCSV(filePath);
      } catch (Exception e) {
          // Handle exception
          return new ArrayList<>();
      }
  }

  private List<HDD> loadHDD(String filePath) {
      try {
          return HDD.readHDDFromCSV(filePath);
      } catch (Exception e) {
          // Handle exception
          return new ArrayList<>();
      }
  }

  private List<SSD> loadSSD(String filePath) {
      try {
          return SSD.readSDDFromCSV(filePath);
      } catch (Exception e) {
          // Handle exception
          return new ArrayList<>();
      }
  }

  private List<Fan> loadFan(String filePath) {
      try {
          return Fan.readFanFromCSV(filePath);
      } catch (Exception e) {
          // handle exception
          return new ArrayList<>();
      }
  }

  //Users
  private List<User> loadUsers(String filePath) {
      try {
          return User.readUsersFromCSV(filePath);
      } catch (Exception e) {
          // Handle exception
          return new ArrayList<>();
      }
  }

  // Getters for the loaded data
  public List<CPU> getCpus() {
      return cpus;
  }

  public List<GPU> getGpus() {
      return gpus;
  }

  public List<Case> getCases() {
      return cases;
  }

  public List<MotherBoard> getMotherboards() {
      return motherboards;
  }

  public List<Ram> getRams() {
      return rams;
  }

  public List<PSU> getPsus() {
      return psus;
  }

  public List<HDD> getHdds() {
      return hdds;
  }

  public List<SSD> getSsds() {
      return ssds;
  }

  public List<Fan> getFans() {
      return fans;
  }

  //Users
  public List<User> getUsers() {
      return users;
  }

  public void saveData() {
      // Implementation of saving data to files or database
  }
}
