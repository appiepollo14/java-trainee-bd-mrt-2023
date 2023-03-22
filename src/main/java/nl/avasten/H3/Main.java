package nl.avasten.H3;

import nl.avasten.H3.client.Client;
import nl.avasten.H3.loops.Loops;
import nl.avasten.H3.trainee.Trainee;
import nl.avasten.H3.weekDays.WeekDays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println(WeekDays.MONDAY);

        Trainee asjer = new Trainee();
        asjer.setFirstName("Asjer");
        asjer.setLastName("van Asten");

        StringBuilder fullName = new StringBuilder();
        fullName.append(asjer.getFirstName());
        fullName.append(" ");
        fullName.append(asjer.getLastName());

        System.out.println(fullName.toString());

        Client client1 = new Client("Jan");
        Client client2 = new Client("Piet");
        client2 = client1;
        client2.name = "Joris";

        System.out.println("Naaam na truuc: " + client1.name);

        Loops loops = new Loops();
        System.out.println("For loop i++:");
        loops.forLoopWithIPlusPlus();

        System.out.println("For loop ++i:");
        loops.forLoopWithPlusPlusI();

    }
}