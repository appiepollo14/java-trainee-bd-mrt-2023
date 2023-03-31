package nl.avasten.H7.webshop;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.*;

public record Order(
    UUID id, Customer customer, LocalTime orderDate, BigDecimal totalOrder, ArrayList<Item> items)
    implements Iterable<Item> {

  public Order(Customer customer, ArrayList<Item> items) {
    this(UUID.randomUUID(), customer, LocalTime.now(), calculateTotalOrder(items), items);
  }

  private static BigDecimal calculateTotalOrder(ArrayList<Item> items) {
    return items.stream().map(Item::getItemPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public UUID getId() {
    return this.id;
  }

  @Override
  public String toString() {
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    currencyFormat.setCurrency(Currency.getInstance(Locale.getDefault()));
    StringBuilder builder = new StringBuilder();
    builder.append("Order: ").append(id).append("\n");
    builder.append("Datum: ").append(orderDate).append("\n");
    builder.append("Klant: ").append(customer).append("\n");
    builder.append("Totale prijs: ").append(currencyFormat.format(totalOrder)).append("\n");
    builder.append(String.format("%-40s%-20s%-20s\n", "Id", "Prijs", "Omschrijving"));
    builder.append(
        "-----------------------------------------------------------------------------------\n");

    for (Item item : items) {
      builder.append(item.toString());
      builder.append("\n");
    }

    return builder.toString();
  }

  // Anonimous class
  @Override
  public Iterator<Item> iterator() {
    return new Iterator<Item>() {

      private int i = 0;

      @Override
      public boolean hasNext() {
        if (i < Order.this.items.size()) {
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
