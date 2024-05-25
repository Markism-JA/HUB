package main.Model;

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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getPrimaryPurpose() {
        return primaryPurpose;
    }

    public void setPrimaryPurpose(String primaryPurpose) {
        this.primaryPurpose = primaryPurpose;
    }

    public String getPreferredCPUBrand() {
        return preferredCPUBrand;
    }

    public void setPreferredCPUBrand(String preferredCPUBrand) {
        this.preferredCPUBrand = preferredCPUBrand;
    }

    public String getPreferredGPUBrand() {
        return preferredGPUBrand;
    }

    public void setPreferredGPUBrand(String preferredGPUBrand) {
        this.preferredGPUBrand = preferredGPUBrand;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
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


