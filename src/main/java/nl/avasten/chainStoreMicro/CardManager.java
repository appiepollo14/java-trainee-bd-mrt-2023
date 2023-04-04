package nl.avasten.chainStoreMicro;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class CardManager {

  public ArrayList<Card> getCardList() {
    return cardList;
  }

  private ArrayList<Card> cardList;

  public CardManager() {
    this.cardList = new ArrayList<>();
  }

  public void addCard(int id, String name, int discount) {
    addCard(id, name, 0, discount);
  }

  public void addCard(int id, String name, int credit, int discount) {
    if (discount > 0) {
      GoldCard newCard = new GoldCard(id, name, credit, discount);
      this.cardList.add(newCard);
    } else {
      RegularCard newCard = new RegularCard(id, name, credit);
      this.cardList.add(newCard);
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

      Optional<Card> foundCard = cardList.stream().filter(f -> f.id == cardID).findFirst();

      if (foundCard.isEmpty()) {
        System.out.println("bla");
        break;
      }

      foundCard.get().pay(amount);

      printOverview();
    }
  }
}
