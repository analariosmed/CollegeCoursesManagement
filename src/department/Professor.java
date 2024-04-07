package department;

import java.util.List;
import java.util.Set;
import java.time.LocalDate;

public class Professor implements Comparable<Professor> {
    private int pId;
    private String name;
    private String lastName;
    private double seniorityLevel;
    private String hiringDate;
    private Set<String> setOfDisciplines;
    private List<Course> affectedCourses;

    public Professor() {
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSeniorityLevel() {
        return seniorityLevel;
    }

    public void setSeniorityLevel(double seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }

    public CharSequence getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Set<String> getSetOfDisciplines() {
        return setOfDisciplines;
    }

    public void setSetOfDisciplines(Set<String> setOfDisciplines) {
        this.setOfDisciplines = setOfDisciplines;
    }

    public List<Course> getAffectedCourses() {
        return affectedCourses;
    }

    public void setAffectedCourses(List<Course> affectedCourses) {
        this.affectedCourses = affectedCourses;
    }

    @Override
    public int compareTo(Professor otherProfessor) {

        // Compare seniority level
        if (this.seniorityLevel > otherProfessor.seniorityLevel) {
            return 1; // This professor is more senior
        } else if (this.seniorityLevel < otherProfessor.seniorityLevel) {
            return -1; // Other professor is more senior
        } else {

            if (this.hiringDate != null && otherProfessor.getHiringDate() != null) {
                LocalDate thisHiringDate = LocalDate.parse(this.hiringDate);
                LocalDate otherHiringDate = LocalDate.parse(otherProfessor.getHiringDate());
              //  int dateComparison = thisHiringDate.compareTo(otherProfessor.getHiringDate());

                // Compare hiring dates
            //    if (dateComparison != 0) {
             //       return dateComparison; // Earlier hiring date comes first
            //    } else { // Hiring dates are also equal, compare IDs
           //         return this.pId - otherProfessor.pId; // Assuming pId is int
                }
          //  } else {
                throw new IllegalArgumentException("Both professors have null hiring dates!");
            }
        }
}
