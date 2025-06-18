class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayRole() {
        System.out.println("I am a person.");
    }
}

// Inheritance & Polymorphism
class Student extends Person {
    private String studentId;

    public Student(String name, String studentId) {
        super(name);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public void displayRole() {
        System.out.println("I am a student. My name is " + name);
    }

    // Missing method: enrollCourse(Course course) (Fixed)
    public void enrollCourse(Course course) {
        System.out.println(name + " is enrolled in " + course.courseName);
    }
}

// Inheritance & Polymorphism
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

// Aggregation
class Course {
    String courseName;
    Teacher teacher;

    // Error: constructor missing parameter for courseName (Fixed)
    public Course(String courseName, Teacher teacher) {
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public void showCourseInfo() {
        System.out.println("Course: " + courseName + ", Taught by: " + teacher.getName());
    }
}

// Composition
class Classroom {
    String roomNumber;
    private Course course;

    public Classroom(String roomNumber, String courseName, Teacher teacher) {
        this.roomNumber = roomNumber;

        // Error: Course constructor expects one parameter, but two passed (Fixed)
        this.course = new Course(courseName, teacher); 
    }

    public void showClassroomInfo() {
        System.out.println("Classroom: " + roomNumber);
        // Missing: call method to show course info (Fixed)
        course.showCourseInfo(); // Display course info
    }

    public Course getCourse() {
        return course;
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Person p1 = new Student("Ali", "S100");
        Person p2 = new Teacher("Ms. Zara", "Biology");

        p1.displayRole();
        p2.displayRole();

        Teacher t = new Teacher("Mr. Samad", "History");
        Classroom c = new Classroom("R202", "World History", t);
        c.showClassroomInfo();

        Student student = new Student("Ali", "S100");

        // Missing: student enrolls in course from classroom (Fixed)
        Course course = c.getCourse();
        student.enrollCourse(course);
    }
}
