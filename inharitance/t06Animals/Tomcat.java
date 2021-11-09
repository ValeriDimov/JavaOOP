package inharitance.t06Animals;

public class Tomcat extends Cat {
    private final static String GENDER_TYPE = "Male";

    public Tomcat(String name, int age, String gender) {
        super(name, age, GENDER_TYPE);
    }

    public Tomcat(String name, int age) {
        super(name, age, GENDER_TYPE);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
