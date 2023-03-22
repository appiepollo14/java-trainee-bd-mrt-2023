package nl.avasten.H5.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FiboTest {

    private Fibo fibo;

    @BeforeEach
    public void init() {
        this.fibo = new Fibo();
    }

    @Test
    void givenIEquals0WhenFiboIsAskedThenResultIsAnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> fibo.run(0));
    }

    @Test
    void givenIEquals1WhenFiboIsAskedThenResultIs1() {
        long expected = 0;
        long actual = fibo.run(1);
        assertEquals(expected, actual);
    }

    @Test
    void givenIEquals2WhenFiboIsAskedThenResultIs2() {
        long expected = 1;
        long actual = fibo.run(2);
        assertEquals(expected, actual);
    }

    @Test
    void givenIEquals6WhenFiboIsAskedThenResultIs5() {
        long expected = 5;
        long actual = fibo.run(6);
        assertEquals(expected, actual);
    }
}