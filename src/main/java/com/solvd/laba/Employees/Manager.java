package com.solvd.laba.Employees;

import com.solvd.laba.Exceptions.*;
import org.apache.log4j.Logger;

public class Manager extends Employee {
    private int insuranceNumber;
    private int claimNumber;

    public Manager(String name, String position, String address, int insuranceNumber, int claimNumber) {
        super(name, position, address);
        this.insuranceNumber = insuranceNumber;
        this.claimNumber = claimNumber;
    }

    public int getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(int claimNumber) {
        this.claimNumber = claimNumber;
    }

    public int getSalesNumber() {
        return insuranceNumber;
    }

    public void setSalesNumber(int salesNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public void talkToInsurance() {
        log.info("As a Manager i talk to insurance");
    }

    public void countSalary() {
        log.info("As a Boss i count Salary for each employee");
    }

    @Override
    public void work() {
        log.info("I am Manager.I work with the clients");
    }

    @Override
    public void printInfo() {
        log.info("Name: " + name + " Position: " + position + " Address: "
                + address + " Sales number:" + getSalesNumber());
    }


    public void createCarInsurance() throws LawException {
        if (insuranceNumber < 0 || insuranceNumber > 10) {
            throw new LawException("Fake car Insurance is illegal");

        } else {
            log.info("Manager creates good insurance");
        }
    }


    public void toWorkWithClients() throws ClaimException {
        if (claimNumber == 0) {
            log.info("Manager works with clients very well.");
        } else if (claimNumber > 0) {
            throw new ClaimException("Manager was rude with a client.Now the client filed a complain");
        }
    }
}
