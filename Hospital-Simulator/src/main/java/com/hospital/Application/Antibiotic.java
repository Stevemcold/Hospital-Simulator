package com.hospital.Application;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;

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
    public String apply(String condition){
        if(condition.equals("T"))
            return "H";
        else
            return condition;
    }

    @Override
    public String collateralEffect(List<Drug> drugs, String condition) {
        for(Drug drug : drugs){
            if (drug.getInitial().equals("I")) {
                if(condition.equals("H"))
                    condition = "F";
                break;
            }
        }
        return  condition;
    }
}
