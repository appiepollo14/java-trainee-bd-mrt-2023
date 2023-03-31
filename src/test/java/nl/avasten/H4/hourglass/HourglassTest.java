package nl.avasten.H4.hourglass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HourglassTest {

    private Hourglass hourglass;

    @BeforeEach
    public void init() {
        this.hourglass = new Hourglass();
    }

    @Test
    public void GivenAnEqualSizeIntGenerateAnHourglass() {
        try {
            hourglass.loopPrinting();
        } catch (EvenNumberException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void GivenASize9IntGenerateAnHourglass() {


    }

}