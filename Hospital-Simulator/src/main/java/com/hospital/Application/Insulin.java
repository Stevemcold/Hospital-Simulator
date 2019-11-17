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
    public Condition apply(Condition condition){
        if(condition.getInitial().equals("D"))
            return new Condition("ID");
        else
            return condition;
    }

    @Override
    public Condition collateralEffect(List<Drug> drugs, Condition condition) {
        for(Drug drug : drugs){
            if (drug.getInitial().equals("An")) {
                if(condition.getInitial().equals("H"))
                    condition = new Condition("F");
                break;
            }
        }
        return  condition;
    }
}
