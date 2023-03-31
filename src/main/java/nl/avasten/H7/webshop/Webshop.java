package nl.avasten.H7.webshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Webshop {

  private final CatalogueManager catalogueManager;
  private final OrderManager orderManager;
  private final String webshopName;

  public Webshop(String webshopName) {
    this.webshopName = webshopName;
    this.catalogueManager = CatalogueManager.getCatalogueManager();
    this.orderManager = OrderManager.getOrderManager();
  }

  public void dataLoader() {
    Item itemA = new Item(new BigDecimal("231.99"), "Bankje");
    Item itemB = new Item(new BigDecimal("121.42"), "Kast type A");
    Item itemC = new Item(new BigDecimal("399.98"), "Oordoppen Sonfy");
    Item itemD = new Item(new BigDecimal("188.99"), "Koptelefoon");
    Item itemE = new Item(new BigDecimal("1231.99"), "Wandkast");
    Item itemF = new Item(new BigDecimal("31.99"), "Klok");

    ArrayList<Item> year2023Items = new ArrayList<>();
    year2023Items.add(itemE);
    year2023Items.add(itemB);
    year2023Items.add(itemC);
    year2023Items.add(itemA);
    ArrayList<Item> year2022Items = new ArrayList<>();
    year2022Items.add(itemA);
    year2022Items.add(itemC);
    year2022Items.add(itemD);
    year2022Items.add(itemE);
    ArrayList<Item> year2021Items = new ArrayList<>();
    year2021Items.add(itemF);
    year2021Items.add(itemA);
    year2021Items.add(itemC);

    Catalogue year2023 = new Catalogue(2023, year2023Items);
    Catalogue year2022 = new Catalogue(2022, year2022Items);
    Catalogue year2021 = new Catalogue(2021, year2021Items);

    catalogueManager.addCatalogue(year2023);
    catalogueManager.addCatalogue(year2022);
    catalogueManager.addCatalogue(year2021);
  }

  public void start() {
    dataLoader();
    System.out.println("Welkom in de webshop: " + this.webshopName);
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Maak een keuze uit het menu:");
      System.out.println("Kies: \"1\" om door de catalogus te bladeren.");
      System.out.println("Kies: \"2\" om door een bestelling te plaatsen.");
      System.out.println("Kies: \"3\" om een bestelling in te zien.");
      System.out.println("Kies: \"Exit\" om de webshop te verlaten.");
      String input = scanner.nextLine();

      if (input.equalsIgnoreCase("Exit")) {
        break;
      } else if (input.equals("1")) {
        browse();
      } else if (input.equals("2")) {
        order();
      } else if (input.equals("3")) {
        getAllOrders();
      } else {
        System.out.println("Onbekende invoer");
      }
    }
  }

  public void browse() {

    Boolean returnToMain = true;

    Scanner scanner = new Scanner(System.in);

    while (returnToMain) {

      Catalogue catalogue = null;
      int year;

      System.out.println(
          "Voer een jaartal in formaat: \"YYYY\" in, om door de catalogus van dat jaar te gaan.");
      System.out.println("Kies: \"Exit\" om terug te gaan naar het hoofdmenu.");
      // Wat als fout?
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("Exit")) {
        break;
      } else if (!input.matches("^[0-9]{4}$")) {
        System.out.println("Jaartal niet correct ingevoerd!");
        continue;
      } else {
        year = Integer.parseInt(input);
      }

      try {
        catalogue = this.catalogueManager.getCatalogueForYear(year);
      } catch (IllegalArgumentException e) {
        catalogue = new Catalogue(year);
        this.catalogueManager.addCatalogue(catalogue);
      }

      if (catalogue.getItems().size() == 0) {
        System.out.println("Geen artikelen in jaar: " + year);
      } else {
        System.out.println(catalogue.toString());
      }
    }
  }

  public void order() {

    Scanner scanner = new Scanner(System.in);

    Boolean returnToMain = true;

    while (returnToMain) {

      String exitString = " of kies: \"Exit\" om terug te gaan naar het hoofdmenu.";
      StringBuilder klantNaamString = new StringBuilder("Voer de naam van de klant in:");
      System.out.println(klantNaamString.append(exitString));
      String inputKlantNaam = scanner.nextLine();

      if (inputKlantNaam.equalsIgnoreCase("Exit")) {
        break;
      }

      StringBuilder klantAdresString = new StringBuilder("Voer het adres van de klant in:");
      System.out.println(klantAdresString.append(exitString));
      String inputKlantAdres = scanner.nextLine();

      if (inputKlantNaam.equalsIgnoreCase("Exit")) {
        returnToMain = false;
        break;
      }

      ArrayList<Item> itemOrderList = new ArrayList<>();

      while (true) {
        StringBuilder itemIdString = new StringBuilder("Voer het id van het te bestellen item in:");
        String exitItemString = " of kies: \"Klaar\" om als je geen items meer wil toevoegen.";
        System.out.println(itemIdString.append(exitItemString));
        String inputItemId = scanner.nextLine();

        if (inputItemId.equalsIgnoreCase("Klaar")) {
          returnToMain = false;
          break;
        }

        try {
          itemOrderList.add(catalogueManager.findObjectByUUID(UUID.fromString(inputItemId)));
        } catch (IllegalArgumentException e) {
          System.out.println("Item met: " + inputItemId + " niet gevonden");
        }
      }

      Customer customer = new Customer(inputKlantNaam, inputKlantAdres);

      orderManager.addOrder(new Order(customer, itemOrderList));
    }
  }

  public void getAllOrders() {
    orderManager.printAllOrders();
  }
}
