package com.lasalle.department;

import com.lasalle.genericPriorityQueue.MyPriorityQueue;
import com.lasalle.utils.Utilities;

import java.io.*;
import java.util.*;

public class Department {

    public static final int MAX_HOURS = 30;
    private HashMap<String, Course> courseMap; //q valor es el string
    private ArrayList<Professor> listOfProfs;


    public Department(ArrayList<Professor> listOfProfs) {
        this.courseMap = new HashMap<>(); //agregation
        this.listOfProfs = listOfProfs;  //composition
    }

    public HashMap<String, Course> getCourseMap() {
        return courseMap;
    }

    public void setCourseMap(HashMap<String, Course> courseMap) {
        this.courseMap = courseMap;
    }


    public MyPriorityQueue<Professor> queueProfessors() {
        MyPriorityQueue<Professor> professorPriorityQueue = new MyPriorityQueue<>();
        for (Professor professor : listOfProfs) {
            professorPriorityQueue.enqueue(professor);
        }
        return professorPriorityQueue;
    }

    public void processProfessors() throws FileNotFoundException {
        MyPriorityQueue<Professor> professorPriorityQueue = queueProfessors();
        while (!professorPriorityQueue.isEmpty()) {
            System.out.println("Processing professor: " + professorPriorityQueue.peek().getProfessorId());
            Professor professor = professorPriorityQueue.dequeue();
            //open professor file
            String filePath = "src/resources/" + professor.getProfessorId() + "_selection.txt";
            File file = new File(filePath);
            //validate if the file exist or not
            if (!file.exists()) {
                System.out.println("File does not exist: " + filePath);
                continue;
            }

            Scanner reader = new Scanner(new FileReader(filePath));
            String requestedHoursLine = reader.nextLine();
            int hoursRequested = Integer.parseInt(requestedHoursLine.trim()); //get the requested hours first line from the file
            if (hoursRequested > MAX_HOURS) {
                System.out.println("Professor " + professor.getProfessorId() + " is requesting more than 30 hours, we will give him 30 hours.");
                hoursRequested = MAX_HOURS;
            }
            System.out.println("hoursRequested per week : " + hoursRequested);


            int hoursGaveToTeacher = 0;
            while (hoursGaveToTeacher < hoursRequested && reader.hasNext()) { //while() not more than total hours and is not the end of the file (prof selection)
                System.out.println("\n\n\nhoursGaveToTeacher : " + hoursGaveToTeacher);

                String[] parts = reader.nextLine().split(", "); // get next line from the file selection
                String courseIdSelected = parts[0].trim();
                int groupsRequested = Integer.parseInt(parts[1].trim());

                Course currentCourse = courseMap.get(courseIdSelected);
                if (currentCourse == null) {
                    System.out.println("Course not found: " + courseIdSelected);
                    continue;
                }
                String courseDiscipline = currentCourse.getDiscipline().trim(); //check if has the discipline (can  not be null cause is empty by default)
                Course courseAffected = new Course(currentCourse);  //copy constructor to the copy of course
                courseAffected.setNumberOfGroups((byte) 0);

                System.out.println("professor  " + professor.getProfessorId() + " is requesting " + groupsRequested + " groups for course : " + courseIdSelected);
                int hoursPerWeekPerCourse = currentCourse.getNumberOfHours() / 15;
                System.out.println("course " + currentCourse.getId() + " has " + currentCourse.getDiscipline() + " disciplines and " + currentCourse.getNumberOfGroups() + " groups" + " and " + currentCourse.getNumberOfHours() + " hours per season (= " + hoursPerWeekPerCourse + " hours per week)");
                System.out.println("professor can teach those disciplines " + professor.getSetOfDisciplines());

                if (professor.getSetOfDisciplines().contains(courseDiscipline)) {
                    System.out.println("professor can teach course");


                    byte numberOfGroupsInCourse = (byte) Math.min(currentCourse.getNumberOfGroups(), groupsRequested);
                    for (int i = 0; i < numberOfGroupsInCourse; i++) {
                        System.out.println("we have " + currentCourse.getNumberOfGroups() + "/" + groupsRequested + "  (groupsInTheCourse/groupsRequested) groups to give for course : " + courseIdSelected);


                        if (hoursRequested < (hoursGaveToTeacher + hoursPerWeekPerCourse)) { // check if we WILL be able to give the hours to the professor
                            System.out.println("prof can't have more hours: " + hoursGaveToTeacher + " hours");
                            break;
                        }
                        System.out.println("prof can have one more group: " + courseAffected.getNumberOfGroups() + "/" + groupsRequested + " (groupsAffected/groupsRequested) for a total of " + hoursGaveToTeacher + " hours");

                        currentCourse.setNumberOfGroups((byte) (currentCourse.getNumberOfGroups() - 1));
                        courseAffected.setNumberOfGroups((byte) (courseAffected.getNumberOfGroups() + 1)); //change the number of groups and put it the affectedcourses at professor

                        hoursGaveToTeacher += hoursPerWeekPerCourse;// then give the hours

                    }
                    professor.getAffectedCourses().add(courseAffected);
                    System.out.println("prof got " + courseAffected.getNumberOfGroups() + " groups for course " + courseAffected.getId() + " out of " + groupsRequested + " requested for a total of " + hoursGaveToTeacher + " hours");

                } else {
                    System.out.println("professor can't teach course");
                    break;
                }
            }
            reader.close();
        }
        System.out.println("\n\n\nfinal mapping :");
        Utilities.displayListOfProfessors(listOfProfs);
    }
}
