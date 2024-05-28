package main.Model;
import java.util.*;
import java.util.stream.Collectors;

import main.Model.Components.*;
import main.Model.Filters.*;
import main.Model.Sorter.*;
import main.Model.DataManager;

public class Recommendation {
  private DataManager dataManager;
  private UserPreferences userPreferences;

  private PriceFilter priceFilter;
  private PurposeFilter purposeFilter;
  private BrandFilter brandFilter;
  private OtherFilter otherFilter;
  private StorageFilter storageFilter;

  private SortPerformance sortPerformance;
  private SortPrice sortPrice;
  private SortSpecificAttributes sortSpecificAttributes;

  public Recommendation(DataManager dataManager, UserPreferences userPreferences) {
    this.dataManager = dataManager;
    this.userPreferences = userPreferences;

    this.priceFilter = new PriceFilter();
    this.purposeFilter = new PurposeFilter();
    this.brandFilter = new BrandFilter();
    this.otherFilter = new OtherFilter();
    this.storageFilter = new StorageFilter();

    this.sortPerformance = new SortPerformance();
    this.sortPrice = new SortPrice();
    this.sortSpecificAttributes = new SortSpecificAttributes();
  }

  public void recommendComponents() {
    dataManager.loadData();
    String PriceRange = userPreferences.getBudget();
    String Purpose = userPreferences.getPurpose();
    String CPUBrand = userPreferences.getCpuBrand();
    String GPUBrand = userPreferences.getGpuBrand();
    String FormFactor = userPreferences.getFormFactor();

    //Filter By PriceRange
    List<CPU> PriceCPUs = priceFilter.filterCPUByPrice(dataManager.getCpus(), PriceRange);
    List<GPU> PriceGPUs = priceFilter.filterGPUByPrice(dataManager.getGpus(), PriceRange);
    List<Ram> PriceRAMs = priceFilter.filterRamByPrice(dataManager.getRams(), PriceRange);
    List<InternalStorage> PriceInternalStorages = priceFilter.filterInternalStorageByPrice(dataManager.getInternalStorages(), PriceRange);
    List<HDD> PriceHDDs = priceFilter.filterHddByPrice(dataManager.getHdds(), PriceRange);
    List<SSD> PriceSSDs = priceFilter.filterSSDByPrice(dataManager.getSsds(), PriceRange);
    List<MotherBoard> PriceMotherBoard = priceFilter.filterMotherBoardsByPrice(dataManager.getMotherboards(), PriceRange);
    List<PSU> PricePSUs = priceFilter.filterPSUByPrice(dataManager.getPsus(), PriceRange);
    List<Fan> PriceFans = priceFilter.filterFansByPrice(dataManager.getFans(), PriceRange);
    List<Case> PriceCases = priceFilter.filterCaseByPrice(dataManager.getCases(), PriceRange);

    //Filter By Purpose
    List<CPU> PurposeCPUs = purposeFilter.filterCPUsByPurpose(PriceCPUs, Purpose);
    List<GPU> PurposeGPUs = purposeFilter.filterGPUsByPurpose(PriceGPUs, Purpose);
    List<Ram> PurposeRAMs = purposeFilter.filterRAMsByPurpose(PriceRAMs, Purpose);

    //Filter By Brand
    List<CPU> BrandCPUs = brandFilter.CPUfilterByBrand(PurposeCPUs, CPUBrand);
    List<GPU> BrandGPUs = brandFilter.GPUfilterByBrand(PurposeGPUs, GPUBrand);

    //Filter By Storage Needs

    //Filter By Ram Needs

    //Filter Case By formFactor
    List<Case> FormFactorCases = otherFilter.filterByFormFactor(PriceCases, FormFactor);

    //SortPerformance

    //SortPrice

    //SortSpecificAttributes

    //SelectPCBuild from the List
    
  }
}
