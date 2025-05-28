import java.util.*;

// Class: Member
// Represents a member who can rent a space lot
class Member {
    private String memberId;
    private String name;
    private String phoneNumber;

    // Constructor
    public Member(String memberId, String name, String phoneNumber) 
    {
        //TO DO: Initialize all fields
        this.memberId = memberId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Return member info
    public String getInfo() {
        // TO DO: Return a formatted string like: "Alice (M001), Phone: 012-3456789"
        return name + "(" + memberId + "), Phone: " + phoneNumber;
    }
}

// Class: Item
// Represents an item stored in a space lot
class Item {
    private String itemId;
    private String name;
    private String description;

    // Constructor
    public Item(String itemId, String name, String description) {
        // TO DO: Initialize all fields
        this.itemId = itemId;
        this.name = name;
        this.description = description;
    }

    // Return item details
    public String getDetails() {
        //TO DO: Return a formatted string like: "Bicycle: Mountain bike"
        return name + ": " + description;
    }
}

// Class: SpaceLot
// Represents a lot within a store assigned to one member and stores multiple items
class SpaceLot {
    private String lotId;
    private double size;
    private Member assignedMember;
    private List<Item> items;

    // Constructor
    public SpaceLot(String lotId, double size) {
        // TO DO: Initialize all fields
        this.lotId = lotId;
        this.size = size;
        this.items = new ArrayList<>();
        this.assignedMember = null;
    }

    // Assign this lot to a member
    public void assignToMember(Member member) {
        // TO DO: Set assignedMember
        this.assignedMember = member;
    }

    // Add an item to the lot
    public void addItem(Item item) {
        // TO DO: Add item to items list
        items.add(item);
    }

    // Get list of items
    public List<Item> getItemList() {
        // TO DO: Return items list
        return items;
    }

    // Get assigned member
    public Member getAssignedMember() {
        // TO DO: Return assigned member
        return assignedMember;
    }

    // Get lot ID
    public String getLotId() {
        return lotId;
    }
}

// Class: Store
// Represents a storage facility that owns multiple space lots
class Store {
    private String storeId;
    private String name;
    private String location;
    private List<SpaceLot> spaceLots;

    // Constructor
    public Store(String storeId, String name, String location) {
        // TO DO: Initialize all fields
        this.storeId = storeId;
        this.name = name;
        this.location = location;
        this.spaceLots = new ArrayList<>();
    }

    // Add a space lot to the store
    public void addSpaceLot(SpaceLot lot) {
        // TO DO: Add lot to the list
        spaceLots.add(lot);
    }

    // Get all space lots
    public List<SpaceLot> getAvailableLots() {
        // TO DO: Return space lots list
        return spaceLots;
    }

    // Get store name
    public String getName() {
        return name;
    }
}

// Class: Main
// Demonstrates how the system works
public class ShareStoreSystem {
    public static void main(String[] args) {
        // TO DO: Create store
        Store store = new Store("S1", "Central Store", "Downtown");

        // TO DO: Create members
        Member member1 = new Member("M001", "Alice", "012-3456789");
        Member member2 = new Member("M002", "Bob", "011-9876543");

        // TO DO: Create space lots
        SpaceLot lot1 = new SpaceLot("L001", 10.0);
        SpaceLot lot2 = new SpaceLot("L002", 15.0);

        // TO DO: Assign lots to members
        lot1.assignToMember(member1);
        lot2.assignToMember(member2);

        // TO DO: Add items to lot1
        lot1.addItem(new Item("I001", "Bicycle", "Mountain bike"));
        lot1.addItem(new Item("I002", "Tent", "Camping tent"));

        // TO DO: Add items to lot2
        lot2.addItem(new Item("I003", "Kayak", "Inflatable kayak"));
        lot2.addItem(new Item("I004", "Cooler", "Ice box for drinks"));

        // TO DO: Add lots to store
        store.addSpaceLot(lot1);
        store.addSpaceLot(lot2);

        // TO DO: Display store and lots info
        System.out.println("Store: " + store.getName());
        for (SpaceLot lot : store.getAvailableLots()) {
            System.out.println("\nLot ID: " + lot.getLotId());
            System.out.println("Assigned to: " + lot.getAssignedMember().getInfo());
            System.out.println("Stored Items:");
            for (Item item : lot.getItemList()) {
                System.out.println(" - " + item.getDetails());
            }
        }
    }
}
