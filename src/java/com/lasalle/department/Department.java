package com.lasalle.department;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Department {

    private HashMap<String, Course> courseMap; //q valor es el string
    private ArrayList<Professor> listOfProfs;

    public Department(ArrayList<Professor> listOfProfs) {
        this.courseMap = new HashMap<>(); //agregation
        this.listOfProfs = listOfProfs;  //
    }

    public HashMap<String, Course> getCourseMap() {
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


        public void readProfessorsFromFile(String filePath) {
           // ArrayList<Professor> listOfProfs = new ArrayList<>();
            PriorityQueue<Professor> profProcessingQueue = new PriorityQueue<>();
            Set<String> myProfDisciplines = new HashSet<>();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
                    Professor prof = new Professor(Integer.parseInt(parts[0].trim()), parts[1].trim(),
                            Double.parseDouble(parts[2].trim()), LocalDate.parse(parts[3].trim(), formatter),
                            myProfDisciplines);
                    this.listOfProfs.add(prof);
                    profProcessingQueue.add(prof);
                    myProfDisciplines.add(parts[4]);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public void readCoursesFromFile(String filePath) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    Course course = new Course(parts[0], parts[1], parts[2], Byte.parseByte(parts[3].trim()), Byte.parseByte(parts[5].trim()));
                    getCourseMap().put(parts[0], course);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

            public void displayProfessors() {
                for (Professor professor : listOfProfs) {
                    System.out.println(professor);
                }
    }


    }



