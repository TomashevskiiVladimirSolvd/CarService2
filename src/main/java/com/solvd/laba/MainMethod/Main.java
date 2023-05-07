package com.solvd.laba.MainMethod;

import com.solvd.laba.CarServices.CarService;
import com.solvd.laba.Exceptions.*;
import com.solvd.laba.Cars.Car;
import com.solvd.laba.CarServices.CarServiceTrailers;
import com.solvd.laba.CarServices.CarServiceTrucks;
import com.solvd.laba.CarServices.CarServiceUsualCars;
import com.solvd.laba.Clients.Client;
import com.solvd.laba.Employees.Boss;
import com.solvd.laba.Employees.Manager;
import com.solvd.laba.Employees.Mechanic;
import com.solvd.laba.Interfaces.ICarService;
import com.solvd.laba.Interfaces.IPrintInfo;
import com.solvd.laba.Interfaces.IWork;
import com.solvd.laba.Licenses.LicenseLinkedList;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import static org.apache.commons.io.FileUtils.writeStringToFile;

public class Main {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.getLogger(Main.class.getName());
        FileHandler fh;
        fh = new FileHandler("src/main/resources/Main.log");
        log.addHandler(fh);

        File text = new File("src/main/resources/text.txt");
        File countUniqueWords = new File("src/main/resources/countUniqueWords.txt");
        String content = FileUtils.readFileToString(text, StandardCharsets.UTF_8.name());
        String[] arr = content.split("[^a-zA-Z]+");
        ArrayList<String> arl = new ArrayList<>(Arrays.asList(arr));
        Set<String> set = new HashSet<>(arl);
        writeStringToFile(countUniqueWords, "The number of unique words is:" + set.size());

        double gas95Rate = CarService.GAS_95_RATE;
        log.info("The rate of Gas 95 is: " + gas95Rate);

        log.info("Cars.Car services for Trucks:");
        CarServiceTrucks cSTrucks = new CarServiceTrucks("TruckFix", " 14th ave", 98766543, false);
        printInfo(cSTrucks);
        Client clientTruck = new Client("Bill Monroe", "555 Dickson street");
        log.info("Clients:");
        clientTruck.printInfo();
        clientTruck.leaveGoodFeedback();
        Manager managerTruck = new Manager("Bill Dylan", "Employees.Manager", "678 Bud street", 1, 0);
        Mechanic mechanicTruck = new Mechanic("Bob Bronson", "Employees.Mechanic", "55 Found ave", 33, 1);
        Boss bossTruck = new Boss("Phill Dumphy", "Employees.Boss", "77 Grass ave", 3);
        log.info("Employees:");
        printInfo(managerTruck);
        work(managerTruck);
        managerTruck.talkToInsurance();
        try {
            managerTruck.toWorkWithClients();
        } catch (ClaimException e) {
            log.info("Employees.Manager was rude with a client.Now the client filed a complain");
            e.printStackTrace();
        }
        printInfo(mechanicTruck);
        work(mechanicTruck);
        mechanicTruck.checkUpCar();
        mechanicTruck.useTheGloves();
        try {
            mechanicTruck.useTheGloves();
        } catch (GetDirtyException e) {
            log.info("Employees.Mechanic doesn't have gloves .His hands are dirty now.");
            e.printStackTrace();
            mechanicTruck.setGlovesNumber(6);
            mechanicTruck.useTheGloves();
        }
        printInfo(bossTruck);
        work(bossTruck);
        bossTruck.countSalary();
        Car truckcar1 = new Car("Volvo", "VNL300");
        Car truckcar2 = new Car("Volvo", "VNL400");
        log.info("Cars:");
        printInfo(truckcar1);
        printInfo(truckcar2);
        cSTrucks.washCar();
        cSTrucks.waxCar();
        printDiscount(cSTrucks);
        log.info("Hash Code" + cSTrucks.hashCode());
        cSTrucks.truckWeighting(cSTrucks.getWeightStationHere());


        log.info("Cars.Car services for usual cars:");
        CarServiceUsualCars cSUsual = new CarServiceUsualCars("CarRepair", "12 Hamilton street", 857563532, false);
        printInfo(cSUsual);
        Manager usualManager = new Manager("Billy Crystal", "Employees.Manager", "365 Gum street", 11, 0);
        Mechanic usualMechanic = new Mechanic("Buddy Hamilton", "Employees.Mechanic", "99 Round ave", 1, 1);
        Boss usualBoss = new Boss("Matt Logan", "Employees.Boss", "432 Pan street", 2);
        log.info("Employees:");
        printInfo(usualManager);
        work(usualManager);
        usualManager.talkToInsurance();
        try {
            usualManager.createCarInsurance();
        } catch (LawException e) {
            log.info("Fake car Insurance is illegal,You'll be in jail");
            e.printStackTrace();
        }
        printInfo(usualMechanic);
        work(usualMechanic);
        usualMechanic.checkUpCar();
        usualMechanic.fillFormOfBrokenTool();
        try {
            usualMechanic.fillFormOfBrokenTool();
        } catch (ToolException e) {
            log.info("You don't have tools .It is really bad");
            e.printStackTrace();
            usualMechanic.setToolsNumber(5);
            usualMechanic.fillFormOfBrokenTool();
        }
        printInfo(usualBoss);
        work(usualBoss);
        usualBoss.countSalary();
        try {
            usualBoss.controlBusiness();
        } catch (BusinessException e) {
            log.info("You don't control your business.It is bad for your income.");
            e.printStackTrace();
        }
        try {
            usualBoss.readDocumentFirstLine("");
        } catch (IOException e) {
            log.info("No such file or directory");
            e.printStackTrace();
        }

