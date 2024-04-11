# Java Project Title

This is a Java project that includes classes for managing a department in a university. The main classes are `Professor` and `Course`.

## Installation

1. Clone the repository: `git clone https://github.com/analariosmed/your-repo.git`
2. Navigate to the project directory: `cd your-repo`
3. Compile the project: `javac src/java/com/lasalle/Main.java`

## Usage

Run the project using the command: `java src/java/com/lasalle/Main`

## Class diagram 

```mermaid
classDiagram
    class Department {
        -Map<String, Course> courseMap
        +Map<String, Course> getCourseMap()
        +void setCourseMap(Map<String, Course>)
    }
    class Professor {
        -int pId
        -String name
        -double seniorityLevel
        -LocalDate hiringDate
        -Set<String> setOfDisciplines
        -List<Course> affectedCourses
        +Professor(int, String, double, LocalDate, Set<String>)
        +double getSeniorityLevel()
        +void setSeniorityLevel(double)
        +Set<String> getSetOfDisciplines()
        +void setSetOfDisciplines(Set<String>)
        +List<Course> getAffectedCourses()
        +void setAffectedCourses(List<Course>)
        +int compareTo(Professor)
        +boolean canProfessorTeachCourse(Professor, String)
    }
    class Course {
        -int id
        -String title
        -String discipline
        -byte numberOfHours
        -byte numberOfGroups
        +Course(int, String, String, byte, byte)
        +Course(Course)
        +int getId()
        +void setId(int)
        +String getTitle()
        +void setTitle(String)
        +String getDiscipline()
        +void setDiscipline(String)
        +byte getNumberOfHours()
        +void setNumberOfHours(byte)
        +byte getNumberOfGroups()
        +void setNumberOfGroups(byte)
    }
    Department --> "*" Course : contains
    Professor "1" --> "*" Course : has
```