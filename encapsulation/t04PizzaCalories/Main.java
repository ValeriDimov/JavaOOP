package encapsulation.t04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaData = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);
        Pizza pizza;

        try {
            pizza = new Pizza(pizzaName, numberOfToppings);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] doughData = scanner.nextLine().split("\\s+");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double weightInGrams = Double.parseDouble(doughData[3]);
        Dough dough;

        try {
            dough = new Dough(flourType, bakingTechnique, weightInGrams);
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String toppings = scanner.nextLine();
        Topping topping = null;

        while (!toppings.equals("END")) {
            String[] toppingsData = toppings.split("\\s+");
            String toppingType = toppingsData[1];
            double toppingsWeight = Double.parseDouble(toppingsData[2]);

            try {
                topping = new Topping(toppingType, toppingsWeight);
                pizza.addTopping(topping);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            toppings = scanner.nextLine();
        }

        double totalCal =  pizza.getOverallCalories();
        System.out.printf("%s - %.2f", pizza.getName(), totalCal);
    }
}
