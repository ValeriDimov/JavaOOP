package encapsulation.t04PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies")
                && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")) {
            String message = String.format("Cannot place %s on top of your pizza.", toppingType);
            throw new IllegalArgumentException(message);
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            String message = String.format("%s weight should be in the range [1..50].", this.toppingType);
            throw new IllegalArgumentException(message);
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double toppingCalories = 2 * this.weight;
        switch (this.toppingType) {
            case "Meat":
                toppingCalories *= 1.2;
                break;
            case "Veggies":
                toppingCalories *= 0.8;
                break;
            case "Cheese":
                toppingCalories *= 1.1;
                break;
            case "Sauce":
                toppingCalories *= 0.9;
                break;
        }
        return toppingCalories;
    }
}
