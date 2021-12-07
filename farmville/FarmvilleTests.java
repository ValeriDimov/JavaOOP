package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {

    private Farm farm;
    private Animal animal = new Animal("cat", 100);


    @Before
    public void setUp() {
        farm = new Farm("Gradus", 25);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorSetNameThrowsException() {
        farm = new Farm(" ", 12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorSetCapacityThrowsException() {
        farm = new Farm("Asus", -11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalWhenFullCapacityThrowsException() {
        farm = new Farm("Asus", 0);
        farm.add(animal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalWhenAnimalTypeExistsThrowsException() {
        farm.add(animal);
        farm.add(new Animal("cat", 14));
    }

    @Test
    public void testAddAnimalAddingSuccessfully() {
        farm.add(animal);
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testRemoveAnimalRemovedSuccessfully() {
        farm.add(animal);
        farm.add(new Animal("dog", 150));
        boolean IsCatRemoved = farm.remove("cat");
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testRemoveAnimalBooleanReturnSuccessfully() {
        farm.add(animal);
        farm.add(new Animal("dog", 150));
        boolean IsCatRemoved = farm.remove("cat");
        Assert.assertTrue(IsCatRemoved);
    }

    @Test
    public void testGetNameOfTheFarm() {
        String farmName = farm.getName();
        Assert.assertEquals("Gradus", farmName);
    }
}

