package nl.avasten.H13;

import java.util.Arrays;

public class MyGenericCollection<T> {

  private T[] arr;
  private int length;

  public MyGenericCollection() {
    this.arr = (T[]) new Object[4];
    this.length = 0;
  }

  public void add(T toBeAddedObject) {
    if (length == this.arr.length) {
      this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
    }
    this.arr[length] = toBeAddedObject;
    ;
    length += 1;
  }

  public T getArr(int i) {
    return this.arr[i];
  }

  public T[] getTotalArray() {
    return this.arr;
  }

  public int getLength() {
    return length;
  }
}
