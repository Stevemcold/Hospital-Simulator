package com.hospital.Application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        SetUp setUp = SetUp.getInstance();
        setUp.setArgs(args);
        String[] parsedConditions = setUp.getParsedConditions();
        String[] parsedDrugs = setUp.getParsedDrugs();
        Map<String, Integer> treatedConditions = setUp.getTreatedConditions();
        List<Patient> patients = new ArrayList<>();
        List<Drug> drugs = new ArrayList<>();

        //create patients from the list of given conditions
        for(String condition : parsedConditions) {
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
        String result = treatedConditions.entrySet().stream().map(entry -> entry.getKey()+":"+entry.getValue()+",").collect(Collectors.joining());
        System.out.println(result.substring(0, result.length()-1));
    }
}
