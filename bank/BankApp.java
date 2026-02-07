package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base Class
abstract class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public abstract void withdraw(double amount);

    public void display() {
        System.out.println("Acc Num: " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// Savings Account
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Type: Savings, Interest Rate: " + interestRate + "%");
    }
}

// Checking Account
class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Transaction declined. Exceeds overdraft limit.");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Type: Checking, Overdraft Limit: " + overdraftLimit);
    }
}

public class BankApp {
    private static List<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nBank Account Application");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Checking Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createSavings();
                    break;
                case "2":
                    createChecking();
                    break;
                case "3":
                    handleDeposit();
                    break;
                case "4":
                    handleWithdraw();
                    break;
                case "5":
                    displayAll();
                    break;
                case "6":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void createSavings() {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter Holder Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double bal = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Interest Rate: ");
        double rate = Double.parseDouble(scanner.nextLine());

        accounts.add(new SavingsAccount(accNum, name, bal, rate));
        System.out.println("Savings Account Created.");
    }

    private static void createChecking() {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter Holder Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double bal = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Overdraft Limit: ");
        double limit = Double.parseDouble(scanner.nextLine());

        accounts.add(new CheckingAccount(accNum, name, bal, limit));
        System.out.println("Checking Account Created.");
    }

    private static BankAccount findAccount(String accNum) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNum)) {
                return acc;
            }
        }
        return null;
    }

    private static void handleDeposit() {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        BankAccount acc = findAccount(accNum);
        if (acc != null) {
            System.out.print("Enter Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void handleWithdraw() {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        BankAccount acc = findAccount(accNum);
        if (acc != null) {
            System.out.print("Enter Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void displayAll() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (BankAccount acc : accounts) {
                acc.display();
                System.out.println("-------------------");
            }
        }
    }
}
