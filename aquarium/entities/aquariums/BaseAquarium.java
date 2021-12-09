package aquarium.entities.aquariums;

import aquarium.common.ExceptionMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.capacity <= fish.getSize()) {
            throw new IllegalStateException("Not enough capacity.");
        }

        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish f : fish) {
            f.eat();
        }
    }

    @Override
    public String getInfo() {
//        String allFish = fish.stream().map(Fish::getName).collect(Collectors.joining(", "));
        List<String> fishNames = fish.stream().map(Fish::getName).collect(Collectors.toList());
        String allFish = String.join(", ", fishNames);

        if (fish.isEmpty()) {
            return String.format("%s (%s):%n" +
                    "Fish: none%n" +
                    "Decorations: %d%n" +
                    "Comfort: %d%n", this.name, this.getClass()
                    .getSimpleName(), this.decorations.size(), this.calculateComfort());

        } else {
            return String.format("%s (%s):%n" +
                    "Fish: %s%n" +
                    "Decorations: %d%n" +
                    "Comfort: %d%n", this.name, this.getClass().getSimpleName(), allFish,
                    this.decorations.size(), this.calculateComfort());
        }
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
