package main.Model;

import main.Model.Components.*;

import java.util.List;

import main.Model.CSVUtil;

public class PCBuild {
    private int ID;  

    private CPU cpu;
    private GPU gpu;
    private Case case1;
    private MotherBoard motherBoard;
    private Ram ram;
    private InternalStorage storage;
    private PSU powerSupply;
    private Fan fan;
    private HDD hdd;
    private SSD ssd;

    public PCBuild ( CPU cpu, GPU gpu, Case case1, MotherBoard motherBoard, Ram ram, Fan fan, PSU powerSupply) {
      this.cpu = cpu;
      this.gpu = gpu;
      this.case1 = case1;
      this.motherBoard = motherBoard;
      this.ram = ram;
      this.storage = storage;
      this.powerSupply = powerSupply;
      this.fan = fan;
      this.hdd = hdd;
      this.ssd = ssd;
    }

    public CPU getCpu() { return cpu; }
    public void setCpu(CPU cpu) { this.cpu = cpu; }

    public GPU getGpu() { return gpu; }
    public void setGPU(GPU gpu) { this.gpu = gpu; }

    public Case getCase1() { return case1; }
    public void setCase(Case case1) { this.case1 = case1; }

    public MotherBoard getMotherBoard() { return motherBoard; }
    public void setMotherBoard(MotherBoard motherBoard) { this.motherBoard = motherBoard; }

    public Ram getRam() { return ram; }
    public void setRam(Ram ram) { this.ram = ram; }

    public InternalStorage getStorage() { return storage; }
    public void setInternalStorage(InternalStorage storage) { this.storage = storage; } 

    public PSU getPowerSupply() { return powerSupply; }
    public void setPowerSupply(PSU powerSupply) { this.powerSupply = powerSupply; }

    public Fan getFan() { return fan; }
    public void setFan(Fan fan) { this.fan = fan; }

    public HDD getHdd() { return hdd; }
    public void setHDD(HDD hdd) { this.hdd = hdd; }

    public SSD getSsd() { return ssd; }
    public void setSSD(SSD ssd) { this.ssd = ssd; }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    public static List<PCBuild> readPCBuildFromCSV(String fileName) {
    return readFromCSV(fileName, data -> new PCBuild(null, null, null, null, null, null, null));
    }

    public String toCSVString() {
        return String.join(",", Integer.toString(id), brand, model, formFactor, Double.toString(price), Boolean.toString(status));
    }


    @Override
    public String toString() {
      return "PCBuild{" + "ID=" + ID + "cpu=" + cpu.getId() + ", gpu=" + gpu.getId() + ", case1=" + case1.getId() + ", motherBoard=" + motherBoard.getId() + ", ram=" + ram.getId() + ", storage=" + storage.getId() + ", powerSupply=" + powerSupply.getId() + ", fan=" + fan.getId() + ", hdd=" + hdd.getId() + ", ssd=" + ssd.getId() + '}';
    }
}

