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
            if(condition.getInitial().equals("F"))
                return new Condition("H");
            else
                return condition;
    }

    @Override
    public Condition collateralEffect(List<Drug> drugs, Condition condition) {
        for(Drug drug : drugs){
            if (drug.getInitial().equals("P")) {
                condition = new Condition("X");
                break;
            }
        }
        return  condition;
    }
}
