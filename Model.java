import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.function.Function;

//TODO: Incorporate a filewriter "CSV Writer" in the component class
//TODO: Incoporate a load method in DataManager
//TODO: Add a sorting and searching function to the Database class
//TODO: 


//hashing
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//String Builder
import java.lang.reflect.Field;
import java.util.StringJoiner;


public class Model {

    @FunctionalInterface
    public interface CSVMapper<T> {
        String apply(T t);
    }


    // Recommendation Module
    public class RecommendationModule {
      // Fields and methods for generating recommendations based on user inputs and predefined rules
      public void generateRecommendations(UserPreferences preferences) {
          //TODO Implementation of recommendation logic
      }
    }

    // User Account Management Module
    public class UserAccountManagement {
      // Fields and methods for managing user accounts

      String usercredentials;
    
      public void registerUser(String username, String password) {
          // Implementation of user registration
        Scanner scan = new Scanner(System.in);

        username = scan.nextLine();
        password = scan.nextLine();
        usercredentials = username + password;

          try{
            Writer output = new FileWriter("");
            output.write(usercredentials);
            output.close();
          }
          catch (Exception e) {
            e.getStackTrace();
        }
      }

      public void loginUser(String username, String password) {
          // Implementation of user login
          
          String delimiter = ",";

          BufferedReader reader = new BufferedReader(new FileReader(null));
          String userData = reader.readLine();
          String [] userDataArray = userData.split(delimiter);

          for(String loginValidator : userDataArray){

            if(loginValidator.equals(username) && loginValidator.equals(password)){
                //continue to proragm
            }
            else{
                //continue loop and ask 
            }
          }
      }

      public void saveUserPreferences(User user, UserPreferences preferences) {
          // Implementation of saving user preferences

      }
    }

    // Compatibility Checking Module
    public class CompatibilityChecking {
      // Fields and methods for checking compatibility of selected parts

        public boolean checkCompatibility(PCBuild pcBuild) {
            // Implementation of compatibility checking logic
            //kinasanimarkpogi

            return true; // Dummy return
        }
    }

    // Data Storage Module
    public class DataManager {
        private List<Component.CPU> cpus;
        private List<Component.GPU> gpus;
        private List<Component.Case> cases;
        private List<Component.MotherBoard> motherboards;
        private List<Component.Ram> rams;
        private List<Component.PSU> psus;
        private List<Component.HDD> hdds;
        private List<Component.SSD> ssds;
        private List<Component.Fan> fans;

        //User
        private List<Model.User> users;

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


        private List<Component.CPU> loadCPU(String filePath) {
            try {
                return Component.CPU.readCPUFromCSV(filePath);
            } catch (Exception e) {
                // Handle exception
                return new ArrayList<>();
            }
        }

        private List<Component.GPU> loadGPU(String filePath) {
            try {
                return Component.GPU.readGPUFromCSV(filePath);
            } catch (Exception e) {
                // Handle exception
                return new ArrayList<>();
            }
        }

        private List<Component.Case> loadCase(String filePath) {
            try {
                return Component.Case.readCaseFromCSV(filePath);
            } catch (Exception e) {
                // Handle exception
                return new ArrayList<>();
            }
        }

        private List<Component.MotherBoard> loadMotherBoard(String filePath) {
            try {
                return Component.MotherBoard.readMotherBoardFromCSV(filePath);
            } catch (Exception e) {
                // Handle exception
                return new ArrayList<>();
            }
        }

        private List<Component.Ram> loadRam(String filePath) {
            try {
                return Component.Ram.readRamFromCSV(filePath);
            } catch (Exception e) {
                // Handle exception
                return new ArrayList<>();
            }
        }

        private List<Component.PSU> loadPSU(String filePath) {
            try {
                return Component.PSU.readPSUFromCSV(filePath);
            } catch (Exception e) {
                // Handle exception
                return new ArrayList<>();
            }
        }

        private List<Component.HDD> loadHDD(String filePath) {
            try {
                return Component.HDD.readHDDFromCSV(filePath);
            } catch (Exception e) {
                // Handle exception
                return new ArrayList<>();
            }
        }

        private List<Component.SSD> loadSSD(String filePath) {
            try {
                return Component.SSD.readSDDFromCSV(filePath);
            } catch (Exception e) {
                // Handle exception
                return new ArrayList<>();
            }
        }

