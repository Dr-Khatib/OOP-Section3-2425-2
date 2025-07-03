Here's a comprehensive exam-oriented study guide for your Java OOP Chapters 5 to 9, structured by exam parts and including short notes, code samples, and tips.

---

## ✅ Part A: Multiple Choice Questions (15 Marks)

**2 questions per chapter (3 for one). Total: 10 questions × 1.5 marks**

---

### **Chapter 5: Vectors and ArrayList**

#### ✏️ Short Notes:

* **ArrayList**: Resizable array, part of `java.util`
* **Vector**: Similar to ArrayList but synchronized (thread-safe)
* **Common Methods**: `add()`, `remove()`, `get()`, `size()`, `clear()`

#### 🔤 Code Example:

```java
ArrayList<String> names = new ArrayList<>();
names.add("Ali");
names.add("Siti");
System.out.println(names.get(0)); // Output: Ali

Vector<Integer> numbers = new Vector<>();
numbers.add(10);
numbers.add(20);
System.out.println(numbers.size()); // Output: 2
```

#### ✅ Tip:

* Use **ArrayList** for general purpose.
* Choose **Vector** only if you need thread safety.

---

### **Chapter 6: Class Relationship (Association, Aggregation, Composition)**

#### ✏️ Short Notes:

* **Association**: "Uses-a", loose relationship.
* **Aggregation**: "Has-a", part-whole, independent lifecycles.
* **Composition**: Strong ownership, part cannot exist without the whole.

#### 🔤 Code Example:

```java
class Engine {} // Composition
class Car {
    private Engine engine = new Engine(); // Composition
}

class Student {} // Aggregation
class University {
    private List<Student> students; // Aggregation
}
```

#### ✅ Tip:

* **Composition**: Object created inside the class.
* **Aggregation**: Object passed in/set from outside.

---

### **Chapter 7: Inheritance**

#### ✏️ Short Notes:

* `extends` keyword
* Superclass and subclass relationship
* Method overriding: same signature
* Method overloading: different parameters

#### 🔤 Code Example:

```java
class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}
```

#### ✅ Tip:

* Use `@Override` to prevent mistakes in overriding.
* Reuse code by extending common functionality.

---

### **Chapter 8: Polymorphism**

#### ✏️ Short Notes:

* **Compile-time (Overloading)** and **Runtime (Overriding)**
* Enables dynamic method dispatch
* Allows general interface usage

#### 🔤 Code Example:

```java
class Shape {
    void draw() {
        System.out.println("Drawing Shape");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

Shape shape = new Circle(); // Polymorphism
shape.draw(); // Output: Drawing Circle
```

#### ✅ Tip:

* Helps in writing flexible and extensible code.
* Look at object type, not reference type.

---

### **Chapter 9: Exception Handling**

#### ✏️ Short Notes:

* `try`, `catch`, `finally`
* `throw` (manual), `throws` (declaration)
* Checked (e.g. IOException), Unchecked (e.g. NullPointerException)

#### 🔤 Code Example:

```java
try {
    int x = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: Division by zero");
} finally {
    System.out.println("End");
}
```

#### ✅ Tip:

* Use **custom exception** for domain-specific errors.
* Catch **specific exceptions first**, then general.

---

## ✅ Part B: Structured (55 Marks)

> 3 Questions per chapter | Includes Explanation, Categorization, Drawing, Implementation

---

### **Chapter 6: Class Relationship (15 Marks)**

#### 📌 Key Concepts:

* Explain and differentiate Association, Aggregation, Composition.
* Identify relationships in class diagram or code.

#### 🔤 Sample Code:

```java
class Address {}
class Person {
    private Address address; // Aggregation
}
```

#### ✅ Tips:

* Use arrows for UML (hollow diamond = Aggregation, filled = Composition).
* Focus on object lifetime and ownership.

---

### **Chapter 7: Inheritance (15 Marks)**

#### 📌 Key Concepts:

* Implement superclass and subclass
* Override methods and improve design

#### 🔤 Sample Code:

```java
class Employee {
    double salary;
    void calculatePay() {}
}

class Manager extends Employee {
    double bonus;
    @Override
    void calculatePay() {
        super.calculatePay();
        // Add bonus logic
    }
}
```

#### ✅ Tips:

* Always identify shared attributes for superclass.
* Class diagram: `Subclass ➝ Superclass` with an empty arrow.

---

### **Chapter 8: Polymorphism (15 Marks)**

#### 📌 Key Concepts:

* Code should demonstrate overridden methods used via base class reference.

#### 🔤 Sample Code:

```java
class Vehicle {
    void move() { System.out.println("Moving"); }
}

class Bike extends Vehicle {
    void move() { System.out.println("Bike moving"); }
}

Vehicle v = new Bike();
v.move(); // Bike moving
```

#### ✅ Tips:

* Ensure you're instantiating the child class using parent reference.
* Use interface for broader polymorphism.

---

### **Chapter 9: Exception Handling (10 Marks)**

#### 📌 Key Concepts:

* Analyze code for risky operations (I/O, arithmetic, null)
* Apply `try-catch` blocks

#### 🔤 Sample Code:

```java
Scanner sc = new Scanner(System.in);
try {
    int n = sc.nextInt(); // risky input
} catch (InputMismatchException e) {
    System.out.println("Invalid input");
}
```

#### ✅ Tips:

* Always validate input.
* Use multiple catch blocks for clarity.

---

## ✅ Part C: Programming (30 Marks)

### 🔥 Task:

* Combine **ArrayList**, **Inheritance**, **Polymorphism**, and **Class Relationship**

#### 🧩 Sample Program Idea:

```java
abstract class Product {
    String name;
    double price;
    abstract void displayInfo();
}

class Book extends Product {
    int pages;
    void displayInfo() {
        System.out.println(name + " - " + pages + " pages");
    }
}

class Cart {
    ArrayList<Product> items = new ArrayList<>();
    void addItem(Product p) { items.add(p); }
    void showItems() {
        for (Product p : items) {
            p.displayInfo(); // Polymorphism
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Cart c = new Cart();
        c.addItem(new Book());
        c.showItems();
    }
}
```

#### ✅ Tips:

* Start with class diagram.
* Use `ArrayList` to store superclass type.
* Ensure at least one overridden method and relationship used.

---

## 📊 Cognitive Level Breakdown (Suggested):

* **LOT (Lower Order Thinking)**: 45–50%
  (Recall, Define, Identify - mainly MCQs and basic explanations)
* **HOT (Higher Order Thinking)**: 50–55%
  (Apply, Implement, Analyze, Improve - structure & programming)

---

