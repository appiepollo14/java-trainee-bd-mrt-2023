package nl.avasten.H3;

import org.junit.jupiter.api.Test;

public class overflowTest {

    private int a = 0;

    //TODO find someone to explain this

    @Test
    public void givenAnIntWithAnOverflowErrror() {
        a = (int) (1234234 * 1232134124);
        System.out.println(a);
    }


}
