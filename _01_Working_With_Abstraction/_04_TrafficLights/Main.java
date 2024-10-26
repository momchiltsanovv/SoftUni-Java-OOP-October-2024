package _04_TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        TrafficLight[] lights = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(TrafficLight::valueOf)
                .toArray(TrafficLight[]::new);


        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            TrafficLight.updateLight(lights);
            TrafficLight.print(lights);
        }


    }
}
