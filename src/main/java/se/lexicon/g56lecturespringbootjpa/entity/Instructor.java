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
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;

    //If needed to have bidirectional
//    @OneToMany(mappedBy = "instructor")
//    private Set<Course> courses = new HashSet<>();

}
