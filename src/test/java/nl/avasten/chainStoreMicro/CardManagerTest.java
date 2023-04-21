package nl.avasten.chainStoreMicro;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import nl.avasten.chainStoreMicro.exceptions.OutOfRangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardManagerTest {

  private CardManager cardManager;

  @BeforeEach
  public void init() {
    this.cardManager = new CardManager();
    //    this.cardManager.addCard(1235, "Gerda", 1000, 0);
    //    this.cardManager.addCard(1236, "Donald", 7000, 10);
    //    this.cardManager.addCard(1237, "Edward", 5000, 0);
    //    this.cardManager.addCard(1238, "Mona", 7000, 10);
    //    this.cardManager.addCard(1239, "Roan", 800, 15);
    //    this.cardManager.addCard(1240, "Vera", 500, 0);
  }

  @Test
  public void givenACardManagerWhenAddingCardWithoutDiscountThenCardsAdded() {
    this.cardManager.addCard(1, "John Doe", 100, 0);
    ArrayList<Card> cardList = cardManager.getCardList();
    assertEquals(1, cardList.size());
    assertEquals(1, cardList.get(0).getId());
    assertEquals("John Doe", cardList.get(0).getName());
    assertEquals(100, cardList.get(0).getCredit());
    assertTrue(cardList.get(0) instanceof RegularCard);
  }

  @Test
  public void givenACardManagerWhenAddingCardWithDiscountThenCardsAdded() {
    this.cardManager.addCard(1, "John Doe", 100, 15);
    ArrayList<Card> cardList = cardManager.getCardList();
    assertEquals(1, cardList.size());
    assertEquals(1, cardList.get(0).getId());
    assertEquals("John Doe", cardList.get(0).getName());
    assertEquals(100, cardList.get(0).getCredit());
    assertTrue(cardList.get(0) instanceof GoldCard);
    assertEquals(15, ((GoldCard) cardList.get(0)).getDiscount());
  }

  @Test
  public void givenACardManagerWhenAddingACardWithEnormousDiscountThenException() {

    this.cardManager.addCard(1233, "John doe", 100, 55);
    assertEquals(0, this.cardManager.getCardList().size());
//    assertThrows(OutOfRangeException.class, () -> this.cardManager.addCard(1233, "Henk", 55));
  }

  @Test
  public void givenACardManagerWhenNotFindingACardThenException() {
    assertThrows(IllegalArgumentException.class, () -> this.cardManager.findCard(1244));
  }

  @Test
  void printOverview() {
    this.cardManager.printOverview();
  }
}
