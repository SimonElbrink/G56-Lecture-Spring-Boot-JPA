package se.lexicon.g56lecturespringbootjpa.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

}
