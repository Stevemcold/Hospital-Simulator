package com.hospital.Application;

import java.util.List;

public class Paracetamol implements Drug {

    public Paracetamol(){
    }

    public String getName() {
        return "Paracetamol";
    }

    public String getInitial() {
        return "P";
    }

    @Override
    public String apply(String condition){
        if(condition.equals("F"))
            return "H";
        else
            return condition;
    }

    @Override
    public String collateralEffect(List<Drug> drugs, String condition) {
        for(Drug drug : drugs){
            if (drug.getInitial().equals("As")) {
                condition = "X";
                break;
            }
        }
        return  condition;
    }
}
