package com.lasalle;

import com.lasalle.department.Course;
import com.lasalle.department.Department;
import com.lasalle.department.Professor;
import com.lasalle.genericPriorityQueue.myPriorityQueue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Department computerScience;

    public static ArrayList<Professor> readProfessorsFromFile(String filePath) {
        ArrayList<Professor> listOfProfs = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                Set<String> myProfDisciplines = new HashSet<>();
                String[] parts = line.split(":");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
                String[] disciplines = parts[4].split(",");
                for (String discipline : disciplines) {
                    myProfDisciplines.add(discipline.trim());
                }
                Professor prof = new Professor(Integer.parseInt(parts[0].trim()), parts[1].trim(),
                        Double.parseDouble(parts[2].trim()), LocalDate.parse(parts[3].trim(), formatter),
                        myProfDisciplines);
                listOfProfs.add(prof);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfProfs;
    }

    public void displayListOfProfessors(Set<Professor> listOfProfs) {
        for (Professor professor : listOfProfs) {
            System.out.println(professor);
        }
    }

    public static HashMap<String, Course>  readCoursesFromFile(String filePath) {
        HashMap<String, Course> mapCourses = new HashMap<String, Course>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                Course course = new Course(parts[0], parts[1], parts[2], Byte.parseByte(parts[3].trim()), Byte.parseByte(parts[5].trim()));
                computerScience.getCourseMap().put(parts[0], course);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapCourses;
    }

    public void displayCourseMap(HashMap<String, Course> mapCourses) {
        for (Map.Entry<String, Course> entry : mapCourses.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public static LinkedHashMap<String, Integer> readProfessorSelection(String filePath) {
        LinkedHashMap<String, Integer> courseSelection = new LinkedHashMap<>();
        int totalHours = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String requestedHoursLine = reader.readLine();
            totalHours = Integer.parseInt(requestedHoursLine.trim()); // to get the first line from my file and assign it to totalHours
            String courseLine;
            while ((courseLine = reader.readLine()) != null) {
                String[] parts = courseLine.split(", ");
                String courseId = parts[0].trim();
                int groups = Integer.parseInt(parts[1].trim());
                courseSelection.put(courseId, groups);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courseSelection;
    }

    public void displayCourseSelection(LinkedHashMap<String, Integer> courseSelection) {
        for (Map.Entry<String, Integer> entry : courseSelection.entrySet()) {
            System.out.println("Course ID: " + entry.getKey() + ", Groups: " + entry.getValue());
        }
    }

    public processProfessors() {
        ArrayList<Professor> processedProfessors = new ArrayList<>();
        for (Professor professor : this.listOfProfs) {
            this.professorPriorityQueue.enqueue(professor);
        }

        while (!this.professorPriorityQueue.isEmpty()) {
            Professor professor = this.professorPriorityQueue.dequeue();
            //open professor file
            //read the pid to read the professorid_selection.txt file
            String filePath = "src/resources/" + professor.getpId() + "_selection.txt";
            File file = new File(filePath);
            if (!file.exists()) {
                continue;
            }
            // get the hours from the professor
            LinkedHashMap<String, Integer> crsSelectionMap = readProfessorSelection(filePath);
            for (Map.Entry<String, Integer> entry : crsSelectionMap.entrySet()) {
                //take the first line and assign it to the totalHours
                totalHours = entry.getValue();
                break;
            }
//            while() not more than total hours and is not the end of the file
//            process
//            dequeue de professor
//            get the requested hours
//            get the selection
//             check if is not null and if has the discipline
//            copy constructor to copy the course change the number of groups and put it the affectedcourses at professor


            processedProfessors.add(professor);
            System.out.println(professor);
        }

        }




    public static void main(String[] args) {
        ArrayList<Professor> listOfProfs = readProfessorsFromFile("src/resources/profs.txt");

        computerScience = new Department(listOfProfs);

        readCoursesFromFile("src/resources/courses_f22.txt.csv");

        System.out.println("\n\n Display Computer Science List Of professors: ");
        computerScience.displayListOfProfessors();


        System.out.println("\n\n Display Computer Science CourseMap: ");
        computerScience.displayCourseMap();

        System.out.println("\n\nProfessors before processing: ");
        computerScience.processProfessors();
        computerScience.readProfessorSelection("src/resources/5999_selection.txt");
        computerScience.displayCourseSelection(computerScience.readProfessorSelection("src/resources/5999_selection.txt"));
        System.out.println(computerScience.totalHours);
        computerScience.assignToProfessors(courseSelection, processedProfessors);












    }































//        myQueue q1 = new myQueue();
//        q1.enqueue(10);
//        q1.enqueue(5);
//        q1.enqueue(20);
//        q1.enqueue(15);
//        q1.enqueue(25);
//        q1.enqueue(40);
//        q1.enqueue(35);
//        q1.enqueue(30);
//
//        q1.dequeue();
//        q1.dequeue();
//        q1.dequeue();
//        q1.dequeue();
//        q1.dequeue();
//        q1.dequeue();
//
//        q1.enqueue(10);
//        q1.enqueue(5);
//
//        //q1.displayAllElements();
//
//        myPriorityQueue<Integer> q2 = new myPriorityQueue<Integer>();
//        q2.enqueue(10);
//        q2.enqueue(5);
//        q2.enqueue(20);
//        q2.enqueue(15);
//        q2.enqueue(25);
//        q2.enqueue(40);
//        q2.enqueue(35);
//        q2.enqueue(30);
//
//
//        q2.dequeue();
//
//        q2.displayAllElements();

        //q2.displayHigherElements(16);


//        Professor p1 = new Professor(11111, "Michelle", "Khalife", 3, "2017-23-01", <>);
    }
