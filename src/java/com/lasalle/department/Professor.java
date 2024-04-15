package com.lasalle.department;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;

/**
 * Represents a Professor with an ID, name, seniority level, hiring date, set of disciplines, and list of affected courses.
 * This class implements Comparable interface to compare professors based on their seniority level, hiring date and professor ID.
 */

public class Professor implements Comparable<Professor> {
    private int pId;
    private String name;
    private double seniorityLevel;
    private LocalDate hiringDate;
    private Set<String> setOfDisciplines;
    /**
     * List of courses that the Professor is currently teaching.
     */
    private List<Course> affectedCourses = new ArrayList<>();

    public Professor(int pId, String name, double seniorityLevel, LocalDate hiringDate, Set<String> setOfDisciplines) {
        this.pId = pId;
        this.name = name;
        this.seniorityLevel = seniorityLevel;
        this.hiringDate = hiringDate;
        this.setOfDisciplines = setOfDisciplines;

    }

    public Professor() {
    }


    public int getProfessorId() {
        return pId;
    }

    /**
     * Returns the set of disciplines that the Professor is qualified to teach.
     *
     * @return The set of disciplines that the Professor is qualified to teach.
     */
    public Set<String> getSetOfDisciplines() {
        return setOfDisciplines;
    }

    private LocalDate getHiringDate() {
        return hiringDate;
    }


    public List<Course> getAffectedCourses() {
        return affectedCourses;
    }

    /**
     * Compares this Professor with the specified Professor for order.
     *
     * @param otherProfessor The Professor to be compared.
     * @return A negative integer, zero, or a positive integer as this Professor has priority over the specified Professor.
     * @throws IllegalArgumentException if the Professor has null values.
     */
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


/**
 * Returns a string representation of the Professor.
 */
    @Override
    public String toString() {
        return "Professor{" +
                "pId=" + pId +
                ", name='" + name +
                ", seniorityLevel=" + seniorityLevel +
                ", hiringDate=" + hiringDate +
                ", setOfDisciplines=" + setOfDisciplines +
                ", affectedCourses=" + affectedCourses +
                '}';
    }

}

