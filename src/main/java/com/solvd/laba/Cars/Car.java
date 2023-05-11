package com.solvd.laba.Cars;

import com.solvd.laba.Interfaces.IPrintInfo;

import java.util.*;

import org.apache.log4j.Logger;

public class Car implements IPrintInfo {
    Logger log = Logger.getLogger(Car.class);
    private String make;
    private String model;

    private Map<String, Integer> oils = new HashMap<>() {{
        put("PORCSHE", 400);
        put("CASTROL", 200);
        put("PENNZOIL", 300);
        put("MOBIL", 100);
    }};

    public void chooseOilAndTellPrice(Map<String, Integer> oils) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("We have oils:PORCSHE,CASTROL,PENNZOIL,MOBIL");
        System.out.println("Enter the name of the oil you want:");
        String input = scanner.nextLine().toUpperCase();
        if (oils.containsKey(input)) {
            int price = oils.get(input);
            System.out.println("The price of " + input + " is " + price + " dollars.");
        } else {
            System.out.println("Sorry, we don't have " + input + " in stock.");
        }
    }

    private Set<String> carMaintenance = new TreeSet<>(Arrays.asList("Oil change", "Tire rotation",
            "Light change", "Air Filter change"));

    public String chooseMaintenance() {
        Scanner scanner = new Scanner(System.in);
        log.info("Please choose a maintenance task from the following options:");
        int i = 1;
        for (String maintenanceTask : getCarMaintenance()) {
            log.info(i + ". " + maintenanceTask);
            i++;
        }
        int choice = scanner.nextInt();
        if (choice < 1 || choice > getCarMaintenance().size()) {
            log.info("Invalid choice. Please try again.");
            return chooseMaintenance();
        }
        String selectedTask = (String) getCarMaintenance().toArray()[choice - 1];
        log.info("You have selected: " + selectedTask);
        return selectedTask;
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Map<String, Integer> getOils() {
        return oils;
    }

    public void setOils(Map<String, Integer> oils) {
        this.oils = oils;
    }

    public Set<String> getCarMaintenance() {
        return carMaintenance;
    }

    public void setCarMaintenance(Set<String> carMaintenance) {
        this.carMaintenance = carMaintenance;
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


}
