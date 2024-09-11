package com.lasalle.utils;

import com.lasalle.department.Course;
import com.lasalle.department.Professor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Utilities {

    public static ArrayList<Professor> readProfessorsFromFile(String filePath) {
        ArrayList<Professor> listOfProfs = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                Set<String> myProfDisciplines = new HashSet<>();
                String[] parts = line.split(":");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");// give format for index 3
                String[] disciplines = parts[4].split(",");//array of disciplines by ,
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



    public static HashMap<String, Course>  readCoursesFromFile(String filePath) {
        HashMap<String, Course> mapCourses = new HashMap<String, Course>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                Course course = new Course(parts[0], parts[1], parts[2], Byte.parseByte(parts[3].trim()), Byte.parseByte(parts[5].trim()));
                mapCourses.put(parts[0].trim(), course); //0 to course Id and value course for next in map
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapCourses;
    }


    public static void displayListOfProfessors(List<Professor> professorList) {
        for (Professor professor : professorList) {
            System.out.println(professor);
        }
    }

    public static void displayCourseMap(HashMap<String, Course> mapCourses) {
        for (Map.Entry<String, Course> entry : mapCourses.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

}
