package restaurant.repositories;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.*;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {
    private List<HealthyFood> foodList;


    public HealthFoodRepositoryImpl() {
        foodList = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        for (HealthyFood healthyFood : foodList) {
            if (healthyFood.getName().equals(name)) {
                return healthyFood;
            }
        }

        return null;
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return foodList;
    }

    @Override
    public void add(HealthyFood entity) {
        foodList.add(entity);
    }
}
