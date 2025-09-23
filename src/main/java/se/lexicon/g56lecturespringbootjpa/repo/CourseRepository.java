package se.lexicon.g56lecturespringbootjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.g56lecturespringbootjpa.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
