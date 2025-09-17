package se.lexicon.g56lecturespringbootjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

}
