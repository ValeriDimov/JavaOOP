package inharitance.t06Animals;

public class Kitten extends Cat {
    private final static String GENDER_TYPE = "Female";


    public Kitten(String name, int age, String gender) {
        super(name, age, GENDER_TYPE);
    }

    public Kitten(String name, int age) {
        super(name, age, GENDER_TYPE);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
