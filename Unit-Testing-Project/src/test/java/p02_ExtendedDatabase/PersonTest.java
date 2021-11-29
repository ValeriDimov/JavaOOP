package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    private static final int ID = 10001;
    private static final String NAME = "Peter";

    @Test
    public void testCreatingConstructorPerson() {
        Person person = new Person(ID, NAME);
        Assert.assertEquals(ID, person.getId());
        Assert.assertEquals(NAME, person.getUsername());

    }

}