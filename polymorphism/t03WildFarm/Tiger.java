package t03WildFarm;

public class Tiger extends Felime {
    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion, Integer eatenFood) {
        super(animalName, animalType, animalWeight, livingRegion, eatenFood);
        this.livingRegion = livingRegion;
    }


    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");

    }

    @Override
    void eat(Food food) {
        if (food instanceof Vegetable) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.setEatenFood(food.getQuantity());
    }
}
