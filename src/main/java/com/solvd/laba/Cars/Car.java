package com.solvd.laba.Cars;

import com.solvd.laba.Interfaces.IPrintInfo;

import java.util.TreeMap;
import java.util.logging.Logger;
import java.util.Map;

public class Car implements IPrintInfo {
    Logger log = Logger.getLogger(Car.class.getName());
    private String make;
    private String model;

    public Map<String, Integer> oils = new TreeMap<>();

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void printInfo() {
        log.info("Make: " + getMake() + " Model: " + getModel());
    }

    public void printOilPrice() {
        log.info(oils.toString());
    }


}
