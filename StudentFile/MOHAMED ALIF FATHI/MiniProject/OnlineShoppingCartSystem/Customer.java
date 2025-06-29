package OnlineShoppingCartSystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Customer extends User {
    private Cart cart;
    private ArrayList<Order> orders;

    public Customer(String name, String userID, String password) {
        super(name, userID, password);
        this.orders = new ArrayList<>();
        this.cart = new Cart();
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
                System.out.println("\n--- Customer Menu ---");
                System.out.println("1. View Products");
                System.out.println("2. Add to Cart");
                System.out.println("3. Remove from Cart");
                System.out.println("4. View Cart");
                System.out.println("5. Checkout");
                System.out.println("6. View Orders");
                System.out.println("7. Logout");
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
                        addToCart(scanner, products);
                        System.out.print("\nPress Enter to return to the menu...");
                        scanner.nextLine();
                        OnlineShoppingCartSystem.clearScreen();
                        break;
                    case "3":
                        removeFromCart(scanner);
                        System.out.print("\nPress Enter to return to the menu...");
                        scanner.nextLine();
                        OnlineShoppingCartSystem.clearScreen();
                        break;
                    case "4":
                        this.cart.displayCart();
                        System.out.print("\nPress Enter to return to the menu...");
                        scanner.nextLine();
                        OnlineShoppingCartSystem.clearScreen();
                        break;
                    case "5":
                        checkout(scanner, products);
                        System.out.print("\nPress Enter to return to the menu...");
                        scanner.nextLine();
                        OnlineShoppingCartSystem.clearScreen();
                        break;
                    case "6":
                        showOrders();
                        System.out.print("\nPress Enter to return to the menu...");
                        scanner.nextLine();
                        OnlineShoppingCartSystem.clearScreen();
                        break;
                    case "7":
                        logout = true;
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

    private void addToCart(Scanner scanner, ArrayList<Product> products) {
        try {
            if (products == null || products.isEmpty()) {
                System.out.println("No products available.");
                return;
            }
            viewProducts(products);
            System.out.print("Enter product name to add: ");
            String productName = scanner.nextLine().trim();
            if (productName.isEmpty()) {
                System.out.println("Product name cannot be empty.");
                return;
            }
            System.out.print("Enter quantity: ");
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

            Product foundProduct = null;
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    foundProduct = product;
                    break;
                }
            }
            if (foundProduct == null) {
                System.out.println("Product '" + productName + "' not found.");
                return;
            }

            // Check if product is already in cart
            Item existingItem = null;
            int currentCartQuantity = 0;

            for (Item item : cart.getItems()) {
                if (item.getItem().getName().equalsIgnoreCase(productName)) {
                    existingItem = item;
                    currentCartQuantity = item.getQuantity();
                    break;
                }
            }

            int availableStock = foundProduct.getStock() - currentCartQuantity;

            if (availableStock <= 0) {
                System.out.println("Cannot add more " + productName + ". All available stock ("
                        + foundProduct.getStock() + ") is already in cart.");
                return;
            }

            int quantityToAdd;
            if (quantity <= availableStock) {
                // Can add the full requested quantity
                quantityToAdd = quantity;
            } else {
                // Add only the remaining available stock
                quantityToAdd = availableStock;
                System.out.println("Only " + availableStock + " units available. (In Cart = " + currentCartQuantity
                        + ") Adding " + quantityToAdd + " to cart.");
            }

            if (existingItem != null) {
                // Update existing item quantity
                existingItem.addQuantity(quantityToAdd);
                System.out.println("Added " + quantityToAdd + " of " + productName + " to cart.");
                System.out.println("Total " + productName + " in cart: " + existingItem.getQuantity());
            } else {
                // Add new item to cart
                Item newItem = new Item(foundProduct, quantityToAdd);
                cart.getItems().add(newItem);
                System.out.println("Added " + quantityToAdd + " of " + productName + " to cart.");
            }

        } catch (Exception e) {
            System.out.println("Error adding item to cart: " + e.getMessage());
        }
    }

    private void removeFromCart(Scanner scanner) {
        try {
            if (cart.isEmpty()) {
                System.out.println("Cart is empty. Nothing to remove.");
                return;
            }

            cart.displayCart();
            System.out.print("Enter product name to remove: ");
            String removeProductName = scanner.nextLine().trim();

            if (removeProductName.isEmpty()) {
                System.out.println("Product name cannot be empty.");
                return;
            }

            System.out.print("Enter quantity to remove: ");
            String quantityInput = scanner.nextLine().trim();

            if (quantityInput.isEmpty()) {
                System.out.println("Quantity cannot be empty.");
                return;
            }

            int removeQuantity;
            try {
                removeQuantity = Integer.parseInt(quantityInput);
                if (removeQuantity <= 0) {
                    System.out.println("Quantity must be a positive number.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a valid number.");
                return;
            }

            boolean itemFound = false;
            for (Item item : cart.getItems()) {
                if (item.itemName().equalsIgnoreCase(removeProductName)) {
                    itemFound = true;
                    if (removeQuantity >= item.getQuantity()) {
                        cart.removeItem(removeProductName);
                        System.out.println("Removed all " + removeProductName + " from cart.");
                    } else {
                        item.reduceQuantity(removeQuantity);
                        System.out.println("Removed " + removeQuantity + " of " + removeProductName + " from cart.");
                    }
                    break;
                }
            }

            if (!itemFound) {
                System.out.println("Product '" + removeProductName + "' not found in cart.");
            }

        } catch (Exception e) {
            System.out.println("Error removing item from cart: " + e.getMessage());
        }
    }

    private void checkout(Scanner scanner, ArrayList<Product> products) {
        try {
            if (cart.isEmpty()) {
                System.out.println("Cart is empty. Cannot proceed with checkout.");
                return;
            }

            // Validate stock availability before checkout and adjust quantities
            boolean cartModified = false;
            ArrayList<Item> itemsToRemove = new ArrayList<>();

            for (Item item : cart.getItems()) {
                Product product = findProductByName(products, item.itemName());
                if (product == null) {
                    System.out.println("Product '" + item.itemName() + "' is no longer available.");
                    itemsToRemove.add(item);
                    cartModified = true;
                    continue;
                }

                if (product.getStock() < item.getQuantity()) {
                    System.out.println(
                            "Insufficient stock for '" + item.itemName() + "'. Available: " + product.getStock());

                    if (product.getStock() == 0) {
                        // Remove item completely if no stock available
                        itemsToRemove.add(item);
                        System.out.println("Removed " + item.itemName() + " from cart due to no stock available.");
                    } else {
                        // Adjust quantity to available stock
                        int originalQuantity = item.getQuantity();
                        item.setQuantity(product.getStock());
                        System.out.println("Reduced quantity of " + item.itemName() + " in cart from "
                                + originalQuantity + " to " + product.getStock());
                    }
                    cartModified = true;
                }
            }

            // Remove items that are no longer available or have no stock
            for (Item item : itemsToRemove) {
                cart.removeItem(item.itemName());
            }

            // If cart was modified, show updated cart and ask user to review
            if (cartModified) {
                System.out.println("\nYour cart has been updated due to stock changes:");
                cart.displayCart();

                if (cart.isEmpty()) {
                    System.out.println("Cart is now empty. Cannot proceed with checkout.");
                    return;
                }

                System.out.print("Do you want to continue with the updated cart? (yes/no): ");
                String continueResponse = scanner.nextLine().trim().toLowerCase();
                if (!continueResponse.equals("yes") && !continueResponse.equals("y")) {
                    System.out.println("Checkout cancelled.");
                    return;
                }
            }

            double totalPrice = cart.getTotalPrice();
            cart.displayCart();
            System.out.printf("Total price: RM%.2f%n", totalPrice);
            System.out.print("Do you want to proceed with checkout? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("yes") || response.equals("y")) {

                // Update stock
                for (Item item : cart.getItems()) {
                    Product product = findProductByName(products, item.itemName());
                    if (product != null) {
                        product.reduceStock(item.getQuantity());
                    }
                }

                // Create order
                Order order = new Order(cart, totalPrice, new Date().toString());
                this.orders.add(order);

                System.out.println("Checkout successful. Thank you for your purchase!");

                // Clear cart after checkout
                cart = new Cart();
            } else {
                System.out.println("Checkout cancelled.");
            }

        } catch (Exception e) {
            System.out.println("Error during checkout: " + e.getMessage());
        }
    }

    public void showOrders() {
        if (this.orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            System.out.println("Your Orders:");
            System.out.println("----------------------------------------");
            for (Order order : this.orders) {
                order.displayOrderDetails();
                System.out.println("----------------------------------------");
            }
        }
    }

    public ArrayList<Order> getOrder() {
        return this.orders;
    }
}