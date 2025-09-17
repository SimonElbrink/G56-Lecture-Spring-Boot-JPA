package se.lexicon.g56lecturespringbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.g56lecturespringbootjpa.entity.Address;
import se.lexicon.g56lecturespringbootjpa.entity.Student;
import se.lexicon.g56lecturespringbootjpa.repo.AddressRepository;
import se.lexicon.g56lecturespringbootjpa.repo.StudentRepository;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    StudentRepository studentRepository;
    AddressRepository addressRepository;

    @Autowired
    public AppCommandLineRunner(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Address address = new Address("123 Main St", "Springfield", "12345", "US");

        addressRepository.save(address);

        Student student = new Student("John", "Doe", "joe@doe.com");
        student.setAddress(address);

        studentRepository.save(student);

        System.out.println(studentRepository.findByFirstName("John"));


    }
}
