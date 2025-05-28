import java.util.*;

// spot the errors
// write short  array declarations
// create and implement helper functions

public class ArrayLab {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Part A : Fix the errors
        // question 1
        double gpa[] = new double[4];

        // question 2
        int[] points = new int[] {90, 85, 88};

        // question 3
        public static void printTotal(String title,int... values) { 
        }

        // Part B : write short Array Declarations
        // question 4 - initialize 2d array
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };

        // question 5 - create ArrayList<Double> for students grades
        ArrayList<Double> grades = new ArrayList<>();

        // question 6 - create an anonymous array using helper function printAverage 
        int[] numbers = {10, 20, 30, 40};
        printAverage(numbers);

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

        // Display all student names
        for (Student s : students) {
            System.out.println("Student: " + s.getName() + ", Age: " + s.getAge());
        }

        //Part C: Create & Use Methods 
        // question 7 - create a static method called findHighestScore(int[scores]) that returns the highest score.
        public static int findHighestScore(int[] scores) {
            int highestScore = 0;
            for (int score : scores) {
                if (score > highestScore) {
                    highestScore = score;
                }
            }
            return highestScore;
        }

        // question 8 - write a method names printStudentInfo(Student[] arr).
        public static void printStudentInfo(Student[] arr) {
            for (Student s : arr) {
                System.out.println("Name: " + s.getName() + ", Age: " + s.getAge());
            }
        }

        // question 9 - write a method sumSubjectMarks(int[][] marks)
        public static int sumSubjectMarks(int[][] marks) {
            int sum = 0;
            for (int i = 0; i < marks.length; i++) {
                for (int j = 0; j < marks[i].length; j++) {
                    sum += marks[i][j];
                }
            }
            return sum;
        }


        input.close();
    }
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



