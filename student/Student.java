package student;

public class Student {
    // Attributes
    private int rollNumber;
    private String name;
    private int age;
    private String course;
    private double gpa;

    // Constructor
    public Student(int rollNumber, String name, int age, String course, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.course = course;
        this.gpa = gpa;
    }

    // Getter methods
    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public double getGpa() {
        return gpa;
    }

    // Setter methods
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("----------------------------------");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("GPA: " + gpa);
        System.out.println("----------------------------------");
    }

    // Override toString method for easy printing
    @Override
    public String toString() {
        return "Student [Roll No: " + rollNumber + ", Name: " + name +
                ", Age: " + age + ", Course: " + course + ", GPA: " + gpa + "]";
    }
}
