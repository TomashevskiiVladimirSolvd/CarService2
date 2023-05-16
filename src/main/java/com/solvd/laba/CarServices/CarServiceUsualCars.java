package com.solvd.laba.CarServices;

import com.solvd.laba.Interfaces.ICarTuning;
import com.solvd.laba.Interfaces.IPrintInfo;
import org.apache.log4j.Logger;

public class CarServiceUsualCars extends CarService implements ICarTuning, IPrintInfo {
    Logger log = Logger.getLogger(CarServiceUsualCars.class);
    boolean isSpoilerInStock;

    public CarServiceUsualCars(String name, String address, long phoneNumber, boolean isSpoilerInStock) {
        super(name, address, phoneNumber);
        this.isSpoilerInStock = isSpoilerInStock;
    }

    public boolean isSpoilerInStock() {
        return isSpoilerInStock;
    }

    public void setSpoilerInStock(boolean spoilerInStock) {
        isSpoilerInStock = spoilerInStock;
    }

    @Override
    public void printInfo() {
        log.info("Service name:" + name + " Address: " + address
                + " Phone: " + phoneNumber + " Spoilers In Stock: " + isSpoilerInStock);
    }

    public void printDiscount() {
        log.info("We have a " + discount + "% discount for you");
    }

    @Override
    public void waxCar() {
        log.info("We need 10 minutes to wax this car");
    }

    @Override
    public void washCar() {
        log.info("We need 10 minutes to wash this car");
    }


    @Override
    public void installSpoilers(boolean isSpoilerInStock) {
        if (isSpoilerInStock) {
            log.info("The spoilers were installed");
        } else {
            log.info("Spoilers not installed");
        }
    }

    @Override
    public void tintingWindows() {
        log.info("The tinting windows is done");
    }

}
