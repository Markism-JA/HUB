package main.Model;
import main.Model.Components.*;
import java.util.List;

public class AdminDatabaseAccess {
    private List<Case> cases;
    private List<CPU> cpus;
    private List<Fan> fans;
    private List<GPU> gpus;
    private List<HDD> hdds;
    private List<InternalStorage> internalStorages;
    private List<MotherBoard> motherBoards;
    private List<PSU> psus;
    private List<Ram> rams;
    private List<SSD> ssds;
    private String caseFilePath;
    private String cpuFilePath;
    private String fanFilePath;
    private String gpuFilePath;
    private String hddFilePath;
    private String internalStorageFilePath;
    private String motherBoardFilePath;
    private String psuFilePath;
    private String ramFilePath;
    private String ssdFilePath;
    
    public AdminDatabaseAccess(String caseFilePath, String cpuFilePath, String fanFilePath, String gpuFilePath, String hddFilePath, String internalStorageFilePath, String motherBoardFilePath, String psuFilePath, String ramFilePath, String ssdFilePath) {
        this.caseFilePath = caseFilePath;
        this.cpuFilePath = cpuFilePath;
        this.fanFilePath = fanFilePath;
        this.gpuFilePath = gpuFilePath;
        this.hddFilePath = hddFilePath;
        this.internalStorageFilePath = internalStorageFilePath;
        this.motherBoardFilePath = motherBoardFilePath;
        this.psuFilePath = psuFilePath;
        this.ramFilePath = ramFilePath;
        this.ssdFilePath = ssdFilePath;
        
        this.cases = Case.readCaseFromCSV(caseFilePath);
        this.cpus = CPU.readCPUFromCSV(cpuFilePath);
        this.fans = Fan.readFanFromCSV(fanFilePath);
        this.gpus = GPU.readGPUFromCSV(gpuFilePath);
        this.hdds = HDD.readHDDFromCSV(hddFilePath);
        this.internalStorages = InternalStorage.readInternalStorageFromCSV(internalStorageFilePath);
        this.motherBoards = MotherBoard.readMotherBoardFromCSV(motherBoardFilePath);
        this.psus = PSU.readPSUFromCSV(psuFilePath);
        this.rams = Ram.readRamFromCSV(ramFilePath);
        this.ssds = SSD.readSSDFromCSV(ssdFilePath);
    }

