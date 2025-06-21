# **Course Registration System**

## **Group Members**
1. Tan Zhi Ming (A23CS0189)
2. Lee Yin Shen (A23CS0236)

## **Project Description**
The **Course Registration System** is a Java-based, menu-driven program that allows an admin to manage students and courses dynamically. Admins can add and remove courses, register students, view course enrollments, and remove students. The system utilizes core Java Object-Oriented Programming (OOP) concepts and demonstrates good programming practices including exception handling and dynamic data storage using `ArrayList`.

---

### ✅ Chapter 5: Vectors and ArrayList
- `ArrayList<Student>` is used to store all students.
- `ArrayList<Course>` stores available courses.
- Each `Student` object also holds its own `ArrayList<Course>` for registered courses.
- Demonstrates usage of `.add()`, `.removeIf()`, `.get()`, and enhanced `for` loops.

```java
ArrayList<Student> students = new ArrayList<>();
ArrayList<Course> courses = new ArrayList<>();
student.registerCourse(courses.get(0));
students.removeIf(s -> s.getStudentId().equals("A123"));
```

### ✅ Chapter 6: Class Relationships
- **Composition**: `Student` has a list of `Course` objects — a "has-a" relationship.
- **Association**: The `Admin` class interacts with both `Student` and `Course` objects to perform operations.
- This shows at least two types of class relationships as required in the rubric.

```java
public class Student extends Person {
    private ArrayList<Course> registeredCourses = new ArrayList<>();
    ...
}
public class Admin extends Person {
    public void viewAllStudents(ArrayList<Student> students) {
        for (Student s : students) {
            System.out.println(s.getName());
        }
    }
}
```

### ✅ Chapter 7: Inheritance
- A superclass `Person` is created with a shared attribute `name` and a method `displayRole()`.
- Two subclasses are defined:
  - `Student` inherits from `Person` and includes `studentId`, course list, and registration methods.
  - `Admin` inherits from `Person` and provides administrative functions.
- This structure supports code reuse and logical hierarchy in the program.

```java
class Person {
    protected String name;
    public void displayRole() {
        System.out.println("I am a person.");
    }
}

class Student extends Person {
    private String studentId;
    public void displayRole() {
        System.out.println("I am a student. My name is " + name);
    }
}

class Admin extends Person {
    public void displayRole() {
        System.out.println("I am an admin. My name is " + name);
    }
}
```

### ✅ Chapter 8: Polymorphism
- The `displayRole()` method is overridden in both `Student` and `Admin` subclasses.
- When `displayRole()` is called, Java determines at runtime which version to execute based on the object type.
- This is an example of **method overriding** — a form of polymorphism.

```java
Person p1 = new Student("Ali", "S123");
Person p2 = new Admin("Zahra");

p1.displayRole(); // I am a student. My name is Ali
p2.displayRole(); // I am an admin. My name is Zahra
```

### ✅ Chapter 9: Exception Handling
- The program uses `try-catch` blocks to handle:
  - Invalid numeric input (e.g., letters when expecting numbers)
  - Invalid index selection from course or student lists
  - Unexpected errors using general `Exception` catch block
- This ensures the program runs smoothly without crashing on user mistakes.

```java
try {
    int index = scanner.nextInt();
    Course selected = courses.get(index);
} catch (InputMismatchException e) {
    System.out.println("Invalid input. Please enter a number.");
} catch (IndexOutOfBoundsException e) {
    System.out.println("Course not found. Please enter a valid index.");
} catch (Exception e) {
    System.out.println("An unexpected error occurred.");
}
```

---

## **How to Use**
1. Compile the program:
   ```
   javac CourseRegistrationSystem.java
   ```

2. Run the program:
   ```
   java CourseRegistrationSystem
   ```

3. Use the menu to navigate:
   ```
   ==== COURSE REGISTRATION SYSTEM ====
   1. Register New Student
   2. Register Student to Course
   3. View All Students
   4. View Student's Registered Courses
   5. Add New Course
   6. Remove Course
   7. Remove Student and Their Courses
   8. View All Courses
   9. Exit
   ```

---

## **Conclusion**
This project demonstrates complete application of Java OOP concepts across Chapters 5–9, fulfilling all rubric requirements including dynamic data structures, class relationships, inheritance, polymorphism, and exception handling in a single cohesive console application.
