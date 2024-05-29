package main.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.Map;
import java.util.HashMap;

import main.Model.DatabaseComponent.*;

public class Database {
    private Map<String, List<?>> components;
    private List<User> users;
    private String basePath;

    public Database(String basePath) {
        this.basePath = basePath;
        components = new HashMap<>();
        loadData();
    }

    public void loadData() {
        loadComponent("CPU", CPUDatabase::readCPUFromCSV);
        loadComponent("GPU", GPUDataBase::readGPUFromCSV);
        loadComponent("Case", CaseDatabase::readCaseFromCSV);
        loadComponent("MotherBoard", MotherBoardDatabase::readMotherBoardFromCSV);
        loadComponent("Ram", RamDatabase::readRamFromCSV);
        loadComponent("PSU", PSUDatabase::readPSUFromCSV);
        loadComponent("InternalStorageDatabas", InternalStorageDatabase::readInternalStorageFromCSV);
        loadComponent("Fan", FanDatabase::readFanFromCSV);

    }

    private <T> void loadComponent(String componentType, Function<String, List<T>> loader) {
        String filePath = basePath + componentType.toLowerCase() + ".csv";
        try {
            components.put(componentType, loader.apply(filePath));
        } catch (Exception e) {
            // Handle exception and log error message
            System.err.println("Error loading component: " + componentType + " from " + filePath + ". Error: " + e.getMessage());
            components.put(componentType, new ArrayList<>());
        }
    }


    public void saveData() {
        saveComponent("CPU", CPUDatabase::writeCPUToCSV);
        saveComponent("GPU", GPUDataBase::writeGPUToCSV);
        saveComponent("Case", CaseDatabase::writeCaseToCSV);
        saveComponent("MotherBoard", MotherBoardDatabase::writeMotherBoardToCSV);
        saveComponent("Ram", RamDatabase::writeRamToCSV);
        saveComponent("PSU", PSUDatabase::writePSUToCSV);
        saveComponent("InternalStorageDatabas", InternalStorageDatabase::writeHDDToCSV);
        saveComponent("Fan", FanDatabase::writeFanToCSV);
    
    }

    @SuppressWarnings("unchecked")
    private <T> void saveComponent(String componentType, BiConsumer<String, List<T>> saver) {
        String filePath = basePath + componentType.toLowerCase() + ".csv";
        List<T> componentList = (List<T>) components.get(componentType);
        if (componentList != null) {
            saver.accept(filePath, componentList);
        }
    }

    // Getters for the loaded data
    public List<CPUDatabase> getCpus() { return getComponents("CPU"); }
    public List<GPUDataBase> getGpus() { return getComponents("GPU"); }
    public List<CaseDatabase> getCases() { return getComponents("Case"); }
    public List<MotherBoardDatabase> getMotherboards() { return getComponents("MotherBoard"); }
    public List<RamDatabase> getRams() { return getComponents("Ram"); }
    public List<PSUDatabase> getPsus() { return getComponents("PSU"); }
    public List<InternalStorageDatabase> getHdds() { return getComponents("InternalStorageDatabas"); }
    public List<FanDatabase> getFans() { return getComponents("Fan"); }

    public List<User> getUsers() { return users; }

    @SuppressWarnings("unchecked")
    private <T> List<T> getComponents(String type) {
        return (List<T>) components.getOrDefault(type, new ArrayList<>());
    }

    public static void main(String[] args) {
        DataManager test = new DataManager("main/Resources/data");
        test.loadData();

        
        test.saveData();
    }
}
