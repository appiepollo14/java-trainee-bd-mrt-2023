package nl.avasten.H13;

import nl.avasten.H10.Human;

public class House<T extends Human> {

  public T human;

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder("This house is owned by [");
    str.append(this.human.toString());
    str.append("] and it says [");
    str.append(this.human.greet());
    str.append("].");
    return str.toString();
  }
}
