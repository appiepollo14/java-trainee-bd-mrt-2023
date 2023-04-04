package nl.avasten.chainStoreMicro;

public abstract class Card {

  protected final int id;
  protected String name;
  protected double credit;

  public Card(int id, String name, double credit) {
    this.id = id;
    this.name = name;
    this.credit = credit;
  }

  public abstract boolean pay(int amount);

  public double getCredit() {
    return credit;
  }

  public void setCredit(double credit) {
    this.credit = credit;
  }
}
