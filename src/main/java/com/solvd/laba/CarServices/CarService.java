package com.solvd.laba.CarServices;

import com.solvd.laba.Cars.Car;
import com.solvd.laba.Interfaces.ICarService;
import com.solvd.laba.Clients.Client;
import com.solvd.laba.Employees.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

public abstract class CarService implements ICarService {
    public enum DayOfWeek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    public static double GAS_95_RATE;

    static {
        GAS_95_RATE = 3.65;
    }

    Logger log = Logger.getLogger(CarService.class.getName());
    private String name;
    private String address;

    private long phoneNumber;
    private List<Employee> employees = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public CarService(String name, String address, long phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }


    public int hashCode() {
        return Objects.hash(employees, cars, clients);
    }

    public String equals(ArrayList<Employee> employees, ArrayList<Client> clients) {
        return "Equals" + employees.equals(clients);
    }


}
