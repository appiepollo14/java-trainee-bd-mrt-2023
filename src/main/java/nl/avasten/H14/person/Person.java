package nl.avasten.H14.person;

import java.text.MessageFormat;
import java.util.*;
import nl.avasten.H10.Human;
import nl.avasten.H7.person.Gender;
import nl.avasten.H7.person.PersonDiedException;

public class Person extends Human implements Comparable<Person>, Iterable<Person.HistoryRecord> {

  public static final String universalRights = "All humans are created equal.";
  static final int maxAge = 130;

  private String name;
  private int age;
  private Gender gender;
  private List<HistoryRecord> historyRecords = new ArrayList<>();
  private int historyCounter;

  public Person() {
    this(null, 0);
  }

  public Person(String name) {
    this(name, 0);
  }

  public Person(String name, int age) {
    this(name, age, Gender.UNKNOWN);
  }

  public Person(String name, int age, Gender gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return this.age;
  }

  public Gender getGender() {
    return this.gender;
  }

  public void haveBirthday() throws PersonDiedException {
    if (this.age + 1 > maxAge) {
      throw new PersonDiedException("Persoon is overleden");
    }
    this.age += 1;
  }

  public void addHistory(String description) {
    historyRecords.add(new HistoryRecord(description));
    historyCounter = historyRecords.size();
  }

  public void printHistory() {

    for (int i = 0; i < this.historyCounter; i++) {
      System.out.println(this.historyRecords.get(i).toString());
    }
  }

  public Human createSubHuman() {
    return new Human() {

      @Override
      public String greet() {
        return "Sub is the best.";
      }
    };
  }

  @Override
  public String greet() {
    return MessageFormat.format("Hello my name is {0}. Nice to meet you!", this.name);
  }

  @Override
  public String toString() {
    return name + " (" + age + ") is " + gender.toString();
  }

  @Override
  public int hashCode() {
    return name.hashCode() * gender.toString().hashCode() * (int) (Math.random() * 100);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (o instanceof Person p) {
      return Objects.equals(p.getName(), this.getName())
          && Objects.equals(p.getAge(), this.getAge())
          && Objects.equals(p.getGender().toString(), this.getGender().toString());
    } else {
      return false;
    }
  }

  public void delay() throws InterruptedException {
    System.out.println("Delayed called");
    Thread.sleep(10000);
    System.out.println("Delayed ended");
  }

  protected void finalize() throws Throwable {
    // TODO Auto-generated method stub
    System.out.println("Blabla finalize is called!");

    // Isn't executed
    Thread.sleep(10000);

    System.out.println("Tweede finalize");

    super.finalize();
  }

  @Override
  public int compareTo(Person o) {
    if (getAge() == o.getAge()) {
      if (getName().length() < o.getName().length()) {
        return -1;
      } else {
        return 1;
      }
    } else if (getAge() < o.getAge()) {
      return -1;
    } else {
      return 1;
    }
  }

  @Override
  public Iterator<HistoryRecord> iterator() {
    return new Iterator<HistoryRecord>() {

      private int i;

      @Override
      public boolean hasNext() {
        return i < Person.this.historyRecords.size();
      }

      @Override
      public HistoryRecord next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return Person.this.historyRecords.get(i++);
      }
    };
  }

  public static class HistoryRecord {

    private String description;

    public HistoryRecord(String description) {
      this.description = description;
    }

    @Override
    public String toString() {
      return "HistoryRecord{" + "description='" + description + '\'' + '}';
    }
  }
}
