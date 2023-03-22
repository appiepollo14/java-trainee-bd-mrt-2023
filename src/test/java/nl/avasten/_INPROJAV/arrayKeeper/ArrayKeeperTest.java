package nl.avasten._INPROJAV.arrayKeeper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

class ArrayKeeperTest {

    private ArrayKeeper arrayKeeper;

    @BeforeEach
    public void initEach() {
        System.out.println("Nieuwe test");
        this.arrayKeeper = new ArrayKeeper();
    }

    @Test
    void printAll() {
        this.arrayKeeper.printAll();
    }

    @Test
    void printHighestInList() {
        this.arrayKeeper.printHighestInList();
    }

    @Test
    void printLowestInList() {
        this.arrayKeeper.printLowestInList();
    }

    @Test
    void printAverageInList() {
        this.arrayKeeper.printAverageInList();
    }

    @Test
    void checkIfValuesAreInRange() {
        this.arrayKeeper.checkIfValuesAreInRange();
    }

    @Test
    public void checkRandomValues() {
        ArrayKeeper randomArray = new ArrayKeeper(new Random().nextInt(10, 100));

        randomArray.printAll();
    }


    @Test
    public void givenAnArrayOfStringPrintShortestName() {
        this.arrayKeeper.printShortestName();
    }

    @Test
    public void throwExceptionDivideByNull() {
        try {
            this.arrayKeeper.throwExceptionDivideByNull();
        } catch (NullPointerException e) {
            System.out.println(e);;
        }
    }

    @Test
    public void throwExceptionArrayOutOfBound() {
        try {
            this.arrayKeeper.throwExceptionArrayOutOfBound();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

    }

    // TODO Vragen waarom deze niet afdwingt dat je hem moet surrouden met try/catch
    @Test
    public void throwExceptionArrayOutOfBound2() {
        this.arrayKeeper.throwExceptionArrayOutOfBound();
    }
}