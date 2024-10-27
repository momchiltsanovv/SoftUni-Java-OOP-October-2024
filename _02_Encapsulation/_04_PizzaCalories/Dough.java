package _04_PizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        if (!flourType.equalsIgnoreCase("white")
                && !flourType.equalsIgnoreCase("wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equalsIgnoreCase("crispy")
                && !bakingTechnique.equalsIgnoreCase("chewy")
                && !bakingTechnique.equalsIgnoreCase("homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        double typeFlour;
        double typeBakingTechnique;
        if (this.flourType.equalsIgnoreCase("white")) {
            typeFlour = 1.5;
        } else {
            typeFlour = 1.0;
        }
        if (this.bakingTechnique.equalsIgnoreCase("crispy")) {
            typeBakingTechnique = 0.9;
        } else if (this.bakingTechnique.equalsIgnoreCase("chewy")) {
            typeBakingTechnique = 1.1;
        } else {
            typeBakingTechnique = 1.0;
        }
        return 2 * this.weight * typeFlour * typeBakingTechnique;
    }

}
 