package nl.avasten.H4.hourglass;

import java.util.Scanner;

public class Hourglass {

  public Hourglass() {}

  public void loopPrinting() throws EvenNumberException, IllegalArgumentException {

    int i = 1;
    int qtyOfErrors = 0;
    int qtyOfHourglassLines;

    while (i == 1) {

      if (qtyOfErrors == 3) {
        break;
      }

      Scanner scanner = new Scanner(System.in);
      System.out.println("Give a qty of Hourglass lines:");
      String inputString = scanner.nextLine();

      try {
        qtyOfHourglassLines = Integer.valueOf(inputString);
      } catch (NumberFormatException e) {
        qtyOfErrors++;
        throw new IllegalArgumentException("Input was not a number!");
      }

      if (qtyOfHourglassLines % 2 == 0) {
        throw new EvenNumberException("Even nummer mag niet!");
      }

      printHourglass(qtyOfHourglassLines);
    }
  }

  public String printSomething(Boolean star) {
    if (star) {
      return new String("*");
    } else {
      return new String(" ");
    }
  }

  public void printHourglass(int size) {

    String[] listOfStrings = new String[size];
    int qtyOfLines = listOfStrings.length;

    for (int i = 0; i <= qtyOfLines; i++) {
      StringBuilder line = new StringBuilder();
      if (i == 0 || i == qtyOfLines) {
        for (int x = 0; x < listOfStrings.length; x++) {
          line.append(printSomething(true));
        }
      } else {
        for (int x = 0; x < qtyOfLines; x++) {
          if (x == i || x == (qtyOfLines - 1 - i)) {
            line.append(printSomething(true));
          } else {
            line.append(printSomething(false));
          }
        }
      }

      System.out.println(line);
    }
  }
}
