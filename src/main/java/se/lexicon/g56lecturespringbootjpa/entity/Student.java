package se.lexicon.g56lecturespringbootjpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(nullable = false, updatable = false)
    private String id;

    @Setter
    @Column(nullable = false, length = 100)
    private String firstName;

    @Setter
    @Column(nullable = false, length = 100)
    private String lastName;

    @Setter
    @ToString.Exclude
    @Column(nullable = false, length = 120, unique = true)
    private String email;

    private boolean status;
    private LocalDateTime createdDate;


    @OneToOne
    @JoinColumn(name = "address_id")
    @Setter
    private Address address;


    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @PrePersist
    private void onCreate(){
        this.status = true;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;
        return status == student.status && Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email) && Objects.equals(createdDate, student.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, status, createdDate);
    }


}
