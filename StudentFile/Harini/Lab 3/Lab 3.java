// Part A
// Corrected Line 1
//double gpa[] = new double[4];

// Corrected Line 2
// int[] points = {90, 85, 88}; 
// Corrected Line 3
// public static void printTotal(String title, int... values) { 
//    ...
// }
// Part B
import java.util.*;

public class Lab3Harini {

    // printAverage method -- continuation of Q6
    public static void printAverage(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.length;
        System.out.println("Average: " + average);
    }

    // Q7 : Create a static method named findHighestScore(int[] scores) that returns the highest value in the scores array. Call it from the main() method and print the result.
    public static int findHighestScore(int[] scores) {
        int highestScore = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > highestScore) {
                highestScore = scores[i];
            }
        }
        return highestScore;
    }

    // Q8 : Write a method named printStudentInfo(Student[] arr) to print all students’ name and age using enhanced for-each loop. Replace the existing print loop with a call to this method.
    public static void printStudentInfo(Student[] arr) {
        for (Student s : arr) {
            System.out.println("Student: " + s.getName() + ", Age: " + s.getAge());
        }
    }

    // Q9 : Write a method sumSubjectMarks(int[][] marks) that returns the sum of all elements in the marks 2D array and print the result in main().
    public static int sumSubjectMarks(int[][] marks) {
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; i < marks[i].length; j++) {
                sum += marks[i][j];
            }
        }
        return sum;
    }

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

        // Q4 : Declare and initialize a 2D array called matrix that stores the numbers 1 to 9 arranged in 3 rows and 3 columns.
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // ArrayList of subjects
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Math");
        subjects.add("Science");
        subjects.add("English");

        // Q5 : reate an ArrayList named grades that stores Double values for student grades.
        ArrayList<Double> grades = new ArrayList<>();

        // Array of Student objects
        Student[] students = new Student[3];
        students[0] = new Student("Ali", 20);
        students[1] = new Student("Siti", 21);
        students[2] = new Student("Raj", 19);

        input.close();

        // Q6 : Create an anonymous array to store and immediately print the average of {10, 20, 30, 40} using a helper method printAverage.
        printAverage(new int[]{10, 20, 30, 40}); // printAverage method is defined above 

        // Q7 continuation
        System.out.println("Highest score : " + findHighestScore(scores));

        // Q8 continuation
        printStudentInfo(students);

        // Q9 continuation
        System.out.println("Total marks of all subjects: " + sumSubjectMarks(marks));
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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
