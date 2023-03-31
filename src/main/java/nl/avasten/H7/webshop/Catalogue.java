package nl.avasten.H7.webshop;

import java.util.ArrayList;

public class Catalogue {

  private int year;
  private ArrayList<Item> items = new ArrayList<>();

  public int getYear() {
    return this.year;
  }

  public Catalogue(int year) {
    this(year, new ArrayList<>());
  }

  public Catalogue(int year, ArrayList<Item> itemList) {
    this.year = year;
    this.items = itemList;
  }

  public ArrayList<Item> getItems() {
    return this.items;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Jaar: ").append(year).append("\n");
    builder.append(String.format("%-40s%-20s%-20s\n", "Id", "Prijs", "Omschrijving"));
    builder.append("-----------------------------------------------------------------------------------\n");

    for (Item item : items) {
      builder.append(item.toString());
      builder.append("\n");
    }

    return builder.toString();
  }
}