        private List<Component.Fan> loadFan(String filePath) {
            try {
                return Component.Fan.readFanFromCSV(filePath);
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
        public List<Component.CPU> getCpus() {
            return cpus;
        }

        public List<Component.GPU> getGpus() {
            return gpus;
        }

        public List<Component.Case> getCases() {
            return cases;
        }

        public List<Component.MotherBoard> getMotherboards() {
            return motherboards;
        }

        public List<Component.Ram> getRams() {
            return rams;
        }

        public List<Component.PSU> getPsus() {
            return psus;
        }

        public List<Component.HDD> getHdds() {
            return hdds;
        }

        public List<Component.SSD> getSsds() {
            return ssds;
        }

        public List<Component.Fan> getFans() {
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

    // Database Management
    public class Database {

        public class InventoryManagement {
            // Fields and methods for managing inventory data
            public void addInventoryItem(Component component) {
                //TODO Implementation of adding inventory item
            }

            public void removeInventoryItem(Component component) {
                //TODO Implementation of removing inventory item
            }

            public List<Component> getInventoryItems() {
                //TODO Implementation of getting inventory items
                return new ArrayList<>(); // Dummy return
            }
        }

        // Market Reference Data
        public class MarketReferenceData {
            // Fields and methods for managing market reference data
            public void addMarketData(Component component) {
                //tODO Implementation of adding market data
            }

            public void removeMarketData(Component component) {
                //TODO Implementation of removing market data
            }

            public List<Component> getMarketData() {
                //TODO Implementation of getting market data
                return new ArrayList<>(); // Dummy return
            }
        }
    }

    // Admin Database Access
    public class AdminDatabaseAccess {
        // Fields and methods for admin access to the database
        public void updateInventory(Component component) {
            //TODO Implementation of updating inventory data
        }

        public void updateMarketData(Component component) {
            //TODO Implementation of updating market data
        }
    }

    public class PriceComparison {
        private String userDecision;
    
        public PriceComparison(String userDecision) {
            this.userDecision = userDecision;
        }
    
        public void comparePricesCPU() {
            DataManager dataManager = new DataManager("./data/");
            List<Component.CPU> cpus = dataManager.getCpus();
    
            List<Component.CPU> highEnd = new ArrayList<>();
            List<Component.CPU> midEnd = new ArrayList<>();
            List<Component.CPU> lowEnd = new ArrayList<>();
    
            for (Component.CPU component : cpus) {
                double price = component.getPrice();
    
                if (price >= 1 && price <= 30) {
                    highEnd.add(component);
                } else if (price > 30 && price <= 60) {
                    midEnd.add(component);
                } else {
                    lowEnd.add(component);
                }
            }
    
            if ("High".equalsIgnoreCase(userDecision)) {
                listComponentsCPU(highEnd, "High End Components");
            } else if ("Mid".equalsIgnoreCase(userDecision)) {
                listComponentsCPU(midEnd, "Mid End Components");
            } else {
                listComponentsCPU(lowEnd, "Low End Components");
            }
        }
    
        private void listComponentsCPU(List<Component.CPU> components, String category) {
            System.out.println(category + ":");
            for (Component.CPU component : components) {
                System.out.println(component);
            }
        }
    
        public void comparePricesGPU() {
            DataManager dataManager = new DataManager("./data/");
            List<Component.GPU> gpus = dataManager.getGpus();
    
            List<Component.GPU> highEnd = new ArrayList<>();
            List<Component.GPU> midEnd = new ArrayList<>();
            List<Component.GPU> lowEnd = new ArrayList<>();
    
            for (Component.GPU component : gpus) {
                double price = component.getPrice();
    
                if (price >= 1 && price <= 30) {
                    highEnd.add(component);
                } else if (price > 30 && price <= 60) {
                    midEnd.add(component);
                } else {
                    lowEnd.add(component);
                }
            }
    
            if ("High".equalsIgnoreCase(userDecision)) {
                listComponentsGPU(highEnd, "High End Components");
            } else if ("Mid".equalsIgnoreCase(userDecision)) {
                listComponentsGPU(midEnd, "Mid End Components");
            } else {
                listComponentsGPU(lowEnd, "Low End Components");
            }
        }
    
        private void listComponentsGPU(List<Component.GPU> components, String category) {
            System.out.println(category + ":");
            for (Component.GPU component : components) {
                System.out.println(component);
            }
        }
        public void comparePricesCase() {
            DataManager dataManager = new DataManager("./data/");
            List<Component.Case> cases = dataManager.getCases();
    
            List<Component.Case> highEnd = new ArrayList<>();
            List<Component.Case> midEnd = new ArrayList<>();
            List<Component.Case> lowEnd = new ArrayList<>();
    
            for (Component.Case component : cases) {
                double price = component.getPrice();
    
                if (price >= 1 && price <= 30) {
                    highEnd.add(component);
                } else if (price > 30 && price <= 60) {
                    midEnd.add(component);
                } else {
                    lowEnd.add(component);
                }
            }
    
            if ("High".equalsIgnoreCase(userDecision)) {
                listComponentsCase(highEnd, "High End Components");
            } else if ("Mid".equalsIgnoreCase(userDecision)) {
                listComponentsCase(midEnd, "Mid End Components");
            } else {
                listComponentsCase(lowEnd, "Low End Components");
            }
        }
    
        private void listComponentsCase(List<Component.Case> components, String category) {
            System.out.println(category + ":");
            for (Component.Case component : components) {
                System.out.println(component);
            }
        }
        public void comparePricesMotherBoard() {
            DataManager dataManager = new DataManager("./data/");
            List<Component.MotherBoard> MotherBoard = dataManager.getMotherboards();
    
            List<Component.MotherBoard> highEnd = new ArrayList<>();
            List<Component.MotherBoard> midEnd = new ArrayList<>();
            List<Component.MotherBoard> lowEnd = new ArrayList<>();
    
            for (Component.MotherBoard component : MotherBoard) {
                double price = component.getPrice();
    
                if (price >= 1 && price <= 30) {
                    highEnd.add(component);
                } else if (price > 30 && price <= 60) {
                    midEnd.add(component);
                } else {
                    lowEnd.add(component);
                }
            }
    
            if ("High".equalsIgnoreCase(userDecision)) {
                listComponentsMotherBoard(highEnd, "High End Components");
            } else if ("Mid".equalsIgnoreCase(userDecision)) {
                listComponentsMotherBoard(midEnd, "Mid End Components");
            } else {
                listComponentsMotherBoard(lowEnd, "Low End Components");
            }
        }
    
        private void listComponentsMotherBoard(List<Component.MotherBoard> components, String category) {
            System.out.println(category + ":");
            for (Component.MotherBoard component : components) {
                System.out.println(component);
            }
        }
    }

  // User Preferences Class (example)
    public class UserPreferences {
        private int budget;
        private String primaryPurpose;
        private String preferredCPUBrand;
        private String preferredGPUBrand;
        private int storageCapacity;
        private int ram;
        private String formFactor;
        private String specificFeatures;

        // Getters and setters for the fields
        // ...
    }

    // User Class (example)
    public static class User {
        private String username;
        private String password;

        public User(String username, String password) {
        this.username = username;
        this.password = password;
        }

        public String getUserName() {
        return username;
        }

        public String getPassword() {
        return password;
        }

        //hash password
        private String hashPassword(String password) {

        }

        @Override
        public String toString() {
            return "User [username=" + username + ", password=" + password + "]";
            }

        public static List<User> readUsersFromCSV(String fileName) {
            return CSVUtils.readFromCSV(fileName, data -> new User(data[0], data[1]));
        }
    }

  // PC Build Class (example)
    public class PCBuild {
      private List<Component> components;

      // Getters and setters for the fields
      // ...
    }

    // Component Class: class definition for each PC parts
    public class Component {

        public static class CPU {
            private String model, brand, socket;
            private double price;
            private int wattage;
            private boolean status;

                public CPU(String model, String brand, double price, String socket, int wattage, boolean status) {
                    this.model = model;
                    this.brand = brand;
                    this.price = price;
                    this.socket = socket;
                    this.wattage = wattage;
                    this.status = status;
                }

                public String getModel() { return model; }
                public void setModel(String model) { this.model = model;}

                public String getBrand() { return brand; }
                public void setBrand(String model) { this.model = model;}

                public double getPrice() { return price; }
                public void setPrice(double price) { this.price = price; }

                public String getSocket() { return socket; }
                public void setSocket(String socket) { this.socket = socket; }

                public int getWattage() { return wattage; }
                public void setWattage(int wattage) { this.wattage = wattage; }

                public boolean getStatus() { return status; }
                public void setStatus(boolean status) { this.status = status; }

                @Override
                public String toString() {
                    return "CPU{" + "model='" + model + '\'' + ", brand='" + brand + '\'' + ", price=" + price + ", socket='" + socket + '\'' + ", wattage=" + wattage + ", status=" + status + '}';
                    }

                public static List<CPU> readCPUFromCSV(String fileName) {
                    return CSVUtils.readFromCSV(fileName, data -> new CPU(data[0], data[1], Double.parseDouble(data[2]), data[3], Integer.parseInt(data[4]), Boolean.parseBoolean(data[5])));
                    }

                public String toCSVString() {
                    return String.join(",", model, brand, Double.toString(price), socket, Integer.toString(wattage), Boolean.toString(status));
                }

                public static void writeCPUToCSV(String fileName, List<CPU> cpus) { 
                    CSVUtils.writeToCSV(fileName, cpus, CPU::toCSVString);
                }

        }

        public static class GPU {
            private String chipset, brand;
            private int memory, wattage;
            private double price;
            private boolean status;

                public GPU(String chipset, String brand, int memory, double price, int wattage, boolean status) {
                    this.chipset = chipset;
                    this.brand = brand;
                    this.memory = memory;
                    this.price = price;
                    this.wattage = wattage;
                    this.status = status;
                }

                public String getChipset() { return chipset; }
                public void setChipset(String chipset) { this.chipset = chipset; }

                public String getBrand() { return brand; }
                public void setBrand(String brand) { this.brand = brand; }

                public int getMemory() { return memory; }
                public void setMemory(int memory) { this.memory = memory; }

                public double getPrice() { return price; }
                public void setPrice(double price) { this.price = price; }

                public int getWattage() { return wattage; }
                public void setWattage(int wattage) { this.wattage = wattage; }

                public boolean getStatus() { return status; }
                public void setStatus(boolean status) { this.status = status; }

                @Override
                public String toString() {
                    return "GPU{" + "chipset='" + chipset + '\'' + ", brand='" + brand + '\'' + ", memory=" + memory + ", price=" + price + ", wattage=" + wattage + ", status=" + status + '}';
                    }

                public static List<GPU> readGPUFromCSV(String fileName) {
                    return CSVUtils.readFromCSV(fileName, data -> new GPU(data[0], data[1],Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), Boolean.parseBoolean(data[5])));
                    }

                public String toCSVString() {
                    return String.join(",", chipset, brand, Integer.toString(memory), Double.toString(price), Integer.toString(wattage), Boolean.toString(status));
                }

                public static void writeGPUToCSV(String fileName, List<GPU> gpus) { 
                    CSVUtils.writeToCSV(fileName, gpus, GPU::toCSVString);
                }

        }

        public static class Case {
            private String brand, model, formFactor;
            private double price;
            private boolean status;

                public Case(String brand, String model, String formFactor, double price, boolean status) {
                    this.brand = brand;
                    this.model = model;
                    this.formFactor = formFactor;
                    this.price = price;
                    this.status = status;
                }

                public String getBrand() { return brand; }
                public void setBrand(String brand) { this.brand = brand; }

                public String getModel() { return model; }
                public void setModel(String model) { this.model = model; }

                public String getFormFactor() { return formFactor; }
                public void setFormFactor(String formFactor) { this.formFactor = formFactor; }

                public double getPrice() { return price; }
                public void setPrice(double price) { this.price = price; }

                public boolean getStatus() { return status; }
                public void setStatus(boolean status) { this.status = status; }

                @Override
                public String toString() {
                    return "Case{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", formFactor='" + formFactor + '\'' + ", price=" + price + ", status=" + status + '}';
                    }
                
                public static List<Case> readCaseFromCSV(String fileName) {
                    return CSVUtils.readFromCSV(fileName, data -> new Case(data[0], data[1], data[2], Double.parseDouble(data[3]), Boolean.parseBoolean(data[4])));
                    }

                public String toCSVString() {
                    return String.join(",", brand, model, Double.toString(price), Boolean.toString(status));
                }

                public static void writeCaseToCSV(String fileName, List<Case> cases) {
                    CSVUtils.writeToCSV(fileName, cases, Case::toCSVString);
                }
        }

        public static class MotherBoard {
            private String brand, model, formFactor, socket;
            private double price;
            private int wattage;
            private boolean status;

            public MotherBoard(String brand, String model, String formFactor, String socket, double price, int wattage, boolean status) {
                this.brand = brand;
                this.model = model;
                this.formFactor = formFactor;
                this.socket = socket;
                this.price = price;
                this.wattage = wattage;
                this.status = status;
            }

            public String getBrand() { return brand; }
            public void setBrand (String brand) { this.brand = brand; }

            public String getModel() { return model; }
            public void setModel (String model) { this.model = model; }

            public String getFormFactor() { return formFactor; }
            public void setFormFactor (String formFactor) { this.formFactor = formFactor; }

            public String getSocket() { return socket; }
            public void setSocket (String socket) { this.socket = socket; }

            public double getPrice() { return price; }
            public void setPrice( double price) { this.price = price; };
 
            public int getWattage() { return wattage; }
            public void setWattage (int wattage) { this.wattage = wattage; }

            public boolean getStatus() { return status; }
            public void setStatus(boolean status) { this.status = status; }

            @Override
            public String toString() {
                return "MotherBoard{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", formFactor='" + formFactor + '\'' + ", socket='" + socket + '\'' + ", price=" + price + ", wattage=" + wattage + ", status=" + status + '}';
                }
                
            public static List<MotherBoard> readMotherBoardFromCSV(String fileName) {
                return CSVUtils.readFromCSV(fileName, data -> new MotherBoard(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]), Integer.parseInt(data[5]), Boolean.parseBoolean(data[6])));
                }

            public String toCSVString() {
                return String.join(",", brand, model, formFactor, socket, Double.toString(price), Integer.toString(wattage), Boolean.toString(status));
            }

            public static void writeMotherBoardToCSV(String fileName, List<MotherBoard> motherBoards) {
                CSVUtils.writeToCSV(fileName, motherBoards, MotherBoard::toCSVString);
            }
        }

        public static class Ram {
            private String brand, model;
            private double price;
            private int wattage; 
            private float frequency;
            private boolean status;

                public Ram(String brand, String model, double price, int wattage, float frequency, boolean status) {
                    this.brand = brand;
                    this.model = model;
                    this.price = price;
                    this.wattage = wattage;
                    this.frequency = frequency;
                    this.status = status;
                }

                public String getBrand() { return brand; }
                public void setBrand(String brand) { this.brand = brand; }

                public String getModel() { return model; }
                public void setModel (String model) { this.model = model; }

                public double getPrice() { return price; }
                public void setPrice(double price) { this.price = price; };

                public int getWattage() { return wattage; }
                public void setWattage (int wattage) { this.wattage = wattage; }

                public float getFrequency() { return frequency; }
                public void setFrequency (float frequency) { this.frequency = frequency; }

                public boolean getStatus() { return status; }
                public void setStatus(boolean status) { this.status = status; }

                @Override
                public String toString() {
                    return "Ram{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", price=" + price + ", wattage=" + wattage + ", frequency=" + frequency + ", status=" + status + '}';
                    }

                public static List<Ram> readRamFromCSV(String fileName) {
                    return CSVUtils.readFromCSV(fileName, data -> new Ram(data[0], data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]), Float.parseFloat(data[4]), Boolean.parseBoolean(data[5])));
                    }

