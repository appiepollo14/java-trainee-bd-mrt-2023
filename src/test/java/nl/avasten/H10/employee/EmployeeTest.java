package nl.avasten.H10.employee;

import org.junit.jupiter.api.BeforeEach;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee employee;

    @BeforeEach
    public void init() {
        this.employee = new Employee();
    }

    @Test
    public void testGreet() {
    System.out.println(
    this.employee.greet());
    }
}
