package nl.avasten.builderDemo.withBuilder;

import nl.avasten.builderDemo.withBuilder.MyVariousFieldType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyVariousFieldTypeTest {

    @Test
    public void testBuildConstructorWithRequiredFieldOnly(){
        MyVariousFieldType mvft = new MyVariousFieldType.MyVariousFieldBuilder("test").build();
        assertEquals("test", mvft.getName());
    }

    @Test
    public void testBuildConstructorWithOneExtraField(){
        MyVariousFieldType mvft = new MyVariousFieldType.MyVariousFieldBuilder("test2").age(20).build();
        assertEquals(20,mvft.getAge());
    }

    public void testBuildConstructorAndSetField(){
        MyVariousFieldType mvft = new MyVariousFieldType.MyVariousFieldBuilder("test3").age(21).build();
        Integer een = 1;
        System.out.println(een.MAX_VALUE);

    }

}