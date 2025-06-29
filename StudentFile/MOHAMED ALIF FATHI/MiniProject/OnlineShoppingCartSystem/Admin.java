package OnlineShoppingCartSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    private ArrayList<Customer> customers;

    public Admin(String name, String userID, String password, ArrayList<Customer> customers) {
        super(name, userID, password);
        this.customers = customers;
    }

    public String getName() {
        return super.getName();
    }

    public String getID() {
        return super.getID();
    }

    public String getPassword() {
        return super.getPassword();
    }

    public void showMenu(Scanner scanner, ArrayList<Product> products) {
        boolean logout = false;
        while (!logout) {
            try {
                System.out.println("\n--- Admin Menu ---");
                System.out.println("1. View Products");
                System.out.println("2. Restock Products");
                System.out.println("3. View Customers' Orders");
                System.out.println("4. Logout");
                System.out.print("Choose option: ");
                String choice = scanner.nextLine();
                System.out.println();

                switch (choice) {
                    case "1":
                        viewProducts(products);
                        System.out.print("\nPress Enter to return to the menu...");
                        scanner.nextLine();
                        OnlineShoppingCartSystem.clearScreen();
                        break;
                    case "2":
                        restockProducts(scanner, products);
                        System.out.print("\nPress Enter to return to the menu...");
                        scanner.nextLine();
                        OnlineShoppingCartSystem.clearScreen();
                        break;
                    case "3":
                        showOrders();
                        System.out.print("\nPress Enter to return to the menu...");
                        scanner.nextLine();
                        OnlineShoppingCartSystem.clearScreen();
                        break;
                    case "4":
                        logout = true;
                        System.out.println("Admin logged out.");
                        break;
                    default:
                        OnlineShoppingCartSystem.clearScreen();
                        System.out.println("Invalid option. Please choose a number between 1-7.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }

    private void restockProducts(Scanner scanner, ArrayList<Product> products) {
        try {
            if (products == null || products.isEmpty()) {
                System.out.println("No products available to restock.");
                return;
            }

            this.viewProducts(products);
            System.out.print("Enter product name to restock: ");
            String productName = scanner.nextLine().trim();

            if (productName.isEmpty()) {
                System.out.println("Product name cannot be empty.");
                return;
            }

            System.out.print("Enter quantity to add: ");
            String quantityInput = scanner.nextLine().trim();

            if (quantityInput.isEmpty()) {
                System.out.println("Quantity cannot be empty.");
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(quantityInput);
                if (quantity <= 0) {
                    System.out.println("Quantity must be a positive number.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a valid number.");
                return;
            }

            Product foundProduct = findProductByName(products, productName);
            if (foundProduct == null) {
                System.out.println("Product '" + productName + "' not found.");
                return;
            }

            int oldStock = foundProduct.getStock();
            foundProduct.reStock(quantity);
            int newStock = foundProduct.getStock();

            System.out.println("Successfully restocked " + quantity + " units of " + productName + ".");
            System.out.println("Stock updated: " + oldStock + " to " + newStock);

        } catch (Exception e) {
            System.out.println("Error restocking product: " + e.getMessage());
        }
    }

    public void showOrders() {
        boolean hasOrders = false;

        // First, check if any customer has orders
        for (Customer customer : customers) {
            if (!customer.getOrder().isEmpty()) {
                hasOrders = true;
                break;
            }
        }

        if (!hasOrders) {
            System.out.println("No orders found");
            return;
        }

        // Display orders if they exist
        for (Customer customer : customers) {
            if (customer.getOrder().isEmpty()) {
                continue;
            }
            System.out.println("Customer: " + customer.getName());
            ArrayList<Order> orders = customer.getOrder();
            System.out.println("----------------------------------------");
            for (Order order : orders) {
                order.displayOrderDetails();
                System.out.println("----------------------------------------");
            }
            System.out.println();
        }
    }
}
