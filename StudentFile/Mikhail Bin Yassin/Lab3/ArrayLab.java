import java.util.*;

public class ArrayLab {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1D array for student scores
        int[] scores = new int[5];
        for (int i = 0; i < scores.length; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = input.nextInt();
        }

        // 2D array for marks of 3 students and 3 subjects
        int[][] marks = {
                {85, 78, 90},
                {88, 92, 79},
                {75, 80, 85}
        };

        // ArrayList of subjects
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Math");
        subjects.add("Science");
        subjects.add("English");

        // Array of Student objects
        Student[] students = new Student[3];
        students[0] = new Student("Ali", 20);
        students[1] = new Student("Siti", 21);
        students[2] = new Student("Raj", 19);


        // --- Answers ---
        // 1.
        double[] gpa = new double[4]; // () -> [], preferred-style array declaration

        // 2.
        int[] points = {90, 85, 88}; // init + declare at the same time.

        // 4.
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        // 5.
        ArrayList<Double> grade = new ArrayList<Double>(); // double is a primitive data type, use Java Double

        // 6.
        printAverage(new int[] {10,20,30,40});

        // 7.
        findHighestScore(scores);

        // 8.
        printStudentInfo(students);

        // 9.
        sumSubjectMarks(marks);
        
        // --- END ---
        
        input.close();
    }
    
    // --- Answer: Methods ----
    // 3.
    public static void printTotal(String title, int... values) { // variable-length arguments must be the last args.
    }

    // 6.
    public static void printAverage(int[] values) {
        int sum = 0;
        int avg = 0;
        for (int value : values) {
            sum += value;
            avg = sum / values.length;
        }
        System.out.println("Average: " + avg);
    }

    // 7.
    public static void findHighestScore(int[] scores) {
        int highest = 0;
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
        }
        System.out.println("Highest score: " + highest);
    }

    // 8.
    public static void printStudentInfo(Student[] students) {
        for (Student s : students) {
            System.out.println("Student: " + s.getName() + ", Age: " + s.getAge());
        }
    }

    // 9.
    public static void sumSubjectMarks(int[][] marks) {
        int totalMarks = 0;

        for (int[] students : marks) {
            for (int mark : students) {
                totalMarks += mark;
            }
        }
        System.out.println("Total Marks: " + totalMarks);
    }
    // --- END ---
}

// Student class
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}
