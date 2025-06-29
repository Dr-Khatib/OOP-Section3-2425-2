package OnlineShoppingCartSystem;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class User {
    private String name;
    private String userID;
    private String password;

    public User(String name, String userID, String password) {
        this.name = name;
        this.userID = userID;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public abstract void showMenu(Scanner scanner, ArrayList<Product> products);

    public abstract void showOrders();

    public void viewProducts(ArrayList<Product> products) {
        OnlineShoppingCartSystem.clearScreen();
        System.out.println("\n--- Available Products ---");
        for (Product product : products) {
            System.out.println(
                    "Name: " + product.getName() + ", Price: " + product.getPrice() + ", Stock: " + product.getStock());
        }
        System.out.println("---------------------------");
    }

    public Product findProductByName(ArrayList<Product> products, String productName) {
        if (products == null || productName == null) {
            return null;
        }

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }
}
