package se.lexicon.g56lecturespringbootjpa.old.dao;


import se.lexicon.g56lecturespringbootjpa.entity.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentDao {

  Student persist(Student student);

  Optional<Student> findById(String id);

  Optional<Student> findByEmail(String email);

  Collection<Student> findByNameContains(String name);

  Collection<Student> findAll();

  void update(Student student);

  void remove(String id);

}
