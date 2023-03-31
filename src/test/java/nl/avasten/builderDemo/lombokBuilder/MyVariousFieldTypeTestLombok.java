package nl.avasten.builderDemo.lombokBuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyVariousFieldTypeTest {

    @Test
    public void testBuildConstructorThrowException(){
        assertThrows(Exception.class, () -> new MyVariousFieldType.MyVariousFieldTypeBuilder().build());
    }

    @Test
    public void testBuildConstructorWithRequiredFieldOnly(){
        MyVariousFieldType mvft = new MyVariousFieldType.MyVariousFieldTypeBuilder().name("test").build();
        assertEquals("test", mvft.getName());
    }

    @Test
    public void testBuildConstructorWithOneExtraField(){
        MyVariousFieldType mvft = new MyVariousFieldType.MyVariousFieldTypeBuilder().name("test2").age(20).build();
        assertEquals(20,mvft.getAge());
    }

    @Test
    public void testSetField(){
        MyVariousFieldType mvft = new MyVariousFieldType.MyVariousFieldTypeBuilder().name("test2").age(20).build();
        // deprecated
    }

}