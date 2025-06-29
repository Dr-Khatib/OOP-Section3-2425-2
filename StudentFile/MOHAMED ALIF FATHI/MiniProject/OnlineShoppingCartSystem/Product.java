package OnlineShoppingCartSystem;

public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reStock(int stock) {
        this.stock += stock;
    }

    public void reduceStock(int quantity) {
        if (this.stock >= quantity) {
            this.stock -= quantity;
        } else {
            System.out.println("Insufficient stock for " + this.name);
        }
    }

    public boolean inStock(int quantity) {
        return this.stock >= quantity;
    }
}
