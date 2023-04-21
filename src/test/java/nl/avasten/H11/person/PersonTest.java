package nl.avasten.H11.person;

import nl.avasten.H10.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

  private Person person;

  @BeforeEach
  public void init() {
    this.person = new Person();
  }

  @Test
  void addHistory() {
    this.person.addHistory("Henk");
    this.person.addHistory("Kaas");

    this.person.printHistory();
  }

  @Test
  public void testHumanCreation() {
    Human henk = this.person.createSubHuman();
    System.out.println(henk.greet());
    ;
  }
}
