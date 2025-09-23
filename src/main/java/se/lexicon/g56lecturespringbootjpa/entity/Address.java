package se.lexicon.g56lecturespringbootjpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String street;
    @NonNull
    @Column(nullable = false)
    private String city;
    @NonNull
    @Column(nullable = false, length = 6)
    private String postalCode;
    @NonNull
    private String country;

    @OneToOne(mappedBy = "address")
    private Student student;

}
