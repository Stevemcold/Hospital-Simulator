package com.hospital.Application;

import java.util.List;
import java.util.Random;

public class Patient {
    private Condition condition;

    public Patient(Condition condition){
        this.condition = condition;
    }

    public Patient(String parsedCondition){
        for(Condition condition : Condition.values()) {
          if(parsedCondition.equals(condition.initial())) {
              this.condition = condition;
              break;
          }
        }
        if(this.condition==null) {
            throw new IllegalArgumentException();
        }
    }

    public Condition getCondition() {
        return condition;
    }

    private Condition noodleMiracle(){
        int result = new Random().nextInt(1000000) + 1;
        if(result==1)
            return Condition.HEALTHY;
        else return Condition.DEAD;
    }

    public void treat(List<Drug> drugs){
        Condition tmpCondition = this.condition;
        for(Drug drug : drugs){
            tmpCondition = drug.collateralEffect(drugs, drug.apply(tmpCondition));
        }
        if(tmpCondition == Condition.INSULINDIABETES) {
            tmpCondition = Condition.DIABETES;
        } else if(tmpCondition == Condition.DIABETES || tmpCondition == Condition.DEAD) {
            tmpCondition = noodleMiracle();
        }

        this.condition = tmpCondition;
    }
}
