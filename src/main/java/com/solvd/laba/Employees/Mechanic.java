package com.solvd.laba.Employees;

import com.solvd.laba.Exceptions.*;


import java.util.TreeSet;
import java.util.Set;

public class Mechanic extends Employee {
    private int toolsNumber;
    private int glovesNumber;
    public Set<String> carMaintenance = new TreeSet<>();

    public Mechanic(String name, String position, String address, int toolsNumber, int glovesNumber) {
        super(name, position, address);
        this.toolsNumber = toolsNumber;
        this.glovesNumber = glovesNumber;
    }

    public int getGlovesNumber() {
        return glovesNumber;
    }

    public void setGlovesNumber(int glovesNumber) {
        this.glovesNumber = glovesNumber;
    }

    public int getToolsNumber() {
        return toolsNumber;
    }

    public void setToolsNumber(int toolsNumber) {
        this.toolsNumber = toolsNumber;
    }

    @Override
    public void printInfo() {
        log.info("Name: " + getName() + " Position: " + getPosition() + " Address: "
                + getAddress() + " Number of tools: " + getToolsNumber());
    }

    @Override
    public void work() {
        log.info("I am Employees.Mechanic.I fix this car.");
    }

    public void checkUpCar() {
        log.info("As  a mechanic i check car first.");
    }


    public void useTools() {

        if (toolsNumber > 0) {
            log.info("You have a tool.You can work.");
        } else {
                throw new ToolException("You don't have tools .It is really bad");

        }
    }

    public void useTheGloves() {
        if (glovesNumber > 0) {
            log.info("Employees.Mechanic uses his gloves.");
        } else {
            throw new GetDirtyException("Employees.Mechanic doesn't have gloves .His hands are dirty now.");
        }
    }

    public void printCarMaintenance() {
        for (String maitenance : carMaintenance) {
            log.info(maitenance);
        }
    }
}



