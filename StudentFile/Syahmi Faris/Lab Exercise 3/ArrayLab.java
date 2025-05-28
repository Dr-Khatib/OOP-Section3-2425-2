import java.util.*;

public class ArrayLab {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Part A: Spot the Errors
        //Question 1 (One Step Declaration)
        double[] gpa = new double[4]; // Line to fix

        //Question 2 (Shorthand Initialization)
        int[] points = {90, 85, 88}; // Line to fix

        //Part B: Write Short Array Declarations
        //Question 4 (Declare & Initialize 2D Array)
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {6,7,8}
        };

        //Question 5 (Create ArrayList - Dynamic Array)
        ArrayList<Double> grades = new ArrayList<>();

        //Question 6 
        int[] numbers = {10,20,30,40};
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

        int highest = findHighestScore(scores);
        System.out.println("Highest Score: " + highest);
        printStudentInfo(students);
        int totalMarks = sumSbjectMarks(marks);
        System.out.println("Total Marks: " + totalMarks);


        input.close();
    }

    //Question 3 (Varargs)
public static void printTotal(String title, int... values){
    int sum = 0;
    for (int value : values) {
        sum += value;
    }
    System.out.println(title + ": " + sum);
}

//Question 6
public static double printAverage(int[] numbers){
    int sum = 0;
    for(int num : numbers)
        sum += num;
    double average = (double) sum / numbers.length;
    System.out.println("Average: " + average);
    return average; // added return
}

//Part C: Create & Use Methods
//Question 7
public static int findHighestScore(int[] scores){
    int highest = scores[0];
    for (int highestscore : scores){
        if(highestscore > highest);
            highest = highestscore;
        }
    return highest;
    }

//Question 8
public static void printStudentInfo(Student[] arr){
    for (Student s : arr){
        System.out.println("Student name: " + s.getName() + ", Age: " + s.getAge());
    }
}

//Question 9
public static int sumSbjectMarks(int[][] marks){
    int sum = 0;
    for(int i = 0; i < marks.length; i++){
        for(int j = 0; j < marks[i].length; j++){
            sum += marks[i][j];
        }
    }
    return sum;
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
