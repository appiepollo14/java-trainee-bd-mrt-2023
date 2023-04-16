package nl.avasten.H13;

import java.util.Arrays;

public class MyGenericCollection<T> {

  private T[] arr;
  private int pointer;

  public MyGenericCollection() {
    // TODO vragen naar deze syntax uitleg
    this.arr = (T[]) new Object[4];
    this.pointer = 0;
  }

  public void add(T toBeAddedObject) {
    if (pointer == this.arr.length) {
      this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
    }
    this.arr[pointer] = toBeAddedObject;
    ;
    pointer += 1;
  }

  public T[] getArr() {
    return this.arr;
  }
}
