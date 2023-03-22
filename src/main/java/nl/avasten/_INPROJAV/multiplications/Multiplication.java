package nl.avasten._INPROJAV.multiplications;

public class Multiplication {

    private int multiplicationOff;

    public Multiplication(int multiplicationOff) {
        this.multiplicationOff = multiplicationOff;
    }

    public int multiply(int base, int multiplyBy) {
        return base * multiplyBy;
    }

    public void calculateMultiplicationsUsingWhile() {
        int i = 1;
        while (i <= 10) {
            System.out.println(i + " * " + this.multiplicationOff + " = " + this.multiply(this.multiplicationOff, i));
            i++;
        }
    }

    public void calculateMultiplicationsUsingFor() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " * " + this.multiplicationOff + " = " + this.multiply(this.multiplicationOff, i));
        }
    }

    public void printStart() {
        System.out.println("Print start");
    }

    public void printKlaar() {
        System.out.println("Klaar!");
    }

    public void print() {
        System.out.println("***************");
    }

    public void print(String message) {
        System.out.println(message + "!");
    }

    public void print(String message, boolean exclamationMark) {
        if (exclamationMark) {
            System.out.println(message + "!");
        } else {
            System.out.println(message);
        }
    }
}
