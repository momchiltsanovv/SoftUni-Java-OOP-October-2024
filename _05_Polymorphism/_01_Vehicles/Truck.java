package _01_Vehicles;


public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
    }

    @Override
    public void refueling(double liters) {
        super.fuelQuantity += 0.95 * liters;

    }

}
