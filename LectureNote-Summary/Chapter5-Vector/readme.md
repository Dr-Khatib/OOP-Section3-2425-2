Here’s a reworked and comprehensive Java notes chapter on **`Vector`**, incorporating the contents of the lecture note along with clear explanations, comparisons, and Java code examples.

---

# 📘 Java Collections: `Vector`

## 🧠 What is a Vector?

A **`Vector`** is a dynamic array that can grow or shrink in size at runtime. It belongs to the **`java.util`** package and provides thread-safe operations for managing a list of objects.

### ✅ Why Use Vector?

* Arrays in Java have **fixed size**. Once created, they cannot grow.
* Vectors offer **dynamic resizing** and can be modified anytime.
* Suitable when **thread safety** is needed (methods are synchronized).
* Can store **any object** (including wrappers for primitive types).

---

## 🆚 Array vs ArrayList vs Vector

| Feature       | Array           | ArrayList          | Vector                     |
| ------------- | --------------- | ------------------ | -------------------------- |
| Size          | Fixed           | Dynamic            | Dynamic                    |
| Thread Safety | Not thread-safe | Not thread-safe    | Thread-safe (synchronized) |
| Performance   | Fast            | Faster than Vector | Slightly slower            |
| Null Allowed? | Yes             | Yes                | Yes                        |
| Type Safety   | Homogeneous     | Generic            | Generic                    |
| Package       | `java.lang`     | `java.util`        | `java.util`                |

---

## 🛠️ Basic Operations and API

### ✨ Constructor

```java
Vector<E> v = new Vector<>();
Vector<E> v = new Vector<>(initialCapacity);
```

### ✨ Common Methods (with examples)

```java
addElement(Object obj)        // Add to end
insertElementAt(obj, index)   // Insert at index
elementAt(index)              // Get element
setElementAt(obj, index)      // Modify element
removeElement(obj)            // Remove by object
removeElementAt(index)        // Remove by index
removeAllElements()           // Clear vector
firstElement(), lastElement() // Access boundary
indexOf(obj), lastIndexOf(obj)// Search
size(), capacity()            // Info
trimToSize()                  // Shrink capacity
```

---

## 🧪 Code Examples

### 1️⃣ Creating and Adding Elements

```java
import java.util.Vector;

public class FacultyVector {
    public static void main(String[] args) {
        Vector<String> faculty = new Vector<>();

        faculty.addElement("FSKSM");
        faculty.addElement("FS");
        faculty.addElement("FKE");
        faculty.addElement("FAB");

        System.out.println("Faculty list: " + faculty);
        System.out.println("Size: " + faculty.size());
    }
}
```

---

### 2️⃣ Insert, Remove, and Modify

```java
faculty.insertElementAt("FPPSM", 2);
faculty.removeElement("FKE");
faculty.removeElementAt(2);
faculty.setElementAt("FKSG", 2);

System.out.println("Updated Faculty: " + faculty);
System.out.println("Element at index 1: " + faculty.elementAt(1));
```

---

### 3️⃣ Wrapper Classes in Vectors

```java
Vector<Double> numbers = new Vector<>();
double x = 13.5;
numbers.addElement(Double.valueOf(x));
double y = numbers.elementAt(0);  // Auto-unboxing

System.out.println("Stored number: " + y);
```

---

### 4️⃣ Sum of All Doubles in a Vector

```java
Vector<Object> v = new Vector<>();
v.addElement("Ali");
v.addElement(Double.valueOf(15.0));
v.addElement(Double.valueOf(35.5));
v.addElement(Integer.valueOf(100));

double sum = 0.0;
for (Object obj : v) {
    if (obj instanceof Double) {
        sum += (Double) obj;
    }
}
System.out.println("Sum of Double elements: " + sum);
```

---

### 5️⃣ Storing Custom Objects

```java
class Employee {
    String name;
    Employee(String name) { this.name = name; }
    public String toString() { return name; }
}

public class EmployeeVector {
    public static void main(String[] args) {
        Vector<Employee> employees = new Vector<>();
        Employee emp1 = new Employee("John");
        Employee emp2 = new Employee("Jane");

        employees.addElement(emp1);
        employees.addElement(emp2);

        employees.setElementAt(new Employee("Mike"), 1);
        employees.insertElementAt(new Employee("Sara"), 1);
        employees.removeElementAt(0);

        System.out.println(employees);
    }
}
```

---

## 🧩 Full Runnable Class Example

```java
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        // Create a vector of strings
        Vector<String> departments = new Vector<>();

        // Add elements
        departments.addElement("Engineering");
        departments.addElement("Business");
        departments.addElement("Science");
        departments.addElement("Law");

        // Insert element
        departments.insertElementAt("Medicine", 2);

        // Remove element
        departments.removeElement("Law");

        // Update element
        departments.setElementAt("Arts", 1);

        // Access element
        String dept = departments.elementAt(2);
        System.out.println("Element at index 2: " + dept);

        // Loop and display all
        System.out.println("Departments: " + departments);

        // Vector size
        System.out.println("Total departments: " + departments.size());
    }
}
```


