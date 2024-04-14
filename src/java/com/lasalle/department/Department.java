package com.lasalle.department;

import com.lasalle.genericPriorityQueue.myPriorityQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Department {

    private HashMap<String, Course> courseMap; //q valor es el string
    private ArrayList<Professor> listOfProfs;
    public myPriorityQueue<Professor> professorPriorityQueue = new myPriorityQueue<>();

    public int totalHours;


    public Department(ArrayList<Professor> listOfProfs) {
        this.courseMap = new HashMap<>(); //agregation
        this.listOfProfs = listOfProfs;  //
    }

    public HashMap<String, Course> getCourseMap() {
        return courseMap;
    }




//
//
    public void assignToProfessors(LinkedHashMap<String, Integer> courseSelection, ArrayList<Professor> professorsPrior) {
        for (Professor professor : professorsPrior) {
            read the pid to read the professorid_selection.txt file
            String filePath = "src/resources/" + professor.getpId() + "_selection.txt";
            File file = new File(filePath);
            //validate if the file exist or not
            if (!file.exists()) {
                continue;
            }
            //read the file
            LinkedHashMap<String, Integer> crsSelection = readProfessorSelection(filePath);
            //iterate over the map to get the total hours from the professors
            for (Map.Entry<String, Integer> entry : crsSelection.entrySet()) {
                //take the first line and assign it to the totalHours
                totalHours = entry.getValue();
                break;
            }
            //iterate over the map ad concatenate the values
            for (Map.Entry<String, Integer> entry2 : courseSelection.entrySet()) {
                //take the courseId and the groups
                String courseId = entry2.getKey();
                int requestedGroups = entry2.getValue();
                //take the course
                Course course = courseMap.get(courseId);
                //if the course is null or the number of groups is 0 continue
                if (course == null || course.getNumberOfGroups() == 0) {
                    continue;
                }
//                //take the discipline
//                String discipline = course.getDiscipline();
//                //if the discipline is not in the set of disciplines continue
//                if (!professor.getSetOfDisciplines().contains(discipline)) {
//                    continue;
//                }
//                //take the hrs from the course file dived it by 16 and assigned to the variable hrs AvaialblePerWeek
//                int hrsAvailablePerWeek = course.getNumberOfHours() /16;
//                //if the total hours is less than the hrsAvailablePerWeek continue
//                if (totalHours > hrsAvailablePerWeek) {
//                    continue;
//                }
//                professor.setAffectedCourses.add(new Course(c));
//
//


        }
    }
}























