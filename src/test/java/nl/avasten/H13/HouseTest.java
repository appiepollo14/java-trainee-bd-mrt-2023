package nl.avasten.H13;

import static org.junit.jupiter.api.Assertions.*;

import nl.avasten.H10.android.Android;
import nl.avasten.H10.person.Person;
import nl.avasten.H7.person.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HouseTest {

  @Test
  public void givenAHouseWithAPersonWhenCreatingExpectNoProblem() {
    House<Person> house = new House<Person>();
  }

  @Test
  public void givenAHouseWithAnAndroidWhenCreatingExpectNoProblem() {
    House<Android> house = new House<Android>();
  }

  //  @Test
  //  public void givenAHouseWithAStringWhenCreatingShouldNotCompile() {
  //    House<String> house = new House<String>();
  //  }

  @Test
  public void givenAHouseWithAPersonWhenCallingThenCompareMessage() {
    House<Person> house = new House<Person>();
    house.human = new Person("Annejet", 30, Gender.FEMALE);
    String expected =
        "This house is owned by [Annejet (30) is FEMALE] and it says [Hello my name is Annejet. Nice to meet you!].";
    Assertions.assertEquals(expected, house.toString());
  }

  @Test
  public void givenAHouseWithAnAndroidWhenCallingToStringThenCompareMessage() {
    House<Android> house = new House<Android>();
    house.human = new Android("Annejet", 30, Gender.FEMALE);
    String expected =
        "This house is owned by [Annejet (30) is FEMALE] and it says [I'm only half human, but human still... My energy level is 0%..].";
    Assertions.assertEquals(expected, house.toString());
  }
}
