package com.solvd.laba.Enums;

import java.util.Scanner;

public class DayOfWeekEnum {
    public enum DayOfWeek {
        MONDAY("Monday", 1, "First day of the week"),
        TUESDAY("Tuesday", 2, "Second day of the week"),
        WEDNESDAY("Wednesday", 3, "Third day of the week"),
        THURSDAY("Thursday", 4, "Fourth day of the week"),
        FRIDAY("Friday", 5, "Fifth day of the week"),
        SATURDAY("Saturday", 6, "Sixth day of the week"),
        SUNDAY("Sunday", 7, "Seventh day of the week");

        private final String name;
        private final int optionNumber;
        private final String description;

        DayOfWeek(String name, int optionNumber, String description) {
            this.name = name;
            this.optionNumber = optionNumber;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public int getOptionNumber() {
            return optionNumber;
        }

        public String getDescription() {
            return description;
        }
    }

    public static DayOfWeek chooseDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a day of the week (MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY):");
        String input = scanner.nextLine().toUpperCase();

        try {
            DayOfWeek day = DayOfWeek.valueOf(input);
            System.out.println("Name: " + day.getName());
            System.out.println("Option Number: " + day.getOptionNumber());
            System.out.println("Description: " + day.getDescription());
            return day;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid day of the week. Please try again.");
            return chooseDay();
        }
    }
}
