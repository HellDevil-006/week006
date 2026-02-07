package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base Employee Class
abstract class Employee {
    protected String name;
    protected int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

// Full-Time Employee
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// Part-Time Employee
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

public class PayrollSystem {
    private static List<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Payroll System");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Display All Salaries");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addFullTimeEmployee();
                    break;
                case "2":
                    addPartTimeEmployee();
                    break;
                case "3":
                    displayAllSalaries();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addFullTimeEmployee() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Monthly Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());

        employees.add(new FullTimeEmployee(name, id, salary));
        System.out.println("Full-Time Employee Added.");
    }

    private static void addPartTimeEmployee() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Hourly Rate: ");
        double rate = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Hours Worked: ");
        int hours = Integer.parseInt(scanner.nextLine());

        employees.add(new PartTimeEmployee(name, id, rate, hours));
        System.out.println("Part-Time Employee Added.");
    }

    private static void displayAllSalaries() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\n--- Employee Salaries ---");
            for (Employee emp : employees) {
                emp.displayDetails();
                System.out.println("Salary: " + emp.calculateSalary());
                System.out.println("-------------------------");
            }
        }
    }
}
