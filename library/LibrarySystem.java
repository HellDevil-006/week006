package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(int id) {
        Book toRemove = null;
        for (Book book : books) {
            if (book.getId() == id) {
                toRemove = book;
                break;
            }
        }
        if (toRemove != null) {
            books.remove(toRemove);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\n--- Library Books ---");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

public class LibrarySystem {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addBook();
                    break;
                case "2":
                    removeBook();
                    break;
                case "3":
                    library.displayBooks();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Author: ");
            String author = scanner.nextLine();

            library.addBook(new Book(id, title, author));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. ID must be a number.");
        }
    }

    private static void removeBook() {
        try {
            System.out.print("Enter Book ID to remove: ");
            int id = Integer.parseInt(scanner.nextLine());
            library.removeBook(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. ID must be a number.");
        }
    }
}
