````mermaid
---
title: Entity Relationship Diagram
---
erDiagram
    STUDENT {
        VARCHAR id PK "NN"
        VARCHAR(50) first_name "NN"
        VARCHAR(50) last_name "NN"
        VARCHAR email UK "NN"
        BOOLEAN status "DF = false"
        TIMESTAMP create_date "DF = NOW()"
        BIGINT address_id UK,FK
    }

    ADDRESS {
        BIGINT id PK "AI NN"
        VARCHAR street "NN"
        VARCHAR city "NN"
        VARCHAR postal_code "NN"
        VARCHAR country "NN"
    }

    INSTRUCTOR {
        BIGINT id PK "AI NN"
        VARCHAR name "NN"
    }

    COURSE {
        BIGINT id PK "AI NN"
        VARCHAR(80) course_name UK "NN"
        BIGINT instructor_id FK "NN"
    }

    ENROLLMENT {
        VARCHAR student_id FK "NN"
        BIGINT course_id FK "NN"
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