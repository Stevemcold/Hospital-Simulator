package com.hospital.Application;

import java.util.List;
import java.util.Random;

public class Patient {
    private Condition condition;

    public Patient(Condition condition){
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }

    private Condition noodleMiracle(){
        int result = new Random().nextInt(1000000) + 1;
        if(result==1)
            return new Condition("H");
        else return new Condition("X");
    }

    public void treat(List<Drug> drugs){
        Condition tmpCondition = this.condition;
        for(Drug drug : drugs){
            tmpCondition = drug.collateralEffect(drugs, drug.apply(tmpCondition));
        }
        if(tmpCondition.getInitial().equals("ID")) {
            tmpCondition = new Condition("D");
        } else if(tmpCondition.equals("D") || tmpCondition.equals("X")) {
            tmpCondition = noodleMiracle();
        }

        this.condition = tmpCondition;
    }
}
