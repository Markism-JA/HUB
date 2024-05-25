package main.Model;

import java.util.ArrayList;
import java.util.List;
import main.Model.Components.*;

public class PriceComparison {
    private String userDecision;

    public PriceComparison(String userDecision) {
        this.userDecision = userDecision;
    }

    public void comparePricesCPU() {
        DataManager dataManager = new DataManager("./data/");
        List<CPU> cpus = dataManager.getCpus();

        List<CPU> highEnd = new ArrayList<>();
        List<CPU> midEnd = new ArrayList<>();
        List<CPU> lowEnd = new ArrayList<>();

        for (CPU component : cpus) {
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

    private void listComponentsCPU(List<CPU> components, String category) {
        System.out.println(category + ":");
        for (CPU component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesGPU() {
        DataManager dataManager = new DataManager("./data/");
        List<GPU> gpus = dataManager.getGpus();

        List<GPU> highEnd = new ArrayList<>();
        List<GPU> midEnd = new ArrayList<>();
        List<GPU> lowEnd = new ArrayList<>();

        for (GPU component : gpus) {
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

    private void listComponentsGPU(List<GPU> components, String category) {
        System.out.println(category + ":");
        for (GPU component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesCase() {
        DataManager dataManager = new DataManager("./data/");
        List<Case> cases = dataManager.getCases();

        List<Case> highEnd = new ArrayList<>();
        List<Case> midEnd = new ArrayList<>();
        List<Case> lowEnd = new ArrayList<>();

        for (Case component : cases) {
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

    private void listComponentsCase(List<Case> components, String category) {
        System.out.println(category + ":");
        for (Case component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesMotherBoard() {
        DataManager dataManager = new DataManager("./data/");
        List<MotherBoard> MotherBoard = dataManager.getMotherboards();

        List<MotherBoard> highEnd = new ArrayList<>();
        List<MotherBoard> midEnd = new ArrayList<>();
        List<MotherBoard> lowEnd = new ArrayList<>();

        for (MotherBoard component : MotherBoard) {
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

    private void listComponentsMotherBoard(List<MotherBoard> components, String category) {
        System.out.println(category + ":");
        for (MotherBoard component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesRam() {
        DataManager dataManager = new DataManager("./data/");
        List<Ram> Ram = dataManager.getRams();

        List<Ram> highEnd = new ArrayList<>();
        List<Ram> midEnd = new ArrayList<>();
        List<Ram> lowEnd = new ArrayList<>();

        for (Ram component : Ram) {
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
            listComponentsRam(highEnd, "High End Components");
        } else if ("Mid".equalsIgnoreCase(userDecision)) {
            listComponentsRam(midEnd, "Mid End Components");
        } else {
            listComponentsRam(lowEnd, "Low End Components");
        }
    }

    private void listComponentsRam(List<Ram> components, String category) {
        System.out.println(category + ":");
        for (Ram component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesPSU() {
        DataManager dataManager = new DataManager("./data/");
        List<PSU> Psu = dataManager.getPsus();

        List<PSU> highEnd = new ArrayList<>();
        List<PSU> midEnd = new ArrayList<>();
        List<PSU> lowEnd = new ArrayList<>();

        for (PSU component : Psu) {
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
            listComponentsPSU(highEnd, "High End Components");
        } else if ("Mid".equalsIgnoreCase(userDecision)) {
            listComponentsPSU(midEnd, "Mid End Components");
        } else {
            listComponentsPSU(lowEnd, "Low End Components");
        }
    }

    private void listComponentsPSU(List<PSU> components, String category) {
        System.out.println(category + ":");
        for (PSU component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesHDD() {
        DataManager dataManager = new DataManager("./data/");
        List<HDD> Hdd = dataManager.getHdds();

        List<HDD> highEnd = new ArrayList<>();
        List<HDD> midEnd = new ArrayList<>();
        List<HDD> lowEnd = new ArrayList<>();

        for (HDD component : Hdd) {
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
            listComponentsHDD(highEnd, "High End Components");
        } else if ("Mid".equalsIgnoreCase(userDecision)) {
            listComponentsHDD(midEnd, "Mid End Components");
        } else {
            listComponentsHDD(lowEnd, "Low End Components");
        }
    }

    private void listComponentsHDD(List<HDD> components, String category) {
        System.out.println(category + ":");
        for (HDD component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesSSD() {
        DataManager dataManager = new DataManager("./data/");
        List<SSD> Ssd = dataManager.getSsds();

        List<SSD> highEnd = new ArrayList<>();
        List<SSD> midEnd = new ArrayList<>();
        List<SSD> lowEnd = new ArrayList<>();

        for (SSD component : Ssd) {
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
            listComponentsSSD(highEnd, "High End Components");
        } else if ("Mid".equalsIgnoreCase(userDecision)) {
            listComponentsSSD(midEnd, "Mid End Components");
        } else {
            listComponentsSSD(lowEnd, "Low End Components");
        }
    }

    private void listComponentsSSD(List<SSD> components, String category) {
        System.out.println(category + ":");
        for (SSD component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesFan() {
        DataManager dataManager = new DataManager("./data/");
        List<Fan> fan = dataManager.getFans();

        List<Fan> highEnd = new ArrayList<>();
        List<Fan> midEnd = new ArrayList<>();
        List<Fan> lowEnd = new ArrayList<>();

        for (Fan component : fan) {
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
            listComponentsFan(highEnd, "High End Components");
        } else if ("Mid".equalsIgnoreCase(userDecision)) {
            listComponentsFan(midEnd, "Mid End Components");
        } else {
            listComponentsFan(lowEnd, "Low End Components");
        }
    }

    private void listComponentsFan(List<Fan> components, String category) {
        System.out.println(category + ":");
        for (Fan component : components) {
            System.out.println(component);
        }
    }



}