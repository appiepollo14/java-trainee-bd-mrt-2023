package nl.avasten.H14;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyGenericCollection<T> implements Collection<T> {

  private T[] arr;
  private int length;

  public MyGenericCollection() {
    this.arr = (T[]) new Object[4];
    this.length = 0;
  }

  @Override
  public boolean add(T toBeAddedObject) {
    if (length == this.arr.length) {
      this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
    }
    this.arr[length] = toBeAddedObject;
    ;
    length += 1;
    return true;
  }

  public T getArr(int i) {
    return this.arr[i];
  }

  public T[] getTotalArray() {
    return this.arr;
  }

  @Override
  public int size() {
    return this.length;
  }

  @Override
  public boolean isEmpty() {
    if (this.length == 0) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean contains(Object o) {

    for (T t : this.arr) {
      if (t != null && t.equals(o)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }

  @Override
  public Object[] toArray() {
    return this.arr;
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return (T[]) this.arr;
  }

  @Override
  public boolean remove(Object o) {
    for (int i = 0; i < this.length; i++) {
      if (this.arr[i] != null && this.arr[i].equals(o)) {
        this.arr[i] = null;
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    for (T t : c) {
       add(t);
    }
    return true;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public void clear() {
    for (int i = 0; i < this.length; i++) {
      this.arr[i] = null;
    }
  }
}
