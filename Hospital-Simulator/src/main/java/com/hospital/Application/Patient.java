package com.hospital.Application;

import java.util.List;
import java.util.Random;

public class Patient {
    private String condition;

    public Patient(String condition){
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    private String noodleMiracle(){
        int result = new Random().nextInt(1000000) + 1;
        if(result==1)
            return "H";
        else return "X";
    }

    public void treat(List<Drug> drugs){
        String tmpCondition = this.condition;
        for(Drug drug : drugs){
            tmpCondition = drug.collateralEffect(drugs, drug.apply(tmpCondition));
        }
        if(tmpCondition.equals("ID")) {
            tmpCondition = "DD";
        } else if(tmpCondition.equals("D") || tmpCondition.equals("X")) {
            tmpCondition = noodleMiracle();
        }

        this.condition = tmpCondition;
    }
}
