import java.util.*;

// Class: Member
class Member {
    private String memberId;
    private String name;
    private String phoneNumber;

    public Member(String memberId, String name, String phoneNumber) {
        this.memberId = memberId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getInfo() {
        return name + " (" + memberId + "), Phone: " + phoneNumber;
    }
}

// Class: Item
class Item {
    private String itemId;
    private String name;
    private String description;

    public Item(String itemId, String name, String description) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
    }

    public String getDetails() {
        return name + ": " + description;
    }
}

// Class: SpaceLot
class SpaceLot {
    private String lotId;
    private double size;
    private Member assignedMember;
    private List<Item> items;

    public SpaceLot(String lotId, double size) {
        this.lotId = lotId;
        this.size = size;
        this.assignedMember = null;
        this.items = new ArrayList<>();
    }

    public void assignToMember(Member member) {
        this.assignedMember = member;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItemList() {
        return items;
    }

    public Member getAssignedMember() {
        return assignedMember;
    }

    public String getLotId() {
        return lotId;
    }
}

// Class: Store
class Store {
    private String storeId;
    private String name;
    private String location;
    private List<SpaceLot> spaceLots;

    public Store(String storeId, String name, String location) {
        this.storeId = storeId;
        this.name = name;
        this.location = location;
        this.spaceLots = new ArrayList<>();
    }

    public void addSpaceLot(SpaceLot lot) {
        spaceLots.add(lot);
    }

    public List<SpaceLot> getAvailableLots() {
        return spaceLots;
    }

    public String getName() {
        return name;
    }
}

// Main class
public class ShareStoreSystem {
    public static void main(String[] args) {
        Store store = new Store("S1", "Central Store", "Downtown");

        Member member1 = new Member("M001", "Alice", "012-3456789");
        Member member2 = new Member("M002", "Bob", "011-9876543");

        SpaceLot lot1 = new SpaceLot("L001", 10.0);
        SpaceLot lot2 = new SpaceLot("L002", 15.0);

        lot1.assignToMember(member1);
        lot2.assignToMember(member2);

        lot1.addItem(new Item("I001", "Bicycle", "Mountain bike"));
        lot1.addItem(new Item("I002", "Tent", "Camping tent"));

        lot2.addItem(new Item("I003", "Kayak", "Inflatable kayak"));
        lot2.addItem(new Item("I004", "Cooler", "Ice box for drinks"));

        store.addSpaceLot(lot1);
        store.addSpaceLot(lot2);

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
