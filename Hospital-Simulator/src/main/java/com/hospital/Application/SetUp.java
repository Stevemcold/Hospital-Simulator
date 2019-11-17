package com.hospital.Application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SetUp {
    public static Properties properties = new Properties();
    public static List<String> conditions = new ArrayList<>();
    private String[] parsedConditions = {};
    private String[] parsedDrugs = {};
    private Map<String, Integer> treatedConditions = new HashMap<>();

    public String[] getParsedConditions() {
        return parsedConditions;
    }

    public String[] getParsedDrugs() {
        return parsedDrugs;
    }

    public Map<String, Integer> getTreatedConditions() {
        return treatedConditions;
    }

    private SetUp() {
        try {
            InputStream input = new FileInputStream("../resources/app.properties");
            properties.load(input);
            properties.forEach((k,v) -> {
                if(k.toString().contains("conditions")){
                    conditions.add(v.toString());
                }
            });
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void setArgs(String[] args){
        if(args.length>0){
            this.parsedConditions = args[0].split(",");
        }
        if(args.length>1) {
            this.parsedDrugs = args[1].split(",");
        }
        for(String condition : parsedConditions) {
            if(!condition.equals("ID"))
                treatedConditions.putIfAbsent(condition, 0);
        }
    }

    private static class SetUpHolder {
        public static final SetUp instance = new SetUp();
    }

    public static SetUp getInstance() {
        return SetUpHolder.instance;
    }

}
