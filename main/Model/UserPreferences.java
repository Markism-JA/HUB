package main.Model;

public class UserPreferences {
    private String budget;
    private String purpose;
    private String cpuBrand;
    private String gpuBrand;
    private int storage;
    private int ram;
    private String formFactor;

    public UserPreferences(String budget, String purpose, String cpuBrand, String gpuBrand, int storage, int ram, String formFactor) {
        this.budget = budget;
        this.purpose = purpose;
        this.cpuBrand = cpuBrand;
        this.gpuBrand = gpuBrand;
        this.storage = storage;
        this.ram = ram;
        this.formFactor = formFactor;
    }

    // Getters and setters for the fields
    public String getBudget() { return budget; }
    public void setBudget(String budget) { this.budget = budget; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public String getCpuBrand() { return cpuBrand; }
    public void setCpuBrand(String cpuBrand) { this.cpuBrand = cpuBrand; }

    public String getGpuBrand() { return gpuBrand; }
    public void setGpuBrand(String gpuBrand) { this.gpuBrand = gpuBrand; }

    public int getStorage() { return storage; }
    public void setStorage(int storage) { this.storage = storage; }

    public int getRam() { return ram; }
    public void setRam(int ram) { this.ram = ram; }

    public String getFormFactor() { return formFactor; }
    public void setFormFactor(String formFactor) { this.formFactor = formFactor; }

    // Convert UserPreferences to a CSV string
    public String toCSVString() {
        return String.join(";", budget, purpose, cpuBrand, gpuBrand, String.valueOf(storage), String.valueOf(ram), formFactor);
    }

    @Override
    public String toString() {
        return "UserPreferences [budget=" + budget + ", purpose=" + purpose + ", cpuBrand=" + cpuBrand + ", gpuBrand=" + gpuBrand + ", storage=" + storage + ", ram=" + ram + ", formFactor=" + formFactor + "]";
    }
}
