package com.lasalle.department;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;



public class Professor implements Comparable<Professor> {
    private int pId;
    private String name;
    private double seniorityLevel;
    private LocalDate hiringDate;
    private Set<String> setOfDisciplines;
    private List<Course> affectedCourses= null ;

    public Professor(int pId, String name, double seniorityLevel, LocalDate hiringDate, Set<String> setOfDisciplines) {
        this.pId = pId;
        this.name = name;
        this.seniorityLevel = seniorityLevel;
        this.hiringDate = hiringDate;
        this.setOfDisciplines = setOfDisciplines;

    }

    public Professor(){}


    public int getpId() {
        return pId;
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

    private LocalDate getHiringDate() {
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
            LocalDate thisHiringDate = this.hiringDate;
            LocalDate otherHiringDate = otherProfessor.getHiringDate();
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

    @Override
    public String toString() {
        return "Professor{" +
                "pId=" + pId +
                ", name='" + name  +
                ", seniorityLevel=" + seniorityLevel +
                ", hiringDate=" + hiringDate +
                ", setOfDisciplines=" + setOfDisciplines +
                ", affectedCourses=" + affectedCourses +
                '}';

    }

}

