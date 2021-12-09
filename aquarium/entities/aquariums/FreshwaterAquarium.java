package aquarium.entities.aquariums;

public class FreshwaterAquarium extends BaseAquarium{
    private static final int CONSTANT_CAPACITY = 50;

    public FreshwaterAquarium(String name) {
        super(name, CONSTANT_CAPACITY);
    }
}
