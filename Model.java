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
          // Implementation of recommendation logic
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
            Writer output = new FileWriter("")
            output.write(usercredentials);
            output.close();
          }
          catch (Exception e) {
            e.getStackTrace();
        }
      }

      public void loginUser(String username, String password) {
          // Implementation of user login

          BufferedReader reader = new BufferedReader(new FileReader());
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
      // Fields and methods for data storage and management

      public void loadData() {
          // Implementation of data loading from files or database

      }

      public void saveData() {
          // Implementation of saving data to files or database

      }
  }
  // Database Management
  public class Database {
      // Inventory Management
      public class InventoryManagement {
          // Fields and methods for managing inventory data
          public void addInventoryItem(Component component) {
              // Implementation of adding inventory item
          }

          public void removeInventoryItem(Component component) {
              // Implementation of removing inventory item
          }

          public List<Component> getInventoryItems() {
              // Implementation of getting inventory items
              return new ArrayList<>(); // Dummy return
          }
      }

      // Market Reference Data
      public class MarketReferenceData {
          // Fields and methods for managing market reference data
          public void addMarketData(Component component) {
              // Implementation of adding market data
          }

          public void removeMarketData(Component component) {
              // Implementation of removing market data
          }

          public List<Component> getMarketData() {
              // Implementation of getting market data
              return new ArrayList<>(); // Dummy return
          }
      }
  }

  // Admin Database Access
  public class AdminDatabaseAccess {
      // Fields and methods for admin access to the database
      public void updateInventory(Component component) {
          // Implementation of updating inventory data
      }

      public void updateMarketData(Component component) {
          // Implementation of updating market data
      }
  }

  // Price Comparison Module
  public class PriceComparison {
    
    // Fields and methods for comparing prices of components
    String userDecision;

    public PriceComparison(String userDecision) {
      this.userDecision = userDecision;
  }

  public void comparePricesCPU(List<Component.CPU> components) {
      List<Component.CPU> highEnd = new ArrayList<>();
      List<Component.CPU> midEnd = new ArrayList<>();
      List<Component.CPU> lowEnd = new ArrayList<>();

      for (Component.CPU component : components) {
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
        private String model;
        private String brand;
        private float frequency;
        private double price;
        private String socket;
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
        private String chipset;
        private String brand;
        private int memory;
        private double price;
        private int wattage;

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
        private String brand;
        private String model;
        private String formFactor;
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
        private String brand;
        private String model;
        private String formFactor;
        private String socket;
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
        private String brand;
        private String model;
        private double price;
        private int wattage;
        private int frequency;

        public Ram(String brand, String model, double price, int wattage, int frequency) {
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

        public int getFrequency() {
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
                        Ram ram = new Ram(data[0], data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
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
        private String brand;

        brand, price, wattage, string rate

    }

    public static class HDD {
        private String brand, storage size, wattage

    }

    public static class SDD {
        private String brand, storage size, wattage
    }

    public static class InternalStorage {
        private String brand, storage size, wattage
    }

    public static class Fans {
        
    }

    }
}


