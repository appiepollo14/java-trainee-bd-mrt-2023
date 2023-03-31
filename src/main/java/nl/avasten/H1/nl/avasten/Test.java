package nl.avasten.H1.nl.avasten;

public class Test {

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