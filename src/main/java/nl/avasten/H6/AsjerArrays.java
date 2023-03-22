package nl.avasten.H6;

import java.util.*;

public class  AsjerArrays {

    public AsjerArrays() {
        System.out.println("Created");
    }

    public static void _61() {

        long[] row = new long[4];
        row[2] = 3;
        long[] copy = row;
        copy[2]++;
        System.out.println(row[2]);
        System.out.println("Nummer 4: " + row[4]);
    }

    public static void copy_array_and_doubleLength() {
        long[] original = new long[4];
        original[0] = 1;
        original[1] = 2;
        original[2] = 3;
        original[3] = 4;

        int i = original.length * 2;

        long[] longerCopy = Arrays.copyOf(original, i);

        System.out.println(Arrays.toString(longerCopy));
    }

    public static long[] multiply(long[] input, int multiplier) {
        long[] returnArray = new long[input.length];
        for (int i = 0; i < input.length; i++) {
            returnArray[i] = input[i] * multiplier;
        }

        return returnArray;
    }

    public static void sumOfArrayFilledFromConsole() {

        long[] inputArray = new long[10];
        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < inputArray.length; i++) {

            int input = 0;

            boolean correctInput = false;
            while (!correctInput) {
                try {
                    System.out.println("Geef een nummer:");
                    input = scanner.nextInt();
                    correctInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Verkeerde input!");
                    scanner.next();
                }
            }

            inputArray[i] = input;
            sum += input;
        }

        StringBuilder result = new StringBuilder();
        result.append("Som van invoer: ");
        result.append(sum);
        System.out.println(result.toString());
    }

    public static void sudokuArray() {

        ArrayList<Integer> choices = new ArrayList<>();
        choices.add(1);
        choices.add(2);
        choices.add(3);
        choices.add(4);
        choices.add(5);
        choices.add(6);
        choices.add(7);
        choices.add(8);
        choices.add(9);

        int[][] sudokuArray = new int[3][3];

        Random random = new Random();

        for (int i = 0; i < sudokuArray.length; i++) {
            for (int y = 0; y < sudokuArray[i].length; y++) {
                int randomIndex = random.nextInt(choices.size());
                sudokuArray[i][y] = choices.get(randomIndex);
                choices.remove(randomIndex);
            }
        }

        System.out.println(Arrays.deepToString(sudokuArray));


    }


}
