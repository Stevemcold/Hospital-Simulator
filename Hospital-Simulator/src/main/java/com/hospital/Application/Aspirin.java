package com.hospital.Application;

import java.util.List;

public class Aspirin implements Drug {

    public Aspirin(){
    }

    public String getName() {
        return "Aspirin";
    }

    public String getInitial() {
        return "As";
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
            if (drug.getInitial().equals("P")) {
                condition = "X";
                break;
            }
        }
        return  condition;
    }
}
