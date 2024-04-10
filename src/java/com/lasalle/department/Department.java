package com.lasalle.department;
import com.lasalle.department.Professor;

import java.util.HashMap;
import java.util.ArrayList;

public class Department {

    private static HashMap<String, Course> courseMap; //q valor es el string
    private ArrayList<Professor> listOfProfs;

    public Department(ArrayList<Professor> listOfProfs) {
        this.courseMap = new HashMap<>(); //agregation
        this.listOfProfs = listOfProfs;  //
    }

    public static HashMap<String, Course> getCourseMap() {
        return courseMap;
    }

    public void setCourseMap(HashMap<String, Course> courseMap) {
        this.courseMap = courseMap;
    }

    public ArrayList<Professor> getListOfProfs() {
        return listOfProfs;
    }

    public void setListOfProfs(ArrayList<Professor> listOfProfs) {
        this.listOfProfs = listOfProfs;
    }

}