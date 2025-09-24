package se.lexicon.g56lecturespringbootjpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @Getter
    @Transient
    private LocalDate date;
    @Getter
    @Transient
    private LocalTime time;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", unique = true)
    @Setter
    private Address address;

    @ManyToMany
    @JoinTable( // OneToMany x2
            name = "students_courses", //name of the join Table
            joinColumns = @JoinColumn(name= "student_id"), // Owning Side
            inverseJoinColumns = @JoinColumn(name ="course_id") // Target Entity
    )
    private Set<Course> courses = new HashSet<>();



    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @PrePersist
    private void onCreate(){
        this.status = true;
        this.createdDate = LocalDateTime.now();
        this.date = createdDate.toLocalDate();
        this.time = createdDate.toLocalTime();

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


    //Convenience method
    public void enrollCourse(Course course) {
        this.courses.add(course);
    }

    //Convenience method
    public void dropCourse(Course course) {
        this.courses.remove(course);
    }
}