                public String toCSVString() {
                    return String.join(",", brand, model, Double.toString(price), Integer.toString(wattage), Float.toString(frequency), Boolean.toString(status));
                }

                public static void writeRamToCSV(String fileName, List<Ram> rams) {
                    CSVUtils.writeToCSV(fileName, rams, Ram::toCSVString);
                }
        }

        public static class PSU {
            private String brand, model, rate;
            private double price;
            private int wattage;
            private boolean status;

                public PSU(String brand, String model, double price, String rate, int wattage, boolean status) {
                    this.brand = brand;
                    this.model = model;
                    this.price = price;
                    this.rate = rate;
                    this.wattage = wattage;
                    this.status = status;
                }

                public String getBrand() { return brand; }
                public void setBrand(String brand) { this.brand = brand; }

                public String getModel() { return model; }
                public void setModel(String model) { this.model = model; }

                public double getPrice() { return price; }
                public void setPrice(double price) { this.price = price; }

                public String getRate() { return rate; }
                public void setRate(String rate) { this.rate = rate; }

                public int getWattage() { return wattage; }
                public void setWattage(int wattage) { this.wattage = wattage; }

                public boolean getStatus() { return status; }
                public void setStatus(boolean status) { this.status = status; }

                @Override
                public String toString() {
                    return "PSU{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", price=" + price + ", rate='" + rate + '\'' + ", wattage=" + wattage + ", status=" + status + '}';
                }

