package com.student.main;

import com.student.dao.StudentDAO;
import com.student.model.Student;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Course: ");
                        String course = sc.nextLine();
                        System.out.print("Marks: ");
                        double marks = Double.parseDouble(sc.nextLine());
                        Student s = new Student(0, name, email, course, marks);
                        System.out.println(dao.addStudent(s) ? "Student added!" : "Failed to add.");
                        break;

                    case 2:
                        List<Student> list = dao.getAllStudents();
                        if (list.isEmpty()) {
                            System.out.println("No records found.");
                        } else {
                            list.forEach(System.out::println);
                        }
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        Student found = dao.getStudentById(Integer.parseInt(sc.nextLine()));
                        System.out.println(found != null ? found : "Student not found.");
                        break;

                    case 4:
                        System.out.print("Enter ID to update: ");
                        int uid = Integer.parseInt(sc.nextLine());
                        if (dao.getStudentById(uid) == null) {
                            System.out.println("Student not found.");
                            break;
                        }
                        System.out.print("New Name: ");
                        String newName = sc.nextLine();
                        System.out.print("New Email: ");
                        String newEmail = sc.nextLine();
                        System.out.print("New Course: ");
                        String newCourse = sc.nextLine();
                        System.out.print("New Marks: ");
                        double newMarks = Double.parseDouble(sc.nextLine());
                        System.out.println(dao.updateStudent(new Student(uid, newName, newEmail, newCourse, newMarks))
                                ? "Updated!" : "Update failed.");
                        break;

                    case 5:
                        System.out.print("Enter ID to delete: ");
                        System.out.println(dao.deleteStudent(Integer.parseInt(sc.nextLine()))
                                ? "Deleted!" : "Student not found.");
                        break;

                    case 6:
                        System.out.println("Goodbye!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
