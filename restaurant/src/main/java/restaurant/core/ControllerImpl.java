package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.BaseBeverage;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Food;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.BaseTable;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import java.util.Collection;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private final HealthFoodRepository<HealthyFood> healthFoodRepository;
    private final BeverageRepository<Beverages> beverageRepository;
    private final TableRepository<Table> tableRepository;
    private double totalBill;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food = null;
        if (type.equals("Salad")) {
            food = new Salad(name, price);
        } else if (type.equals("VeganBiscuits")) {
            food = new VeganBiscuits(name, price);
        }

        HealthyFood currentlyAddedFood = this.healthFoodRepository.foodByName(name);
        if (currentlyAddedFood == null) {
            healthFoodRepository.add(food);
            return String.format(FOOD_ADDED, name);
        }

        throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        BaseBeverage drink = null;
        if (type.equals("Fresh")) {
            drink = new Fresh(name, counter, brand);
        } else if (type.equals("Smoothie")) {
            drink = new Smoothie(name, counter, brand);
        }

        Beverages currentBeverage = this.beverageRepository.beverageByName(name, brand);
        if (currentBeverage == null) {
            beverageRepository.add(drink);
            return String.format(BEVERAGE_ADDED, type, brand);
        }

        throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
    }


    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        BaseTable table = null;
        if (type.equals("Indoors")) {
            table = new Indoors(tableNumber, capacity);
        } else if (type.equals("InGarden")) {
            table = new InGarden(tableNumber, capacity);
        }

        Table currentTable = this.tableRepository.byNumber(tableNumber);

        if (currentTable == null) {
            tableRepository.add(table);
            return String.format(TABLE_ADDED, tableNumber);
        }

        throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
    }

    @Override
    public String reserve(int numberOfPeople) {
        Collection<Table> allTables = tableRepository.getAllEntities();
        for (Table table : allTables) {
            if (!table.isReservedTable() && table.getSize() >= numberOfPeople) {
                return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
            }
        }

        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);
        HealthyFood healthyFood = healthFoodRepository.foodByName(healthyFoodName);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (healthyFood == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }

        table.orderHealthy(healthyFood);

        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);
        Beverages beverage = beverageRepository.beverageByName(name, brand);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (beverage == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }

        table.orderBeverages(beverage);

        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);
        double bill = table.bill();
        table.clear();
        
        totalBill += bill;

        return String.format(BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {

        return String.format(TOTAL_MONEY, totalBill);
    }
}