                public static List<PSU> readPSUFromCSV(String fileName) {
                    return CSVUtils.readFromCSV(fileName, data -> new PSU(data[0], data[1], Double.parseDouble(data[2]), data[3], Integer.parseInt(data[4]), Boolean.parseBoolean(data[5])));
                }

                public String toCSVString() {
                    return String.join(",", brand, model, Double.toString(price), rate, Integer.toString(wattage), Boolean.toString(status));
                }

                public static void writePSUToCSV(String fileName, List<PSU> psus) {
                    CSVUtils.writeToCSV(fileName, psus, PSU::toCSVString);
                }

            }

        public static class HDD {
                private String brand;
                private int storageSize, wattage;
                private double price;
                private boolean status;

                    public HDD(String brand, int storageSize, int wattage, double price, boolean status) {
                        this.brand = brand;
                        this.storageSize = storageSize;
                        this.wattage = wattage;
                        this.price = price;
                        this.status = status;
                    }

                    public String getBrand() { return brand; }
                    public void setBrand(String brand) { this.brand = brand; }

                    public int getStorageSize() { return storageSize; }
                    public void setStorageSize(int storageSize) { this.storageSize = storageSize; }

                    public int getWattage() { return wattage; }
                    public void setWattage(int wattage) { this.wattage = wattage; }

