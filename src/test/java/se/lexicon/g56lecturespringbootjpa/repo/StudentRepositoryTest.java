package se.lexicon.g56lecturespringbootjpa.repo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.g56lecturespringbootjpa.entity.Student;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    @DisplayName("Save Simon")
    void testSaveStudent() {
        // Arrange: create a student instance
        Student student = new Student("Simon", "Elbrink", "simon@exmaple.com");

        // Act: save the student to the in-memory DB
        Student savedStudent = studentRepository.save(student);

        // Assert: verify that the student was assigned an ID (i.e., persisted)
//        assertTrue(savedStudent.getId() != null);
        assertThat(savedStudent.getId()).isNotNull();


    }

    @Test
    void testFindByFirstName() {
        // Arrange: create and save student
        Student student = new Student("Simon", "Elbrink", "simon@exmaple.com");
        studentRepository.save(student);

        // Act: retrieve the student using a custom method
        List<Student> result = studentRepository.findByFirstName("Simon");

        // Assert: ensure exactly one student is returned
        assertThat(result).hasSize(1);
    }
}