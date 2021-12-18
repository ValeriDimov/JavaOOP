package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private Cat cat;
    private House house;

    @Before
    public void setUp() {
        house = new House("Bundy", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHouseWithExceptionEmptyName() {
        house = new House(" ", 12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHouseWithExceptionNegativeCapacity() {
        house = new House("Valeri", -3);
    }

    @Test
    public void testGetNameMethodAndCreateHouseSuccessfully() {
        house = new House("Valeri", 15);
        String houseName = house.getName();

        Assert.assertEquals("Valeri", houseName);
    }

    @Test
    public void testGetCapacityMethodAndCreateHouseSuccessfully() {
        house = new House("Valeri", 15);
        int houseCapacity = house.getCapacity();

        Assert.assertEquals(15, houseCapacity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatWithExceptionAboveCapacity() {
        house = new House("Valeri", 2);
        cat = new Cat("Pesho");
        Cat cat2 = new Cat("Sasho");
        Cat cat3 = new Cat("Pepi");

        house.addCat(cat);
        house.addCat(cat2);
        house.addCat(cat3);
    }

    @Test
    public void testAddCatSuccessfully() {
        cat = new Cat("Pesho");
        Cat cat2 = new Cat("Sasho");
        Cat cat3 = new Cat("Pepi");

        house.addCat(cat);
        house.addCat(cat2);
        house.addCat(cat3);

        int count = house.getCount();

        Assert.assertEquals(3, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatWithExceptionNoSuchCatName() {
        house = new House("Valeri", 2);
        cat = new Cat("Pesho");
        Cat cat2 = new Cat("Sasho");

        house.removeCat("Gosho");
    }

    @Test
    public void testRemoveCatSuccessfully() {
        house = new House("Valeri", 4);
        cat = new Cat("Pesho");
        Cat cat2 = new Cat("Sasho");
        Cat cat3 = new Cat("Pepi");

        house.addCat(cat);
        house.addCat(cat2);
        house.addCat(cat3);

        house.removeCat("Pepi");
        int count = house.getCount();

        Assert.assertEquals(2, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleWithExceptionNoSuchCatName() {
        house = new House("Valeri", 2);
        cat = new Cat("Pesho");
        Cat cat2 = new Cat("Sasho");

        house.catForSale("Gosho");
    }

    @Test
    public void testCatForSaleSuccessfully() {
        house = new House("Valeri", 4);
        cat = new Cat("Pesho");
        Cat cat2 = new Cat("Sasho");
        Cat cat3 = new Cat("Pepi");

        house.addCat(cat);
        house.addCat(cat2);
        house.addCat(cat3);

        Cat catForSale = house.catForSale("Pepi");

        Assert.assertEquals(cat3.getName(), catForSale.getName());
        Assert.assertFalse(catForSale.isHungry());
    }

    @Test
    public void testStatisticsMethodRunSuccessfully() {
        house = new House("Valeri", 4);
        cat = new Cat("Pesho");
        Cat cat2 = new Cat("Sasho");

        house.addCat(cat);
        house.addCat(cat2);

        String expectedMessage = "The cat Pesho, Sasho is in the house Valeri!";
        String statistics = house.statistics();

        Assert.assertEquals(expectedMessage, statistics);
    }

}
