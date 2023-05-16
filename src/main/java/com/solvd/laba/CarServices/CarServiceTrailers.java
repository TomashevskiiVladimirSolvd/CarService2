package com.solvd.laba.CarServices;

import com.solvd.laba.Interfaces.IDesignChanges;
import com.solvd.laba.Interfaces.IPrintInfo;
import org.apache.log4j.Logger;

public class CarServiceTrailers extends CarService implements IDesignChanges, IPrintInfo {
    Logger log = Logger.getLogger(CarServiceTrailers.class);
    boolean isFridgeInStock;

    public CarServiceTrailers(String name, String address, long phoneNumber, boolean isFridgeInStock) {
        super(name, address, phoneNumber);
        this.isFridgeInStock = isFridgeInStock;
    }

    @Override
    public void printInfo() {
        log.info("Service name:" + name + " Address: " + address
                + " Phone: " + phoneNumber + " Fridge In Stock: " + isFridgeInStock);
    }

    public boolean isFridgeInStock() {
        return isFridgeInStock;
    }

    public void setFridgeInStock(boolean fridgeInStock) {
        isFridgeInStock = fridgeInStock;
    }

    public void printDiscount() {
        log.info("We have a " + discount + "% discount for you");
    }


    @Override
    public void waxCar() {
        log.info("We need 25 minutes to wax this car");
    }

    @Override
    public void washCar() {
        log.info("We need 25 minutes to wash this car");
    }


    @Override
    public void bathroomChange() {
        log.info("Bathroom is changed");
    }

    @Override
    public void kitchenChange(boolean isFridgeInStock) {
        if (isFridgeInStock) {
            log.info("Kitchen is changed");
        } else {
            log.info("We can't change kitchen.");
        }

    }


}
