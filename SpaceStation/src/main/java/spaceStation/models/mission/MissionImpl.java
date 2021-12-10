package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;

import java.util.Collection;

public class MissionImpl implements Mission {
    private Bag bag;

    public MissionImpl() {
        bag = new Backpack();
    }

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        Collection<String> planetItems = planet.getItems();

        for (Astronaut astronaut : astronauts) {

            while (astronaut.canBreath() && planetItems.iterator().hasNext()) {
                String currentPlanetItem = planetItems.iterator().next();
                astronaut.getBag().getItems().add(currentPlanetItem);
                astronaut.breath();
                planet.getItems().remove(currentPlanetItem);
            }
        }
    }
}
