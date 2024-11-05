package _01_Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    protected double fuelQuantity;
    protected double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public String driving(double distance) {

        DecimalFormat df = new DecimalFormat("#.##");

        if (fuelQuantity < distance * this.fuelConsumption) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        fuelQuantity -= distance * this.fuelConsumption;

        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));

    }

    abstract void refueling(double liters);

    @Override
    public String toString() {
        return String.format("%s: %.2f\n", this.getClass().getSimpleName(), fuelQuantity);
    }
}
