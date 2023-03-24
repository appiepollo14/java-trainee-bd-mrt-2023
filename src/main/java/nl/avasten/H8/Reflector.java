package nl.avasten.H8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflector {

    public void printAllMethods() {
        Method[] methods = Person.class.getDeclaredMethods();
        for (Method m: methods) {
            System.out.println(m.getName());
        }
    }

    public void printAllFields() {
        Field[] fields = Person.class.getFields();
        for (Field f: fields) {
            System.out.println(f.getName());
        }
    }

    public void printAllConstructors() {
        Constructor[] fields = Person.class.getDeclaredConstructors();
        for (Constructor c: fields) {
            System.out.println(c.getName());
        }
    }

}
