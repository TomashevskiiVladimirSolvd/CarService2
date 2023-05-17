package com.solvd.laba.Cars;

import com.solvd.laba.Enums.ColorEnum;
import com.solvd.laba.Interfaces.IPrintInfo;

import java.util.*;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

public class Car implements IPrintInfo {
    Logger log = Logger.getLogger(Car.class);
    private String make;
    private String model;
    private int year;
    private int price;
    private boolean isAvailable;
    private List<String> oils = new ArrayList<>() {{
        add("PORCSHE");
        add("CASTROL");
        add("PENNZOIL");
        add("MOBIL");
    }};
    private TreeSet<String> serviceType = new TreeSet<>(Arrays.asList("Wheels change", "Tire rotation",
            "Light change", "Air Filter change"));

    public Car(String make, String model, int year, int price, boolean isAvailable) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    //Stream1
    public long getServiceTypeCount() {
        return serviceType.stream().count();
    }
    //Stream2
    public boolean hasServiceType(String type) {
        return serviceType.stream().anyMatch(t -> t.equalsIgnoreCase(type));
    }
    //Stream3
    public List<String> getSortedServiceTypes() {
        return serviceType.stream().sorted().collect(Collectors.toList());
    }
    //Stream4
    public String getFirstServiceType() {
        return serviceType.stream().findFirst().orElse(null);
    }
    //Stream5
    public void removeOil(String oil) {
        oils.removeIf(o -> o.equalsIgnoreCase(oil));
    }
    //Stream6
    public String getOilWithLongestName() {
        return oils.stream().max(Comparator.comparingInt(String::length)).orElse(null);
    }
    //Stream7
    public boolean allOilsContainKeyword(String keyword) {
        return oils.stream().allMatch(o -> o.toLowerCase().contains(keyword.toLowerCase()));
    }
    public static ColorEnum.Color printColorCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a color(RED GREEN BLUE YELLOW ORANGE PURPLE PINK BROWN BLACK WHITE): ");
        String colorInput = scanner.nextLine();

        try {
            ColorEnum.Color color = ColorEnum.Color.valueOf(colorInput.toUpperCase());

            switch (color) {
                case RED:
                    System.out.println("The color code for RED is " + ColorEnum.Color.RED.getColorCode());
                    break;
                case GREEN:
                    System.out.println("The color code for GREEN is " + ColorEnum.Color.GREEN.getColorCode());
                    break;
                case BLUE:
                    System.out.println("The color code for BLUE is " + ColorEnum.Color.BLUE.getColorCode());
                    break;
                case YELLOW:
                    System.out.println("The color code for YELLOW is " + ColorEnum.Color.YELLOW.getColorCode());
                    break;
                case ORANGE:
                    System.out.println("The color code for ORANGE is " + ColorEnum.Color.ORANGE.getColorCode());
                    break;
                case PURPLE:
                    System.out.println("The color code for PURPLE is " + ColorEnum.Color.PURPLE.getColorCode());
                    break;
                case PINK:
                    System.out.println("The color code for PINK is " + ColorEnum.Color.PINK.getColorCode());
                    break;
                case BROWN:
                    System.out.println("The color code for BROWN is " + ColorEnum.Color.BROWN.getColorCode());
                    break;
                case BLACK:
                    System.out.println("The color code for BLACK is " + ColorEnum.Color.BLACK.getColorCode());
                    break;
                case WHITE:
                    System.out.println("The color code for WHITE is " + ColorEnum.Color.WHITE.getColorCode());
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

    public List<String> getOils() {
        return oils;
    }

    public void setOils(List<String> oils) {
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
