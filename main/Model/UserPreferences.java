package main.Model;

public class UserPreferences {
    private String budget;
    private String purpose;
    private String cpuBrand;
    private String gpuBrand;
    private int storage;
    private int ram;
    private String formFactor;
    private String specificFeatures;

    // Getters and setters for the fields

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String primaryPurpose) {
        this.purpose = primaryPurpose;
    }

    public String getCpuBrand() {
        return cpuBrand;
    }

    public void setCpuBrand(String preferredCPUBrand) {
        this.cpuBrand = preferredCPUBrand;
    }

    public String getGpuBrand() {
        return gpuBrand;
    }

    public void setGpuBrand(String preferredGPUBrand) {
        this.gpuBrand = preferredGPUBrand;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storageCapacity) {
        this.storage = storageCapacity;
    }
    
    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getSpecificFeatures() {
        return specificFeatures;
    }

    public void setSpecificFeatures(String specificFeatures) {
        this.specificFeatures = specificFeatures;
    }
}
