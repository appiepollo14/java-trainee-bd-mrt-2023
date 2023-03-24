package nl.avasten.H8;

import nl.avasten.H7.person.Gender;
import nl.avasten.H7.person.PersonDiedException;

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

    public String getName() {
        return name;
    }

    public void haveBirthday() throws PersonDiedException {
        if (this.age + 1 > maxAge) {
            throw new PersonDiedException("Persoon is overleden");
        }
        this.age += 1;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}

