package polymorphism.t02VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    void driving(double distance) {
        double currentDistanceConsumption = distance * (this.fuelConsumption + 1.4);
        if (currentDistanceConsumption > this.fuelQuantity) {
            System.out.println(this.getClass().getSimpleName() + " needs refueling");
        } else {
            this.fuelQuantity -= currentDistanceConsumption;
            String pattern = "###.##";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            String format = decimalFormat.format(distance);
            System.out.println(this.getClass().getSimpleName() + " travelled " + format + " km");
        }
    }

    @Override
    void driving(double distance, String busType) {
        if (busType.equals("DriveEmpty")) {
            double currentDistanceConsumption = distance * this.fuelConsumption;
            if (currentDistanceConsumption > this.fuelQuantity) {
                System.out.println(this.getClass().getSimpleName() + " needs refueling");
            } else {
                this.fuelQuantity -= currentDistanceConsumption;
                String pattern = "###.##";
                DecimalFormat decimalFormat = new DecimalFormat(pattern);
                String format = decimalFormat.format(distance);
                System.out.println(this.getClass().getSimpleName() + " travelled " + format + " km");
            }
        }
    }
}
