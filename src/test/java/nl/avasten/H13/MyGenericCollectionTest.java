package nl.avasten.H13;

import org.junit.jupiter.api.Test;

class MyGenericCollectionTest {

  private MyGenericCollection<String> stringTarget;
  private MyGenericCollection<Integer> integerTarget;

  @Test
  void add() {

    stringTarget = new MyGenericCollection<>();

    this.stringTarget.add("Een");
    this.stringTarget.add("Twee");
    this.stringTarget.add("Drie");
    this.stringTarget.add("Vier");

    for (int i = 0; i < this.stringTarget.getLength(); i++) {
      System.out.println(this.stringTarget.getArr(i).toString());
    }
  }

  @Test
  void add2() {

    stringTarget = new MyGenericCollection<>();

    this.stringTarget.add("Een");
    this.stringTarget.add("Twee");
    this.stringTarget.add("Drie");
    this.stringTarget.add("Vier");

    Object[] t = this.stringTarget.getTotalArray();

    for (int i = 0; i < t.length; i++) {
      System.out.println((String) t[i]);
    }
  }

  @Test
  void givenAnIntArrayOfSize8ThenExpectblabla() {

    integerTarget = new MyGenericCollection<>();

    this.integerTarget.add(1);
    this.integerTarget.add(2);
    this.integerTarget.add(3);
    this.integerTarget.add(4);
    this.integerTarget.add(5);
    this.integerTarget.add(6);
    this.integerTarget.add(7);
    this.integerTarget.add(8);

     Object[] result = this.integerTarget.getTotalArray();

        for (int i = 0; i < result.length; i++) {
          System.out.println(result[i]);
        }
  }
}
