package aquarium.repositories;

import aquarium.entities.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DecorationRepository implements Repository {
    private Collection<Decoration> decorations;

    public DecorationRepository() {
        decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        Decoration decoration1 = this.decorations.stream()
                .filter(d -> d.equals(decoration))
                .findFirst()
                .orElse(null);

        return decoration1 != null;
    }

    @Override
    public Decoration findByType(String type) {
        Decoration decoration = null;
        switch (type) {
            case "Ornament":
                decoration = this.decorations.stream()
                        .filter(d -> d.getClass().getSimpleName().equals(type))
                        .findFirst().orElse(null);
                break;

            case "Plant":
                decoration = this.decorations.stream()
                        .filter(d -> d.getClass().getSimpleName().equals(type))
                        .findFirst().orElse(null);
                break;

        }
        return decoration;
    }
}
