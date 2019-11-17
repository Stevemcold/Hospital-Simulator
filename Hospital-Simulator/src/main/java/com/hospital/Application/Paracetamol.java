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
    public Condition apply(Condition condition){
        if(condition.getInitial().equals("F"))
            return new Condition("H");
        else
            return condition;
    }

    @Override
    public Condition collateralEffect(List<Drug> drugs, Condition condition) {
        for(Drug drug : drugs){
            if (drug.getInitial().equals("As")) {
                condition = new Condition("X");
                break;
            }
        }
        return  condition;
    }
}
