package com.lasalle;

import com.lasalle.department.Department;
import com.lasalle.department.Professor;
import com.lasalle.genericPriorityQueue.myPriorityQueue;

import java.util.ArrayList;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Department computerScience = new Department(new ArrayList<Professor>());

        computerScience.readProfessorsFromFile("src/resources/profs.txt");
        computerScience.readCoursesFromFile("src/resources/courses_f22.txt.csv");

        System.out.println("\n\n Display Computer Science List Of professors: ");
        computerScience.displayListOfProfessors();


        System.out.println("\n\n Display Computer Science CourseMap: ");
        computerScience.displayCourseMap();
        computerScience.readProfessorSelection("src/resources/5999_selection.txt");


        System.out.println("\n\nProfessors before processing: ");
        computerScience.processProfessors();














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
