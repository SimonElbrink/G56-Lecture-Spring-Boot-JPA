package se.lexicon.g56lecturespringbootjpa.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void test1() {
        Student student1 = new Student("Test", "Testsson","test.testsson@test.te");
        assertEquals("Test", student1.getFirstName());

    }
}