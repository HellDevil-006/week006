package online_shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Product {
    double getPrice();

    String getDetails();
}

class Electronics implements Product {
    private String name;
    private double price;
    private String brand;

    public Electronics(String name, double price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDetails() {
        return "Electronics [Name: " + name + ", Price: " + price + ", Brand: " + brand + "]";
    }
}

class Clothing implements Product {
    private String name;
    private double price;
    private String size;

    public Clothing(String name, double price, String size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDetails() {
        return "Clothing [Name: " + name + ", Price: " + price + ", Size: " + size + "]";
    }
}

class ShoppingCart {
    private List<Product> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public void addProduct(Product product) {
        cart.add(product);
        System.out.println("Product added to cart.");
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : cart) {
            total += p.getPrice();
        }
        return total;
    }

    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("\n--- Shopping Cart ---");
            for (Product p : cart) {
                System.out.println(p.getDetails());
            }
            System.out.println("Total Cart Value: " + calculateTotal());
        }
    }
}

public class ShoppingCartSystem {
    private static ShoppingCart cart = new ShoppingCart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nOnline Shopping Cart");
            System.out.println("1. Add Electronics");
            System.out.println("2. Add Clothing");
            System.out.println("3. View Cart & Total");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addElectronics();
                    break;
                case "2":
                    addClothing();
                    break;
                case "3":
                    cart.displayCart();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addElectronics() {
        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter Brand: ");
            String brand = scanner.nextLine();

            cart.addProduct(new Electronics(name, price, brand));
        } catch (NumberFormatException e) {
            System.out.println("Invalid price.");
        }
    }

    private static void addClothing() {
        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter Size: ");
            String size = scanner.nextLine();

            cart.addProduct(new Clothing(name, price, size));
        } catch (NumberFormatException e) {
            System.out.println("Invalid price.");
        }
    }
}
