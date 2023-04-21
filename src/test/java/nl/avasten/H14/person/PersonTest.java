package nl.avasten.H14.person;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import nl.avasten.H10.Human;
import nl.avasten.H7.person.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

  private Person person;
  private HashSet<Person> personHashSet;

  @BeforeEach
  public void init() {
    this.person = new Person();
    this.personHashSet = new HashSet<>();
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

  @Test
  public void givenOnePersonWhenAddingPersonToHashSetExpectOneInHashSet() {
    Person annejet = new Person("Annejet", 30, Gender.FEMALE);
    this.personHashSet.add(annejet);
    System.out.println(this.personHashSet);
    int qtyInHashset = 1;
    Assertions.assertEquals(qtyInHashset, this.personHashSet.size());
  }

  @Test
  public void givenOnePersonWhenAddingSamePersonToHashSetExpectOneInHashSet() {
    Person annejet = new Person("Annejet", 30, Gender.FEMALE);
    System.out.println("Hashcode person1: " + annejet.hashCode());
    this.personHashSet.add(annejet);
    Person annejet2 = new Person("Annejet", 30, Gender.FEMALE);
    System.out.println("Hashcode person2: " + annejet2.hashCode());
    this.personHashSet.add(annejet2);
    System.out.println(this.personHashSet);
    Assertions.assertEquals(2, this.personHashSet.size());
    ;
  }

  @Test
  public void givenMultiplePersonsWhenAddingToTreeMapExpectSorting() {
    // https://www.baeldung.com/java-treemap
    Person annejet = new Person("Annejet", 30, Gender.FEMALE);
    Person coreline = new Person("Coreline", 30, Gender.FEMALE);
    Person asjer = new Person("Asjer", 28, Gender.FEMALE);
    Person erik = new Person("Erik", 32, Gender.FEMALE);
    Person henk = new Person("Henk", 55, Gender.FEMALE);
    TreeMap<Person, String> personTreeMap = new TreeMap<>(Comparator.reverseOrder());
    personTreeMap.put(annejet, "annejet");
    personTreeMap.put(coreline, "coreline");
    personTreeMap.put(asjer, "asjer");
    personTreeMap.put(erik, "erik");
    personTreeMap.put(henk, "henk");

    for (Map.Entry<Person, String> entry : personTreeMap.entrySet()) {
      System.out.println(entry.getKey() + " ==== " + entry.getValue());
    }
  }

  @Test
  public void givenAPersonWithAListOfHistoryRecordsWhenIteratingThenCountIterations() {

    Person annejet = new Person("Annejet", 30, Gender.FEMALE);

    annejet.addHistory("Henk");
    annejet.addHistory("Kaas");

    int actualHistRecord = 0;

    for (Person.HistoryRecord h: annejet) {
        System.out.println(h);
        actualHistRecord += 1;
    }

    Assertions.assertEquals(2, actualHistRecord);


  }
}
