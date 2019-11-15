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
        if(condition == Condition.DIABETES)
            return Condition.INSULINDIABETES;
        else
            return condition;
    }

    @Override
    public Condition collateralEffect(List<Drug> drugs, Condition condition) {
        for(Drug drug : drugs){
            if (drug.getInitial().equals("An")) {
                if(condition == Condition.HEALTHY)
                    condition = Condition.FEVER;
                break;
            }
        }
        return  condition;
    }
}
