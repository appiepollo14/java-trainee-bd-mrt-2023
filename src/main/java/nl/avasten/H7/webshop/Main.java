package nl.avasten.H7.webshop;

import java.math.BigDecimal;

public class Main {

    private static final Webshop webshop = new Webshop("AvAsten");
    private final Item itemA = new Item(new BigDecimal("231.99"), "Bankje");
    private final Item itemB = new Item(new BigDecimal("121.42"), "Bankje");
    private final Item itemC = new Item(new BigDecimal("231.99"), "Bankje");
    private final Item itemD = new Item(new BigDecimal("231.99"), "Bankje");
    private final Item itemE = new Item(new BigDecimal("231.99"), "Bankje");
    private final Item itemF = new Item(new BigDecimal("231.99"), "Bankje");

    public static void main(String[] args) {
        System.out.println("Welkom in de webshop: " + webshop.getWebshopName());
    }

}
