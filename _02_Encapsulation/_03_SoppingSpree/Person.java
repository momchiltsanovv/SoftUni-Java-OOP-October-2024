package _03_SoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final List<Product> products;
    private String name;
    private double money;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > money) {
            String message = "%s can't afford %s%n".formatted(this.getName(), product.getName());
            throw new IllegalArgumentException(message);
        }
        this.products.add(product);
        this.money -= product.getCost();
        System.out.printf("%s bought %s\n", this.name, product.getName());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ");
        if (!products.isEmpty()) {
            products.forEach(product -> sb.append(product.getName()).append(", "));
            sb.setLength(sb.length() - 2);
        } else {
            sb.append("Nothing bought");
        }

        return sb.toString();
    }


}
