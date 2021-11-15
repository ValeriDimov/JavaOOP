package polymorphism.t02VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        String[] carData = scanner.nextLine().split("\\s+");
        Vehicle car = getVehicle(carData);

        String[] truckData = scanner.nextLine().split("\\s+");
        Vehicle truck = getVehicle(truckData);

        String[] busData = scanner.nextLine().split("\\s+");
        Vehicle bus = getVehicle(busData);

        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

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
                case "DriveEmpty":
                    double emptyBusDistance = Double.parseDouble(commandsData[2]);
                    String busType = commandsData[0];
                    vehicles.get(vehicleType).driving(emptyBusDistance, busType);
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(commandsData[2]);
                    try {
                        vehicles.get(vehicleType).refueling(liters);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(String[] vehicleData) {
        String vehicleType = vehicleData[0];
        double vehicleFuelQuantity = Double.parseDouble(vehicleData[1]);
        double vehicleLitresPerKm = Double.parseDouble(vehicleData[2]);
        double vehicleTankCapacity = Double.parseDouble(vehicleData[3]);
        Vehicle vehicle = null;

        switch (vehicleType) {
            case "Car":
                vehicle = new Car(vehicleFuelQuantity, vehicleLitresPerKm, vehicleTankCapacity);
                break;
            case "Truck":
                vehicle = new Truck(vehicleFuelQuantity, vehicleLitresPerKm, vehicleTankCapacity);
                break;
            case "Bus":
                vehicle = new Bus(vehicleFuelQuantity, vehicleLitresPerKm, vehicleTankCapacity);
                break;
        }
        return vehicle;
    }
}
