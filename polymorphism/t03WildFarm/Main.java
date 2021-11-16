package t03WildFarm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] animalData = input.split("\\s+");
            String animalType = animalData[0];

            String[] foodData = scanner.nextLine().split("\\s+");
            String foodType = foodData[0];

            Food food = getFood(foodData);

            Animal animal = getAnimal(animalData);
            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            animals.add(animal);

            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }

    }

    private static Food getFood(String[] foodData) {
        String foodType = foodData[0];
        Integer foodQuantity = Integer.parseInt(foodData[1]);
        Food food = null;

        switch (foodType) {
            case "Vegetable":
                food = new Vegetable(foodQuantity);
                break;
            case "Meat":
                food = new Meat(foodQuantity);
                break;

        }
        return food;
    }

    private static Animal getAnimal(String[] animalData) {
        Animal animal = null;
        String animalType = animalData[0];
        String animalName = animalData[1];
        Double animalWeight = Double.parseDouble(animalData[2]);
        String animalLivingRegion = animalData[3];
        String catBreed = "";

        if (animalType.equals("Cat")) {
            catBreed = animalData[4];
        }
        switch (animalType) {
            case "Mouse":
                animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion, 0);
                break;
            case "Zebra":
                animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion, 0);
                break;
            case "Cat":
                animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, 0, catBreed);
                break;
            case "Tiger":
                animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion, 0);
                break;
        }
        return animal;
    }
}
