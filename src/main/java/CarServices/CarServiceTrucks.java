package CarServices;

import Interfaces.IPrintInfo;
import Interfaces.IWeighting;

public class CarServiceTrucks extends CarService implements IWeighting, IPrintInfo {

    private boolean isWeightStationHere;

    public CarServiceTrucks(String name, String address, long phoneNumber, boolean isWeightStationHere) {
        super(name, address, phoneNumber);
        this.isWeightStationHere = isWeightStationHere;

    }


    public boolean getWeightStationHere() {
        return isWeightStationHere;
    }

    public void setWeightStationHere(boolean weightStationHere) {
        isWeightStationHere = weightStationHere;
    }

    public void printDiscount() {
        log.info("We have a " + discount + "% discount for you");
    }

    @Override
    public void printInfo() {
        log.info("Service name:" + getName() + " Address: " + getAddress()
                + " Phone: " + getPhoneNumber() + " Weight Station: " + isWeightStationHere);
    }

    @Override
    public void waxCar() {
        log.info("We need 20 minutes to wax this car");
    }

    @Override
    public void washCar() {
        log.info("We need 20 minutes to wash this car");
    }

    @Override
    public void truckWeighting(boolean isWeightStationHere) {
        if (isWeightStationHere) {
            log.info("Truck is weighted");
        } else {
            log.info("Cars.Car services don't weight the trucks anymore");
        }
    }
}
