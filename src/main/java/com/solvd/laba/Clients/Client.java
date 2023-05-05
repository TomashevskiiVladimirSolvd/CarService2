package com.solvd.laba.Clients;

import com.solvd.laba.Interfaces.IPrintInfo;

import java.util.logging.Logger;

public class Client implements IPrintInfo {
    Logger log = Logger.getLogger(Client.class.getName());
    private String name;
    private String address;

    public Client(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void printInfo() {
        log.info("Name: " + getName() + " Address: " + getAddress());
    }

    public void leaveGoodFeedback() {
        log.info(getName() + "leave good feedback.");
    }
}
