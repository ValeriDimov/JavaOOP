package t03WildFarm;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, Integer eatenFood, String breed) {
        super(animalName, animalType, animalWeight, livingRegion, eatenFood);
        this.breed = breed;
    }


    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eat(Food food) {
        super.setEatenFood(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        String format = decimalFormat.format(getAnimalWeight());
        return String.format("%s[%s, %s, %s, %s, %d]", getAnimalType(), getAnimalName(),
                this.breed, format, getLivingRegion(), getEatenFood());
    }
}
