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
            public Condition apply(Condition condition) {
                return null;
            }

            @Override
            public Condition collateralEffect(List<Drug> drugs, Condition condition) {
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
    Condition apply(Condition condition);
    Condition collateralEffect(List<Drug> drugs, Condition condition);
}
