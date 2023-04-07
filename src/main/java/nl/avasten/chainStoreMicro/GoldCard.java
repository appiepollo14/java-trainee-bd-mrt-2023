package nl.avasten.chainStoreMicro;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import nl.avasten.chainStoreMicro.exceptions.OutOfRangeException;

public class GoldCard extends Card {

  private int discount;

  public GoldCard(int id, String name, int discount) throws OutOfRangeException {
    this(id, name, 0.00, discount);
  }

  public GoldCard(int id, String name, double credit, int discount) throws OutOfRangeException{
    super(id, name, credit);

    this.setDiscount(discount);
  }

  @Override
  public boolean pay(int amount) {
    double newAmount =
        super.getCredit() - ((double) amount * ((double) (100 - this.getDiscount()) / 100));
    super.setCredit(newAmount);
    return true;
  }

  public void setDiscount(int discount) throws OutOfRangeException {
    if (discount > 1 && discount < 30) this.discount = discount;
    else throw new OutOfRangeException("Discount not in range 1..30");
  }

  public int getDiscount() {
    return discount;
  }

  @Override
  public String toString() {

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    currencyFormat.setCurrency(Currency.getInstance(Locale.getDefault()));

    return String.format("%-8s%-20s%-15s%-15s", id, name, currencyFormat.format(credit), discount);
  }
}
