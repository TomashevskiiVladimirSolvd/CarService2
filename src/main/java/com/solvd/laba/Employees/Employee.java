package com.solvd.laba.Employees;

import com.solvd.laba.Interfaces.IPrintInfo;
import com.solvd.laba.Interfaces.IWork;


import org.apache.log4j.Logger;

abstract public class Employee implements IWork, IPrintInfo {
    Logger log = Logger.getLogger(Employee.class.getName());
    protected String name;
    protected String position;
    protected String address;

    public Employee(String name, String position, String address) {
        this.name = name;
        this.address = address;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    abstract public void printInfo();
}
