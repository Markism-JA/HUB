package main.Model.Filters;

import java.util.List;
import java.util.stream.Collectors;

import main.Model.Components.*;

public class BrandFilter {

    public List<CPU> CPUfilterByBrand(List<CPU> cpus, String brand) {
        if (brand.equalsIgnoreCase("No Preference")) {
            return cpus;
        }
        return cpus.stream().filter(CPU -> CPU.getBrand().equalsIgnoreCase(brand)).collect(Collectors.toList());
    }

    public List<GPU> GPUfilterByBrand(List<GPU> gpus, String brand) {
        if (brand.equalsIgnoreCase("No Preference")) {
            return gpus;
        }
        return gpus.stream().filter(CPU -> CPU.getBrand().equalsIgnoreCase(brand)).collect(Collectors.toList());
    }
}