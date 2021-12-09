package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ExplorerRepository implements Repository<Explorer> {
    private Collection<Explorer> explorers;

    public ExplorerRepository() {
        explorers = new ArrayList<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableCollection(explorers);
    }

    @Override
    public void add(Explorer entity) {
        explorers.add(entity);
    }

    @Override
    public boolean remove(Explorer entity) {
        boolean isRemoved = false;

            if (explorers.contains(entity)) {
                isRemoved = true;
                explorers.remove(entity);
            }

        return isRemoved;
    }

    @Override
    public Explorer byName(String name) {
        return explorers.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
}
