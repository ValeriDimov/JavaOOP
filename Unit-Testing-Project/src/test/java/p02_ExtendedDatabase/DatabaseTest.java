package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Person PERSON1 = new Person(10001, "Peter");
    private static final Person PERSON2 = new Person(10002, "Martin");
    private static final Person PERSON3 = new Person(10003, "George");
    private Person[] people = new Person[2];

    private Database database;

    @Before
    public void prepare() throws OperationNotSupportedException {
        people[0] = PERSON1;
        people[1] = PERSON2;
        database = new Database(PERSON1, PERSON2);

    }

    @Test
    public void testCreatingConstructorDatabase() throws OperationNotSupportedException {
        database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorDatabaseThrowingExceptionWithNullElements() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorDatabaseThrowingExceptionWithMoreElements() throws OperationNotSupportedException {
        people = new Person[17];
        database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodThrowException() throws OperationNotSupportedException {
        Person person = null;
        database.add(person);
    }

    @Test
    public void testAddMethodAddingPeopleAndGetElementsMethod() throws OperationNotSupportedException {
        people = new Person[]{PERSON1, PERSON2, PERSON3};
        database.add(PERSON3);
        Person[] elements = database.getElements();
        Assert.assertEquals(3, elements.length);
        Assert.assertArrayEquals(people, elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodThrowException() throws OperationNotSupportedException {
        database = new Database();
        database.remove();
    }

    @Test
    public void testRemoveMethodRemoveElement() throws OperationNotSupportedException {
        database.remove();
        Person[] elements = database.getElements();
        Assert.assertEquals(1, elements.length);

        Assert.assertEquals(PERSON1, elements[elements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodThrowExceptionWhenOFB() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByNameMethodThrowsExceptionWithNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByNameMethodThrowsExceptionWithNonExistingName() throws OperationNotSupportedException {
        database.findByUsername("Steve");
    }

    @Test
    public void testFindByNameMethodFindName() throws OperationNotSupportedException {
        String nameToFind = "Martin";
        Person byUsername = database.findByUsername(nameToFind);

        Assert.assertEquals(nameToFind, byUsername.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdMethodThrowsExceptionWithNonExistingId() throws OperationNotSupportedException {
        database.findById(100031);
    }

    @Test
    public void testFindByIdMethodFindById() throws OperationNotSupportedException {
        Person byId = database.findById(10002);

        Assert.assertEquals(PERSON2.getId(), byId.getId());
    }

}