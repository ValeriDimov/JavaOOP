package aquarium.entities.aquariums;

public class SaltwaterAquarium extends BaseAquarium {
    private static final int CONSTANT_CAPACITY = 25;

    public SaltwaterAquarium(String name) {
        super(name, CONSTANT_CAPACITY);
    }
}
