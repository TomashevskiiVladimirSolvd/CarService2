package MainMethod;

import CarServices.*;
import Employees.*;
import Interfaces.*;
import Exceptions.*;
import Clients.Client;
import Licenses.*;
import Cars.*;
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

public class Main {


    public static void main(String[] args) throws Exception {
        Logger log = Logger.getLogger(Main.class.getName());
        FileHandler fh;
        fh = new FileHandler("/Users/virasamarska/Desktop/MainMethod.Main.log");
        log.addHandler(fh);

        File text = new File("src/main/resources/text.txt");
        String content = FileUtils.readFileToString(text, StandardCharsets.UTF_8.name());
        String[] arr = content.split("\\W+");
        ArrayList<String> arl = new ArrayList<>(Arrays.asList(arr));
        System.out.println(arl.toString());
        Set<String> set = new HashSet<>(arl);
        FileUtils.writeStringToFile(text, content + " " + set.size());


        log.info("Cars.Car services for Trucks:");
        CarServiceTrucks cSTrucks = new CarServiceTrucks("TruckFix", " 14th ave", 98766543, false);
        printInfo(cSTrucks);
        Client clientTruck = new Client("Bill Monroe", "555 Dickson street");
        log.info("Clients:");
        clientTruck.printInfo();
        clientTruck.leaveGoodFeedback();
        Manager managerTruck = new Manager("Bill Dylan", "Employees.Manager", "678 Bud street", 1, 0);
        Mechanic mechanicTruck = new Mechanic("Bob Bronson", "Employees.Mechanic", "55 Found ave", 33, 0);
        Boss bossTruck = new Boss("Phill Dumphy", "Employees.Boss", "77 Grass ave", 3);
        log.info("Employees:");
        printInfo(managerTruck);
        work(managerTruck);
        managerTruck.talkToInsurance();
        try {
            managerTruck.toWorkWithClients();
        } catch (ClaimException c) {
            log.info("Employees.Manager was rude with a client.Now the client filed a complain");
            c.printStackTrace();
        }
        printInfo(mechanicTruck);
        work(mechanicTruck);
        mechanicTruck.checkUpCar();
        try {
            mechanicTruck.useTheGloves();
        } catch (GetDirtyException g) {
            log.info("Employees.Mechanic doesn't have gloves .His hands are dirty now.");
            g.printStackTrace();
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
        Mechanic usualMechanic = new Mechanic("Buddy Hamilton", "Employees.Mechanic", "99 Round ave", 0, 1);
        Boss usualBoss = new Boss("Matt Logan", "Employees.Boss", "432 Pan street", 2);
        log.info("Employees:");
        printInfo(usualManager);
        work(usualManager);
        usualManager.talkToInsurance();
        try {
            usualManager.createCarInsurance();
        } catch (LawException l) {
            log.info("Fake car Insurance is illegal,You'll be in jail");
            l.printStackTrace();
        }
        printInfo(usualMechanic);
        work(usualMechanic);
        usualMechanic.checkUpCar();
        try {
            usualMechanic.useTools();
        } catch (ToolException t) {
            log.info("You don't have tools .It is really bad");
            t.printStackTrace();
        }
        printInfo(usualBoss);
        work(usualBoss);
        usualBoss.countSalary();
        try {
            usualBoss.controlBusiness();
        } catch (BusinessException b) {
            log.info("You don't control your business.It is bad for your income.");
            b.printStackTrace();
        }
        try {
            usualBoss.readDocumentFirstLine("");
        } catch (IOException i) {
            log.info("No such file or directory");
            i.printStackTrace();
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
        licensePlateString.add("hhfghj");
        licensePlateString.add("hffyhj");
        licensePlateString.add("hhjghj");
        licensePlateString.printInfo();

        LicenseLinkedList<Integer> licensePlateInteger = new LicenseLinkedList<>();
        licensePlateInteger.add(123456);
        licensePlateInteger.add(857576);
        licensePlateInteger.add(284045);
        licensePlateInteger.printInfo();


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