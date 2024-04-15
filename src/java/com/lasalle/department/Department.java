package com.lasalle.department;

import com.lasalle.genericPriorityQueue.MyPriorityQueue;
import com.lasalle.utils.Utilities;

import java.io.*;
import java.util.*;

public class Department {

    /**
     * Fields for Department class, set MAx_Hours to 30(project requirement)
     */
    public static final int MAX_HOURS = 30;
    /**
     * A map to store courses offered by the department, where the key is the course ID (String) and the value is the corresponding Course object.
     */
    private HashMap<String, Course> courseMap; //q valor es el string
    private ArrayList<Professor> listOfProfs;


    /**
     * Constructs a Department object with a given list of professors.
     *
     * @param listOfProfs The list of professors for the department.
     */
    public Department(ArrayList<Professor> listOfProfs) {
        this.courseMap = new HashMap<>(); //aggregation
        this.listOfProfs = listOfProfs;  //composition
    }

    public HashMap<String, Course> getCourseMap() {
        return courseMap;
    }

    /**
     * Sets the course map for the department.
     *
     * @param courseMap The new HashMap containing course information.
     */
    public void setCourseMap(HashMap<String, Course> courseMap) {
        this.courseMap = courseMap;
    }

    /**
     * Creates a priority queue containing all professors in the department using our priorityQueue.
     *
     * @return A MyPriorityQueue object containing all professors.
     */
    public MyPriorityQueue<Professor> queueProfessors() {
        MyPriorityQueue<Professor> professorPriorityQueue = new MyPriorityQueue<>();
        for (Professor professor : listOfProfs) {
            professorPriorityQueue.enqueue(professor);
        }
        return professorPriorityQueue;
    }

    /**
     * Processes course selection for a professor based on information in a text file.
     *
     * This method iterates through lines in a professor selection file until the end of the file is reached or the professor's requested hours are fulfilled.
     * For each line:
     *   - Parses the course ID and number of groups requested.
     *   - Retrieves the course object from the department's course map.
     *   - Checks if the course exists and skips if not.
     *   - Creates a copy (`courseAffected`) of the retrieved course object to avoid modifying the original course data.
     *   - Verifies if the professor's discipline matches the course's discipline.
     *   - Calculates the hours per week for the course by dividing the total number of hours by 15 (assuming a standard semester format).
     *   - If the professor can teach the course:
     *     - Determines the minimum number of groups to assign between the course's current number and the professor's request.
     *     - Iterates up to the minimum number of groups:
     *       - Checks if assigning another group would exceed the professor's requested hours.
     *       - Decrements the original course's number of groups and increments the copy's number of groups (representing assigned groups).
     *       - Increments the `hoursGaveToTeacher` counter to track assigned hours.
     *     - Adds the copy (`courseAffected`) to the professor's list of affected courses (presumably for tracking purposes).
     *   - Prints informative messages throughout the process.
     *
     * @throws FileNotFoundException If the professor selection file cannot be found.
     */
    public void processProfessors() throws FileNotFoundException {
        MyPriorityQueue<Professor> professorPriorityQueue = queueProfessors();
        while (!professorPriorityQueue.isEmpty()) {
            System.out.println("Processing professor: " + professorPriorityQueue.peek().getProfessorId());
            Professor professor = professorPriorityQueue.dequeue();
            //open professor file
            String filePath = "src/resources/" + professor.getProfessorId() + "_selection.txt";
            File file = new File(filePath);
            //validate file existence
            if (!file.exists()) {
                System.out.println("File does not exist: " + filePath);
                continue;
            }

            Scanner reader = new Scanner(new FileReader(filePath));
            String requestedHoursLine = reader.nextLine();
            int hoursRequested = Integer.parseInt(requestedHoursLine.trim()); //get the requested hours first line from the file
            // Limit requested hours to maximum allowed
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

                // Find the course in the department's course map
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
