package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    private Fish f1;
    private Fish f2;
    private Aquarium aquarium;

    @Before
    public void setUp() {
        aquarium = new Aquarium("BlueSea", 12);
        f1 = new Fish("name1");
        f2 = new Fish("name2");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsCapacityException() {
        aquarium = new Aquarium("DeepSea", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsNameException() {
        aquarium = new Aquarium("", 13);
    }

    @Test
    public void testConstructorImplementedSuccessfully() {
        aquarium = new Aquarium("BlackSea", 51);
        String name = aquarium.getName();
        int capacity = aquarium.getCapacity();

        Assert.assertEquals("BlackSea", name);
        Assert.assertEquals(51, capacity);
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test
    public void testGetCount() {
        aquarium.add(f1);
        aquarium.add(f2);

        Assert.assertEquals(2, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsExceptionDueToFullCapacity() {
        aquarium = new Aquarium("Sea", 2);
        aquarium.add(f1);
        aquarium.add(f2);

        Fish f3 = new Fish("name3");
        aquarium.add(f3);
    }

    @Test
    public void testAddMethodAddingFishSuccessfully() {
        aquarium.add(f1);
        aquarium.add(f2);

       Assert.assertEquals(2, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveThrowsExceptionDueToNoSuchFishName() {
        aquarium = new Aquarium("Sea", 2);
        aquarium.add(f1);
        aquarium.add(f2);

        aquarium.remove("Pesho");
    }

    @Test
    public void testRemoveSuccessfullyRemoveFishWithSuchFishName() {
        aquarium = new Aquarium("Sea", 2);
        aquarium.add(f1);
        aquarium.add(f2);

        aquarium.remove("name2");
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishThrowsExceptionDueToNoSuchFishName() {
        aquarium = new Aquarium("Sea", 2);
        aquarium.add(f1);
        aquarium.add(f2);

        aquarium.sellFish("Pesho");
    }

    @Test
    public void testSellFishSuccessfullySellFishWithSuchFishName() {
        aquarium = new Aquarium("Sea", 2);
        aquarium.add(f1);
        aquarium.add(f2);
        String fishName = f2.getName();

        Fish fish = aquarium.sellFish("name2");
        Assert.assertEquals(fishName, fish.getName());
    }

    @Test
    public void testSellFishIsNotAvailableWithSuchFishName() {
        aquarium = new Aquarium("Sea", 2);
        aquarium.add(f1);
        aquarium.add(f2);

        Fish sellFish = aquarium.sellFish("name2");

        Assert.assertFalse(sellFish.isAvailable());
    }

    @Test
    public void testReportFishIsInTheAquarium() {
        aquarium = new Aquarium("Sea", 2);
        aquarium.add(f1);
        aquarium.add(f2);
        String fishName = f2.getName();

        String actualMessage = "Fish available at Sea: name1, name2";
        String report = aquarium.report();
        Assert.assertEquals(actualMessage, report);
    }
}

