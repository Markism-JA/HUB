package main.Model;

import main.Model.Filters.*;
import main.Model.Components.*;
import java.util.List;

public class PriceComparison {
    private String userDecision;
    private PriceFilter priceFilter; 

    public PriceComparison(String userDecision) {
        this.userDecision = userDecision;
        this.priceFilter = new PriceFilter();
    }

    public void comparePricesCPU() {
        DataManager dataManager = new DataManager("./data/");
        List<CPU> cpus = dataManager.getCpus();
        List<CPU> filteredCPUs = priceFilter.filterCPUByPrice(cpus, userDecision);

        listComponentsCPU(filteredCPUs, userDecision + " End Components");
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
        List<GPU> filteredGPUs = priceFilter.filterGPUByPrice(gpus, userDecision);

        listComponentsGPU(filteredGPUs, userDecision + " End Components");
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
        List<Case> filteredCases = priceFilter.filterCaseByPrice(cases, userDecision);
        listComponentsCase(filteredCases, userDecision + " End Components");

    }

    private void listComponentsCase(List<Case> components, String category) {
        System.out.println(category + ":");
        for (Case component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesMotherBoard() {
        DataManager dataManager = new DataManager("./data/");
        List<MotherBoard> motherboards = dataManager.getMotherboards();
        List<MotherBoard> filteredMotherboards = priceFilter.filterMotherBoardsByPrice(motherboards, userDecision);
        
        listComponentsMotherBoard(filteredMotherboards, userDecision + " End Components");
    }

    private void listComponentsMotherBoard(List<MotherBoard> components, String category) {
        System.out.println(category + ":");
        for (MotherBoard component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesRam() {
        DataManager dataManager = new DataManager("./data/");
        List<Ram> rams = dataManager.getRams();
        List<Ram> filteredRams = priceFilter.filterRamByPrice(rams, userDecision);

        listComponentsRam(filteredRams, userDecision + " End Components");
    }

    private void listComponentsRam(List<Ram> components, String category) {
        System.out.println(category + ":");
        for (Ram component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesPSU() {
        DataManager dataManager = new DataManager("./data/");
        List<PSU> psus = dataManager.getPsus();
        List<PSU> filteredPSUs = priceFilter.filterPSUByPrice(psus, userDecision);

        listComponentsPSU(filteredPSUs, userDecision + " End Components");
    }

    private void listComponentsPSU(List<PSU> components, String category) {
        System.out.println(category + ":");
        for (PSU component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesHDD() {
        DataManager dataManager = new DataManager("./data/");
        List<HDD> hdds = dataManager.getHdds();
        List<HDD> filteredHDDs = priceFilter.filterHddByPrice(hdds, userDecision);

        listComponentsHDD(filteredHDDs, userDecision + " End Components");
    }

    private void listComponentsHDD(List<HDD> components, String category) {
        System.out.println(category + ":");
        for (HDD component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesSSD() {
        DataManager dataManager = new DataManager("./data/");
        List<SSD> ssds = dataManager.getSsds();
        List<SSD> filteredSSDs = priceFilter.filterSSDByPrice(ssds, userDecision);

        listComponentsSSD(filteredSSDs, userDecision + " End Components");
    }

    private void listComponentsSSD(List<SSD> components, String category) {
        System.out.println(category + ":");
        for (SSD component : components) {
            System.out.println(component);
        }
    }

    public void comparePricesFan() {
        DataManager dataManager = new DataManager("./data/");
        List<Fan> fans = dataManager.getFans();
        List<Fan> filteredFans = priceFilter.filterFansByPrice(fans, userDecision);
        
        listComponentsFan(filteredFans, userDecision + " End Components");
    }

    private void listComponentsFan(List<Fan> components, String category) {
        System.out.println(category + ":");
        for (Fan component : components) {
            System.out.println(component);
        }
    }
}
