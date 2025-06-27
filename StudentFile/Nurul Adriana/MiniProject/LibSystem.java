// PROJECT OOP

import java.util.*;

// Book class
class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        if (title.trim().isEmpty() || author.trim().isEmpty() || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("No field should be empty.");
        }
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    public void showDetails() {
        System.out.println("[" + title + "] by " + author + " (ISBN: " + isbn + ")");
    }
}

// Custom Exception
class BookNotFoundException extends Exception {
    public BookNotFoundException(String msg) {
        super(msg);
    }
}

// Library class
class Library {
    private ArrayList<Book> bookList;
    private Librarian librarian; // for association and aggregation

    public Library() {
        bookList = new ArrayList<>();
    }

    public void assignLibrarian(Librarian l) {
        this.librarian = l;
    }

    public void addBook(Book b) {
        bookList.add(b);
        System.out.println("Book added: " + b.getTitle());
    }

    public void removeBook(String isbn) throws BookNotFoundException {
        boolean found = false;
        for (Book b : bookList) {
            if (b.getIsbn().equals(isbn)) {
                bookList.remove(b);
                System.out.println("Removed book with ISBN: " + isbn);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new BookNotFoundException("No book with ISBN " + isbn);
        }
    }

    public Book findBook(String isbn) throws BookNotFoundException {
        for (Book b : bookList) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        throw new BookNotFoundException("Book not found: ISBN " + isbn);
    }

    public void listAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("Current books in library:");
        for (Book b : bookList) {
            b.showDetails();
        }
    }
}

// Superclass
abstract class User {
    protected String name;
    protected String id;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public abstract void displayRole();
    public abstract double calculateFine(int daysLate);
}

// Unified Member class (inherits User + has borrowing logic)
class Member extends User {
    private ArrayList<Book> borrowed;

    public Member(String name, String id) {
        super(name, id);
        borrowed = new ArrayList<>();
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Member");
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 0.50;
    }

    public void borrow(Book b) {
        borrowed.add(b);
        System.out.println(name + " borrowed: " + b.getTitle());
    }

    public void viewBorrowed() {
        System.out.println(name + " has borrowed:");
        if (borrowed.isEmpty()) {
            System.out.println("None");
        } else {
            for (Book b : borrowed) {
                b.showDetails();
            }
        }
    }
}

// Librarian class
class Librarian extends User {
    public Librarian(String name, String id) {
        super(name, id);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Librarian");
    }

    @Override
    public double calculateFine(int daysLate) {
        return 0.0;
    }
}

// LibraryCard
class LibraryCard {
    private Member member;

    public LibraryCard(Member m) {
        this.member = m;
    }

    public void showCardDetails() {
        if (member != null) {
            System.out.println("Library Card belongs to: " + member.name + " (ID: " + member.id + ")");
        } else {
            System.out.println("Library Card has no valid owner.");
        }
    }

    public void detachMember() {
        this.member = null;
    }
}


// Main class for testing
public class LibSystem {
    public static void main(String[] args) {
        Library lib = new Library();

        try {
            // Add and manage books
            System.out.println("\n=== Adding Books ===");
            Book b1 = new Book("The Hobbit", "J.R.R. Tolkien", "1111");
            Book b2 = new Book("The Alchemist", "Paulo Coelho", "2222");

            lib.addBook(b1);
            lib.addBook(b2);
            
            System.out.println("\n=== Listing All Books ===");
            lib.listAllBooks();
            
            System.out.println("\n=== Finding Book ===");
            Book found = lib.findBook("1111");
            found.showDetails();
            
            System.out.println("\n=== Removing Book ===");
            lib.removeBook("1111");
            
            System.out.println("\n=== Listing Remaining Books ===");
            lib.listAllBooks();

            // Member functionality
            System.out.println("\n=== Member Borrows a Book ===");
            Member m = new Member("Ziyaad", "M001");
            m.borrow(b2);
            m.viewBorrowed();
            
            System.out.println("\n=== Member Info ===");
            m.displayRole();
            System.out.println("Fine for 3 late days: RM" + m.calculateFine(3));

            //System.out.println();

            // Polymorphism test
            System.out.println("\n=== Polymorphism Test ===");
            User u1 = new Member("Adriana", "M002");
            User u2 = new Librarian("Siti", "L001");

            u1.displayRole();
            System.out.println("Fine for 5 late days: RM" + u1.calculateFine(5));

            u2.displayRole();
            System.out.println("Fine for 5 late days: RM" + u2.calculateFine(5));

            // Association Test
            System.out.println("\n=== Association Test ===");
            Librarian libLibrarian = new Librarian("Farah", "L002");
            lib.assignLibrarian(libLibrarian);
            System.out.println("Librarian assigned to library: " + libLibrarian.name);
            lib = null;
            System.out.println("Library deleted (set to null). Librarian still exists:");
            libLibrarian.displayRole();
            System.out.println("Fine for 7 late days: RM" + libLibrarian.calculateFine(7));

            // Aggregation Test
            System.out.println("\n=== Aggregation Test ===");
            Librarian aggLibrarian = new Librarian("Daniel", "L003");
            Library lib2 = new Library();
            lib2.assignLibrarian(aggLibrarian);
            System.out.println("Library 2 now has librarian: " + aggLibrarian.name);
            lib2 = null;
            System.out.println("Library 2 deleted (set to null). Librarian still exists and works:");
            aggLibrarian.displayRole();
            System.out.println("Fine for 10 late days: RM" + aggLibrarian.calculateFine(10));

            // Composition Test
            System.out.println("\n=== Composition Test ===");
            Member m2 = new Member("Hakim", "M003");
            LibraryCard card = new LibraryCard(m2);
            card.showCardDetails();

            // Deletion
            m2 = null;
            card.detachMember();
            System.out.println("Member object deleted (set to null). Trying to use LibraryCard...");
            try {
                card.showCardDetails();
                System.out.println("Warning: LibraryCard still exists, but is now detached from its original owner.");
            } catch (Exception e) {
                System.out.println("LibraryCard can't function as its owner (Member) is gone.");
            }

            // Exception Handling Test
            System.out.println("\n=== Exception Handling Test ===");
            Library tempLib = new Library();
            try {
                tempLib.findBook("9999");
            } catch (BookNotFoundException e) {
                System.out.println("Caught exception: " + e.getMessage());
            }

           
        } catch (IllegalArgumentException | BookNotFoundException err) {
            System.out.println("[Error] " + err.getMessage());
        }
    }
}
