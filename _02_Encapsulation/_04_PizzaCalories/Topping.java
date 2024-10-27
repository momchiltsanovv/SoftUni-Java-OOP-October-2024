package _04_PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!toppingType.equalsIgnoreCase("veggies")
                && !toppingType.equalsIgnoreCase("sauce")
                && !toppingType.equalsIgnoreCase("cheese")
                && !toppingType.equalsIgnoreCase("meat")) {

            String message = "Cannot place %s on top of your pizza.".formatted(toppingType);
            throw new IllegalArgumentException(message);
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 50) {
            String message = "%s weight should be in the range [1..50].".formatted(toppingType);
            throw new IllegalArgumentException(message);
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double type;
        if(toppingType.equalsIgnoreCase("veggies")) {
            type = 0.8;
        } else if(toppingType.equalsIgnoreCase("sauce")) {
            type = 0.9;
        }else if(toppingType.equalsIgnoreCase("cheese")) {
            type = 1.1;
        } else {
            type = 1.2;
        }
        return 2 * this.weight * type;
    }


}
