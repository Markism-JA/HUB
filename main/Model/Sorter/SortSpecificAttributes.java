package main.Model.Sorter;

import java.util.Comparator;
import java.util.List;

import main.Model.Components.*;

public class SortSpecificAttributes {
    
    public List<PSU> sortPSUbyWattage(List<PSU> psus) {
      psus.sort(Comparator.comparingInt(PSU::getWattage).reversed());
      return psus;
    }

    public List<HDD> sortHDDbyStorage(List<HDD> hdds) {
      hdds.sort(Comparator.comparingInt(HDD::getStorageSize).reversed());
      return hdds;
    }

    public List<SSD> sortSSDbyStorage(List<SSD> ssds) {
      ssds.sort(Comparator.comparingInt(SSD::getStorageSize).reversed());
      return ssds;
    }

    public List<InternalStorage> sortInternalStorageByStorage(List<InternalStorage> internalStorages) {
      internalStorages.sort(Comparator.comparingInt(InternalStorage::getStorageSize).reversed());
      return internalStorages;
    }
}
