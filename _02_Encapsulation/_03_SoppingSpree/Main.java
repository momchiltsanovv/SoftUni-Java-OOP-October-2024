package _03_SoppingSpree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String[] firstLine = sc.nextLine().split(";");
        for (String token : firstLine) {
            String name = token.split("=")[0];
            double money = Double.parseDouble(token.split("=")[1]);
            Person person = new Person(name, money);
            people.add(person);
        }

        List<Product> products = new ArrayList<>();

        String[] secondLine = sc.nextLine().split(";");
        for (String token : secondLine) {
            String name = token.split("=")[0];
            double cost = Double.parseDouble(token.split("=")[1]);
            Product product = new Product(name, cost);
            products.add(product);
        }

        List<Person> list = new LinkedList<>();
        String[] input = sc.nextLine().split("\\s+");
        while (!input[0].equals("END")) {
            String personName = input[0];
            String productName = input[1];

            Person person = people.stream()
                    .filter(person1 -> person1.getName().equals(personName))
                    .findFirst()
                    .orElse(null);

            Product product = products.stream()
                    .filter(product1 -> product1.getName().equals(productName))
                    .findFirst()
                    .orElse(null);

            if (person != null && product != null) {
                person.buyProduct(product);
            }

            if (!list.contains(person)) {
                list.add(person);
            }

            input = sc.nextLine().split("\\s+");
        }


        list.forEach(System.out::println);
    }
}
