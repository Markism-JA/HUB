package main.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.Map;
import java.util.HashMap;

import main.Model.Components.*;

public class DataManager {
    private Map<String, List<?>> components;
    private List<User> users;
    private String basePath;
    private boolean allFilesReadSuccessfully;

    public DataManager(String basePath) {
        this.basePath = basePath.endsWith(File.separator) ? basePath : basePath + File.separator;
        components = new HashMap<>();
        allFilesReadSuccessfully = true; // Initialize the flag to true

        File baseDir = new File(this.basePath);
        if (baseDir.exists() && baseDir.isDirectory()) {
            System.out.println("Folder found: " + this.basePath);
            loadData();
        } else {
            System.err.println("Folder not found: " + this.basePath);
            // Handle the case when the folder is not found, e.g., create the folder or throw an exception
            allFilesReadSuccessfully = false; // Set flag to false if folder not found
        }

        // Print the final status of file reading
        if (allFilesReadSuccessfully) {
            System.out.println("All files read successfully.");
        } else {
            System.err.println("Some files could not be read.");
        }
    }

    public void loadData() {
        loadComponent("CPU", CPU::readCPUFromCSV);
        loadComponent("GPU", GPU::readGPUFromCSV);
        loadComponent("Case", Case::readCaseFromCSV);
        loadComponent("MotherBoard", MotherBoard::readMotherBoardFromCSV);
        loadComponent("Ram", Ram::readRamFromCSV);
        loadComponent("PSU", PSU::readPSUFromCSV);
        loadComponent("HDD", HDD::readHDDFromCSV);
        loadComponent("SSD", SSD::readSSDFromCSV);
        loadComponent("Fan", Fan::readFanFromCSV);
        loadComponent("InternalStorage", InternalStorage::readInternalStorageFromCSV);
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
            allFilesReadSuccessfully = false; // Set flag to false if any file fails to load
        }
    }

    private List<User> loadUsers() {
        String filePath = basePath + "user.csv";
        try {
            return User.readUsersFromCSV(filePath);
        } catch (Exception e) {
            // Handle exception and log error message
            System.err.println("Error loading users from " + filePath + ". Error: " + e.getMessage());
            allFilesReadSuccessfully = false; // Set flag to false if users file fails to load
            return new ArrayList<>();
        }
    }

    public void saveData() {
        saveComponent("CPU", CPU::writeCPUToCSV);
        saveComponent("GPU", GPU::writeGPUToCSV);
        saveComponent("Case", Case::writeCaseToCSV);
        saveComponent("MotherBoard", MotherBoard::writeMotherBoardToCSV);
        saveComponent("Ram", Ram::writeRamToCSV);
        saveComponent("PSU", PSU::writePSUToCSV);
        saveComponent("HDD", HDD::writeHDDToCSV);
        saveComponent("SSD", SSD::writeSSDToCSV);
        saveComponent("Fan", Fan::writeFanToCSV);
        saveComponent("InternalStorage", InternalStorage::writeInternalStorageToCSV);
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
    public List<CPU> getCpus() { return getComponents("CPU"); }
    public List<GPU> getGpus() { return getComponents("GPU"); }
    public List<Case> getCases() { return getComponents("Case"); }
    public List<MotherBoard> getMotherboards() { return getComponents("MotherBoard"); }
    public List<Ram> getRams() { return getComponents("Ram"); }
    public List<PSU> getPsus() { return getComponents("PSU"); }
    public List<HDD> getHdds() { return getComponents("HDD"); }
    public List<SSD> getSsds() { return getComponents("SSD"); }
    public List<Fan> getFans() { return getComponents("Fan"); }
    public List<InternalStorage> getInternalStorages() { return getComponents("InternalStorage"); }
    public List<User> getUsers() { return users; }

    @SuppressWarnings("unchecked")
    private <T> List<T> getComponents(String type) {
        return (List<T>) components.getOrDefault(type, new ArrayList<>());
    }

    public boolean allFilesReadSuccessfully() {
        return allFilesReadSuccessfully;
    }

    public static void main(String[] args) {
       
            DataManager dataManager = new DataManager("main/Resources/data");
            List<User> users = dataManager.getUsers();
    
            if (users.isEmpty()) {
                System.out.println("No users found.");
            } else {
                System.out.println("Loaded users:");
                for (User user : users) {
                    System.out.println(user);
                }
            }
        }
}
