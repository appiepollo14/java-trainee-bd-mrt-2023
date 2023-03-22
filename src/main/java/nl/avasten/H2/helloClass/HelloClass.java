package nl.avasten.H2.helloClass;

import java.util.Scanner;
import static java.lang.Math.abs;

public class HelloClass {
    public static void main(String[] args) {
        StringBuilder message = new StringBuilder("Hello World ");
        if (args.length > 0) {
            message.append(args[0]);
        }
        System.out.println(message.toString());

        Scanner in = new Scanner(System.in);
        System.out.println("Enter username");
        String userName = in.nextLine();
        System.out.println("Username is: " + userName);

        int plusTwo = abs(-2);

        System.out.println(plusTwo);
    }
}