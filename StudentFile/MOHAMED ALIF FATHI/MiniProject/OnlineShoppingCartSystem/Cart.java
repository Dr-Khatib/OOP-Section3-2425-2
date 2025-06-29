package OnlineShoppingCartSystem;

import java.util.*;

public class Cart {
    private ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        Item cartItem = new Item(product, quantity);
        items.add(cartItem);
    }

    public void removeItem(String name) {
        for (Item item : items) {
            if (item.itemName().equals(name)) {
                item.reduceQuantity(item.getQuantity());
                items.remove(item);
                break;
            }
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.calculateTotalPrice();
        }
        return totalPrice;
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Items in cart:");
            for (Item item : items) {
                System.out.println(item.itemName() + " - Quantity: " + item.getQuantity() + ", Price: "
                        + item.calculateTotalPrice());
            }
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
