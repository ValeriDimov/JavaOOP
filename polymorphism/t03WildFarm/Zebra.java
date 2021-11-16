package t03WildFarm;

public class Zebra extends Mammal {


    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion, Integer eatenFood) {
        super(animalName, animalType, animalWeight, livingRegion, eatenFood);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.setEatenFood(food.getQuantity());

    }
}
