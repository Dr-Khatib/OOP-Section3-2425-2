import java.util.ArrayList;
import java.util.Scanner;

abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String inputUser, String inputPass) {
        return username.equals(inputUser) && password.equals(inputPass);
    }

    public abstract void showMenu(Scanner scanner, ArrayList<Student> students, ArrayList<Course> courses);
}

class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void showMenu(Scanner scanner, ArrayList<Student> students, ArrayList<Course> courses) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. View All Students");
            System.out.println("4. Remove Student");
            System.out.println("5. Logout");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student password: ");
                    String pwd = scanner.nextLine();
                    students.add(new Student(name, id, pwd));
                    System.out.println("Student added.");
                    break;
                case 2:
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    courses.add(new Course(courseName));
                    System.out.println("Course added.");
                    break;
                case 3:
                    System.out.println("\nAll Students:");
                    int count = 1 ;
                    for (Student student : students) {
                        System.out.println(count + ". " + student.username + " (" + student.getStudentId() + ")");
                        count++;
                    }   
                    break;
                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students to remove.");
                        break;
                    }
                    System.out.println("\nCurrent Students:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).getStudentId());
                    }
                    System.out.print("Enter student number to remove: ");
                    int removeIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (removeIndex >= 0 && removeIndex < students.size()) {
                        students.remove(removeIndex);
                        System.out.println("Student removed.");
                    } else {
                        System.out.println("Invalid student number.");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

class Student extends User {
    private String studentId;
    private ArrayList<Course> registeredCourses;

    public Student(String name, String studentId, String password) {
        super(name, password);
        this.studentId = studentId;
        this.registeredCourses = new ArrayList<>();
    }

    @Override
    public boolean login(String inputUser, String inputPass) {
        return studentId.equals(inputUser) && password.equals(inputPass);
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        System.out.println("Course " + course.getCourseName() + " registered.");
    }

    public void removeCourse(Course course) {
        registeredCourses.remove(course);
        System.out.println("Course " + course.getCourseName() + " removed.");
    }

    public void viewRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("\nRegistered Courses:");
            for (Course c : registeredCourses) {
                System.out.println("- " + c.getCourseName());
            }
        }
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public void showMenu(Scanner scanner, ArrayList<Student> students, ArrayList<Course> courses) {
        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Register Course");
            System.out.println("2. Remove Registered Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Logout");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (courses.isEmpty()) {
                        System.out.println("No available courses.");
                        break;
                    }
                    System.out.println("\nAvailable Courses:");
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
                    }
                    System.out.print("Select course number: ");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (index >= 0 && index < courses.size()) {
                        registerCourse(courses.get(index));
                    } else {
                        System.out.println("Invalid course number.");
                    }
                    break;
                case 2:
                    if (registeredCourses.isEmpty()) {
                        System.out.println("No registered courses to remove.");
                        break;
                    }
                    System.out.println("\nCurrent Registered Courses:");
                    for (int i = 0; i < registeredCourses.size(); i++) {
                        System.out.println((i + 1) + ". " + registeredCourses.get(i).getCourseName());
                    }
                    System.out.print("Select course number to remove: ");
                    int removeIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (removeIndex >= 0 && removeIndex < registeredCourses.size()) {
                        removeCourse(registeredCourses.get(removeIndex));
                    } else {
                        System.out.println("Invalid course number.");
                    }
                    break;
                case 3:
                    viewRegisteredCourses();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

class Course {
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        Admin admin = new Admin("admin", "admin123");

        courses.add(new Course("Mathematics"));

        while (true) {
            System.out.println("\n=== Course Registration System ===");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.print("Select option: ");
            int mainChoice;
            try {
                mainChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (mainChoice == 1) {
                System.out.print("Enter Admin ID: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (admin.login(username, password)) {
                    admin.showMenu(scanner, students, courses);
                } else {
                    System.out.println("Invalid admin credentials.");
                }
            } else if (mainChoice == 2) {
                System.out.print("Enter Student ID: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                boolean studentFound = false;
                for (Student student : students) {
                    if (student.login(username, password)) {
                        studentFound = true;
                        student.showMenu(scanner, students, courses);
                        break;
                    }
                }

                if (!studentFound) {
                    System.out.println("Invalid student credentials.");
                }
            } else if (mainChoice == 3) {
                System.out.println("Exiting program. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }
}
