package se.lexicon.g56lecturespringbootjpa.repo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.g56lecturespringbootjpa.entity.Student;

import java.util.List;
import java.util.Optional;

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
    @DisplayName("Find Simon by first name")
    void testFindByFirstName() {
        // Arrange: create and save student
        Student student = new Student("Simon", "Elbrink", "simon@exmaple.com");
        studentRepository.save(student);

        // Act: retrieve the student using a custom method
        List<Student> result = studentRepository.findByFirstName("Simon");

        // Assert: ensure exactly one student is returned
        assertThat(result).hasSize(1);
    }

    @Test
    @DisplayName("Find Simon by email")
    void testFindByEmail() {
        // Arrange: save a student with a known email
        Student student = new Student("Simon", "Elbrink", "simon@example.com");
        studentRepository.save(student);

        // Act: retrieve the student using a custom method
        Optional<Student> optional = studentRepository.findByEmail("simon@example.com");

        // Assert: check that the student was found
        assertThat(optional).isPresent();
    }

    @Test
    @DisplayName("Find all students: Mehrdad, Simon, Tobias")
    void testFindAll() {
        // Arrange: save 3 students
        studentRepository.save(new Student("Mehrdad", "Javan", "mehrdad.all@example.com"));
        studentRepository.save(new Student("Simon", "Jones", "simon.all@example.com"));
        studentRepository.save(new Student("Tobias", "Andersson", "tobias.all@example.com"));

        // Act: retrieve all students from the DB
        List<Student> students = (List<Student>) studentRepository.findAll();

        // Assert: check that 3 students exist
        assertThat(students).hasSize(3);
    }

    @Test
    @DisplayName("Update student status by ID")
    void testUpdateStudentStatusById() {
        // Arrange: Save a new student with default status (false)
        Student student = new Student("Lina", "Smith", "lina@example.com");
        Student savedStudent = studentRepository.save(student);

        // Act: Update the status to true
        int rowsAffected = studentRepository.updateStudentStatusById(savedStudent.getId(), true);

        // Assert: Check that exactly one row was updated
        assertThat(rowsAffected).isEqualTo(1);

        // Fetch the student again and verify the status was updated
        Optional<Student> updated = studentRepository.findById(savedStudent.getId());
        assertThat(updated).isPresent();
        assertThat(updated.get().isStatus()).isTrue();
    }
}