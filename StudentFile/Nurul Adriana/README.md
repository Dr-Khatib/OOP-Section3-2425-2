# 📚 Library Management System – OOP Mini Project

This Java mini project simulates a **Library Management System** that allows users to add, remove, and borrow books using core object-oriented programming concepts such as **inheritance**, **polymorphism**, **composition**, and **exception handling**.

---

## 👥 Team Members

| Name      | Role       | Responsibilities |
|-----------|------------|------------------|
| Ziyaad | Person A | Data structures, relationships, exception handling |
| Nurul Adriana    | Person B | Inheritance, polymorphism, documentation & testing |

---

## 🛠️ Features Implemented

- ✅ Add, list, find, and remove books in a library
- ✅ Borrowed book tracking for members
- ✅ Custom exception for invalid or missing books
- ✅ Abstract superclass `User` with subclasses `Member` and `Librarian`
- ✅ Method overriding (`calculateFine()`, `displayRole()`)
- ✅ Dynamic binding with polymorphism

---

## 🧠 Object-Oriented Concepts Used

| Concept | Explanation |
|--------|-------------|
| **Inheritance** | `Member` and `Librarian` extend `User` |
| **Polymorphism** | Dynamic binding: `User u = new Member(); u.displayRole();` |
| **Composition** | `Library` has a list of `Book` objects |
| **Association** | `Member` borrows `Book` (linked behaviorally) |
| **Encapsulation** | Private fields with public getters/setters |
| **Exception Handling** | `BookNotFoundException`, input validation, try-catch in `main()` |

---

## 🔍 Sample Output

=== Adding Books ===
Book added: The Hobbit
Book added: The Alchemist

=== Listing All Books ===
Current books in library:
[The Hobbit] by J.R.R. Tolkien (ISBN: 1111)
[The Alchemist] by Paulo Coelho (ISBN: 2222)

=== Finding Book ===
[The Hobbit] by J.R.R. Tolkien (ISBN: 1111)

=== Removing Book ===
Removed book with ISBN: 1111

=== Listing Remaining Books ===
Current books in library:
[The Alchemist] by Paulo Coelho (ISBN: 2222)

=== Member Borrows a Book ===
Ziyaad borrowed: The Alchemist
Ziyaad has borrowed:
[The Alchemist] by Paulo Coelho (ISBN: 2222)

=== Member Info ===
Role: Member
Fine for 3 late days: RM1.5

=== Polymorphism Test ===
Role: Member
Fine for 5 late days: RM2.5
Role: Librarian
Fine for 5 late days: RM0.0

---

## ▶️ How to Run

1. Compile the program.
2. Run the program.

---

## 🧪 Testing Guide

- Use the terminal or IDE console to verify book operations, member borrowing, and fine calculation.
- Screenshots of sample output are recommended as proof of testing.

---

## 📄 UML Class Diagram

*(See below 👇)*

