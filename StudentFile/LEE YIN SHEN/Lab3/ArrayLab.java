import java.util.*;

public class ArrayLab {

    public static void main(String[] args) {

        //Part A: Spot the Errors (3 Questions)
        //Question 1 
        System.out.println("-----Part A-----");
        System.out.println("Question 1:");
        System.out.println("double gpa[] = new double(4); ");
        System.out.println("-> double gpa[] = new double[4]; ");

        //Question 2
        System.out.println();
        System.out.println("Question 2:");
        System.out.println("int[] points;\r\n" + //
                        "points = {90, 85, 88};");
        System.out.println("-> int[] points = {90， 85， 88} ");
        
        //Question 3
        System.out.println();
        System.out.println("Question 3:");
        System.out.println("public static void printTotal(int... values, String title) { \r\n" + //
                        "    // ...\r\n" + //
                        "}");
        System.out.println("-> public static void printTotal(String title, int... values) { \r\n" + //
                        "    // ...\r\n" + //
                        "}");


        //Part B: Write Short Array Declarations (3 Questions)
        //Question 4
        System.out.println();
        System.out.println("-----Part B-----");
        System.out.println("Question 4:");
        System.out.println("\n" + 
                           "int[][] matrix = {{1, 2, 3}, \n" +
                           "                  {4, 5, 6}, \n" +
                           "                  {7, 8, 9}} ;") ;
        int[][] matrix = {{1, 2, 3}, 
                          {4, 5, 6},
                          {7, 8, 9}} ;


        //Question 5
        System.out.println();
        System.out.println("Question 5:");
        System.out.println("ArrayList<Double> grades = new ArrayList<>() ;");
        ArrayList<Double> grades = new ArrayList<>() ;

        //Question 6
        System.out.println();
        System.out.println("Question 6:");
        System.out.println("ArrayList<Double> grades = new ArrayList<>() ;");
        printAverage(new int[]{10, 20, 30, 40});
        System.out.println();

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

        //Part C: Create & Use Methods (3 Questions)
        //Question 7
        System.out.println();
        System.out.println("-----Part C-----");
        System.out.println("Question 7:");
        System.out.println("Highest score: " + findHighestScore(scores));
        
        //Question 8
        System.out.println();
        System.out.println("Question 8:");
        // Display all student names
        printStudentInfo(students);

        //Question 9
        System.out.println();
        System.out.println("Question 9:");
        System.out.println("Total marks: " + sumSubjectMarks(marks));

        input.close();
    }

    //Question 6
    public static void printAverage(int[] values) {
        int sum = 0 ;
        double average ;
        for (int value : values) {
            sum += value ;
        }
        average = sum / values.length ;
        System.out.println("Average: " + average) ;
    }

    //Question 7
    public static int findHighestScore(int[] scores){
        int highest = scores[0] ;
        for(int score : scores){
            if(score > highest){
                highest = score ;
            }
        }
        return highest ;
    }

    //Question 8
    public static void printStudentInfo(Student[] arr){
        for(Student s : arr){
            System.out.println("Name: " + s.getName() + ", " + "Age: " + s.getAge());
        }
    }

    //Question 9
    public static int sumSubjectMarks(int[][] marks){
        int sum = 0 ;
        for(int i = 0 ; i < marks.length ; i++){
            for(int j = 0 ; j < marks[i].length ; j++){
                sum += marks[i][j] ;
            }
        }
        return sum ;
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