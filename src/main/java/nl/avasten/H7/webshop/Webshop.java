package nl.avasten.H7.webshop;

import java.util.Scanner;

public class Webshop {

    private CatalogueManager catalogueManager;
    private String webshopName;

    public Webshop(String webshopName) {
        this.webshopName = webshopName;
        this.catalogueManager = new CatalogueManager();
    }

//
//    private Order order = new Order();
//
//    for(Item i : order) {
//        i.get
//    }

    public void browse() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input year to browse catalogue:");
        int year = scanner.nextInt();

        Catalogue catalogue = null;

        try {
            catalogue = this.catalogueManager.getCatalogueForYear(year);
        } catch (IllegalArgumentException e) {
            catalogue = new Catalogue(year);
            this.catalogueManager.addCatalogue(catalogue);
        }

        if (catalogue.getItems().size() == 0) {
            System.out.print("Geen artikelen in jaar: " + year);
        } else {
            System.out.println(catalogue.toString());
        }
    }


    public void order(int articleNumber) {
        System.out.println("Order " + articleNumber);
    }

    public String getWebshopName() {
        return this.webshopName;
    }

}
