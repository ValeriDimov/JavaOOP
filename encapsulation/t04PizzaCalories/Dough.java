package encapsulation.t04PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double doughCalories = 2 * this.weight;
        switch (this.flourType) {
            case "White":
                if (this.bakingTechnique.equals("Crispy")) {
                    doughCalories = doughCalories * 1.5 * 0.9;
                } else if (this.bakingTechnique.equals("Chewy")) {
                    doughCalories = doughCalories * 1.5 * 1.1;
                } else if (this.bakingTechnique.equals("Homemade")) {
                    doughCalories = doughCalories * 1.5 * 1.0;
                }
                break;
            case "Wholegrain":
                if (this.bakingTechnique.equals("Crispy")) {
                    doughCalories = doughCalories * 1.0 * 0.9;
                } else if (this.bakingTechnique.equals("Chewy")) {
                    doughCalories = doughCalories * 1.0 * 1.1;
                } else if (this.bakingTechnique.equals("Homemade")) {
                    doughCalories = doughCalories * 1.0 * 1.0;
                }
                break;
        }
        return doughCalories;
    }
}
