package Employees;

import Interfaces.IPrintInfo;
import Interfaces.IWork;

import java.util.logging.Logger;

abstract public class Employee implements IWork, IPrintInfo {
    Logger log = Logger.getLogger(Employee.class.getName());
    private String name;
    private String position;
    private String address;

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