                    public double getPrice() { return price; }
                    public void setPrice(double price) { this.price = price; }

                    public boolean getStatus() { return status; }
                    public void setStatus(boolean status) { this.status = status; }

                    @Override
                    public String toString() {
                        return "HDD{" + "brand='" + brand + '\'' + ", storageSize=" + storageSize + ", wattage=" + wattage + ", price=" + price + '}';
                        }
                
                    public static List<HDD> readHDDFromCSV(String fileName) {
                        return CSVUtils.readFromCSV(fileName, data -> new HDD(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Double.parseDouble(data[3]), Boolean.parseBoolean(data[4])));
                    }

                    public String toCSVString() {
                        return String.join(",", brand, Integer.toString(storageSize), Integer.toString(wattage), Double.toString(price), Boolean.toString(status));
                    }

                    public static void writeHDDToCSV(String fileName, List<HDD> hdds) {
                        CSVUtils.writeToCSV(fileName, hdds, HDD::toCSVString);
                    }
            }

        public static class SSD {
            private String brand;
            private int storageSize, wattage;
            private double price;
            private boolean status;

                public SSD (String brand, int storageSize, int wattage, double price, boolean status) {
                    this.brand = brand;
                    this.storageSize = storageSize;
                    this.wattage = wattage;
                    this.price = price;
                    this.status = status;
                }

