package com.example.hibernatecrud;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        // CREATE
        Student s1 = new Student("Alice", "alice@example.com", 21);
        dao.saveStudent(s1);

        // READ
        System.out.println("\nFetching all students:");
        List<Student> students = dao.getAllStudents();
        students.forEach(System.out::println);

        // UPDATE
        s1.setAge(22);
        dao.updateStudent(s1);

        // READ by ID
        Student fetched = dao.getStudentById(s1.getId());
        System.out.println("\nFetched by ID: " + fetched);

        // DELETE
        dao.deleteStudent(s1.getId());

        HibernateUtil.shutdown();
    }
}
