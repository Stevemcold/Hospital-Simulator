package com.hospital.Application;

import java.util.List;

public class Antibiotic implements Drug {

    public Antibiotic(){
    }

    public String getName() {
        return "Antibiotic";
    }

    public String getInitial() {
        return "An";
    }

    @Override
    public Condition apply(Condition condition){
        if(condition == Condition.TUBERCULOSIS)
            return Condition.HEALTHY;
        else
            return condition;
    }

    @Override
    public Condition collateralEffect(List<Drug> drugs, Condition condition) {
        for(Drug drug : drugs){
            if (drug.getInitial().equals("I")) {
                if(condition == Condition.HEALTHY)
                    condition = Condition.FEVER;
                break;
            }
        }
        return  condition;
    }
}
