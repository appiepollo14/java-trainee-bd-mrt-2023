package nl.avasten.H7.webshop;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;

public record Item(UUID id, BigDecimal itemPrice, String description) {

  public Item(BigDecimal itemPrice, String description) {
    this(UUID.randomUUID(), itemPrice, description);
  }

  public UUID getId() {
    return this.id;
  }

  public BigDecimal getItemPrice() {
    return this.itemPrice;
  }

  @Override
  public String toString() {

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    currencyFormat.setCurrency(Currency.getInstance(Locale.getDefault()));

    return String.format(
        "%-40s%-20s%-20s", id.toString(), currencyFormat.format(itemPrice), description);
  }
}
