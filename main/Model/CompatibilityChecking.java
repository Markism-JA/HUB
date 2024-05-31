package main.Model;
import java.util.List;
import main.Model.Components.*;

   public class CompatibilityChecking {
    // Fields and methods for checking compatibility of selected parts
    public boolean WattsComputation(CPU cpu, GPU gpu, MotherBoard motherboard, Ram ram, SSD ssd, HDD hdd, PSU psu){
      int total = cpu.getWattage() + gpu.getWattage() + motherboard.getWattage() + ram.getWattage() + ssd.getWattage() + hdd.getWattage() + 50;
       if(total <= psu.getWattage()){
          return true;
       }
       else{
       return false;
    }
  }
    public boolean BottleNeckChecker(CPU cpu, GPU gpu){
     double cpu_speed = cpu.getClockSpeed()/5.6 *100;
     double gpu_speed = gpu.getMemory()/24 * 100;

     if(cpu_speed - gpu_speed <= 20.0 || gpu_speed - cpu_speed <- 20.0){
      return false;
     }
     
     else{
     return true;
     }
    }
    public boolean SocketCompatibiliyChecker(CPU cpu, MotherBoard motherboard){
      if(cpu.getSocket().equals(motherboard.getSocket())){
        return true;
      }
      else{
      return false;
    }
  }
    public boolean FormFactorCompatibilityChecker(Case cases, MotherBoard motherboard){
      if(cases.getFormFactor().equals(motherboard.getFormFactor())){
        return true;
      }
      else{
        return false;
      }
    }
    public boolean RamGenCompatibilityChecker(Ram ram, MotherBoard motherboard){
      if(ram.getDDR().equals(motherboard.getDDR())){
        return true;
      }
      else{
        return false; 
      }
    }
      public boolean checkCompatibility(PCBuild pcBuild) {
          // Implementation of compatibility checking logic
      
          if(BottleNeckChecker(null, null) == false && 
          WattsComputation(null, null, null, null, null, null, null) == true && 
          SocketCompatibiliyChecker(null, null) == true && 
          FormFactorCompatibilityChecker(null, null) == true && 
          RamGenCompatibilityChecker(null, null) == true)
          {
            return true;
          }
          else{
            return false;
          }
      }
  }