public class Lab2 {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setEmpNum(101);
        e1.setEmpName("Ali");
        System.out.println("Employee Number: " + e1.getEmpNum());
        System.out.println("Employee Name: " + e1.getEmpName());

        //Question 3
        Book b1 = new Book("Java 101", "John Doe");
        b1.display();

        //Question 6
        new User();
        new User();
        System.out.println("Total Users: " + User.getUserCount());

        //Question 7
        Employee e = new Employee();
        e.setSalary(5000);
        System.out.println("Salary: " + e.getSalary());
    }
}

//Question 1
class Employee {
    // TODO: Add fields
    // TODO: Add setter and getter methods
    private int EmpNum;
    private String EmpName;
    private double EmpSalary;

    public void setEmpNum(int num){
        EmpNum = num;
    }
    
    public void setEmpName(String name){
        EmpName = name;
    }

    public int getEmpNum(){
        return EmpNum;
    }

    public String getEmpName(){
        return EmpName;
    }

    //Question 7
    // TODO: Make salary private
    public void setSalary(double salary){
        EmpSalary = salary;
    }

    // TODO: Write setSalary() and getSalary() methods
    public double getSalary(){
        return EmpSalary;
    }
}

//Question 2
class Car {
    private String carBrand;
    private int carYear;

    public void setCarbrand(String brand){
        carBrand = brand;
    }

    public int getCaryear(){
        return carYear;
    }
}

//Question 3
class Book {
    private String title;
    private String author;

    // TODO: Add a constructor

    public Book(String bookTitle, String bookAuthor){
        title = bookTitle;
        author = bookAuthor;
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

//Question 4
class Student {
    private String name;
    private int age;

    // TODO: Implement setter for name
    public void setName(String studName){
        name = studName;
    }

    // TODO: Implement getter for age
    public int getAge(){
        return age;
    }
}

//Question 5
class Message {
    // TODO: Write a method display() that prints "Hello!"
    public void display(){
        System.out.println("Hello!");
    }
    // TODO: Overload display(String msg) to print "Message: msg"
    public void display(String msg){
        System.out.println("Message: " + msg);
    }
}

//Question 6
class User {
    // TODO: Declare a static counter variable
    private static int counter;

    public User() {
        // TODO: Increment counter
        counter++;
    }

    public static int getUserCount() {
        // TODO: Return counter
        return counter;
    }
}



