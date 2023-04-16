package nl.avasten.H13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyGenericCollectionTest {

  @Test
  void add() {

    MyGenericCollection<String> stringMyGenericCollection = new MyGenericCollection<>();

    stringMyGenericCollection.add("Een");
    stringMyGenericCollection.add("Twee");
    stringMyGenericCollection.add("Drie");
    stringMyGenericCollection.add("Vier");

    for (int i = 0; i < stringMyGenericCollection.getArr().length; i++) {
      System.out.println(stringMyGenericCollection.getArr()[i]);
    }
  }

//  @Test
//  void givenAnIntArrayOfSize8ThenExpectblabla() {
//    this.intCollection.add(1);
//    this.intCollection.add(2);
//    this.intCollection.add(3);
//    this.intCollection.add(4);
//    this.intCollection.add(5);
//    this.intCollection.add(6);
//    this.intCollection.add(7);
//    this.intCollection.add(8);
//
//    int[] result = this.intCollection.getIntArr();
//
//    for (int i = 0; i < result.length; i++) {
//      System.out.println(result[i]);
//    }
//  }
}
