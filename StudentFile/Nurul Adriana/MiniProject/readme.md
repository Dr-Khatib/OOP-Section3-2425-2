# 📚 Library Management System – OOP Mini Project

This OOP mini project simulates a **Library Management System** that allows users to add, remove, and borrow books using core object-oriented programming concepts such as **inheritance**, **polymorphism**, **composition**, and **exception handling**.

---

## 👥 Team Members

| Name      | Role       | Responsibilities |
|-----------|------------|------------------|
| AHMAD ZIYAAD BIN MOHD ABBAS (A23CS0206) | Person A | Data structures, relationships, exception handling |
| NURUL ADRIANA BINTI KAMAL JEFRI (A23C0258) | Person B | Inheritance, polymorphism, documentation & testing |

---

## 🛠️ Features Implemented

- ✅ Add, list, find, and remove books in a library
- ✅ Borrowed book tracking for members
- ✅ Custom exception for invalid or missing books
- ✅ Abstract superclass `User` with subclasses `Member` and `Librarian`
- ✅ Method overriding (`calculateFine()`, `displayRole()`)
- ✅ Dynamic binding with polymorphism

---

## 🧠 Object-Oriented Concepts with Implementation & Code Examples

| Concept                | Implementation Summary                                                                         | Code Example                                                                                                                                                                                                       |
| ---------------------- | ---------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Inheritance**        | `Member` and `Librarian` are subclasses that extend the abstract superclass `User`.            | `java<br>abstract class User { ... }<br>class Member extends User { ... }<br>class Librarian extends User { ... }<br>`                                                                                             |
| **Method Overriding**  | Subclasses override methods from `User` such as `displayRole()` and `calculateFine()`.         | `java<br>@Override<br>public void displayRole() { System.out.println("Role: Member"); }<br>public double calculateFine(int daysLate) { return daysLate * 0.50; }<br>`                                              |
| **Polymorphism**       | A `User` reference points to a `Member` or `Librarian`, allowing dynamic behavior.             | `java<br>User u1 = new Member("Adriana", "M002");<br>u1.displayRole();<br>System.out.println("Fine: RM " + u1.calculateFine(5));<br>`                                                                              |
| **Dynamic Binding**    | Java decides at runtime which version of the overridden method to call.                        | `java<br>User u2 = new Librarian("Siti", "L001");<br>u2.displayRole(); // Calls Librarian’s version<br>`                                                                                                           |
| **Encapsulation**      | Class fields are private, and accessed through public methods.                                 | `java<br>private String title;<br>public String getTitle() { return title; }<br>`                                                                                                                                  |
| **Composition**        | `LibraryCard` owns a `Member` instance. If the member is deleted, the card is affected.        | `java<br>LibraryCard card = new LibraryCard(m2);<br>card.showCardDetails();<br>m2 = null;<br>card.detachMember();<br>`                                                                                             |
| **Association**        | `Library` can be associated with a `Librarian` (they can exist independently).                 | `java<br>Library lib = new Library();<br>Librarian l = new Librarian("Farah", "L002");<br>lib.assignLibrarian(l);<br>`                                                                                             |
| **Aggregation**        | `Library` uses a `Librarian`, but if `Library` is deleted, `Librarian` remains intact.         | `java<br>Library lib2 = new Library();<br>Librarian aggLibrarian = new Librarian("Daniel", "L003");<br>lib2.assignLibrarian(aggLibrarian);<br>lib2 = null;<br>aggLibrarian.displayRole();<br>`                     |
| **Exception Handling** | Handles input validation and custom exceptions like `BookNotFoundException` using `try-catch`. | `java<br>if (title.trim().isEmpty()) throw new IllegalArgumentException("No field should be empty.");<br>throw new BookNotFoundException("Book not found");<br>...<br>try { ... } catch (Exception e) { ... }<br>` |

---

## 🔍 Sample Output

=== Adding Books === <br>
/nBook added: The Hobbit <br>
Book added: The Alchemist 

=== Listing All Books === <br>
Current books in library: <br>
[The Hobbit] by J.R.R. Tolkien (ISBN: 1111) <br>
[The Alchemist] by Paulo Coelho (ISBN: 2222)

=== Finding Book === <br>
[The Hobbit] by J.R.R. Tolkien (ISBN: 1111)

=== Removing Book === <br>
Removed book with ISBN: 1111

=== Listing Remaining Books === <br>
Current books in library: <br>
[The Alchemist] by Paulo Coelho (ISBN: 2222)

=== Member Borrows a Book === <br>
Ziyaad borrowed: The Alchemist <br>
Ziyaad has borrowed: <br>
[The Alchemist] by Paulo Coelho (ISBN: 2222)

=== Member Info === <br>
Role: Member <br>
Fine for 3 late days: RM1.5

=== Polymorphism Test === <br>
Role: Member <br>
Fine for 5 late days: RM2.5 <br>
Role: Librarian <br>
Fine for 5 late days: RM0.0

=== Association Test === <br>
Librarian assigned to library: Farah <br>
Library deleted (set to null). Librarian still exists: <br>
Role: Librarian <br>
Fine for 7 late days: RM0.0

=== Aggregation Test === <br>
Library 2 now has librarian: Daniel <br>
Library 2 deleted (set to null). Librarian still exists and works: <br>
Role: Librarian <br>
Fine for 10 late days: RM0.0

=== Composition Test === <br>
Library Card belongs to: Hakim (ID: M003) <br>
Member object deleted (set to null). Trying to use LibraryCard... <br>
Library Card has no valid owner. <br>
Warning: LibraryCard still exists, but is now detached from its original owner.

=== Exception Handling Test === <br>
Caught exception: Book not found: ISBN 9999

---

## ▶️ How to Run

1. Compile the program.
2. Run the program.

---

## 🧪 Testing Guide

- All features are tested in the `main()` method
- Screenshots of output are recommended for evidence
- Demonstrates handling of both normal and exceptional cases

---

## 📄 UML Class Diagram

📌 *See “OOP Mini Project.png” for class structure visualization, including relationships like inheritance, association, and composition.*

---

