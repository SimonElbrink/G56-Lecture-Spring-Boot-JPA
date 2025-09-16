package se.lexicon.g56lecturespringbootjpa.old.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.g56lecturespringbootjpa.entity.Student;

import java.util.Collection;
import java.util.Optional;

/*
In the context of Spring Framework and Spring Data,
 the @Repository annotation is used to indicate that a class is a Data Access Object (DAO) component.
It works exactly like the @Component annotation
 and is used to mark classes that interact with databases or other data sources.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

  /*
  We use the @PersistenceContext annotation to inject an EntityManager,
   which is provided by the Hibernate JPA provider.
   */
  @PersistenceContext
  private EntityManager entityManager;

  /*
  Transactional annotations are used to specify that methods,
   such as persist, update, and remove, should be executed within a transactional context.
   */
  @Override
  @Transactional
  public Student persist(Student student) {
    entityManager.persist(student);
    return student;
  }

  @Override
  public Optional<Student> findById(String id) {
    Student student = entityManager.find(Student.class, id);
    return Optional.ofNullable(student);
  }

  @Override
  public Optional<Student> findByEmail(String email) {
    return entityManager.createQuery("SELECT s FROM Student s WHERE s.email = :email", Student.class)
            .setParameter("email", email)
            .getResultList()
            .stream()
            .findFirst();
  }

  @Override
  public Collection<Student> findByNameContains(String name) {
    return entityManager.createQuery("SELECT s FROM Student s WHERE UPPER(s.firstName) LIKE UPPER(CONCAT('%', :name, '%')) OR UPPER(s.lastName) LIKE UPPER(CONCAT('%', :name, '%'))", Student.class)
            .setParameter("name", "%" + name + "%")
            .getResultList();
  }

  @Override
  public Collection<Student> findAll() {
    return entityManager.createQuery("SELECT s FROM Student s", Student.class)
            .getResultList();
  }

  @Override
  @Transactional
  public void update(Student student) {
    entityManager.merge(student);
  }

  @Override
  @Transactional
  public void remove(String id) {
    Student student = entityManager.find(Student.class, id);
    if (student != null) {
      entityManager.remove(student);
    }
  }
}
