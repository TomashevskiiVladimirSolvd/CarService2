package com.solvd.laba.MainMethod;

import com.solvd.laba.Enums.DayOfWeekEnum;
import com.solvd.laba.FinalClass.DataBaseConfig;
import com.solvd.laba.Exceptions.*;
import com.solvd.laba.Cars.Car;
import com.solvd.laba.CarServices.CarServiceTrailers;
import com.solvd.laba.CarServices.CarServiceTrucks;
import com.solvd.laba.CarServices.CarServiceUsualCars;
import com.solvd.laba.Clients.Client;
import com.solvd.laba.Employees.Boss;
import com.solvd.laba.Employees.Manager;
import com.solvd.laba.Employees.Mechanic;
import com.solvd.laba.Interfaces.*;
import com.solvd.laba.Licenses.LicenseLinkedList;
import com.solvd.laba.LogRead;

import java.util.*;

import org.apache.log4j.Logger;

import static com.solvd.laba.Interfaces.ICarService.GAS_95_RATE;

public class Main {

    public static void main(String[] args) {
        Logger log = Logger.getLogger(Main.class);
        DayOfWeekEnum.chooseDay();
        double gas95Rate = GAS_95_RATE;
        log.info("The rate of gas-95 is: " + gas95Rate);
        CarServiceTrucks cSTrucks = new CarServiceTrucks("TruckFix", " 14th ave", 98766543, false);
        printInfo(cSTrucks);
        //Custom lambda1
        ICheck iCheckContains = (str1, str2) -> str1.contains(str2);
        System.out.println(iCheckContains.check(cSTrucks.getName(), "Truck"));
        //Custom lambda2
        IUppercase iUppercase = str -> str.equals(str.toUpperCase());
        System.out.println(iUppercase.isUppercase(cSTrucks.getName()));
        //Custom lambda3
        IStringConsumer iStringConsumer = str -> System.out.println(str.length());
        iStringConsumer.printLength(cSTrucks.getName());

        Client clientTruck = new Client("Bill Monroe", "555 Dickson street");
        clientTruck.printInfo();
        clientTruck.leaveGoodFeedback();
        clientTruck.showStatus();
        clientTruck.showMembershipLevel();
        clientTruck.choosePaymentMethod();
        Manager managerTruck = new Manager("Bill Dylan", "Manager", "678 Bud street", 1, 0);
        Mechanic mechanicTruck = new Mechanic("Bob Bronson", "Mechanic", "55 Found ave", 33, 1);
        Boss bossTruck = new Boss("Phill Dumphy", "Boss", "77 Grass ave", 3);
        printInfo(managerTruck);
        work(managerTruck);
        managerTruck.talkToInsurance();
        try {
            managerTruck.toWorkWithClients();
        } catch (ClaimException e) {
            log.info("Manager was rude with a client.Now the client filed a complain");
            e.printStackTrace();
        }
        printInfo(mechanicTruck);
        work(mechanicTruck);
        mechanicTruck.checkUpCar();
        try {
            mechanicTruck.useTheGloves();
        } catch (GetDirtyException e) {
            log.info("Mechanic doesn't have gloves .His hands are dirty now.");
            e.printStackTrace();
            mechanicTruck.setGlovesNumber(6);
            mechanicTruck.useTheGloves();
        }
        printInfo(bossTruck);
        work(bossTruck);
        bossTruck.countSalary();
        Car truckcar1 = new Car("Volvo", "VNL300", 1990, 7600, true);
        Car truckcar2 = new Car("Volvo", "VNL400", 1995, 8000, false);
        printInfo(truckcar1);
        System.out.println("List of oils" + truckcar1.getOils());
        long serviceCount = truckcar1.getServiceTypeCount();
        log.info("Count of ServiceTypes: " + serviceCount);
        boolean isHasServiceType = truckcar1.hasServiceType("Wheels change");
        log.info("Is Service type has 'Wheels change'?:" + isHasServiceType);
        String firstServiceType = truckcar1.getFirstServiceType();
        log.info("The first Service Type is: " + firstServiceType);
        List<String> sortedServiceTypes = truckcar1.getSortedServiceTypes();
        sortedServiceTypes.stream().forEach(str -> log.info(str));
        String oilWithLongestName = truckcar1.getOilWithLongestName();
        log.info("Oil with longest name is:" + oilWithLongestName);
        boolean isAllOilsContainKeyword = truckcar1.allOilsContainKeyword("mobil");
        log.info("Is all oils contains 'mobil'?: " + isAllOilsContainKeyword);
        truckcar1.removeOil("mobil");
        System.out.println("List of oils without mobil:" + truckcar1.getOils());
        truckcar1.printColorCode();
        printInfo(truckcar2);
        cSTrucks.washCar();
        cSTrucks.waxCar();
        printDiscount(cSTrucks);
        log.info("Hash Code" + cSTrucks.hashCode());
        cSTrucks.truckWeighting(cSTrucks.getWeightStationHere());
        log.info("Cars.Car services for usual cars:");
        CarServiceUsualCars cSUsual = new CarServiceUsualCars("CarRepair", "12 Hamilton street", 857563532, false);
        printInfo(cSUsual);
        Manager usualManager = new Manager("Billy Crystal", "Manager", "365 Gum street", 11, 0);
        Mechanic usualMechanic = new Mechanic("Buddy Hamilton", "Mechanic", "99 Round ave", 1, 1);
        Boss usualBoss = new Boss("Matt Logan", "Boss", "432 Pan street", 2);
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

        Car usualcar1 = new Car("Toyota", "Corolla", 2018, 13800, true);
        Car usualcar2 = new Car("Nissan", "Versa", 2015, 9000, false);
        printInfo(usualcar1);
        printInfo(usualcar2);
        cSUsual.waxCar();
        cSUsual.washCar();
        printDiscount(cSUsual);
        log.info("Hash Code" + cSUsual.hashCode());
        cSUsual.installSpoilers(cSUsual.isSpoilerInStock());
        cSUsual.tintingWindows();

        CarServiceTrailers cSTrailers = new CarServiceTrailers("TrailersGood", "333 Madison road", 43456788, false);
        printInfo(cSTrailers);
        Manager trailerManager = new Manager("William Norton", "Manager", "399 Zoom street", 3, 1);
        Mechanic trailerMechanic = new Mechanic("Ernest Hamim", "Mechanic", "90 Bound ave", 45, 2);
        Boss trailerBoss = new Boss("Lick Lock", "Boss", "454 Grant street", 4);
        printInfo(trailerManager);
        work(trailerManager);
        trailerManager.talkToInsurance();
        printInfo(trailerMechanic);
        work(trailerMechanic);
        trailerMechanic.checkUpCar();
        printInfo(trailerBoss);
        work(trailerBoss);
        trailerBoss.countSalary();
        Car trailercar1 = new Car("RAM", "Roadtrek Zion", 2007, 30000, true);
        Car trailercar2 = new Car("Ford", "Chateau", 2009, 35000, false);
        printInfo(trailercar1);
        trailercar1.chooseServiceType();
        printInfo(trailercar2);
        cSTrailers.waxCar();
        cSTrailers.washCar();
        printDiscount(cSTrailers);
        log.info("Hash Code: " + cSTrailers.hashCode());
        cSTrailers.hashCode();
        cSTrailers.kitchenChange(cSTrailers.isFridgeInStock());
        log.info("Available lisence plates:");
        LicenseLinkedList<String> licensePlateString = new LicenseLinkedList<>();
        licensePlateString.add("plate");
        licensePlateString.add("blatev");
        licensePlateString.add("klate");
        licensePlateString.add("kmlaate");
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
        licensePlateInteger.addAll(licensePlateInteger2);
        Iterator<Integer> iterator = licensePlateInteger.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        DataBaseConfig dataBaseConfig = new DataBaseConfig("jdbc:mysql://localhost:3507/Bigdb", 200);
        dataBaseConfig.printInfo();

        LogRead logRead = new LogRead();
        logRead.countUniqueWords("src/main/resources/countUniqueWords.txt");

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