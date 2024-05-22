import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Model {

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
  public class DataStorage {
    private List<Model.Component.CPU> cpus;
    private List<Model.Component.GPU> gpus;
    private List<Model.Component.Case> cases;
    private List<Model.Component.MotherBoard> motherboards;
    private List<Model.Component.Ram> rams;
    private List<Model.Component.PSU> psus;
    private List<Model.Component.HDD> hdds;

    public DataStorage() {
        loadDataFromCSV();
    }

    private void loadDataFromCSV() {
        cpus = loadCPU(null);
        gpus = loadGPU(null);
        cases = loadCase(null);
        motherboards = loadMotherBoard(null);
        rams = loadRam(null);
        psus = loadPSU(null);
        hdds = loadHDD(null);
    }

    private List<Model.Component.CPU> loadCPU(String filePath) {
        try {
            return Component.CPU.CSVReader.readCPUsFromCSV(filePath);
        } catch (Exception e) {
            // Handle exception
            return new ArrayList<>();
        }
    }

    private List<Model.Component.GPU> loadGPU(String filePath) {
        try {
            return Component.GPU.CSVReader.readGPUsFromCSV(filePath);
        } catch (Exception e) {
            // Handle exception
            return new ArrayList<>();
        }
    }

    private List<Model.Component.Case> loadCase(String filePath) {
        try {
            return Component.Case.CSVReader.readCasesFromCSV(filePath);
        } catch (Exception e) {
            // Handle exception
            return new ArrayList<>();
        }
    }

    private List<Model.Component.MotherBoard> loadMotherBoard(String filePath) {
        try {
            return Component.MotherBoard.CSVReader.readMotherBoardsFromCSV(filePath);
        } catch (Exception e) {
            // Handle exception
            return new ArrayList<>();
        }
    }

    private List<Model.Component.Ram> loadRam(String filePath) {
        try {
            return Component.Ram.CSVReader.readRamsFromCSV(filePath);
        } catch (Exception e) {
            // Handle exception
            return new ArrayList<>();
        }
    }

    private List<Model.Component.PSU> loadPSU(String filePath) {
        try {
            return Component.PSU.CSVReader.readPSUsFromCSV(filePath);
        } catch (Exception e) {
            // Handle exception
            return new ArrayList<>();
        }
    }

    private List<Model.Component.HDD> loadHDD(String filePath) {
        try {
            return Component.HDD.CSVReader.readHDDsFromCSV(filePath);
        } catch (Exception e) {
            // Handle exception
            return new ArrayList<>();
        }
    }

    // Getters for the loaded data
    public List<Model.Component.CPU> getCpus() {
        return cpus;
    }

    public List<Model.Component.GPU> getGpus() {
        return gpus;
    }

    public List<Model.Component.Case> getCases() {
        return cases;
    }

    public List<Model.Component.MotherBoard> getMotherboards() {
        return motherboards;
    }

    public List<Model.Component.Ram> getRams() {
        return rams;
    }

    public List<Model.Component.PSU> getPsus() {
        return psus;
    }

    public List<Model.Component.HDD> getHdds() {
        return hdds;
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

  // Price Comparison Module
    //FIXME Ron gumawa ako ng loadMethod para reusable yong code natin sa database gamitin mo dito
  public class PriceComparison {
    
  // Fields and methods for comparing prices of components
    String userDecision;

    public PriceComparison(String userDecision) {
        this.userDecision = userDecision;
    }
    
    public void comparePricesCPU(List<Model.Component.CPU> components) {
        List<Model.Component.CPU> highEnd = new ArrayList<>();
        List<Model.Component.CPU> midEnd = new ArrayList<>();
        List<Model.Component.CPU> lowEnd = new ArrayList<>();

        for (Model.Component.CPU component : components) {
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

    private void listComponentsCPU(List<Model.Component.CPU> components, String category) {
        System.out.println(category + ":");
        for (Model.Component.CPU component : components) {
            System.out.println(component);
        }
    }


    public void comparePricesGPU(List<Component.GPU> components) {
        List<Component.GPU> highEnd = new ArrayList<>();
        List<Component.GPU> midEnd = new ArrayList<>();
        List<Component.GPU> lowEnd = new ArrayList<>();

        for (Component.GPU component : components) {
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
  public class User {
      private String username;
      private String password;

      // Getters and setters for the fields
      // ...
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
        private float frequency;
        private double price;
        private int wattage;

        public CPU(String model, String brand, float frequency, double price, String socket, int wattage) {
            this.model = model;
            this.brand = brand;
            this.frequency = frequency;
            this.price = price;
            this.socket = socket;
            this.wattage = wattage;
        }

        public String getModel() {
            return model;
        }

        public String getBrand() {
            return brand;
        }

        public float getFrequency() {
            return frequency;
        }

        public double getPrice() {
            return price;
        }

        public String getSocket() {
            return socket;
        }

        public int getWattage() {
            return wattage;
        }

        @Override
        public String toString() {
            return "CPU{" +
                    "model='" + model + '\'' +
                    ", brand='" + brand + '\'' +
                    ", frequency=" + frequency +
                    ", price=" + price +
                    ", socket='" + socket + '\'' +
                    ", wattage=" + wattage +
                    '}';
        }



        public static class CSVReader {
            public static List<CPU> readCPUsFromCSV(String fileName) {
                List<CPU> cpus = new ArrayList<>();
                String line = "";
                String splitBy = ",";
    
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    br.readLine(); // Skip the header
    
                    while ((line = br.readLine())!= null) {
                        String[] data = line.split(splitBy);
                        CPU cpu = new CPU(data[0], data[1], Float.parseFloat(data[2]), Double.parseDouble(data[3]), data[4], Integer.parseInt(data[5]));
                        cpus.add(cpu);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
    
                return cpus;
            }
        }
    
    }

    public static class GPU {
        private String chipset, brand;
        private int memory, wattage;
        private double price;

        public GPU(String chipset, String brand, int memory, double price, int wattage) {
            this.chipset = chipset;
            this.brand = brand;
            this.memory = memory;
            this.price = price;
            this.wattage = wattage;
        }

        public String getChipset() {
            return chipset;
        }

        public String getBrand() {
            return brand;
        }

        public int getMemory() {
            return memory;
        }

        public double getPrice() {
            return price;
        }

        public int getWattage() {
            return wattage;
        }

        @Override
        public String toString() {
            return "GPU{" +
                    "chipset='" + chipset + '\'' +
                    ", brand='" + brand + '\'' +
                    ", memory=" + memory +
                    ", price=" + price +
                    ", wattage=" + wattage +
                    '}';
        }

        public static class CSVReader {
            public static List<GPU> readGPUsFromCSV(String fileName) {
                List<GPU> gpus = new ArrayList<>();
                String line = "";
                String splitBy = ",";

                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    br.readLine();

                    while ((line = br.readLine())!= null) {
                        String[] data = line.split(splitBy);
                        GPU gpu = new GPU(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]));
                        gpus.add(gpu); // Add the GPU to the list
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return gpus;
            }
        }
    }

    public static class Case {
        private String brand, model, formFactor;
        private double price;

        public Case(String brand, String model, String formFactor, double price) {
            this.brand = brand;
            this.model = model;
            this.formFactor = formFactor;
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public String getFormFactor() {
            return formFactor;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Case{" +
                    "brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", formFactor='" + formFactor + '\'' +
                    ", price=" + price +
                    '}';
        }

        public static class CSVReader {
            public static List<Case> readCasesFromCSV(String fileName) {
                List<Case> cases = new ArrayList<>();
                String line = "";
                String splitBy = ",";

                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    br.readLine(); // Skip the header

                    while ((line = br.readLine())!= null) {
                        String[] data = line.split(splitBy);
                        Case case1 = new Case(data[0], data[1], data[2], Double.parseDouble(data[3]));
                        cases.add(case1); // Add the Case to the list
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return cases;
            }
        }
    }

    public static class MotherBoard {
        private String brand, model, formFactor, socket;
        private double price;
        private int wattage;

        public MotherBoard(String brand, String model, String formFactor, String socket, double price, int wattage) {
            this.brand = brand;
            this.model = model;
            this.formFactor = formFactor;
            this.socket = socket;
            this.price = price;
            this.wattage = wattage;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public String getFormFactor() {
            return formFactor;
        }

        public String getSocket() {
            return socket;
        }

        public double getPrice() {
            return price;
        }

        public int getWattage() {
            return wattage;
        }

        @Override
        public String toString() {
            return "MotherBoard{" +
                    "brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", formFactor='" + formFactor + '\'' +
                    ", socket='" + socket + '\'' +
                    ", price=" + price +
                    ", wattage=" + wattage +
                    '}';
        }

        public static class CSVReader {
            public static List<MotherBoard> readMotherBoardsFromCSV(String fileName) {
                List<MotherBoard> motherBoards = new ArrayList<>();
                String line = "";
                String splitBy = ",";

                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    br.readLine();

                    while ((line = br.readLine())!= null) {
                        String[] data = line.split(splitBy);
                        MotherBoard motherBoard = new MotherBoard(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]), Integer.parseInt(data[5]));
                        motherBoards.add(motherBoard);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    }

                return motherBoards;
                }
            }
        }
    
    public static class Ram {
        private String brand, model;
        private double price;
        private int wattage; 
        private float frequency;

        public Ram(String brand, String model, double price, int wattage, float frequency) {
            this.brand = brand;
            this.model = model;
            this.price = price;
            this.wattage = wattage;
            this.frequency = frequency;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public double getPrice() {
            return price;
        }

        public int getWattage() {
            return wattage;
        }

        public float getFrequency() {
            return frequency;
        }

        @Override
        public String toString() {
            return "Ram{" +
                    "brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", price=" + price +
                    ", wattage=" + wattage +
                    ", frequency=" + frequency +
                    '}';
        }

        public static class CSVReader {
            public static List<Ram> readRamsFromCSV(String fileName) {
                List<Ram> rams = new ArrayList<>();
                String line = "";
                String splitBy = ",";

                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    while ((line = br.readLine())!= null) {
                        String[] data = line.split(splitBy);
                        Ram ram = new Ram(data[0], data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]), Float.parseFloat(data[4]));
                        rams.add(ram);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                    return rams;
                }
            }
        }

    public static class PSU {
        private String brand, model, rate;
        private double price;
        private int wattage;
    
            public PSU(String brand, String model, double price, String rate, int wattage) {
                this.brand = brand;
                this.model = model;
                this.price = price;
                this.rate = rate;
                this.wattage = wattage;
            }
    
            public String getBrand() {
                return brand;
            }
    
            public String getModel() {
                return model;
            }
    
            public double getPrice() {
                return price;
            }
    
            public String getRate() {
                return rate;
            }
    
            public int getWattage() {
                return wattage;
            }
    
            @Override
            public String toString() {
                return "PSU{" +
                        "brand='" + brand + '\'' +
                        ", model='" + model + '\'' +
                        ", price=" + price +
                        ", rate='" + rate + '\'' +
                        ", wattage=" + wattage +
                        '}';
            }
    
            public static class CSVReader {
                public static List<PSU> readPSUsFromCSV(String fileName) {
                    List<PSU> psus = new ArrayList<>();
                    String line = "";
                    String splitBy = ",";
    
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        while ((line = br.readLine())!= null) {
                            String[] data = line.split(splitBy);
                            PSU psu = new PSU(data[0], data[1], Double.parseDouble(data[2]), data[3], Integer.parseInt(data[4]));
                            psus.add(psu);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
    
                    return psus;
                }
            }
        }

    public static class HDD {
            private String brand;
            private int storageSize, wattage;
            private double price;
    
            public HDD(String brand, int storageSize, int wattage, double price) {
                this.brand = brand;
                this.storageSize = storageSize;
                this.wattage = wattage;
                this.price = price;
            }
    
            public String getBrand() {
                return brand;
            }
    
            public int getStorageSize() {
                return storageSize;
            }
    
            public int getWattage() {
                return wattage;
            }
    
            public double getPrice() {
                return price;
            }
    
            @Override
            public String toString() {
                return "HDD{" +
                        "brand='" + brand + '\'' +
                        ", storageSize=" + storageSize +
                        ", wattage=" + wattage +
                        ", price=" + price +
                        '}';
            }
    
            public static class CSVReader {
                public static List<HDD> readHDDsFromCSV(String fileName) {
                    List<HDD> hdds = new ArrayList<>();
                    String line = "";
                    String splitBy = ",";
    
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        while ((line = br.readLine())!= null) {
                            String[] data = line.split(splitBy);
                            HDD hdd = new HDD(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Double.parseDouble(data[3]));
                            hdds.add(hdd);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
    
                    return hdds;
                }
            }
        }

    public static class SDD {
        private String brand;
        private int storageSize, wattage;
        private double price;

        public SDD (String brand, int storageSize, int wattage, double price) {
            this.brand = brand;
            this.storageSize = storageSize;
            this.wattage = wattage;
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        public int getStorageSize() {
            return storageSize;
        }

        public int getWattage() {
            return wattage;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "SDD{" +
                    "brand='" + brand + '\'' +
                    ", storageSize=" + storageSize +
                    ", wattage=" + wattage +
                    ", price=" + price +
                    '}';
        }

        public static class CSVReader {
            public static List<SDD> readHDDsFromCSV(String fileName) {
                List<SDD> sdds = new ArrayList<>();
                String line = "";
                String splitBy = ",";

                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    while ((line = br.readLine())!= null) {
                        String[] data = line.split(splitBy);
                        SDD hdd = new SDD(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Double.parseDouble(data[3]));
                        sdds.add(hdd);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return sdds;
            }
        }
    }

    public static class InternalStorage {
        private String brand;
        private int storageSize, wattage;

        public InternalStorage (String brand, int storageSize, int wattage) {
            this.brand = brand;
            this.storageSize = storageSize;
            this.wattage = wattage;
        }

        public String getBrand() {
            return brand;
        }

        public int getStorageSize() {
            return storageSize;
        }

        public int wattage() {
            return wattage;
        }

        @Override
        public String toString() {
            return "InternalStorage{" +
                "brand='" + brand + '\'' +
                ", storageSize=" + storageSize +
                ", wattage=" + wattage +
                '}';
        }

        public static class CSVReader {
            public static List<InternalStorage> readCSV(String fileName) {
                List<InternalStorage> internalStorages = new ArrayList<>();
                String line = "";
                String splitBy = ",";
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    while ((line = br.readLine()) != null) {
                        String[] storage = line.split(splitBy);
                        InternalStorage internalStorage = new InternalStorage(storage[0], Integer.parseInt(storage[1]), Integer.parseInt(storage[2]));
                        internalStorages.add(internalStorage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return internalStorages;
            }
        }
    }

    public static class Fans {
        
        }

    }
}

