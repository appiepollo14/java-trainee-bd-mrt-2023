package nl.avasten.H3;

import org.junit.jupiter.api.Test;

public class timeCalculatorTest {

    private int currentHour = 23;

    @Test
    public void givenTheCurrentHourAdd80HoursTestNewTime() {
        int toBeAddedDays = 93 / 24;
        System.out.println("Added days: " + toBeAddedDays);

        // TODO kan dit ook in één berekening?
        currentHour += (80 % 24);
        currentHour = (currentHour % 24);
        System.out.println(currentHour);
    }


}
