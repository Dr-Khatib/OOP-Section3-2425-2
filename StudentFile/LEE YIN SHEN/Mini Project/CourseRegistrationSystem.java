import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Superclass
class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public void displayRole() {
        System.out.println("I am a person.");
    }
}

// Subclass 1
class Student extends Person {
    private String studentId;
    private ArrayList<Course> registeredCourses;

    public Student(String name, String studentId) {
        super(name);
        this.studentId = studentId;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
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

    public void removeCourse(String courseName) {
        registeredCourses.removeIf(c -> c.getCourseName().equalsIgnoreCase(courseName));
    }

    @Override
    public void displayRole() {
        System.out.println("I am a student. My name is " + name);
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

// Subclass 2
class Admin extends Person {
    public Admin(String name) {
        super(name);
    }

    @Override
    public void displayRole() {
        System.out.println("I am an admin. My name is " + name);
    }

    public void viewAllStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            System.out.println("All Registered Students:");
            for (Student s : students) {
                System.out.println("- " + s.getName() + " (" + s.getStudentId() + ")");
            }
        }
    }
}

// Course class
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
        Admin admin = new Admin("Admin1");

        
        courses.add(new Course("Mathematics"));
        courses.add(new Course("Physics"));
        courses.add(new Course("Computer Science"));

        int choice = -1;

        while (choice != 9) {
            try {
                System.out.println("\n==== COURSE REGISTRATION SYSTEM ====");
                System.out.println("1. Register New Student");
                System.out.println("2. Register Student to Course");
                System.out.println("3. View All Students");
                System.out.println("4. View Student's Registered Courses");
                System.out.println("5. Add New Course");
                System.out.println("6. Remove Course");
                System.out.println("7. Remove Student and Their Courses");
                System.out.println("8. View All Courses");
                System.out.println("9. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student ID: ");
                        String id = scanner.nextLine();
                        students.add(new Student(name, id));
                        System.out.println("Student registered successfully.");
                        break;

                    case 2: 
                        if (students.isEmpty()) {
                            System.out.println("No students found.");
                            break;
                        }
                        System.out.println("Select a student:");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println((i + 1) + ". " + students.get(i).getName());
                        }
                        int studentIndex = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (studentIndex < 0 || studentIndex >= students.size()) {
                            System.out.println("Invalid student selection.");
                            break;
                        }

                        System.out.println("Available Courses:");
                        for (int i = 0; i < courses.size(); i++) {
                            System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
                        }
                        System.out.print("Enter course number: ");
                        int courseIndex = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (courseIndex < 0 || courseIndex >= courses.size()) {
                            System.out.println("Invalid course selection.");
                        } else {
                            students.get(studentIndex).registerCourse(courses.get(courseIndex));
                            System.out.println("Course registered successfully.");
                        }
                        break;

                    case 3: 
                        admin.viewAllStudents(students);
                        break;

                    case 4: 
                        if (students.isEmpty()) {
                            System.out.println("No students to display.");
                            break;
                        }
                        System.out.println("\nStudent List:");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println((i + 1) + ". " + students.get(i).getName());
                        }
                        System.out.print("Enter the number of student: ");
                        int viewIndex = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (viewIndex < 0 || viewIndex >= students.size()) {
                            System.out.println("Invalid selection.");
                        } else {
                            students.get(viewIndex).viewRegisteredCourses();
                        }
                        break;

                    case 5: 
                        System.out.print("Enter new course name: ");
                        String newCourse = scanner.nextLine();
                        courses.add(new Course(newCourse));
                        System.out.println("Course added.");
                        break;

                    case 6: 
                        System.out.print("Enter course name to remove: ");
                        String courseToRemove = scanner.nextLine();
                        boolean removed = courses.removeIf(c -> c.getCourseName().equalsIgnoreCase(courseToRemove));

                        
                        for (Student s : students) {
                            s.removeCourse(courseToRemove);
                        }

                        if (removed) {
                            System.out.println("Course removed from system and all students.");
                        } else {
                            System.out.println("Course not found.");
                        }
                        break;

                    case 7:
                        System.out.print("Enter student ID to remove: ");
                        String idToRemove = scanner.nextLine();
                        boolean studentRemoved = students.removeIf(s -> s.getStudentId().equalsIgnoreCase(idToRemove));
                        if (studentRemoved) {
                            System.out.println("Student and their courses removed.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 8: 
                        if (courses.isEmpty()) {
                            System.out.println("No courses available.");
                        } else {
                            System.out.println("Available Courses:");
                            for (Course c : courses) {
                                System.out.println("- " + c.getCourseName());
                            }
                        }
                        break;

                    case 9:
                        System.out.println("Exiting system. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Numbers only.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
