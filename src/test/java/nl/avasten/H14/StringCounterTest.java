package nl.avasten.H14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCounterTest {

  private StringCounter sut;

  @BeforeEach
  public void init() {
    this.sut = new StringCounter();
  }

  @Test
  void givenAStringWhenCountingCharsThenExpectedCorrectUniqueQtyOfCharsInString() {

    String toBeCounted = new String("Groooote");
    System.out.println(this.sut.countString(toBeCounted));
    String toBeCounted2 = new String("Groooote");
    System.out.println(this.sut.countString(toBeCounted2));

  }
}
