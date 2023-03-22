package nl.avasten.H3;

import org.junit.jupiter.api.Test;

public class calculateJTest {

    private int i = 3;

    // Ternary
    int j = i < 3 ? i++ + ++i : ++i >>> 1;

    @Test
    public void givenAnIntWithAnOverflowErrror() {
        System.out.println(j);;
    }

}
