package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        houses = new ArrayList<>();
        toys = new ToyRepository();
    }

    @Override
    public String addHouse(String type, String name) {
        House house = null;

        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;

            case "LongHouse":
                house = new LongHouse(name);
                break;

            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }

        houses.add(house);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy = null;

        switch (type) {
            case "Ball":
                toy = new Ball();
                break;

            case "Mouse":
                toy = new Mouse();
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }

        this.toys.buyToy(toy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy currentToy = toys.findFirst(toyType);

        if (currentToy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }

        toys.removeToy(currentToy);

        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                house.buyToy(currentToy);
            }
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat = null;
        String message = "";

        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;

            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }

        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                if ((house.getClass().getSimpleName().startsWith("Short") && catType.startsWith("Short"))
                        || (house.getClass().getSimpleName().startsWith("Long") && catType.startsWith("Long"))) {
                    house.addCat(cat);
                    message = String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
                } else {
                    message = ConstantMessages.UNSUITABLE_HOUSE;
                }
            }
        }

        return message;
    }

    @Override
    public String feedingCat(String houseName) {
        int fedCount = 0;

        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                fedCount = house.getCats().size();
                house.feeding();
            }

        }

        return String.format(ConstantMessages.FEEDING_CAT, fedCount);
    }

    @Override
    public String sumOfAll(String houseName) {
        double totalSumToys = 0;
        double totalSumCats = 0;

        for (House house : houses) {
            if (house.getName().equals(houseName)) {
                totalSumToys = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
                totalSumCats = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
            }
        }

        return String.format(ConstantMessages.VALUE_HOUSE, houseName, totalSumToys + totalSumCats);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (House house : houses) {
            sb.append(house.getStatistics());
        }

        return sb.toString();
    }

}
