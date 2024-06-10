package main.Model.Filters;

import java.util.List;
import java.util.stream.Collectors;

import main.Model.Components.*;

public class BrandFilter {

    public List<CPU> CPUfilterByBrand(List<CPU> cpus, String brand) {
        if (cpus == null) {
            throw new IllegalArgumentException("CPU list cannot be null");
        }
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }

        try {
            if (brand.equalsIgnoreCase("No Preference")) {
                return cpus;
            }
            return cpus.stream()
                    .filter(cpu -> cpu != null && brandMatches(cpu.getBrand(), brand))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error filtering CPUs by brand", e);
        }
    }

    public List<GPU> GPUfilterByBrand(List<GPU> gpus, String brand) {
        if (gpus == null) {
            throw new IllegalArgumentException("GPU list cannot be null");
        }
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }

        try {
            if (brand.equalsIgnoreCase("No Preference")) {
                return gpus;
            }
            return gpus.stream()
                    .filter(gpu -> gpu != null && brandMatches(gpu.getBrand(), brand))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error filtering GPUs by brand", e);
        }
    }

    private boolean brandMatches(String actualBrand, String filterBrand) {
        return actualBrand != null && actualBrand.equalsIgnoreCase(filterBrand);
    }
}
