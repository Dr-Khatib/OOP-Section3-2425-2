package OnlineShoppingCartSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class OnlineShoppingCartSystem {
    public static void main(String[] args) {
        // Create users
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        Customer cust1 = new Customer("MOHAMED ALIF FATHI", "ali", "ali123");
        Customer cust2 = new Customer("SITI NURHALIZA", "siti", "siti123");
        customers.add(cust1);
        customers.add(cust2);
        Admin admin = new Admin("IMAN ABADI", "admin", "admin123", customers);
        users.add(admin);
        users.add(cust1);
        users.add(cust2);

        ArrayList<Product> products = new ArrayList<>();
        // Sample products
        products.add(new Product("Laptop", 6000.00, 10));
        products.add(new Product("Phone", 3000.00, 20));
        products.add(new Product("Earbuds", 150.00, 50));
        products.add(new Product("Tablet", 1500.00, 15));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Welcome to Electronic Shopping Cart System ---");
            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            User currentUser = null;

            for (User user : users) {
                if (username.equals(user.getID()) && password.equals(user.getPassword())) {
                    currentUser = user;
                    break;
                }
            }

            if (currentUser == null) {
                clearScreen();
                System.out.println("Invalid username or password. Please try again.");
                continue;
            }
            clearScreen();
            System.out.println("Welcome, " + currentUser.getName() + "!");
            currentUser.showMenu(scanner, products);
            clearScreen();
            System.out.println("\nDo you want to exit the system? (yes to exit, press Enter to continue): ");
            System.out.print("Your choice: ");
            String response = scanner.nextLine().toLowerCase();
            if (response.equals("yes")) {
                exit = true;
            } else {
                clearScreen();
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}