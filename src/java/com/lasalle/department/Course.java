package com.lasalle.department;


public class Course {
    private String id;
    private String title;
    private String discipline;
    private byte numberOfHours;
    private byte numberOfGroups;

    public Course() {
    }

    public Course(String id, String title, String discipline, byte numberOfHours, byte numberOfGroups) {
        this.id = id;
        this.title = title;
        this.discipline = discipline;
        this.numberOfHours = numberOfHours;
        this.numberOfGroups = numberOfGroups;
    }

    public Course(Course c) {
        this.id = c.id;
        this.title = c.title;
        this.discipline = c.discipline;
        this.numberOfHours = c.numberOfHours;
        this.numberOfGroups = c.numberOfGroups;
    }

    public String getId() {
        return id;
    }


    public String getDiscipline() {
        return discipline;
    }


    public byte getNumberOfHours() {
        return numberOfHours;
    }


    public byte getNumberOfGroups() {
        return numberOfGroups;
    }

    public void setNumberOfGroups(byte numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
    }


    @Override
    public String toString() {
        return "\nCourse ID: " + id + " Number of Groups: " + numberOfGroups;
    }
}
