package com.solvd.laba.Cars;

import com.solvd.laba.Interfaces.IPrintInfo;

import java.util.*;

import org.apache.log4j.Logger;

public class Car implements IPrintInfo {
    Logger log = Logger.getLogger(Car.class);
    private String make;
    private String model;
    private int year;
    private int price;
    private boolean isAvailable;
    private Map<String, Integer> oils = new HashMap<>() {{
        put("PORCSHE", 400);
        put("CASTROL", 200);
        put("PENNZOIL", 300);
        put("MOBIL", 100);
    }};
    private TreeSet<String> serviceType = new TreeSet<>(Arrays.asList("Wheels change", "Tire rotation",
            "Light change", "Air Filter change"));

    public enum Color {
        RED("#FF0000"),
        GREEN("#00FF00"),
        BLUE("#0000FF"),
        YELLOW("#FFFF00"),
        ORANGE("#FFA500"),
        PURPLE("#800080"),
        PINK("#FFC0CB"),
        BROWN("#A52A2A"),
        BLACK("#000000"),
        WHITE("#FFFFFF");

        private final String colorCode;

        Color(String colorCode) {
            this.colorCode = colorCode;
        }

        public String getColorCode() {
            return colorCode;
        }
    }

    public Car(String make, String model, int year, int price, boolean isAvailable) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public static Color printColorCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a color(RED GREEN BLUE YELLOW ORANGE PURPLE PINK BROWN BLACK WHITE): ");
        String colorInput = scanner.nextLine();

        try {
            Color color = Color.valueOf(colorInput.toUpperCase());

            switch (color) {
                case RED:
                    System.out.println("The color code for RED is " + Color.RED.getColorCode());
                    break;
                case GREEN:
                    System.out.println("The color code for GREEN is " + Color.GREEN.getColorCode());
                    break;
                case BLUE:
                    System.out.println("The color code for BLUE is " + Color.BLUE.getColorCode());
                    break;
                case YELLOW:
                    System.out.println("The color code for YELLOW is " + Color.YELLOW.getColorCode());
                    break;
                case ORANGE:
                    System.out.println("The color code for ORANGE is " + Color.ORANGE.getColorCode());
                    break;
                case PURPLE:
                    System.out.println("The color code for PURPLE is " + Color.PURPLE.getColorCode());
                    break;
                case PINK:
                    System.out.println("The color code for PINK is " + Color.PINK.getColorCode());
                    break;
                case BROWN:
                    System.out.println("The color code for BROWN is " + Color.BROWN.getColorCode());
                    break;
                case BLACK:
                    System.out.println("The color code for BLACK is " + Color.BLACK.getColorCode());
                    break;
                case WHITE:
                    System.out.println("The color code for WHITE is " + Color.WHITE.getColorCode());
                    break;
                default:
                    System.out.println("Unknown color");
            }
            return color;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid color input. Please enter a valid color.");
            return printColorCode();
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


    public void chooseServiceType() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Please choose a maintenance task from the following options:");
            int i = 1;
            for (String task : serviceType) {
                System.out.println(i + ". " + task);
                i++;
            }

            int choice;
            do {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                if (choice < 1 || choice > serviceType.size()) {
                    System.out.println("Invalid choice. Please try again.");
                }
            } while (choice < 1 || choice > serviceType.size());

            String selectedTask = null;
            i = 1;
            for (String task : serviceType) {
                if (i == choice) {
                    selectedTask = task;
                    break;
                }
                i++;
            }

            System.out.println("You have selected: " + selectedTask);
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
            chooseServiceType();
        }
    }


    public Map<String, Integer> getOils() {
        return oils;
    }

    public void setOils(Map<String, Integer> oils) {
        this.oils = oils;
    }

    public TreeSet<String> getServiceType() {
        return serviceType;
    }

    public void setServiceType(TreeSet<String> serviceType) {
        this.serviceType = serviceType;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public void printInfo() {
        log.info("Make: " + getMake() + " Model: " + getModel() + " Year: " + getYear() + " Price: "
                + getPrice() + " Is available: " + isAvailable());
    }


}
