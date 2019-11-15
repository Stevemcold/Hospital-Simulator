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
    public Condition apply(Condition condition){
            if(condition == Condition.FEVER)
                return Condition.HEALTHY;
            else
                return condition;
    }

    @Override
    public Condition collateralEffect(List<Drug> drugs, Condition condition) {
        for(Drug drug : drugs){
            if (drug.getInitial().equals("P")) {
                condition = Condition.DEAD;
                break;
            }
        }
        return  condition;
    }
}
