package polymorphism.t01Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        String[] carData = scanner.nextLine().split("\\s+");
        double carFuelQuantity = Double.parseDouble(carData[1]);
        double carLitresPerKm = Double.parseDouble(carData[2]);
        Vehicle car = new Car(carFuelQuantity, carLitresPerKm);

        String[] truckData = scanner.nextLine().split("\\s+");
        double truckFuelQuantity = Double.parseDouble(truckData[1]);
        double truckLitresPerKm = Double.parseDouble(truckData[2]);
        Vehicle truck = new Truck(truckFuelQuantity, truckLitresPerKm);

        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            String[] commandsData = scanner.nextLine().split("\\s+");
            String command = commandsData[0];
            String vehicleType = commandsData[1];

            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(commandsData[2]);
                    vehicles.get(vehicleType).driving(distance);
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(commandsData[2]);
                    vehicles.get(vehicleType).refueling(liters);
                    break;
            }
        }
        vehicles.values().forEach(System.out::println);
    }
}
