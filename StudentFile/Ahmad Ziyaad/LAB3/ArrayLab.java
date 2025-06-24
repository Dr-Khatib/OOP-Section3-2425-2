import java.util.*;

public class ArrayLab {

    public static void main(String[] args) {
        PartA();
        PartB();

        System.out.println("==== Part C: Working with Methods ====");
        System.out.println("-- Question 7 --");
        Scanner input = new Scanner(System.in);

        // 1D array for student scores
        int[] scores = new int[5];
        for (int i = 0; i < scores.length; i++) {
            System.out.print("Please enter score #" + (i + 1) + ": ");
            scores[i] = input.nextInt();
        }

        // Question 7
        int highestScore = findHighestScore(scores);
        System.out.println(">> Highest Score Recorded: " + highestScore + "\n");

        // 2D array for marks of 3 students and 3 subjects
        int[][] marks = {
            {85, 78, 90},
            {88, 92, 79},
            {75, 80, 85}
        };

        // Question 9
        System.out.println("-- Question 9 --");
        int sum = sumSubjectMarks(marks);
        System.out.println(">> Total Marks for All Subjects: " + sum + "\n");

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
        System.out.println("-- Question 8 --");
        printStudentInfo(students);

        input.close();
    }

    public static void PartA(){
        System.out.println("==== Part A: Correct the Errors ====");
        // Question 1
        System.out.println("-- Question 1 --");
        System.out.println("Original:\n\tdouble gpa[] = new double(4);");
        System.out.println("Fixed:\n\tdouble gpa[] = new double[4];\n");
        double gpa[] = new double[4];

        // Question 2
        System.out.println("-- Question 2 --");
        System.out.println("Original:\n\tint[] points;\n\tpoints = {90, 85, 88};");
        System.out.println("Fixed:\n\tint[] points = {90, 85, 88};\n");
        int[] points = {90, 85, 88};

        // Question 3
        System.out.println("-- Question 3 --");
        System.out.println("Original:\n\tpublic static void printTotal(int... values, String title) { ... }");
        System.out.println("Fixed:\n\tpublic static void printTotal(String title, int... values) { ... }\n");
    }

    public static void printTotal(String title, int... values) {
        // Implementation not required for this exercise
    }

    public static void PartB(){
        System.out.println("==== Part B: Array Declarations ====");
        // Question 4
        System.out.println("-- Question 4 --");
        System.out.println("\tint[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };");
        int [][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Question 5
        System.out.println("-- Question 5 --");
        System.out.println("\tArrayList<Double> grades = new ArrayList<Double>();");
        ArrayList<Double> grades = new ArrayList<>();

        // Question 6
        System.out.println("-- Question 6 --");
        printAverage(new int[]{10, 20, 30, 40});
    }

    public static void printAverage(int[] a){
        System.out.print("Array Elements: ");
        int sum = 0;
        for(int x : a){
            System.out.print(x + " ");
            sum += x;
        }
        double average = (double) sum / a.length;
        System.out.printf("\nComputed Average: %.2f\n\n", average);
    }

    public static int findHighestScore(int[] scores){
        int max = scores[0];
        for (int score : scores){
            if (score > max){
                max = score;
            }
        }
        return max;
    }

    public static void printStudentInfo(Student[] arr) {
        System.out.println("Student Details:");
        for(Student s : arr){
            System.out.println("- Name: " + s.getName() + ", Age: " + s.getAge());
        }
        System.out.println();
    }

    public static int sumSubjectMarks(int[][] marks){
        int total = 0;
        for(int[] row : marks){
            for(int mark : row){
                total += mark;
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
