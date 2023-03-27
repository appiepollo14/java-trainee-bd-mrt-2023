package nl.avasten.H7.webshop;

import java.util.ArrayList;

public class Catalogue {

    private int year;
    private ArrayList<Item> items = new ArrayList<>();

    public int getYear() {
        return this.year;
    }

    public Catalogue(int year) {
        this(year, null);
    }

    public Catalogue(int year, ArrayList<Item> itemList) {
        this.year = year;
        this.items = itemList;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

}