        Car usualcar1 = new Car("Toyota", "Corolla");
        Car usualcar2 = new Car("Nissan", "Versa");
        log.info("Cars:");
        printInfo(usualcar1);
        printInfo(usualcar2);
        cSUsual.waxCar();
        cSUsual.washCar();
        printDiscount(cSUsual);
        log.info("Hash Code" + cSUsual.hashCode());
        cSUsual.installSpoilers(cSUsual.isSpoilerInStock());
        cSUsual.tintingWindows();


        log.info("Cars.Car services for Trailers:");
        CarServiceTrailers cSTrailers = new CarServiceTrailers("TrailersGood", "333 Madison road", 43456788, false);
        printInfo(cSTrailers);
        Manager trailerManager = new Manager("William Norton", "Employees.Manager", "399 Zoom street", 3, 1);
        Mechanic trailerMechanic = new Mechanic("Ernest Hamim", "Employees.Mechanic", "90 Bound ave", 45, 2);
        Boss trailerBoss = new Boss("Lick Lock", "Employees.Boss", "454 Grant street", 4);
        log.info("Employees:");
        printInfo(trailerManager);
        work(trailerManager);
        trailerManager.talkToInsurance();
        printInfo(trailerMechanic);
        work(trailerMechanic);
        trailerMechanic.checkUpCar();
        printInfo(trailerBoss);
        work(trailerBoss);
        trailerBoss.countSalary();
        Car trailercar1 = new Car("RAM", "Roadtrek Zion");
        Car trailercar2 = new Car("Ford", "Chateau");
        log.info("Cars:");
        printInfo(trailercar1);
        printInfo(trailercar2);
        cSTrailers.waxCar();
        cSTrailers.washCar();
        printDiscount(cSTrailers);
        log.info("Hash Code" + cSTrailers.hashCode());
        cSTrailers.kitchenChange(cSTrailers.isFridgeInStock());

        log.info("List of Oil price:");
        trailercar1.oils.put(400, "Porcshe");
        trailercar1.oils.put(200, "Castrol");
        trailercar1.oils.put(300, "Pennzoil");
        trailercar1.oils.put(100, "Mobil");
        trailercar1.printOilPrice();

        log.info("List of car maintenance:");
        trailerMechanic.carMaintenance.add("Oil change");
        trailerMechanic.carMaintenance.add("Tire rotation");
        trailerMechanic.carMaintenance.add("Light change");
        trailerMechanic.carMaintenance.add("Air Filter change");
        trailerMechanic.printCarMaintenance();

        log.info("Available lisence plates:");
        LicenseLinkedList<String> licensePlateString = new LicenseLinkedList<>();
        licensePlateString.add("plate");
        licensePlateString.add("pplate");
        licensePlateString.add("pllate");
        licensePlateString.add("plaate");
        licensePlateString.remove(2);
        licensePlateString.printInfo();
        System.out.println(licensePlateString.size());
        System.out.println(licensePlateString.get(1));


        LicenseLinkedList<Integer> licensePlateInteger = new LicenseLinkedList<>();
        licensePlateInteger.add(123456);
        licensePlateInteger.clear();
        licensePlateInteger.add(857576);
        licensePlateInteger.add(284045);
        licensePlateInteger.add(285445);
        licensePlateInteger.printInfo();
        System.out.println("Is this empty list: " + licensePlateInteger.isEmpty());
        System.out.println(licensePlateInteger.contains(857576));


        LicenseLinkedList<Integer> licensePlateInteger2 = new LicenseLinkedList<>();
        licensePlateInteger2.add(586768);
        licensePlateInteger2.add(586760);
        try {
            licensePlateInteger2.addAll(licensePlateInteger);
        } catch (UnsupportedOperationException e) {
            licensePlateInteger.printInfo();
        }

    }

    public static void printDiscount(ICarService iCarService) {
        iCarService.printDiscount();
    }

    public static void printInfo(IPrintInfo iPrintInfo) {
        iPrintInfo.printInfo();
    }

    public static void work(IWork iWork) {
        iWork.work();
    }


}