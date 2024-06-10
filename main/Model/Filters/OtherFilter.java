package main.Model.Filters;

import java.util.List;
import java.util.stream.Collectors;

import main.Model.Components.*;

public class OtherFilter {

    // FilterByRam
    public List<Ram> filterByRAMNeeds(List<Ram> rams, int ramNeeds) {
        if (rams == null) {
            throw new IllegalArgumentException("RAM list cannot be null");
        }
        if (ramNeeds <= 0) {
            return rams;
        }

        try {
            return rams.stream()
                    .filter(ram -> ram != null && ram.getCapacity() == ramNeeds)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error filtering RAMs by needs", e);
        }
    }

    // FilterByFormFactorCase
    public List<Case> filterByFormFactor(List<Case> cases, String formFactor) {
        if (cases == null) {
            throw new IllegalArgumentException("Case list cannot be null");
        }
        if (formFactor == null || formFactor.trim().isEmpty()) {
            throw new IllegalArgumentException("Form factor cannot be null or empty");
        }

        try {
            switch (formFactor.toUpperCase()) {
                case "atx":
                case "matx":
                case "mitx":
                    return cases.stream()
                            .filter(c -> c != null && c.getFormFactor().equalsIgnoreCase(formFactor))
                            .collect(Collectors.toList());
                default:
                    throw new IllegalArgumentException("Invalid form factor: " + formFactor);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error filtering cases by form factor", e);
        }
    }
}
