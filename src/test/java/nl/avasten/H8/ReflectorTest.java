package nl.avasten.H8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReflectorTest {

    private Reflector target;

    @BeforeEach
    public void init() {
        this.target = new Reflector();
    }

    @Test
    public void printAllMethods() {
        target.printAllMethods();
    }

    @Test
    public void printAllFields() {
        target.printAllFields();
    }

    @Test
    public void printAllConstructors() {
        target.printAllConstructors();
    }
}