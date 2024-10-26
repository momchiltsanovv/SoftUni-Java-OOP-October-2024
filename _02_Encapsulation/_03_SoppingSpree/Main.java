package _03_SoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Person> persons = new HashMap<>();
        String[] tokensPersons = sc.nextLine().split(";");
        for (String token : tokensPersons) {
            String[] parts = token.split("=");
            String personName = parts[0];
            double personMoney = Double.parseDouble(parts[1]);
            persons.put(personName, new Person(personName, personMoney));
        }

        Map<String, Product> products = new HashMap<>();
        String[] tokensProducts = sc.nextLine().split(";");
        for (String token : tokensProducts) {
            String[] parts = token.split("=");
            String productName = parts[0];
            double productCost = Double.parseDouble(parts[1]);
            products.put(productName, new Product(productName, productCost));
        }

        List<Person> list = new LinkedList<>();
        String[] input = sc.nextLine().split("\\s+");
        while (!input[0].equals("END")) {
            String personName = input[0];
            String productName = input[1];

            Person person = persons.get(personName);
            Product product = products.get(productName);

            person.buyProduct(product);

            if (!list.contains(person)) {
                list.add(person);
            }
            input = sc.nextLine().split("\\s+");
        }


        list.forEach(System.out::println);
    }
}
