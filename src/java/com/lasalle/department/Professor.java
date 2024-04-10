package com.lasalle.department;

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
    private List<Course> affectedCourses = null;

    public Professor(int pId, String name, String lastName, double seniorityLevel, String hiringDate, Set<String> setOfDisciplines) {
        this.pId = pId;
        this.name = name;
        this.lastName = lastName;
        this.seniorityLevel = seniorityLevel;
        this.hiringDate = hiringDate;
        this.setOfDisciplines = setOfDisciplines;
    }



    public double getSeniorityLevel() {
        return seniorityLevel;
    }

    public void setSeniorityLevel(double seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }


    public Set<String> getSetOfDisciplines() {
        return setOfDisciplines;
    }

    private String getHiringDate() {
        return hiringDate;
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
        if (this.equals(otherProfessor))
            return 0;
        if (this.seniorityLevel > otherProfessor.seniorityLevel)
            return 1;
        else if (this.seniorityLevel == otherProfessor.seniorityLevel) {
            LocalDate thisHiringDate = LocalDate.parse(this.hiringDate);
            LocalDate otherHiringDate = LocalDate.parse(otherProfessor.getHiringDate());
            int dateComparison = thisHiringDate.compareTo(otherHiringDate);
            if (dateComparison < 0) //if is 0 is because is smaller than the other
                return 1;
            else if (dateComparison > 0)
                return -1;
            else {
                if (this.pId < otherProfessor.pId)
                    return 1;
                else
                    return -1;
            }
        } else
            throw new IllegalArgumentException("Professor have null values!");
    }///tyr catch for null values, just the ones we can taste



    public boolean canProfessorTeachCourse(Professor professor, String courseId) {
        ///get the course from the hasmap of the java.com.lasalle.department
        Course course = Department.getCourseMap().get(courseId);
        ///this course is part of which discipline
        String discipline = course.getDiscipline();
        //does my set of discipline contains the discipline of the course
        return professor.getSetOfDisciplines().contains(discipline);
    }
}

