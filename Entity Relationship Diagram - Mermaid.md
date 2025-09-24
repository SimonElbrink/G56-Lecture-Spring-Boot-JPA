````mermaid
---
title: Entity Relationship Diagram
---
erDiagram
    STUDENT {
        string id PK
        string first_name
        string last_name
        string email UK
        boolean status
        datetime create_date
        long address_id UK,FK
    }

    ADDRESS {
        long id PK
        string street
        string city
        string postal_code
        string country
    }

    INSTRUCTOR {
        long id PK
        string name
    }

    COURSE {
        long id PK
        string course_name UK
        long instructor_id FK
    }

    ENROLLMENT {
        string student_id FK
        long course_id FK
    }

%% Relationships
    STUDENT ||--|| ADDRESS: has_address
    INSTRUCTOR ||--o{ COURSE: teaches
    STUDENT ||--o{ ENROLLMENT: enrolls
    COURSE ||--o{ ENROLLMENT: has
````
### Relationship descriptions: 
* Student has one and only one address.  
* Address has one and only one student.  
* Students can enroll in zero or more courses.   
* Course has zero or more students.  
* Instructor teaches zero or more courses.  
* Course has one and only one instructor. 

> Student ↔ Course relationship is handled with a join table, bridging the gap between the two tables.