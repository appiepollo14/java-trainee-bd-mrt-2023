package nl.avasten.H5.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

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
        int expected = 0;
        int actual = fibo.run(1);
        assertEquals(expected, actual);
    }

    @Test
    void givenIEquals2WhenFiboIsAskedThenResultIs2() {
        int expected = 1;
        int actual = fibo.run(2);
        assertEquals(expected, actual);
    }

    @Test
    void givenIEquals6WhenFiboIsAskedThenResultIs5() {
        int expected = 5;
        int actual = fibo.run(6);
        assertEquals(expected, actual);
    }

    @Test
    void givenIEquals6StartEquals4WhenFiboIsAskedThenResultIs5() {
        int expected = 32;
        int actual = fibo.run(4, 6);
        assertEquals(expected, actual);
    }

    @Test
    void givenIEquals6F1Equals4F2Equals5WhenFiboIsAskedThenResultIs5() {
        int expected = 37;
        int actual = fibo.run(4, 5, 6);
        assertEquals(expected, actual);
    }

    @Test
    void givenIEquals10WhenGoldenRatioIsCalculatedThenResultIsSmall() {
        fibo.goldenRatio(10);
    }

    @Test
    void givenIEquals46WhenGoldenRatioIsCalculatedThenResultIsSmall() {
        fibo.goldenRatio(46);
    }

    @Test
    void givenIEquals100WhenGoldenRatioIsCalculatedThenResultIsSmall() {
        fibo.goldenRatio(100);
    }

    @Test
    void givenIEquals100WhenGoldenRatioIsCalculatedUsingLongsThenResultIsSmall() {
        for (int i = 4; i < 1000000; i++) {
            assertTrue(fibo.goldenRatio2(i).compareTo(BigDecimal.ZERO) > 0, "Kapot bij: " + i);
        }
    }
}