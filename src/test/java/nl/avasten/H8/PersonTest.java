package nl.avasten.H8;

import nl.avasten.H7.person.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

    private Person personA;
    private Person personB;
    private Person personC;
    private Person personD;

    @BeforeEach
    public void init() {
        personA = new Person("Jan", 45, Gender.MALE);
        personB = new Person("Jan", 45, Gender.MALE);
        personC = new Person("Jan", 45, Gender.FEMALE);
        personD = null;
    }

    @Test
    void testToString() {
        String expected = "Jan (45) is MALE";
        Assertions.assertEquals(expected, personA.toString());
    }

    @Test
    void testHashCode() {
        int expected = -997799029;
        Assertions.assertEquals(expected, personB.hashCode());
    }

    @Test
    void testEquals1() {
        boolean vergelijk = personA.equals(personB);
        Assertions.assertTrue(vergelijk);
    }

    @Test
    public void testEquals2() {
        boolean vergelijk = personA.equals(personC);
        Assertions.assertFalse(vergelijk);
    }

    @Test
    void testEquals3() {
        boolean vergelijk = personA.equals(personD);

        Assertions.assertFalse(vergelijk);
    }
}