package com.hospital.Application;

import java.util.List;

public class Insulin implements Drug {

    public Insulin(){
    }

    public String getName() {
        return "Insulin";
    }

    public String getInitial() {
        return "I";
    }

    @Override
    public String apply(String condition){
        if(condition.equals("D"))
            return "ID";
        else
            return condition;
    }

    @Override
    public String collateralEffect(List<Drug> drugs, String condition) {
        for(Drug drug : drugs){
            if (drug.getInitial().equals("An")) {
                if(condition.equals("H"))
                    condition = "F";
                break;
            }
        }
        return  condition;
    }
}
