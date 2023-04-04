package nl.avasten.H10.teacher;

import org.junit.jupiter.api.BeforeEach;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    private Teacher teacher;

    @BeforeEach
    public void init() {
        this.teacher = new Teacher();
    }

    @Test
    public void greet() {
    System.out.println(this.teacher.greet());
    }
}
