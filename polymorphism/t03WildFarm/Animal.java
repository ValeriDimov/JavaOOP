package t03WildFarm;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer eatenFood;

    public Animal(String animalName, String animalType, Double animalWeight, Integer eatenFood) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.eatenFood = eatenFood;
    }

    public void setEatenFood(Integer eatenFood) {
        this.eatenFood = eatenFood;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getEatenFood() {
        return eatenFood;
    }

    abstract void makeSound();
    abstract void eat(Food food);

}
