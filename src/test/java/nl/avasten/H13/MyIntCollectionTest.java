package nl.avasten.H13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyIntCollectionTest {

  private MyIntCollection intCollection;

  @BeforeEach
  public void init() {
    this.intCollection = new MyIntCollection();
  }

  @Test
  void add() {

    this.intCollection.add(1);
    this.intCollection.add(2);
    this.intCollection.add(3);
    this.intCollection.add(4);

    int[] result = this.intCollection.getIntArr();

    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }

  @Test
  void givenAnIntArrayOfSize8ThenExpectblabla() {
    this.intCollection.add(1);
    this.intCollection.add(2);
    this.intCollection.add(3);
    this.intCollection.add(4);
    this.intCollection.add(5);
    this.intCollection.add(6);
    this.intCollection.add(7);
    this.intCollection.add(8);

    int[] result = this.intCollection.getIntArr();

    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }
}
