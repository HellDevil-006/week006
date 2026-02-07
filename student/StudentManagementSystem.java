package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    // List to store student objects
    private List<Student> studentList;
    private Scanner scanner;

    // Constructor
    public StudentManagementSystem() {
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add a new student
    public void addStudent() {
        System.out.println("\n=== Add New Student ===");

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();

        // Create student object and add to list
        Student student = new Student(rollNumber, name, age, course, gpa);
        studentList.add(student);

        System.out.println("\n✓ Student added successfully!");
    }

    // Method to add student with parameters (for programmatic use)
    public void addStudent(int rollNumber, String name, int age, String course, double gpa) {
        Student student = new Student(rollNumber, name, age, course, gpa);
        studentList.add(student);
        System.out.println("Student " + name + " added successfully!");
    }

    // Method to display all students
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("\nNo students in the system.");
            return;
        }

        System.out.println("\n=== All Students ===");
        System.out.println("Total Students: " + studentList.size());
        System.out.println();

        for (Student student : studentList) {
            student.displayDetails();
        }
    }

    // Method to display student by roll number
    public void displayStudentByRollNumber(int rollNumber) {
        for (Student student : studentList) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("\n=== Student Found ===");
                student.displayDetails();
                return;
            }
        }
        System.out.println("\nStudent with Roll Number " + rollNumber + " not found.");
    }

    // Method to search students by course
    public void displayStudentsByCourse(String course) {
        System.out.println("\n=== Students in " + course + " ===");
        boolean found = false;

        for (Student student : studentList) {
            if (student.getCourse().equalsIgnoreCase(course)) {
                student.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found in " + course);
        }
    }

    // Method to get total number of students
    public int getTotalStudents() {
        return studentList.size();
    }

    // Method to display menu
    public void displayMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║  STUDENT MANAGEMENT SYSTEM MENU    ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student by Roll Number");
        System.out.println("4. Display Students by Course");
        System.out.println("5. Exit");
        System.out.print("\nEnter your choice: ");
    }

    // Main method to run the system
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        // Adding some sample students
        System.out.println("Adding sample students...\n");
        sms.addStudent(101, "Alice Johnson", 20, "Computer Science", 3.8);
        sms.addStudent(102, "Bob Smith", 21, "Electrical Engineering", 3.5);
        sms.addStudent(103, "Charlie Brown", 19, "Computer Science", 3.9);
        sms.addStudent(104, "Diana Prince", 22, "Mechanical Engineering", 3.7);
        sms.addStudent(105, "Eve Williams", 20, "Computer Science", 3.6);

        boolean running = true;

        while (running) {
            sms.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    sms.addStudent();
                    break;

                case 2:
                    sms.displayAllStudents();
                    break;

                case 3:
                    System.out.print("\nEnter Roll Number to search: ");
                    int rollNumber = scanner.nextInt();
                    sms.displayStudentByRollNumber(rollNumber);
                    break;

                case 4:
                    System.out.print("\nEnter Course name: ");
                    String course = scanner.nextLine();
                    sms.displayStudentsByCourse(course);
                    break;

                case 5:
                    System.out.println("\n✓ Thank you for using Student Management System!");
                    running = false;
                    break;

                default:
                    System.out.println("\n✗ Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