                public String getBrand() { return brand; }
                public void setBrand(String brand) { this.brand = brand; }

                public int getStorageSize() { return storageSize; }
                public void setStorageSize(int storageSize)  { this.storageSize = storageSize; }

                public int getWattage() { return wattage; }
                public void setWattage(int wattage) { this.wattage = wattage; } 

                public double getPrice() { return price; }
                public void setPrice(double price) { this.price = price; }

                public boolean getStatus() { return status; }
                public void setStatus(boolean status) { this.status = status; }

                @Override
                public String toString() {
                    return "SDD{" + "brand='" + brand + '\'' + ", storageSize=" + storageSize + ", wattage=" + wattage +  ", price=" + price + ", status=" + status + '}';
                    }

                public static List<SSD> readSDDFromCSV(String fileName) {
                    return CSVUtils.readFromCSV(fileName, data -> new SSD(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Double.parseDouble(data[3]), Boolean.parseBoolean(data[4])));
                    } 
                    
                public String toCSVString() {
                    return String.join(",", brand, Integer.toString(storageSize), Integer.toString(wattage), Double.toString(price), Boolean.toString(status));
                }

                public static void writeSSDToCSV(String fileName, List<SSD> sdds) {
                    CSVUtils.writeToCSV(fileName, sdds, SSD::toCSVString);
                }
        }

