package _04_PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split("\\s+");
        Pizza pizza = null;
        Dough dough;
        Topping topping;
        while (!tokens[0].equals("END")) {
            String type = tokens[0];

            if (type.equals("Pizza")) {
                String pizzaName = tokens[1];
                int numberOfToppings = Integer.parseInt(tokens[2]);
                pizza = new Pizza(pizzaName, numberOfToppings);
            } else if (type.equals("Dough")) {
                String flourType = tokens[1];
                String backingTechnique = tokens[2];
                double weightInGrams = Double.parseDouble(tokens[3]);
                dough = new Dough(flourType, backingTechnique, weightInGrams);
                if (pizza != null) { //  or use assert pizza != null
                    pizza.setDough(dough);
                }
            } else {
                String toppingType = tokens[1];
                double weightInGrams = Double.parseDouble(tokens[2]);
                topping = new Topping(toppingType, weightInGrams);
                if (pizza != null) { //  or use assert pizza != null
                    pizza.addTopping(topping);
                }
            }

            tokens = sc.nextLine().split("\\s+");
        }

        if (pizza != null) {
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        }
    }
}
