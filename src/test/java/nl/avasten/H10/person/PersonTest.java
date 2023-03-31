package nl.avasten.H10.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

  private Person person;

  @BeforeEach
  public void init() {
    this.person = new Person();
  }

  @Test
  void greet() {}
}
