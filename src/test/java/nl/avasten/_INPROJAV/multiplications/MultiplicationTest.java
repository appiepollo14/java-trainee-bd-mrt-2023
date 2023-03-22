package nl.avasten._INPROJAV.multiplications;

import org.junit.jupiter.api.Test;

class MultiplicationTest {


    @Test
    void calculateMultiplicationsUsingWhile() {
        Multiplication multiplication = new Multiplication(7);
        multiplication.calculateMultiplicationsUsingWhile();
    }


    @Test
    void givenTheMultiplicationOff7WhenRunningTableThen() {
        Multiplication multiplication = new Multiplication(7);
        multiplication.calculateMultiplicationsUsingFor();
    }

    @Test
    void givenTheMultiplicationOff8WhenPrintingCalculationsThenRun() {
        Multiplication multiplication = new Multiplication(8);
        multiplication.calculateMultiplicationsUsingFor();
    }

    @Test
    void givenTheMultiplicationOff8WhenPrintingWithSeparateFunctionsThenRun() {
        Multiplication multiplication = new Multiplication(8);
        multiplication.printStart();
        multiplication.calculateMultiplicationsUsingFor();
        multiplication.printKlaar();
    }

    @Test
    void givenTheMultiplicationOff8WhenPrintingWithAGenericPrintFunctionThenRun() {
        Multiplication multiplication = new Multiplication(8);
        multiplication.print("Start");
        multiplication.calculateMultiplicationsUsingFor();
        multiplication.print("Klaar");
    }

    @Test
    void givenTheMultiplicationOff8WhenPrintingWithAGenericPrintFunctionAndExclamationMarkBooleanThenRun() {
        Multiplication multiplication = new Multiplication(8);
        multiplication.print("Start", false);
        multiplication.calculateMultiplicationsUsingFor();
        multiplication.print("Klaar", true);
    }

    @Test
    void givenTheMultiplicationOff1To10WhenPrintingThenRun() {
        for (int i = 1; i <= 10; i++) {
            Multiplication multiplication = new Multiplication(i);
            multiplication.calculateMultiplicationsUsingFor();
        }
    }
}