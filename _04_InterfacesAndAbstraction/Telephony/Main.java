package Telephony;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        List<String> numbers = Stream.of(sc.nextLine().split("\\s+")).toList();
        List<String> urls = Stream.of(sc.nextLine().split("\\s+")).toList();

        Smartphone smartphone = new Smartphone(numbers, urls);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());


    }
}
