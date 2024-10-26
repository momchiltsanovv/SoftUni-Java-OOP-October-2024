package _01_ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double length = Double.parseDouble(sc.nextLine());
        double width = Double.parseDouble(sc.nextLine());
        double height = Double.parseDouble(sc.nextLine());
        Box box = new Box(length, width, height);

        double surfaceArea = box.calculateSurfaceArea();
        double calculateVolume = box.calculateLateralSurfaceArea();
        double volume = box.calculateVolume();


        System.out.printf("""
                    Surface Area - %.2f
                    Lateral Surface Area - %.2f
                    Volume - %.2f""", surfaceArea, calculateVolume, volume
                );




    }
}
