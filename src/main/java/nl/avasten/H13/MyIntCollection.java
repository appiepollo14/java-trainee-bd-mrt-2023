package nl.avasten.H13;

import java.util.Arrays;

public class MyIntCollection {

  private int[] intArr;
  private int pointer;

  public MyIntCollection() {
    this.intArr = new int[4];
    this.pointer = 0;
  }

  public void add(int toBeAddedNumber) {
    if (pointer == this.intArr.length) {
      this.intArr = Arrays.copyOf(this.intArr, this.intArr.length * 2);
    }
    this.intArr[pointer] = toBeAddedNumber;
    ;
    pointer += 1;
  }

  public int[] getIntArr() {
    return intArr;
  }
}
