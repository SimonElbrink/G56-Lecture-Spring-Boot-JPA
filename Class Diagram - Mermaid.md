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
    
    Student "1" <--> "1" Address

````