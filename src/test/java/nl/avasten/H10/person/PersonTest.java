package nl.avasten.H10.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

  private Person person;

  @BeforeEach
  public void init() {
    this.person = new Person("Jan");
  }

  @Test
  public void greet() {
    String expected = "Hello my name is Jan. Nice to meet you!";
    String actual = person.greet();
    assertEquals(expected, actual);
  }
}
