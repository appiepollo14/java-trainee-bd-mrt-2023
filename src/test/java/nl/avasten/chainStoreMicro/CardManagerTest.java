package nl.avasten.chainStoreMicro;

import static org.junit.jupiter.api.Assertions.*;

import nl.avasten.chainStoreMicro.exceptions.OutOfRangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardManagerTest {

  private CardManager cardManager;

  @BeforeEach
  public void init() {
    this.cardManager = new CardManager();
    this.cardManager.addCard(1235, "Gerda", 1000, 0);
    this.cardManager.addCard(1236, "Donald", 7000, 10);
    this.cardManager.addCard(1237, "Edward", 5000, 0);
    this.cardManager.addCard(1238, "Mona", 7000, 10);
    this.cardManager.addCard(1239, "Roan", 800, 15);
    this.cardManager.addCard(1240, "Vera", 500, 0);
  }

  @Test
  public void givenACardManagerWhenAddingTwoCardsThenCheckLengthOfCardList() {

    int expectedLength = 6;

    int actualLength = this.cardManager.getCardList().size();

    assertEquals(expectedLength, actualLength);
  }

  @Test
  public void givenACardManagerWhenAddingACardWithEnormousDiscountThenException() {
    assertThrows(OutOfRangeException.class, () -> this.cardManager.addCard(1233, "Henk", 55));
  }

  @Test
  void printOverview() {
    this.cardManager.printOverview();
  }

  @Test
  public void givenACardManagerWhenRunningThen() {

  }

}
