package t03WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion,Integer eatenFood) {
        super(animalName, animalType, animalWeight, eatenFood);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        String format = decimalFormat.format(getAnimalWeight());
        return String.format("%s[%s, %s, %s, %d]", getAnimalType(),getAnimalName(),
                format, getLivingRegion(), getEatenFood());
    }
}
