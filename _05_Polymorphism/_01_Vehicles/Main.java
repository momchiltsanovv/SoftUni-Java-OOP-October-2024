package _01_Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String[] inputCar = sc.nextLine().split("\\s+");
        String[] inputTruck = sc.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(inputCar[1]), Double.parseDouble(inputCar[2]));
        Vehicle truck = new Truck(Double.parseDouble(inputTruck[1]), Double.parseDouble(inputTruck[2]));

        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String type = input[1];
            switch (input[0]) {
                case "Drive" -> {
                    if (type.equals("Car")) {
                        System.out.println(car.driving(Double.parseDouble(input[2])));
                    } else {
                        System.out.println(truck.driving(Double.parseDouble(input[2])));
                    }
                }
                case "Refuel" -> {
                    if (type.equals("Car")) {
                        car.refueling(Double.parseDouble(input[2]));
                    } else {
                        truck.refueling(Double.parseDouble(input[2]));
                    }
                }
            }
        }

        System.out.printf(car.toString());
        System.out.printf(truck.toString());

    }
}
