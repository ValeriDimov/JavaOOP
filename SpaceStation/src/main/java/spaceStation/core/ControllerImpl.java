package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.bags.Bag;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int exploredPlanetsCount;

    public ControllerImpl() {
        astronautRepository = new AstronautRepository();
        planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;

        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;

            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;

            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        for (String item : items) {
            planet.getItems().add(item);
        }

        planetRepository.add(planet);

        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut currentAstronaut = astronautRepository.findByName(astronautName);

        if (currentAstronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        astronautRepository.remove(currentAstronaut);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Mission mission = new MissionImpl();

        List<Astronaut> topAstronauts = astronautRepository.getModels().stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());

        if (topAstronauts.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        mission.explore(planetRepository.findByName(planetName), topAstronauts);

        List<Astronaut> deadAstronautsList = topAstronauts
                .stream()
                .filter(a -> a.getOxygen() == 0)
                .collect(Collectors.toList());

        exploredPlanetsCount++;
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronautsList.size());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d planets were explored!", exploredPlanetsCount))
                .append(System.lineSeparator());
        sb.append("Astronauts info:").append(System.lineSeparator());

        Collection<Astronaut> astronauts = astronautRepository.getModels();
        for (Astronaut a : astronauts) {
            sb.append(String.format("Name: %s", a.getName())).append(System.lineSeparator());
            sb.append(String.format("Oxygen: %.0f", a.getOxygen())).append(System.lineSeparator());

            Collection<String> items = a.getBag().getItems();

            if (items.isEmpty()) {
            sb.append("Bag items: none").append(System.lineSeparator());
            } else {
                sb.append("Bag items: ").append(String.join(", ", items)).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