    public void removeCase(int index) {
        if (index >= 0 && index < cases.size()) {
            cases.remove(index);
            saveCases(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }

    public void updateCase(int index, Case updatedCase) {
        if (index >= 0 && index < cases.size()) {
            cases.set(index, updatedCase);
            saveCases(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }

    private void saveCases() {
        Case.writeCaseToCSV(caseFilePath, cases);
    }

    public void addCPU(CPU newCPU) {
        cpus.add(newCPU);
        saveCPUs(); 
    }
    
    public void removeCPU(int index) {
        if (index >= 0 && index < cpus.size()) {
            cpus.remove(index);
            saveCPUs(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    public void updateCPU(int index, CPU updatedCPU) {
        if (index >= 0 && index < cpus.size()) {
            cpus.set(index, updatedCPU);
            saveCPUs(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    private void saveCPUs() {
        CPU.writeCPUToCSV(cpuFilePath, cpus);
    }
    
    public void addFan(Fan newFan) {
        fans.add(newFan);
        saveFans(); 
    }
    
    public void removeFan(int index) {
        if (index >= 0 && index < fans.size()) {
            fans.remove(index);
            saveFans(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    public void updateFan(int index, Fan updatedFan) {
        if (index >= 0 && index < fans.size()) {
            fans.set(index, updatedFan);
            saveFans(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    private void saveFans() {
        Fan.writeFanToCSV(fanFilePath, fans);
    }

    public void addGPU(GPU newGPU) {
        gpus.add(newGPU);
        saveGPUs(); 
    }
    
    public void removeGPU(int index) {
        if (index >= 0 && index < gpus.size()) {
            gpus.remove(index);
            saveGPUs(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    public void updateGPU(int index, GPU updatedGPU) {
        if (index >= 0 && index < gpus.size()) {
            gpus.set(index, updatedGPU);
            saveGPUs(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    private void saveGPUs() {
        GPU.writeGPUToCSV(gpuFilePath, gpus);
    }

    public void addHDD(HDD newHDD) {
        hdds.add(newHDD);
        saveHDDs(); 
    }
    
    public void removeHDD(int index) {
        if (index >= 0 && index < hdds.size()) {
            hdds.remove(index);
            saveHDDs(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    public void updateHDD(int index, HDD updatedHDD) {
        if (index >= 0 && index < hdds.size()) {
            hdds.set(index, updatedHDD);
            saveHDDs(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    private void saveHDDs() {
        HDD.writeHDDToCSV(hddFilePath, hdds);
    }

    public void addInternalStorage(InternalStorage newInternalStorage) {
        internalStorages.add(newInternalStorage);
        saveInternalStorages(); 
    }
    
    public void removeInternalStorage(int index) {
        if (index >= 0 && index < internalStorages.size()) {
            internalStorages.remove(index);
            saveInternalStorages(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    public void updateInternalStorage(int index, InternalStorage updatedInternalStorage) {
        if (index >= 0 && index < internalStorages.size()) {
            internalStorages.set(index, updatedInternalStorage);
            saveInternalStorages(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    private void saveInternalStorages() {
        InternalStorage.writeInternalStorageToCSV(internalStorageFilePath, internalStorages);
    }

    public void addMotherBoard(MotherBoard newMotherBoard) {
        motherBoards.add(newMotherBoard);
        saveMotherBoards(); 
    }
    
    public void removeMotherBoard(int index) {
        if (index >= 0 && index < motherBoards.size()) {
            motherBoards.remove(index);
            saveMotherBoards(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    public void updateMotherBoard(int index, MotherBoard updatedMotherBoard) {
        if (index >= 0 && index < motherBoards.size()) {
            motherBoards.set(index, updatedMotherBoard);
            saveMotherBoards(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    private void saveMotherBoards() {
        MotherBoard.writeMotherBoardToCSV(motherBoardFilePath, motherBoards);
    }

    public void addPSU(PSU newPSU) {
        psus.add(newPSU);
        savePSUs(); 
    }
    
    public void removePSU(int index) {
        if (index >= 0 && index < psus.size()) {
            psus.remove(index);
            savePSUs(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    public void updatePSU(int index, PSU updatedPSU) {
        if (index >= 0 && index < psus.size()) {
            psus.set(index, updatedPSU);
            savePSUs(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    private void savePSUs() {
        PSU.writePSUToCSV(psuFilePath, psus);
    }

    public void addRam(Ram newRam) {
        rams.add(newRam);
        saveRams(); 
    }
    
    public void removeRam(int index) {
        if (index >= 0 && index < rams.size()) {
            rams.remove(index);
            saveRams(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    public void updateRam(int index, Ram updatedRam) {
        if (index >= 0 && index < rams.size()) {
            rams.set(index, updatedRam);
            saveRams(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    private void saveRams() {
        Ram.writeRamToCSV(ramFilePath, rams);
    }

    public void addSSD(SSD newSSD) {
        ssds.add(newSSD);
        saveSSDs(); 
    }
    
    public void removeSSD(int index) {
        if (index >= 0 && index < ssds.size()) {
            ssds.remove(index);
            saveSSDs(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    public void updateSSD(int index, SSD updatedSSD) {
        if (index >= 0 && index < ssds.size()) {
            ssds.set(index, updatedSSD);
            saveSSDs(); 
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    
    private void saveSSDs() {
        SSD.writeSSDToCSV(ssdFilePath, ssds);
    }
}