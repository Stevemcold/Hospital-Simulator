package com.hospital.Application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SetUp {
    public static Properties properties = new Properties();
    public static List<Condition> conditions = new ArrayList<>();
    private List<Condition> parsedConditions = new ArrayList<>();
    private String[] parsedDrugs = {};
    private Map<Condition, Integer> treatedConditions = new HashMap<>();

    public List<Condition> getParsedConditions() {
        return parsedConditions;
    }

    public String[] getParsedDrugs() {
        return parsedDrugs;
    }

    public Map<Condition, Integer> getTreatedConditions() {
        return treatedConditions;
    }

    private SetUp() {
        try {
            InputStream input = new FileInputStream("../resources/app.properties");
            properties.load(input);
            properties.forEach((k,v) -> {
                if(k.toString().contains("conditions")){
                    conditions.add(new Condition(v.toString()));
                }
            });
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void setArgs(String[] args){
        String[] inputConditions = {};
        if(args.length>0){
            inputConditions = args[0].split(",");
        }
        if(args.length>1) {
            this.parsedDrugs = args[1].split(",");
        }
        for(String condition : inputConditions) {
            if(!condition.equals("ID")){
                this.parsedConditions.add(new Condition(condition));
            }
        }
        for(Condition cond : this.parsedConditions){
            treatedConditions.putIfAbsent(cond, 0);
        }
    }

    private static class SetUpHolder {
        public static final SetUp instance = new SetUp();
    }

    public static SetUp getInstance() {
        return SetUpHolder.instance;
    }

}
