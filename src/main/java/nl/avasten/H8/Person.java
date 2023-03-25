package nl.avasten.H8;

import nl.avasten.H7.person.Gender;
import nl.avasten.H7.person.PersonDiedException;

import java.util.Objects;

public class Person {

    public static final String universalRights = "All humans are created equal.";
    static final int maxAge = 130;

    private String name;
    private int age;
    private Gender gender;


    public Person() {
        this.gender = Gender.UNKNOWN;
    }

    public Person(String name, int age) {
        this();
        this.name = name;
        this.age = age;
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


    @Override
    public String toString() {
        return name + " (" +
                age + ") is " +
                gender.toString();
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
        if (o instanceof Person p) {
            return Objects.equals(p.getName(), this.getName()) &&
                    Objects.equals(p.getAge(), this.getAge()) &&
                    Objects.equals(p.getGender().toString(), this.getGender().toString());
        } else {
            return false;
        }
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return age == person.age && Objects.equals(name, person.name) && gender == person.gender;
//    }
}

