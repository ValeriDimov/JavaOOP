package polymorphism.t01Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    void driving(double distance) {
        double currentDistanceConsumption = distance * (this.fuelConsumption);
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

    void refueling(double litres) {
        this.fuelQuantity += litres;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
