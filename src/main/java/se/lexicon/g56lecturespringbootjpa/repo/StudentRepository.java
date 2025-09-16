package se.lexicon.g56lecturespringbootjpa.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.g56lecturespringbootjpa.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student,String> {

    // Query Lookup Strategies
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    List<Student> findByFirstName(String firstName);
    Optional<Student> findByEmail(String email);
    List<Student> findByFirstNameAndLastNameContainsIgnoreCase(String firstName, String lastName);



    @Query("SELECT s FROM Student s WHERE s.firstName = :fn")
    List<Student> selectByFirstName(@Param("fn") String firstName);

    @Query("SELECT s FROM Student s WHERE s.firstName = :fn AND LOWER(s.lastName) LIKE LOWER(CONCAT('%', :ln, '%'))")
    List<Student> selectByFirstNameAndLastNameContainsIgnoreCase(@Param("fn") String firstName, @Param("ln") String LastName);


    @Modifying
    @Query("UPDATE Student s SET s.status = :status WHERE s.id = :id")
    int updateStudentStatusById(@Param("id") String id, @Param("status") boolean status);





}

