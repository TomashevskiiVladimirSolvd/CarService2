package com.solvd.laba.Employees;

import com.solvd.laba.Exceptions.*;


import java.util.TreeSet;
import java.util.Set;

public class Mechanic extends Employee {
    private int toolsNumber;
    private int glovesNumber;


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
        log.info("Name: " + name + " Position: " + position + " Address: "
                + address + " Number of tools: " + getToolsNumber());
    }

    @Override
    public void work() {
        log.info("I am Mechanic.I fix this car.");
    }

    public void checkUpCar() {
        log.info("As  a Mechanic i check car first.");
    }


    public void fillFormOfBrokenTool() {

        if (toolsNumber > 0) {
            log.info("You have a tool.You can work.");
            toolsNumber--;
        } else {
            throw new ToolException("You don't have tools .It is really bad");

        }
    }

    public void useTheGloves() {
        if (glovesNumber > 0) {
            log.info("Mechanic uses his gloves.");
            glovesNumber--;
        } else {
            throw new GetDirtyException("Mechanic doesn't have gloves .His hands are dirty now.");
        }
    }
}



