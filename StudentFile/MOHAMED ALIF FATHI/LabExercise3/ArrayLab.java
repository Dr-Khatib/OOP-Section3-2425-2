//Name: MOHAMED ALIF FATHI BIN ABDUL LATIF
//Matric Number: A23CS0112

import java.util.*;

public class ArrayLab {
    public static void main(String[] args) {

        // PART A - Question 1
        double gpa[] = new double[4];

        // PART A - Question 2
        int[] points;
        points = new int[] {90, 85, 88};

        // PART B - Question 4
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // PART B - Question 5
        ArrayList<Double> grades = new ArrayList<>();

        // PART A and B - Print methods
        partA();
        partB();

        // PART B - Question 6
        printAverage(new int[]{10, 20, 30, 40});

        Scanner input = new Scanner(System.in);

        System.out.println("Part C: Create & Use Methods\n");

        // 1D array for student scores
        int[] scores = new int[5];
        for (int i = 0; i < scores.length; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = input.nextInt();
        }

        // PART C - Question 7
        int highestScore = findHighestScore(scores);
        System.out.println("\nQuestion 7:");
        System.out.println("Highest score: " + highestScore + "\n");

        // 2D array for marks of 3 students and 3 subjects
        int[][] marks = {
            {85, 78, 90},
            {88, 92, 79},
            {75, 80, 85}
        };

        // PART C - Question 9
        System.out.println("Question 9:");
        System.out.println("Total marks of all students: " + sumSubjectMarks(marks) + "\n");

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
        // PART C - Question 8
        System.out.println("Question 8:");
        printStudentInfo(students);

        input.close();
    }

    // PART A - Print
    public static void partA()
    {
        System.out.println("Part A: Spot the Errors\n");

        System.out.println("Question 1:");
        System.out.println("double gpa[] = new double(4); // Line to fix\n");
        System.out.println("double gpa[] = new double[4]; // Corrected\n");
        
        System.out.println("Question 2:");
        System.out.println("int[] points;\n" +
                           "points = new int[] {90, 85, 88}; // Line to fix\n");
        System.out.println("points = new int[] {90, 85, 88}; // Corrected\n");

        System.out.println("Question 3:");
        System.out.println("public static void printTotal(int... values, String title) { // Invalid\n" +
                           "    // ...\n" +
                           "}\n");
        System.out.println("public static void printTotal(String title, int... values) { // Corrected\n" +
                           "    // ...\n" +
                           "}\n");
    }

    // PART A - Question 3
    public static void printTotal(String title, int... values) {
        // ...
    }

    // PART B - Print
    public static void partB()
    {
        System.out.println("Part B: Write Short Array Declarations\n");

        System.out.println("Question 4:");
        System.out.println("Answer:");
        System.out.println("int[][] matrix = {\n" +
                           "    {1, 2, 3},\n" +
                           "    {4, 5, 6},\n" +
                           "    {7, 8, 9}\n" +
                           "};\n");

        System.out.println("Question 5:");
        System.out.println("Answer:");
        System.out.println("ArrayList<Double> grades = new ArrayList<>();\n");

        System.out.println("Question 6:");
        System.out.println("Answer:");
        System.out.println("printAverage(new int[]{10, 20, 30, 40});");
    }

    // PART B - Question 6
    public static void printAverage(int[] arr) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        double avg = (double) sum / arr.length;
        System.out.println("Average of anonymous array: " + avg + "\n");
    }

    // PART C - Question 7
    public static int findHighestScore(int[] scores) {
        int highest = scores[0];
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
        }
        return highest;
    }

    // PART C - Question 8
    public static void printStudentInfo(Student[] arr) {
        for (Student s : arr) {
            System.out.println("Student: " + s.getName() + ", Age: " + s.getAge());
        }
    }

    // PART C - Question 9
    public static int sumSubjectMarks(int[][] marks) {
        int total = 0;
        for (int[] row : marks) {
            for (int val : row) {
                total += val;
            }
        }
        return total;
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