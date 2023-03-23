package nl.avasten.H7.webshop;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

import static java.math.BigDecimal.ZERO;
import static java.time.LocalTime.now;

public class Order implements Iterable<Item> {

    private Customer customer;
    private LocalTime orderDate;
    // TODO uitzoeken hoe dat gaat met formaat achter de komma
    private BigDecimal totalOrder = ZERO;
    private ArrayList<Item> items;

    public Order(Customer customer, BigDecimal totalOrder, ArrayList<Item> items) {
        this.customer = customer;
        this.orderDate = now();

        for (Item i : items) {
            this.totalOrder = this.totalOrder.add(i.itemPrice());
        };
    }

    // Anonimous class
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private int i = 0;

            @Override
            public boolean hasNext() {
                if ( i < Order.this.items.size()) {
                    return true;
                }
                return false;
            }

            @Override
            public Item next() {
                return Order.this.items.get(i);
            }
        };
    }
}
