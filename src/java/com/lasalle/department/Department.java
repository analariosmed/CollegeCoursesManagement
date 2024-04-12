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
                    this.listOfProfs.add(prof);
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
                    this.getCourseMap().put(parts[0], course);
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
    public void displayCourseMap() {
        for (Map.Entry<String, Course> entry : courseMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }



    }



