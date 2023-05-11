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
    private Set<String> carMaintenance = new TreeSet<>(Arrays.asList("Oil change", "Tire rotation",
            "Light change", "Air Filter change"));

    public enum Color {
        RED,
        GREEN,
        BLUE,
        YELLOW,
        ORANGE,
        PURPLE,
        PINK,
        BROWN,
        BLACK,
        WHITE
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void printColorCode() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a color: ");
        String colorInput = scanner.nextLine();

        Color color = Color.valueOf(colorInput.toUpperCase());

        switch (color) {
            case RED:
                System.out.println("The color code for RED is #FF0000");
                break;
            case GREEN:
                System.out.println("The color code for GREEN is #00FF00");
                break;
            case BLUE:
                System.out.println("The color code for BLUE is #0000FF");
                break;
            case YELLOW:
                System.out.println("The color code for YELLOW is #FFFF00");
                break;
            case ORANGE:
                System.out.println("The color code for ORANGE is #FFA500");
                break;
            case PURPLE:
                System.out.println("The color code for PURPLE is #800080");
                break;
            case PINK:
                System.out.println("The color code for PINK is #FFC0CB");
                break;
            case BROWN:
                System.out.println("The color code for BROWN is #A52A2A");
                break;
            case BLACK:
                System.out.println("The color code for BLACK is #000000");
                break;
            case WHITE:
                System.out.println("The color code for WHITE is #FFFFFF");
                break;
            default:
                System.out.println("Unknown color");
        }
    }

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
