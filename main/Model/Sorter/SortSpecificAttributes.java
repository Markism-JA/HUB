package main.Model.Sorter;

import java.util.Comparator;
import java.util.List;

import main.Model.Components.*;

public class SortSpecificAttributes {
    
    public List<PSU> filterPSUbyWattage(List<PSU> psus) {
      psus.sort(Comparator.comparingInt(PSU::getWattage).reversed());
      return psus;
    }

    public List<HDD> filterHDDbyStorage(List<HDD> hdds) {
      hdds.sort(Comparator.comparingInt(HDD::getStorageSize).reversed());
      return hdds;
    }

    public List<SSD> filterSSDbyStorage(List<SSD> ssds) {
      ssds.sort(Comparator.comparingInt(SSD::getStorageSize).reversed());
      return ssds;
    }

    public List<InternalStorage> filterInternalStorageByStorage(List<InternalStorage> internalStorages) {
      internalStorages.sort(Comparator.comparingInt(InternalStorage::getStorageSize).reversed());
      return internalStorages;
    }
}
