package com.solvd.laba.Employees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.solvd.laba.Exceptions.*;


public class Boss extends Employee {
    private int manageNumber;

    public Boss(String name, String position, String address, int manageNumber) {
        super(name, position, address);
        this.manageNumber = manageNumber;
    }

    public int getManageNumber() {
        return manageNumber;
    }

    public void setManageNumber(int manageNumber) {
        this.manageNumber = manageNumber;
    }

    public void countSalary() {
        log.info("As  a Boss i count Salary for each employee");
    }

    @Override
    public void printInfo() {
        log.info("Name: " + getName() + " Position: " + getPosition() + " Address: "
                + getAddress() + " Manage number: " + getManageNumber());
    }

    @Override
    public void work() {
        log.info("I am Boss.I control everything.");
    }


    public void controlBusiness() throws BusinessException {
        if (manageNumber > 0) {
            log.info("You control your business very well.");
        } else {
            throw new BusinessException("You don't control your business.It is bad for your income.");
        }
    }

    public String readDocumentFirstLine(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            return bufferedReader.readLine();
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
    }


}

