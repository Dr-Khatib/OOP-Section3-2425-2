public class Main {
    public static void main(String[] args) {
        // Question 1
        Employee emp = new Employee();
        emp.setEmpNum(101);
        emp.setEmpName("Ali");
        System.out.println("Employee Number: " + emp.getEmpNum());
        System.out.println("Employee Name: " + emp.getEmpName());

        // Question 3
        Book javaBook = new Book("Java 101", "John Doe");
        javaBook.display();

        // Question 6
        new User();
        new User();
        System.out.println("Total Users: " + User.getUserCount());

        // Question 7
        Employee emp2 = new Employee();
        emp2.setSalary(5000);
        System.out.println("Salary: " + emp2.getSalary());

        // Question 2
        Car myCar = new Car();
        myCar.setBrand("Toyota");
        myCar.setYear(2022);
        System.out.println("Car Brand and Year: " + myCar.getBrand() + ", " + myCar.getYear());

        // Question 4
        Student learner = new Student();
        learner.setName("Sara");
        learner.setAge(20);
        System.out.println("Student Age: " + learner.getAge());

        // Question 5
        Message m = new Message();
        m.display();
        m.display("Welcome to Java!");
    }
}

// Question 1 & 7
class Employee {
    private int id;
    private String fullName;
    private double monthlySalary;

    public void setEmpNum(int num) {
        id = num;
    }

    public void setEmpName(String name) {
        fullName = name;
    }

    public int getEmpNum() {
        return id;
    }

    public String getEmpName() {
        return fullName;
    }

    // Question 7
    public void setSalary(double salary) {
        monthlySalary = salary;
    }

    public double getSalary() {
        return monthlySalary;
    }
}

// Question 2
class Car {
    private String brand;
    private int manufactureYear;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setYear(int year) {
        manufactureYear = year;
    }

    public int getYear() {
        return manufactureYear;
    }
}

// Question 3
class Book {
    private String title;
    private String author;

    public Book(String bookTitle, String bookAuthor) {
        title = bookTitle;
        author = bookAuthor;
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Question 4
class Student {
    private String name;
    private int age;

    public void setName(String studentName) {
        name = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int studentAge) {
        age = studentAge;
    }
}

// Question 5
class Message {
    public void display() {
        System.out.println("Hello!");
    }

    public void display(String msg) {
        System.out.println("Message: " + msg);
    }
}

// Question 6
class User {
    private static int userCount = 0;

    public User() {
        userCount++;
    }

    public static int getUserCount() {
        return userCount;
    }
}
