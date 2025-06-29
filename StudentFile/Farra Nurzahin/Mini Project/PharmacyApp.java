import java.util.ArrayList;
import java.util.Scanner;

// ch7: Inheritance - Superclass
class User {
    protected String name;
    protected String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }
    
    public void displayInfo() {
        System.out.println("User: " + name + ", Role: " + role);
    }
}


// ch7: Inheritance - Subclass of User
// ch8: Polymorphism - Method overriding
class Admin extends User {
    public Admin(String name) {
        super(name,"Admin");
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Admin Name : " + name);
    }
}

// ch7: Inheritance - Subclass of User
// ch8: Polymorphism - Method overriding
class Pharmacist extends User {
    public Pharmacist(String name){
        super(name, "Pharmacist");
    }
    
    @Override
    public void displayInfo(){
        System.out.println("Pharmacist Name: " + name);
    }
}

// ch6: Class Relationships - Aggregation
// Medicine is a component of the inventory system (InventoryManager "has-a" Medicine)

class Medicine {
    private String id;
    private String name;
    private int quantity;
    private double price;
    private String expiryDate;

    public Medicine(String id, String name, int quantity, double price, String expiryDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public String getId() {return id;}
    public String getName() {return name;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int q) {this.quantity = q;}

    @Override
    public String toString(){
        return "ID: " + id + ", Name: " + name + ", Qty: " + quantity + ", Price: RM" + price + ", Expiry: " + expiryDate;
    }
}

class InventoryManager {
    private ArrayList<Medicine> medicines; //ch5: ArrayList

    public InventoryManager(){
        medicines = new ArrayList<>();
    }

    public void addMedicine(Medicine m){
        medicines.add(m);
        System.out.println("Medicine added!");
    }

    public void removeMedicine(String id){
        medicines.removeIf(m -> m.getId().equalsIgnoreCase(id));
        System.out.println("Medicine removed if existed.");
    }

    public void updateQuantity(String id, int newQty){
        for (Medicine m : medicines) {
            if (m.getId().equalsIgnoreCase(id)) {
                m.setQuantity(newQty);
                System.out.println("Quantity updated.");
                return;
            }
        }
        System.out.println("Medicine not found.");

    }

    public void displayAll(){
        if (medicines.isEmpty()) {
            System.out.println("No medicines found.");
        } else {
            for (Medicine m : medicines){
                System.out.println(m);
            }
        }
    }

    public void lowStockAlert(int threshold){
        for (Medicine m : medicines){
            if (m.getQuantity() < threshold){
                System.out.println("Low stock: " + m);
            }
        }
    }
}


// ch6: Association - PharmacyApp "uses" Admin and Pharmacist objects
public class PharmacyApp{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();

        //ch6 : Association - Using Admin and Pharmacist objects
        Admin admin = new Admin("Zara");
        Pharmacist pharmacist = new Pharmacist("Ali");

        admin.displayInfo();
        pharmacist.displayInfo();

        while (true){
            //ch9: Exception handling
            try {
                System.out.println("\n=== Pharmacy Inventory ===");
                System.out.println("1. Add Medicine");
                System.out.println("2. View Medicines");
                System.out.println("3. Update Quantity");
                System.out.println("4. Remove Medicine");
                System.out.println("5. Check Low Stock");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Medicine Code: ");
                        String id = sc.nextLine();
                        System.out.print("Medicine Name: ");
                        String name = sc.nextLine();
                        System.out.print("Quantity: ");
                        int qty = Integer.parseInt(sc.nextLine());
                        System.out.print("Price: ");
                        double price = Double.parseDouble(sc.nextLine());
                        System.out.print("Expiry Date (YYYY-MM-DD): ");
                        String date = sc.nextLine();

                        Medicine med = new Medicine (id, name, qty, price, date);
                        manager.addMedicine(med);
                        break;

                    case 2:
                        manager.displayAll();
                        break;
                    
                    case 3:
                        System.out.print("Enter ID: ");
                        String updateId = sc.nextLine();
                        System.out.print("New Quantity: ");
                        int newQty = Integer.parseInt(sc.nextLine());
                        manager.updateQuantity(updateId, newQty);
                        break;

                    case 4:
                        System.out.print("Enter ID: ");
                        String delId = sc.nextLine();
                        manager.removeMedicine(delId);
                        break;

                    case 5:
                        System.out.print("Enter minimum quantity: ");
                        int threshold = Integer.parseInt(sc.nextLine());
                        manager.lowStockAlert(threshold);
                        break;

                    case 6:
                        System.out.println("Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
                }catch (NumberFormatException e){
                    System.out.println("Invalid input! Please enter a number.");
                }catch (Exception e){
                    System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}
