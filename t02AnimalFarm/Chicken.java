package encapsulation.t02AnimalFarm;

public class Chicken {
    private String name;
    private int age;


    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double productPerDay(int age) {
        return calculateProductPerDay(age);
    }

    private double calculateProductPerDay(int age) {
        double eggs = 0;
        if (age < 6) {
            eggs = 2;
        } else if (age < 12) {
            eggs = 1;
        } else {
            eggs = 0.75;
        }
        return eggs;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",this.name, this.age, this.productPerDay(this.age));
    }
}
