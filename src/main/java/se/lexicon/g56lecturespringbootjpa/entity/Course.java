package se.lexicon.g56lecturespringbootjpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String CourseName;

    @NonNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

//    @ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST)
//    private Set<Student> students = new HashSet<>();

}
