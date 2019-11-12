package com.hospital.Application;

public enum Condition {
    FEVER ("F"),
    HEALTHY ("H"),
    DIABETES ("D"),
    INSULINDIABETES ("ID"),
    TUBERCULOSIS ("T"),
    DEAD ("X");

    private final String initial;

    Condition(String initial){
        this.initial = initial;
    }

    public String initial() {
        return initial;
    }

}
