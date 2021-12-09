package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private static final double INITIAL_UNITS_OF_ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, INITIAL_UNITS_OF_ENERGY);
    }

    @Override
    public void search() {
        double currentEnergy = getEnergy();
        if (currentEnergy < 7) {
            setEnergy(0);
        } else {
            setEnergy(currentEnergy - 7);
        }
    }
}
