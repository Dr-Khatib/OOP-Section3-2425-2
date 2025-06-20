class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public void displayRole() {
        System.out.println("I am a person.");
    }
}

// Inheritance & Polymorphism: Student inherits from Person and overrides displayRole()
class Student extends Person {
    private String studentId;
    
    public Student(String name, String studentId) {
        super(name);
        this.studentId = studentId;
    }

    @Override
    public void displayRole() {
        System.out.println("I am a student. My name is " + name);
    }

    /**
     * Association: A Student can be associated with a Course.
     * This method represents the action of enrolling.
     * @param course The course to enroll in.
     */
    public void enrollCourse(Course course) {
        System.out.println(this.name + " is enrolled in " + course.courseName);
    }
}

// Inheritance & Polymorphism: Teacher inherits from Person and overrides displayRole()
class Teacher extends Person {
    private String subject;

    public Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    @Override
    public void displayRole() {
        System.out.println("I am a teacher. My name is " + name + " and I teach " + subject);
    }

    public String getSubject() {
        return subject;
    }
}

/**
 * Aggregation: A Course has a Teacher.
 * The Teacher can exist independently of the Course.
 */
class Course {
    String courseName;
    Teacher teacher; // The teacher is part of the course but not owned by it.

    // FIX: The constructor now correctly accepts and initializes both courseName and teacher.
    public Course(String courseName, Teacher teacher) {
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public void showCourseInfo() {
        // The courseName is now properly initialized.
        System.out.println("Course: " + courseName + ", Taught by: " + teacher.name);
    }
}

/**
 * Composition: A Classroom is composed of a Course.
 * The Course object is created and managed internally by the Classroom and
 * does not exist outside of it.
 */
class Classroom {
    String roomNumber;
    private Course course; // The course is owned by the classroom.

    public Classroom(String roomNumber, String courseName, Teacher teacher) {
        this.roomNumber = roomNumber;
        // FIX: The call to the Course constructor now matches its corrected definition.
        this.course = new Course(courseName, teacher);
    }

    public void showClassroomInfo() {
        System.out.println("Classroom: " + roomNumber);
        // COMPLETE: Added the missing call to display the course information.
        this.course.showCourseInfo();
    }

    public Course getCourse() {
        return course;
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        // --- Polymorphism Demonstration ---
        // Person references hold Student and Teacher objects.
        Person p1 = new Student("Ali", "S100");
        Person p2 = new Teacher("Ms. Zara", "Biology");

        // The overridden displayRole() method is called for each object.
        p1.displayRole();
        p2.displayRole();

        // --- Aggregation and Composition Demonstration ---
        // A standalone Teacher object is created.
        Teacher t = new Teacher("Mr. Samad", "History");
        // The Classroom object creates and owns its Course object (Composition).
        // The Course object has a reference to the Teacher (Aggregation).
        Classroom c = new Classroom("R202", "World History", t);
        c.showClassroomInfo();

        // --- Association Demonstration ---
        Student student = new Student("Ali", "S100");

        // COMPLETE: The student enrolls in the course offered in the classroom.
        // This establishes an association between the Student and the Course.
        student.enrollCourse(c.getCourse());
    }
}
