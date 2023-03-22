package nl.avasten.H4;

import nl.avasten.H4.hourglass.EvenNumberException;
import nl.avasten.H4.hourglass.Hourglass;

import java.util.Scanner;

public class Main {

    public static void printTable(int multiplicationOff) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " x " + multiplicationOff + " = " + (multiplicationOff * i));
        }
    }

    public static void main(String[] args) {

        // TODO how to unit test this?
        for (int i = 1; i <= 10; i++) {
            printTable(i);
        }

        int[] bankNum = new int[9];


        Scanner scanner = new Scanner(System.in);
        System.out.println("Give a banknumber:");
        String bankNumString = scanner.nextLine();
        try {
            for  (int i = 0; i < bankNumString.length(); i++) {
                bankNum[i] = Character.getNumericValue(bankNumString.charAt(i));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input was not a number!");
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Input too long");
        }

        int elevenProofSum = 0;
        int elevenProofMultiplier = 9;

        for (int i = 0; i < bankNum.length; i++) {
            elevenProofSum += (bankNum[i] * elevenProofMultiplier);
            elevenProofMultiplier--;
        }

        if (elevenProofSum % 11 == 0) {
            System.out.println("Banknumber is valid!");
        } else {
            throw new IllegalArgumentException("Not a valid banknumber");
        }

        Hourglass hourglass = new Hourglass();

        try {
            hourglass.loopPrinting();
        } catch (EvenNumberException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}