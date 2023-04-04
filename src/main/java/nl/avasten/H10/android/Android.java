package nl.avasten.H10.android;

import java.util.Objects;
import nl.avasten.H10.Human;
import nl.avasten.H10.chargable.Chargable;
import nl.avasten.H7.person.Gender;
import nl.avasten.H7.person.PersonDiedException;

public class Android extends Human implements Chargable {

  public static final String universalRights = "All humans are created equal.";
  static final int maxAge = 130;

  private String name;
  private int age;
  private Gender gender;
  private int level;

  public Android() {
    this(null, 0);
  }

  public Android(String name) {
    this(name, 0);
  }

  public Android(String name, int age) {
    this(name, age, Gender.UNKNOWN);
  }

  public Android(String name, int age, Gender gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.level = 0;
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

  @Override
  public String greet() {
    return "I'm only half human, but human still... My energy level is " + this.level + "%..";
  }

  @Override
  public int charge(int amount) {
    if (this.level + amount <= 100) {
      this.level += amount;
    }
    return this.level;
  }

  @Override
  public String toString() {
    return name + " (" + age + ") is " + gender.toString();
  }

  @Override
  public int hashCode() {
    return name.hashCode() * gender.toString().hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (o instanceof Android p) {
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
}
