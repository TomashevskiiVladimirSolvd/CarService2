package com.solvd.laba.Clients;

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

    public Client(String name, String address) {
        this.name = name;
        this.address = address;
    }

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

    public static Status showStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter status (ACTIVE, INACTIVE, or PENDING): ");
        String statusString = scanner.nextLine().toUpperCase();

        try {
            Status status = Status.valueOf(statusString);

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
            return status;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please enter a valid status.");
            return showStatus();
        }
    }


    public static MembershipLevel showMembershipLevel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter membership level (BRONZE, SILVER, GOLD, or PLATINUM): ");
        String levelString = scanner.nextLine().toUpperCase();

        try {
            MembershipLevel membershipLevel = MembershipLevel.valueOf(levelString);

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

            return membershipLevel;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please enter a valid membership level.");
            return showMembershipLevel();
        }
    }


    public static PaymentMethod choosePaymentMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter payment method (CREDIT_CARD, DEBIT_CARD, PAYPAL, or BANK_TRANSFER): ");
        String methodString = scanner.nextLine().toUpperCase();

        try {
            PaymentMethod paymentMethod = PaymentMethod.valueOf(methodString);

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

            return paymentMethod;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please enter a valid payment method.");
            return choosePaymentMethod();
        }
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
