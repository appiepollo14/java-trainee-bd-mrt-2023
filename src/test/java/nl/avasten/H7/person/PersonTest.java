package nl.avasten.H7.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    public void init() {
        this.person = new Person();
    }

    @Test
    //TODO ask if this is a correct design pattern
    @DisplayName("Person test for H7 time permits")
    public void testPerson() {
        Person p = new Person("Jan", 130);
        System.out.println(p.getGender());
        p.setGender(Gender.MALE);
        System.out.println(p.getGender());
        try {
            p.haveBirthday(); // person gets one year older
        } catch (PersonDiedException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(p.getAge() <= Person.maxAge);
        System.out.println(p.getAge());
        System.out.println(Person.universalRights);
    }

}