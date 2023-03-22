package nl.avasten._INPROJAV.arrayKeeper;

import java.math.BigDecimal;
import java.util.Random;

public class ArrayKeeper {

    private int[] lijstje;
    private String[] listOfNames;

    public ArrayKeeper() {
        this.lijstje = new int[5];
        lijstje[0] = 23;
        lijstje[1] = 99;
        lijstje[2] = 12;
        lijstje[3] = 57;
        lijstje[4] = 86;

        this.listOfNames = new String[11];
        listOfNames[0] = "Bram";
        listOfNames[1] = "Daniel";
        listOfNames[2] = "Leon";
        listOfNames[3] = "Corné";
        listOfNames[4] = "Derk";
        listOfNames[5] = "Tim";
        listOfNames[6] = "Luca";
        listOfNames[7] = "Asjer";
        listOfNames[8] = "Juul";
        listOfNames[9] = "Stan";
        listOfNames[10] = "Sander";

    }

    public ArrayKeeper(int listSize) {
        this.lijstje = new int[listSize];

        for (int i = 0; i < this.lijstje.length; i++) {
            this.lijstje[i] = new Random().nextInt(10, 100);
        }

        //int cijfer = new Random().nextInt(10, 100);

    }

    public void printAll() {
        for (int i = 0; i < this.lijstje.length; i++) {
            System.out.println(lijstje[i]);
        }
    }

    public void printHighestInList() {
        int highestNum = 0;

        for (int i = 0; i < this.lijstje.length; i++) {
            if (lijstje[i] > highestNum) {
                highestNum = lijstje[i];
            }
        }

        System.out.println(highestNum);
    }

    public void printLowestInList() {
        int lowestNum = this.lijstje[1];

        for (int i = 0; i < this.lijstje.length; i++) {
            if (lijstje[i] < lowestNum) {
                lowestNum = lijstje[i];
            }
        }

        System.out.println(lowestNum);
    }

    public void printAverageInList() {
        int sumOfList = 0;

        for (int i = 0; i < this.lijstje.length; i++) {
            sumOfList += this.lijstje[i];
        }

        double averageOfList = sumOfList / (double) this.lijstje.length;

        System.out.println(averageOfList);
    }

    public void checkIfValuesAreInRange() {

        for (int i = 0; i < this.lijstje.length; i++) {
            if (this.lijstje[i] < 10 || this.lijstje[i] > 100) {
                System.out.println("Waarde: " + this.lijstje[i] + " met index: " + i + " ligt buiten de opgegeven range!");
            }
        }
    }

    public String findShortestName(String[] listOfNames) {

        String shortestName = listOfNames[0];

        for (int i = 0; i < listOfNames.length; i++) {
            if (listOfNames[i].length() < shortestName.length()) {
                shortestName = listOfNames[i];
            }
        }

        return shortestName;
    }

    public void printShortestName() {
        System.out.println(findShortestName(this.listOfNames));
    }

    public void throwExceptionDivideByNull() throws NullPointerException {
        BigDecimal bd1 = new BigDecimal("1");
        BigDecimal bd2 = null;

        System.out.println(bd1.divide(bd2));

    }

    public void throwExceptionArrayOutOfBound() throws ArrayIndexOutOfBoundsException {
        System.out.println(this.lijstje[6]);
    }

}
