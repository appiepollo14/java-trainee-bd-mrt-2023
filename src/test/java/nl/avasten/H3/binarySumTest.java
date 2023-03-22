package nl.avasten.H3;

import org.junit.jupiter.api.Test;

public class binarySumTest {

    @Test
    public void givenAnIntWithAnOverflowErrror() {
        int sum = 0b1010 + 0b100;
        System.out.println(sum);
    }


}
