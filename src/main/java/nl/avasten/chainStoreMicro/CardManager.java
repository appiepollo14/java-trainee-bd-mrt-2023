package nl.avasten.chainStoreMicro;

import java.util.ArrayList;
import java.util.Scanner;
import nl.avasten.chainStoreMicro.exceptions.OutOfRangeException;

public class CardManager {

  private enum CardType {
    REGULAR,
    GOLD
  };

  public ArrayList<Card> getCardList() {
    return cardList;
  }

  private ArrayList<Card> cardList;

  public CardManager() {
    this.cardList = new ArrayList<>();
  }

  public void addCard(int id, String name, int discount) {
    if (discount > 0) {
      addCard(CardType.GOLD, id, name, 0, discount);
    } else {
      addCard(CardType.REGULAR, id, name, 0, discount);
    }
  }

  public void addCard(int id, String name, int credit, int discount) {
    if (discount > 0) {
      addCard(CardType.GOLD, id, name, credit, discount);
    } else {
      addCard(CardType.REGULAR, id, name, credit, discount);
    }
  }

  // TODO implement factory method
  public void addCard(CardType t, int id, String name, int credit, int discount) {
    switch (t) {
      case REGULAR:
        this.cardList.add(new RegularCard(id, name, credit));
        break;
      case GOLD:
        try {
          this.cardList.add(new GoldCard(id, name, credit, discount));
        } catch (OutOfRangeException e) {
          System.out.println(e.getMessage());
        }

        break;
    }
  }

  public void printOverview() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(
        String.format("%-8s%-20s%-15s%-15s", "CardId", "Name", "Credit", "Discount"));

    System.out.println(stringBuilder.toString());

    for (Card c : cardList) {
      System.out.println(c.toString());
    }
  }

  public Card findCard(int id) throws IllegalArgumentException {
    return cardList.stream()
        .filter(f -> f.id == id)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Card not found!"));
  }

  public void runMicro() {
    printOverview();
    while (true) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Continue?:");
      String input = scanner.next();
      if (input.equalsIgnoreCase("no")) {
        break;
      }
      System.out.println("Enter the cardID:");
      int cardID = scanner.nextInt();
      System.out.println("Enter the amount to pay:");
      int amount = scanner.nextInt();

      Card foundCard = null;

      try {
        foundCard = findCard(cardID);
      } catch (IllegalArgumentException e) {
        System.out.println("Card not found");
        continue;
      }

      boolean payed = foundCard.pay(amount);

      if (!payed) {
        System.out.println("Saldo ontoereikend!");
      }

      printOverview();
    }
  }
}
