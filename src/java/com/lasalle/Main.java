package com.lasalle;

import com.lasalle.department.Course;
import com.lasalle.department.Department;
import com.lasalle.department.Professor;
import com.lasalle.utils.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        ArrayList<Professor> listOfProfs = Utilities.readProfessorsFromFile("src/resources/profs.txt");
        HashMap<String, Course> hasMapCourse = Utilities.readCoursesFromFile("src/resources/courses_f22.txt.csv");
        Department computerScience = new Department(listOfProfs);
        computerScience.setCourseMap(hasMapCourse);

        System.out.println("\n\n Display Computer Science List Of professors: ");
        Utilities.displayListOfProfessors(listOfProfs);

        System.out.println("\n\n Display Computer Science CourseMap: ");
        Utilities.displayCourseMap(hasMapCourse);

        System.out.println("\n\nStart processing Professors: ");
        computerScience.processProfessors();
    }

}
