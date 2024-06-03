package main.Model.PCBuild;

import main.Model.Components.CPU;
import main.Model.Components.Case;
import main.Model.Components.Fan;
import main.Model.Components.GPU;
import main.Model.Components.HDD;
import main.Model.Components.InternalStorage;
import main.Model.Components.MotherBoard;
import main.Model.Components.PSU;
import main.Model.Components.Ram;
import main.Model.Components.SSD;

public class MidHighPCBuild {
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

    public MidHighPCBuild (CPU cpu, GPU gpu, Case case1, MotherBoard motherBoard, Ram ram, InternalStorage storage, HDD hdd,SSD ssd, Fan fan, PSU powerSupply) {
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

    public PSU powerSupply() { return powerSupply; }
    public void setPowerSupply(PSU powerSupply) { this.powerSupply = powerSupply; }

    public Fan fan() { return fan; }
    public void setFan(Fan fan) { this.fan = fan; }

    public HDD hdd() { return hdd; }
    public void setHDD(HDD hdd) { this.hdd = hdd; }

    public SSD ssd() { return ssd; }
    public void setSSD(SSD ssd) { this.ssd = ssd; }

}

