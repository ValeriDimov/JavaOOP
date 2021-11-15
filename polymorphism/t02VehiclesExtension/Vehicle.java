package polymorphism.t02VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    void driving(double distance, String busType) {

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
        if (litres <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if ((this.fuelQuantity + litres) > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += litres;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
