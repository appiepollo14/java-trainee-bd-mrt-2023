package nl.avasten.H9;

import nl.avasten.H9.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    private Person target;

    @BeforeEach
    public void init() {
        this.target = new Person();
    }


    @Test
    public void givenAPersonWhenCallingSleepThenCountDelay() {
        System.out.println("Started: " + System.currentTimeMillis());
        long expectedTime = 10000;
        long startTime = System.currentTimeMillis();
        try {
            target.delay();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        long actualTime = endTime - startTime;
        System.out.println(actualTime);
        assertTrue(actualTime > expectedTime);
    }

    @Test
    public void givenAPersonWhenIsFinalizedCalled() {
        target = null;
        System.gc();
    }

}
