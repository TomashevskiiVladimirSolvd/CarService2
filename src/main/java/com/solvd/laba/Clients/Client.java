package com.solvd.laba.Clients;

import com.solvd.laba.Interfaces.IPrintInfo;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Client implements IPrintInfo {
    Logger log = Logger.getLogger(Client.class);
    protected String name;
    protected String address;
    protected Status status;
    protected MembershipLevel membershipLevel;
    protected PaymentMethod paymentMethod;

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

    public static void showStatus(Scanner scanner) {
        System.out.print("Enter status (ACTIVE, INACTIVE, or PENDING): ");
        String statusString = scanner.nextLine().toUpperCase();
        Status status = Status.valueOf(statusString.toUpperCase());

        switch (status) {
            case ACTIVE:
                System.out.println("Your current status is: ACTIVE");
                break;
            case INACTIVE:
                System.out.println("Your current status is: INACTIVE");
                break;
            case PENDING:
                System.out.println("Your current status is: PENDING");
                break;
            default:
                System.out.println("Invalid input. Please enter a valid status.");
                break;
        }
    }

    public static void showMembershipLevel(Scanner scanner) {
        System.out.print("Enter membership level (BRONZE, SILVER, GOLD, or PLATINUM): ");
        String levelString = scanner.nextLine().toUpperCase();
        MembershipLevel membershipLevel = MembershipLevel.valueOf(levelString.toUpperCase());

        switch (membershipLevel) {
            case BRONZE:
                System.out.println("Your current membership level is: BRONZE");
                break;
            case SILVER:
                System.out.println("Your current membership level is: SILVER");
                break;
            case GOLD:
                System.out.println("Your current membership level is: GOLD");
                break;
            case PLATINUM:
                System.out.println("Your current membership level is: PLATINUM");
                break;
            default:
                System.out.println("Invalid input. Please enter a valid membership level.");
                break;
        }
    }

    public static void choosePaymentMethod(Scanner scanner) {
        System.out.print("Enter payment method (CREDIT_CARD, DEBIT_CARD, PAYPAL, or BANK_TRANSFER): ");
        String methodString = scanner.nextLine().toUpperCase();
        PaymentMethod paymentMethod = PaymentMethod.valueOf(methodString.toUpperCase());

        switch (paymentMethod) {
            case CREDIT_CARD:
                System.out.println("Your current payment method is: CREDIT_CARD");
                break;
            case DEBIT_CARD:
                System.out.println("Your current payment method is: DEBIT_CARD");
                break;
            case PAYPAL:
                System.out.println("Your current payment method is: PAYPAL");
                break;
            case BANK_TRANSFER:
                System.out.println("Your current payment method is: BANK_TRANSFER");
                break;
            default:
                System.out.println("Invalid input. Please enter a valid payment method.");
                break;
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
