package main.Model;
import main.Model.Components.*;

public class CompatibilityChecker {
  // Fields and methods for checking compatibility of selected parts
  public boolean WattsComputationLow(CPU cpu, GPU gpu, MotherBoard motherboard, Ram ram, InternalStorage nvme, HDD hdd,Fan fan, PSU psu){
    int total = cpu.getWattage() + gpu.getWattage() + motherboard.getWattage() + ram.getWattage() + nvme.getWattage() + hdd.getWattage() + fan.getWattage() + 50;
    
    if(total <= psu.getWattage()) {
        return true;
    } else {
      return false;
    } 
  }

  public boolean WattsComputationHigh(CPU cpu, GPU gpu, MotherBoard motherboard, Ram ram, InternalStorage nvme, SSD ssd, HDD hdd, Fan fan, PSU psu){
    int total = cpu.getWattage() + gpu.getWattage() + motherboard.getWattage() + ram.getWattage() + nvme.getWattage() + ssd.getWattage() + hdd.getWattage() + fan.getWattage() + 50;
    
    if(total <= psu.getWattage()) {
        return true;
    } else {
      return false;
    } 
  }
  
  public boolean BottleneckChecker(GPU gpu, CPU cpu, double clockSpeed, double coreCount, double vram) {
    // Adding 1 to avoid division by zero
    double coreCount100 = coreCount + 1;
    double clockSpeed100 = clockSpeed + 1;
    double vram100 = vram + 1;

    // Scaling the values to a range of 0 to 100
    double vramCheck = (gpu.getMemory() / vram100) * 100;
    double coreCountCheck = (cpu.getCoreCount() / coreCount100) * 100;
    double clockSpeedCheck = (cpu.getClockSpeed() / clockSpeed100) * 100;

    // Checking if any of the scaled values are significantly lower than the others
    double minScaledValue = Math.min(Math.min(vramCheck, coreCountCheck), clockSpeedCheck);
    double threshold = 70; // Adjust the threshold as needed
    return minScaledValue < threshold;
  }

  public boolean FormFactorCompatibility(Case cases, MotherBoard motherboard){
    if(cases.getFormFactor().equals(motherboard.getFormFactor())){
      return true;
    } else {
      return false;
    }
  }

  public boolean SocketCompatibility(CPU cpu, MotherBoard motherBoard) {
    if(cpu.getSocket().equals(motherBoard.getSocket())){
        return true;
      } else {
        return false;
      }
  }

  public boolean MemoryCompatibility(Ram ram, MotherBoard motherBoard) {
    if(ram.getDDR().equalsIgnoreCase(motherBoard.getDDR())) {
      return true;
    } else {
      return false;
    }
  }

  public boolean FanCaseCompatibility(Fan fan, Case case1) {
    int smallFan = 80;
    int largeFan = 120;

    if(fan.getSize() == smallFan) {
      boolean validation = case1.getFormFactor().equalsIgnoreCase("Mini-ITX");
      return validation;
    } else if (fan.getSize() == largeFan) {
      boolean validation = case1.getFormFactor().equalsIgnoreCase("ATX")||case1.getFormFactor().equalsIgnoreCase("Micro-ATX");
      return validation;
    } else {
      return false;
    }
  }

}