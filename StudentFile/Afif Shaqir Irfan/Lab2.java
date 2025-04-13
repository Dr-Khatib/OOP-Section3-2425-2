public class Lab2 {
    public static void main(String[] args) {

        //Q1
        Employee e1 = new Employee();
        e1.setEmpNum(101);
        e1.setEmpName("Ali");
        System.out.println("Employee Number: " + e1.getEmpNum());
        System.out.println("Employee Name: " + e1.getEmpName());

        //Q3
        Book b1 = new Book("Java 101","John Doe");
        b1.display();

        //Q6
        new User();
        new User();
        System.out.println("Total Users: " + User.getUserCount());

        //Q7
        Employee e = new Employee();
        e.setSalary(5000);
        System.out.println("Salary:" + e.getSalary());
    }
}

//Q1
class Employee {
    private int empNum;
    private String empName;

    public void setEmpNum(int num) {
        empNum = num;
    }

    public int getEmpNum() {
        return empNum;
    }

    public void setEmpName(String name) {
        empName = name;
    }

    public String getEmpName() {
        return empName;
    }

    //Q7
    private int salary;

    public void setSalary(int s) {
        salary = s;
    }

    public int getSalary() {
        return salary;
    }
}

// Q2
class Car {
    private String brand;
    private int year;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }
}

//Q3
class Book {
    private String title;
    private String author;

    public Book(String t, String a) {
        title = t;
        author = a;
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

//Q4
class Student {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
}

//Q5
class Message {
    public void display() {
        System.out.println("Hello!");
    }

    public void display(String msg) {
        System.out.println("Message: " + msg);
    }
}

//Q6
class User {
    private static int counter = 0;

    public User() {
        counter++;
    }

    public static int getUserCount() {
        return counter;
    }
}
