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
        loadComponent("GPU", GPU::readGPUFromCSV);
        loadComponent("Case", CaseDatabase::readCaseFromCSV);
        loadComponent("MotherBoard", MotherBoard::readMotherBoardFromCSV);
        loadComponent("Ram", Ram::readRamFromCSV);
        loadComponent("PSU", PSU::readPSUFromCSV);
        loadComponent("HDD", HDD::readHDDFromCSV);
        loadComponent("SSD", SSD::readSDDFromCSV);
        loadComponent("Fan", Fan::readFanFromCSV);
        users = loadUsers();
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

    private List<User> loadUsers() {
        String filePath = basePath + "user.csv";
        try {
            return User.readUsersFromCSV(filePath);
        } catch (Exception e) {
            // Handle exception and log error message
            System.err.println("Error loading users from " + filePath + ". Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void saveData() {
        saveComponent("CPU", CPUDatabase::writeCPUToCSV);
        saveComponent("GPU", GPU::writeGPUToCSV);
        saveComponent("Case", CaseDatabase::writeCaseToCSV);
        saveComponent("MotherBoard", MotherBoard::writeMotherBoardToCSV);
        saveComponent("Ram", Ram::writeRamToCSV);
        saveComponent("PSU", PSU::writePSUToCSV);
        saveComponent("HDD", HDD::writeHDDToCSV);
        saveComponent("SSD", SSD::writeSSDToCSV);
        saveComponent("Fan", Fan::writeFanToCSV);
        saveUsers();
    }

    @SuppressWarnings("unchecked")
    private <T> void saveComponent(String componentType, BiConsumer<String, List<T>> saver) {
        String filePath = basePath + componentType.toLowerCase() + ".csv";
        List<T> componentList = (List<T>) components.get(componentType);
        if (componentList != null) {
            saver.accept(filePath, componentList);
        }
    }

    private void saveUsers() {
        String filePath = basePath + "user.csv";
        try {
            User.writeUserToCSV(filePath, users);
        } catch (Exception e) {
            // Handle exception and log error message
            System.err.println("Error saving users to " + filePath + ". Error: " + e.getMessage());
        }
    }

    // Getters for the loaded data
    public List<CPUDatabase> getCpus() { return getComponents("CPU"); }
    public List<GPU> getGpus() { return getComponents("GPU"); }
    public List<CaseDatabase> getCases() { return getComponents("Case"); }
    public List<MotherBoard> getMotherboards() { return getComponents("MotherBoard"); }
    public List<Ram> getRams() { return getComponents("Ram"); }
    public List<PSU> getPsus() { return getComponents("PSU"); }
    public List<HDD> getHdds() { return getComponents("HDD"); }
    public List<SSD> getSsds() { return getComponents("SSD"); }
    public List<Fan> getFans() { return getComponents("Fan"); }

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
