package io;

import model.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentIO {
    private static final Path studentsPath = Paths.get("src/data/students-data.dat");
    private static final File studentsFile = studentsPath.toFile();
    private static List<Student> students = getAll();

    private StudentIO() {
    }
    public static List<Student> getAll() {
        if (students != null) {
            return students;
        }

        students = new ArrayList<>();
        if (Files.exists(studentsPath)) {
            try (BufferedReader in = new BufferedReader(
                    new FileReader(studentsFile)
            )) {
                String line = in.readLine();
                while(line != null) {
                    String[] columns = line.split(",");
                    String id = columns[0];
                    String name = columns[1];
                    String dob = columns[2];
                    String classroom = columns[3];
                    String subject = columns[4];

                    Student s = new Student();
                    s.setId(id);
                    s.setName(name);
                    s.setDateOfBirth(dob);
                    s.setClassroom(classroom);
                    s.setSubject(subject);
                    students.add(s);

                    line = in.readLine();
                }

            } catch (IOException e) {
                System.out.println(e);
                return null;
            }
        }
        return students;
    }
    public static Student get(String id) {
        students = getAll();
        if (students == null) {
            System.out.println("Error!. Unable to get student.");
        }
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public static boolean saveAll() {
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(studentsFile)))) {
            for (Student std : students) {
                out.print(std.getId() + ",");
                out.print(std.getName() + ",");
                out.print(std.getDateOfBirth() + ",");
                out.print(std.getClassroom() + ",");
                out.println(std.getSubject());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static boolean add(Student std) {
        students.add(std);
        return saveAll();
    }
    public static boolean update(Student newStudent) {
        students = getAll();

        Student oldStudent = get(newStudent.getId());
        int i = students.indexOf(oldStudent);
        students.remove(i);

        students.add(i, newStudent);

        return saveAll();
    }
    public static boolean delete(Student s) {
        students = getAll();
        students.remove(s);
        return saveAll();
    }
}
