package com.solvd.laba.Clients;

import com.solvd.laba.CarServices.CarServiceUsualCars;
import com.solvd.laba.Interfaces.IPrintInfo;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Client implements IPrintInfo {
    Logger log = Logger.getLogger(Client.class);
    private String name;
    private String address;
    private Status status;
    private MembershipLevel membershipLevel;
    private PaymentMethod paymentMethod;

    public enum Status {
        ACTIVE,
        INACTIVE,
        PENDING
    }

    public enum MembershipLevel {
        BRONZE,
        SILVER,
        GOLD,
        PLATINUM
    }

    public enum PaymentMethod {
        CREDIT_CARD,
        DEBIT_CARD,
        PAYPAL,
        BANK_TRANSFER
    }

    public void showStatus(Scanner scanner) {
        System.out.print("Enter status (ACTIVE, INACTIVE, or PENDING): ");
        String statusString = scanner.nextLine().toUpperCase();
        try {
            Status status = Status.valueOf(statusString);
            System.out.println("Your current Status is : " + status);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please enter a valid status.");
        }
    }

    public void showMembershipLevel(Scanner scanner) {
        System.out.print("Enter membership level (BRONZE, SILVER, GOLD, or PLATINUM): ");
        String levelString = scanner.nextLine().toUpperCase();
        try {
            MembershipLevel level = MembershipLevel.valueOf(levelString);
            System.out.println("Your current Membership Level: " + level);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please enter a valid membership level.");
        }
    }

    public void choosePaymentMethod(Scanner scanner) {
        System.out.print("Enter payment method (CREDIT_CARD, DEBIT_CARD, PAYPAL, or BANK_TRANSFER): ");
        String methodString = scanner.nextLine().toUpperCase();
        try {
            PaymentMethod method = PaymentMethod.valueOf(methodString);
            this.paymentMethod = method;
            System.out.println("Your current Payment method is : " + method);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please enter a valid payment method.");
        }
    }


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
