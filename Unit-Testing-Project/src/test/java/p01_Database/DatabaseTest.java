package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Integer[] DATABASE_NUMBERS = {1, 2, 4, 6};
    private static final Integer[] TOO_LONG_DATABASE_NUMBERS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};

    private Database database;
    private Integer[] currentIntArr;

    @Before
    public void prepare() throws OperationNotSupportedException {
        this.database = new Database(DATABASE_NUMBERS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructorThrowExceptionDuringCreationWithLongLength() throws OperationNotSupportedException {
        database = new Database(TOO_LONG_DATABASE_NUMBERS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructorThrowExceptionWhenLengthIsNull() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test
    public void testDatabaseConstructorSuccessfulCreation() {
        currentIntArr = database.getElements();
        Assert.assertArrayEquals(DATABASE_NUMBERS, currentIntArr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodThrowsException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddMethodAddingElement() throws OperationNotSupportedException {
        Integer num = 8;
        database.add(num);
        currentIntArr = database.getElements();
        Assert.assertEquals(num, currentIntArr[4]);
    }

    @Test
    public void testRemoveMethod() throws OperationNotSupportedException {
        database.remove();
        currentIntArr = database.getElements();
        Assert.assertEquals(DATABASE_NUMBERS[DATABASE_NUMBERS.length - 2], currentIntArr[currentIntArr.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodThrowsException() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.remove();
        database.remove();

    }

}