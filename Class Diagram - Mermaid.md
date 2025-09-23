````mermaid
classDiagram
    class Student {
        - String id
        - String firstName
        - String lastName
        - String email
        - boolean status
        - LocalDateTime createDate
        - Address address
        - Set~courses~ courses
    }
    
    class Address{
        - Long id
        - String street
        - String city
        - String postalCode
        - String country
        - Student student
    }

    class Course {
        - Long id
        - String courseName
        - Instructor instructor
    }

    class Instructor {
        - Long id
        - String name
    }
    
    Student "1" <--> "1" Address: OneToOne
    Course "1" --> "0.*" Instructor : ManyToOne
    Student "0..*" --> "0..*" Course : ManyToMany
    

````