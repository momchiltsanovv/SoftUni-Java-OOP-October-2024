package _02_VehiclesExtended;

public interface Vehicle {

    String drive(double distance);

    void refuel(double liters);

    void setEmpty(boolean empty);
}