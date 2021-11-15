package polymorphism.t01Vehicles;

public class Truck extends Vehicle {
    public static final double AC_ADDITIONAL_CONSUMPTION = 1.6;
    public static final double FUEL_REDUCTION = 0.95;


    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AC_ADDITIONAL_CONSUMPTION);
    }

    @Override
    void refueling(double litres) {
        super.refueling(litres * FUEL_REDUCTION);
    }
}
