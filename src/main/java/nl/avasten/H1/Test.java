package com.nl.avasten;

public class Test {

    /**
     * Prints Hello plus any argument passed into the function
     * if none, than prints Hello World
     * @param Array of strings to be printed after Hello
     * @return nothing
     */

    public static void main(String[] argumentjes) {
        if (argumentjes.length > 0) {

            String boodschap = "Hello ";

            for (int i = 0; i < argumentjes.length; i++) {
                boodschap = boodschap + argumentjes[i] + " ";
            }
            System.out.println(boodschap);
        } else {
            System.out.println("Hello World");
        }
    }

}