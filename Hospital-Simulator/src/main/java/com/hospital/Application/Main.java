package com.hospital.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String[] parsedConditions = {};
        String[] parsedDrugs = {};
        if(args.length>0){
            parsedConditions = args[0].split(",");
        }
        if(args.length>1) {
            parsedDrugs = args[1].split(",");
        }
        List<Patient> patients = new ArrayList<>();
        List<Drug> drugs = new ArrayList<>();
        Map<Condition, Integer> treatedConditions = new HashMap<>();
        //fill Map with Conditions
        for(Condition condition : Condition.values()) {
            if(condition!=Condition.INSULINDIABETES)
                treatedConditions.putIfAbsent(condition, 0);
        }
        //create patients from the list of given conditions
        for(String condition : parsedConditions){
            patients.add(new Patient(condition));
        }
        //create drugs from the list of given drugs
        for(String drug : parsedDrugs){
            drugs.add(Drug.createDrug(drug));
        }
        //treat all patients
        for(Patient patient : patients){
            patient.treat(drugs);
            treatedConditions.put(patient.getCondition(), treatedConditions.get(patient.getCondition()) + 1);
        }
        //print result of treatment
        String result = treatedConditions.entrySet().stream().map(entry -> entry.getKey().initial()+":"+entry.getValue()+",").collect(Collectors.joining());
        System.out.println(result.substring(0, result.length()-1));
    }
}
