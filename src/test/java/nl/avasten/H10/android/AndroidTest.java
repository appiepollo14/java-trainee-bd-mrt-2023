package nl.avasten.H10.android;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AndroidTest {

  private Android android;

  @BeforeEach
  public void init() {
    this.android = new Android();
  }

  @Test
  void greet() {
    String expected = "I'm only half human, but human still... My energy level is 0%..";
    String actual = android.greet();
    assertEquals(expected, actual);
    android.charge(90);
    String expectedAfterFirstCharge =
        "I'm only half human, but human still... My energy level is 90%..";
    String actualAfterFirstCharge = android.greet();
    assertEquals(expectedAfterFirstCharge, actualAfterFirstCharge);
    android.charge(90);
    String expectedAfterSecondCharge =
        "I'm only half human, but human still... My energy level is 90%..";
    String actualAfterSecondCharge = android.greet();
    assertEquals(expectedAfterSecondCharge, actualAfterSecondCharge);
  }
}
