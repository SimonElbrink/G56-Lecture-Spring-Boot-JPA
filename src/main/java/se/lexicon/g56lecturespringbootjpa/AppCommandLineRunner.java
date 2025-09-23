package se.lexicon.g56lecturespringbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.g56lecturespringbootjpa.entity.Address;
import se.lexicon.g56lecturespringbootjpa.entity.Course;
import se.lexicon.g56lecturespringbootjpa.entity.Instructor;
import se.lexicon.g56lecturespringbootjpa.entity.Student;
import se.lexicon.g56lecturespringbootjpa.repo.AddressRepository;
import se.lexicon.g56lecturespringbootjpa.repo.CourseRepository;
import se.lexicon.g56lecturespringbootjpa.repo.StudentRepository;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    StudentRepository studentRepository;
    AddressRepository addressRepository;
    CourseRepository  courseRepository;

    @Autowired
    public AppCommandLineRunner(StudentRepository studentRepository, AddressRepository addressRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Address address = new Address("123 Main St", "Springfield", "12345", "US");

        Student john = new Student("John", "Doe", "joe@doe.com");
        john.setAddress(address);


        Instructor simon = new Instructor("Simon");
        Course course = new Course("Java G56",simon);

        john.enrollCourse(course);

        courseRepository.save(course);
        studentRepository.save(john);



    }
}