        public static class InternalStorage {
            private String brand;
            private int storageSize, wattage;
            private double price;
            private boolean status;

            public InternalStorage (String brand, int storageSize, int wattage, double price, boolean status) {
                this.brand = brand;
                this.storageSize = storageSize;
                this.wattage = wattage;
                this.price = price;
                this.status = status;
            }

            public String getBrand() { return brand; }
            public void setBrand(String brand) { this.brand = brand; }

            public int getStorageSize() { return storageSize; }
            public void setStorageSize(int storageSize)  { this.storageSize = storageSize; }

            public int getWattage() { return wattage; }
            public void setWattage(int wattage) { this.wattage = wattage; }

            public double getPrice() { return price; }
            public void setPrice(double price) { this.price = price; }

            public boolean getStatus() { return status; }
            public void setStatus(boolean status) { this.status = status; }

            @Override
            public String toString() {
                return "InternalStorage{" + "brand='" + brand + '\'' + ", storageSize=" + storageSize + ", wattage=" + wattage +", price=" + price + ", status=" + status + '}';
            }

            public static List<InternalStorage> readInternalStorageFromCSV(String fileName) {
                return CSVUtils.readFromCSV(fileName, data -> new InternalStorage(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Double.parseDouble(data[3]), Boolean.parseBoolean(data[4])));
            }

            public String toCSVString() {
                return String.join(",", brand, Integer.toString(storageSize), Integer.toString(wattage), Double.toString(price), Boolean.toString(status));
            }

            public static void writeInternalStorageToCSV(String fileName, List<InternalStorage> internalStorages) {
                CSVUtils.writeToCSV(fileName, internalStorages, InternalStorage::toCSVString);
            }
        }

        public static class Fan {
            private String brand, model;
            private int wattage, size;
            private double price;
            private boolean status;

            public Fan(String brand, String model, int wattage, int size, double price, boolean status) {
                this.brand = brand;
                this.model = model;
                this.wattage = wattage;
                this.size = size;
                this.price = price;
                this.status = status;
            }

            public String getBrand() { return brand; }
            public void setBrand(String brand) { this.brand = brand; }

            public String getModel() { return model; }
            public void setModel(String model) { this.model = model; }

            public int getWattage() { return wattage; }
            public void setWattage(int wattage) { this.wattage = wattage; }

            public int getSize() { return size; }
            public void setSize(int size) { this.size = size; }

            public double getPrice() { return price; }
            public void setPrice(double price) { this.price = price; }

            public boolean getStatus() { return status; }
            public void setStatus(boolean status) { this.status = status; }

            @Override
            public String toString() {
                return "Fan{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", wattage=" + wattage + ", size=" + size + ", price=" + price + ", status=" + status + '}';
            }

            public static List<Fan> readFanFromCSV(String fileName) {
                return CSVUtils.readFromCSV(fileName, data -> new Fan(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[4]), Boolean.parseBoolean(data[5])));
            }
            

            public String toCSVString() {
                return String.join(",", brand, model, Integer.toString(wattage), Integer.toString(size), Double.toString(price), Boolean.toString(status));
            }

            public static void writeHDDToCSV(String fileName, List<Fan> fans) {
                CSVUtils.writeToCSV(fileName, fans, Fan::toCSVString);
            }

        }
    }

    //CSV Reader and Writer
    public class CSVUtils {

        //getHeader for each component class
        public static String getHeader(Class<?> clazz) {
            StringBuilder header = new StringBuilder();
            for (Field field : clazz.getDeclaredFields()) {
                header.append(field.getName()).append(",");
            }
            return header.toString().replaceAll(",$", ""); // remove trailing comma
        }

        //CSVReader
        public static <T> List<T> readFromCSV(String fileName, Function<String[], T> mapper) {
            List<T> items = new ArrayList<>();
            String line;
            String splitBy = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(splitBy);
                    items.add(mapper.apply(data));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return items;
            }

            public static <T> void writeToCSV(String fileName, List<T> items, CSVMapper<T> mapper) {
                String header = getHeader(items.get(0).getClass());
                try (FileWriter writer = new FileWriter(fileName)) {
                    writer.write(header + "\n"); // Write header
        
                    for (T item : items) {
                        writer.write(mapper.apply(item) + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }

    public static void main(String[] args) {
    }
    
}
