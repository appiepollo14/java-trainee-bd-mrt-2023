package nl.avasten._INPROJAV.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    private Strings string;

    @BeforeEach
    void init() {
        this.string = new Strings();
    }

    @Test
    void concat() {
        string.concat();
    }

    @Test
    void contains() {
        string.contains();
    }

    @Test
    void endsWith() {
        string.endsWith();
    }

    @Test
    void testEquals() {
        string.equals();
    }

    @Test
    void equalsIgnoreCase() {
        string.equalsIgnoreCase();
    }
}