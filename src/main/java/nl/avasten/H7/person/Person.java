package nl.avasten.H7.person;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    //TODO Ask whether this is designed correctly
    public void haveBirthday() throws PersonDiedException {
        if (this.age + 1 > maxAge) {
            throw new PersonDiedException("Persoon is overleden");
        }
        this.age += 1;
    }
}

