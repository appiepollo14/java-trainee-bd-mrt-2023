package nl.avasten.H5.calculations.calculations;

import nl.avasten.H5.calculations.Calculations;
import nl.avasten.H6.AsjerArrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculationsTest {

    private Calculations calculations;

    @BeforeEach
    public void init() {
            this.calculations = new Calculations();
        }

    @Test
    void GivenTwoIntsCalculateGreatestInt() {
        int expected = 5;
        int actual = calculations.greatest(5, 3);
        assertEquals(expected, actual);
    }

    @Test
    void GivenTwoStringsCalculateGreatestIntValue() {
        String a = "12";
        String b = "25";
        int expected = 25;

        assertEquals(expected, calculations.greatest(a, b));

    }

    @Test
    void GivenTwoStringsWithTextCalculateGreatestIntValueThrowsError() {

        String a = "b";
        String b = "c";

        assertThrows(NumberFormatException.class, () -> {
            calculations.greatest(a, b);
        });
    }

    @Test
    void GivenAnArrayOfIntsCalculateGreatestInt() {

        ArrayList<Integer> listOfInts = new ArrayList<>();
        listOfInts.add(5);
        listOfInts.add(14);
        listOfInts.add(-4);
        listOfInts.add(2);

        int expected = 14;

        assertEquals(expected, calculations.greatest(listOfInts));
    }

    @Test
    public void GivenAnIntCalculateFactorialEquals() {
        int expected = 120;
        int actual = calculations.factorial(5);
        assertEquals(expected, actual);
    }

    @Test
    public void GivenAnArrayOfLongsAndAMultiplierAssertResultIsMultipliedCorrectly() {
        long[] originalArray = new long[4];
        originalArray[0] = 1;
        originalArray[1] = 2;
        originalArray[2] = 3;
        originalArray[3] = 4;

        int multiplier = 4;

        long[] expectedArray = new long[4];
        expectedArray[0] = 4;
        expectedArray[1] = 8;
        expectedArray[2] = 12;
        expectedArray[3] = 16;

        assertEquals(Arrays.toString(expectedArray), Arrays.toString(AsjerArrays.multiply(originalArray, multiplier)));
    }


}