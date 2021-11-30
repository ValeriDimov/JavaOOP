package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.List;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private static final String[] ELEMENTS = new String[]{"Peter", "John" ,"Terry"};
    private static final String[] EMPTY_ELEMENTS = new String[]{};
    ListIterator listIterator;

    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWhenThrowsException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void testConstructorWhenSuccessful() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(ELEMENTS);
    }

    @Test
    public void testPrintMethod() throws OperationNotSupportedException {
        String printString = listIterator.print();
        Assert.assertEquals(ELEMENTS[0], printString);
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintMethodThrowsException() throws OperationNotSupportedException {
        listIterator = new ListIterator(EMPTY_ELEMENTS);
        String printString = listIterator.print();
    }

//    @Test
//    public void testHasNextMethod() {
//        Assert.assertTrue(listIterator.hasNext());
//        listIterator.setCurrentIndex(3);
//        Assert.assertFalse(listIterator.hasNext());
//    }

    @Test
    public void testMoveMethod() {
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

}