package nl.avasten.chainStoreMicro;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class RegularCard extends Card {

  public RegularCard(int id, String name) {
    this(id, name, 0.00);
  }

  public RegularCard(int id, String name, double credit) {
    super(id, name, credit);
  }

  @Override
  public boolean pay(int amount) {
    double newAmount = super.getCredit() - (double) amount;
    if (newAmount < 0d) {
      return false;
    } else {
      super.setCredit(newAmount);
      return true;
    }
  }

  @Override
  public String toString() {

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    currencyFormat.setCurrency(Currency.getInstance(Locale.getDefault()));

    return String.format("%-8s%-20s%-15s", id, name, currencyFormat.format(credit));
  }
}
