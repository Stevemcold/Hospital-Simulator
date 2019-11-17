package com.hospital.Application;

import java.util.List;

public interface Drug {

    static Drug createDrug(String parsedInitial) {
        Drug parsedDrug = new Drug() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getInitial() {
                return null;
            }

            @Override
            public String apply(String condition) {
                return null;
            }

            @Override
            public String collateralEffect(List<Drug> drugs, String condition) {
                return null;
            }
        };
        switch(parsedInitial) {
            case "As":
                return new Aspirin();
            case "An":
                return new Antibiotic();
            case "I":
                return new Insulin();
            case "P":
                return new Paracetamol();
            default:
                return parsedDrug;
        }
    }

    String getName();
    String getInitial();
    String apply(String condition);
    String collateralEffect(List<Drug> drugs, String condition);
}
