package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class ShopTest {
    private Shop shop;

    @Before
    public void setUp() {
        shop = new Shop();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelvesChangeOfUnmodifiedCollection() {
        shop.getShelves().remove("Shelves1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsIfNotContainsSuchShelf() throws OperationNotSupportedException {
        shop.addGoods("Shelves13", new Goods("Chocolate", "001"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsIfShelfIsNotNull() throws OperationNotSupportedException {
        shop.addGoods("Shelves2", new Goods("Chocolate", "001"));
        shop.addGoods("Shelves2", new Goods("Pasta", "002"));
    }

//    @Test(expected = OperationNotSupportedException.class)
//    public void testAddGoodsIfShelfAlreadyContainsGood() throws OperationNotSupportedException {
//        Goods chocolate = new Goods("Chocolate", "001");
//        shop.addGoods("Shelves2", chocolate);
//        shop.addGoods("Shelves2", new Goods("Pasta", "002"));
//    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsIfNotContainsSuchShelf() throws OperationNotSupportedException {
        shop.removeGoods("Shelves13", new Goods("Chocolate", "001"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsIfShelfIsNotNull() throws OperationNotSupportedException {
        shop.removeGoods("Shelves1", new Goods("Chocolate", "001"));
    }

    @Test
    public void testRemoveGoodsRemoveGood() throws OperationNotSupportedException {
        Goods chocolate = new Goods("Chocolate", "001");
        shop.addGoods("Shelves1", chocolate);
        shop.removeGoods("Shelves1", chocolate);
        Assert.assertNull(shop.getShelves().get("Shelves1"));
    }

    @Test
    public void testRemoveGoodsRemoveGoodAndReturn() throws OperationNotSupportedException {
        Goods chocolate = new Goods("Chocolate", "001");
        shop.addGoods("Shelves1", chocolate);
        String shelves1 = shop.removeGoods("Shelves1", chocolate);
        Assert.assertEquals("Goods: 001 is removed successfully!", shelves1);
    }
}
