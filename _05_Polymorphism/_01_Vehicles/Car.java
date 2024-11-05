package _01_Vehicles;


public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 0.9);
    }

    @Override
    public void refueling(double liters) {
        this.fuelQuantity += liters;
    }




}
