package com.lasalle.department;

public class Course {
    private int id;
    private String title;
    private String discipline;
    private byte numberOfHours;
    private byte numberOfGroups;

    private Course(){
    }
    public Course(int id, String title, String discipline, byte numberOfHours, byte numberOfGroups) {
        this.id = id;
        this.title = title;
        this.discipline = discipline;
        this.numberOfHours = numberOfHours;
        this.numberOfGroups = numberOfGroups;
    }

    public Course(Course c){
        this.id = c.id;
        this.title = c.title;
        this.discipline = c.discipline;
        this.numberOfHours = c.numberOfHours;
        this.numberOfGroups = c.numberOfGroups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public byte getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(byte numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public byte getNumberOfGroups() {
        return numberOfGroups;
    }

    public void setNumberOfGroups(byte numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
    }
}
