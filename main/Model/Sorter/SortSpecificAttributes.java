package main.Model.Sorter;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import main.Model.Components.HDD;
import main.Model.Components.InternalStorage;
import main.Model.Components.PSU;
import main.Model.Components.SSD;

public class SortSpecificAttributes {

    public List<PSU> sortPSUbyWattage(List<PSU> psus) {
        Objects.requireNonNull(psus, "PSU list cannot be null");
        psus.sort(Comparator.comparingInt(PSU::getWattage).reversed());
        return psus;
    }

    public List<HDD> sortHDDbyStorage(List<HDD> hdds) {
        Objects.requireNonNull(hdds, "HDD list cannot be null");
        hdds.sort(Comparator.comparingInt(HDD::getStorageSize).reversed());
        return hdds;
    }

    public List<SSD> sortSSDbyStorage(List<SSD> ssds) {
        Objects.requireNonNull(ssds, "SSD list cannot be null");
        ssds.sort(Comparator.comparingInt(SSD::getStorageSize).reversed());
        return ssds;
    }

    public List<InternalStorage> sortInternalStorageByStorage(List<InternalStorage> internalStorages) {
        Objects.requireNonNull(internalStorages, "Internal storage list cannot be null");
        internalStorages.sort(Comparator.comparingDouble(InternalStorage::getPrice).reversed());
        return internalStorages;
    }
}
