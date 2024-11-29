package _02_VehiclesExtended;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {

    private final double tankCapacity;
    private double fuelQuantity;
    private double fuelConsumption;

    public VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String drive(double distance) {
        DecimalFormat df = new DecimalFormat("#.##");

        double neededFuel = this.fuelConsumption * distance;

        String result = "%s needs refueling".formatted(this.getClass().getSimpleName());

        if (this.fuelQuantity >= neededFuel) {
            result = String.format("%s travelled %s km",
                                   this.getClass().getSimpleName(),
                                   df.format(distance));

            this.fuelQuantity -= neededFuel;
        }

        return result;
    }

    @Override
    public void refuel(double liters) {

        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (this.fuelQuantity + liters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return "%s: %.2f".formatted(this.getClass().getSimpleName(), this.fuelQuantity);
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setEmpty(boolean empty) {
        //TODO print Method not supported
    }
}
