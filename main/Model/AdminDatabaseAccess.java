package main.Model;
import main.Model.Components.*;
import java.util.List;

public class AdminDatabaseAccess {
    private List<Case> cases;
    private List<CPU> cpus;
    private List<Fan> fans;
    private List<GPU> gpus;
    private List<HDD> hdds;
    private String caseFilePath;
    private String cpuFilePath;
    private String fanFilePath;
    private String gpuFilePath;
    private String hddFilePath;
    
public AdminDatabaseAccess(String caseFilePath) {
        this.caseFilePath = caseFilePath;
        
        this.cases = Case.readCaseFromCSV(caseFilePath);
    }

    public void addCase(Case newCase) {
        cases.add(newCase);
        saveCases(); 
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

    
}