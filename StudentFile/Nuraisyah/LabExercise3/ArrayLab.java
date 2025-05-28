import java.util.*;

public class ArrayLab 
{
    public static void main (String[] args) 
    {
        Scanner input = new Scanner(System.in);

        //Part A: Question 1
        //double gpa[] = new double(4); // Line to fix
        double[] gpa = new double[4];

        //Part A: Question 2
        //int[] points;
        //points = {90, 85, 88}; // Line to fix
        int[] points = {90, 85, 88};

        //Part B: Question 4
        int[][] matrix = 
        {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        //Part B: Question 5
        ArrayList<Double> grades = new ArrayList<>();
        //grades.add(85.5);
        //grades.add(90.0);
        //grades.add(76.5);
        
        // 1D array for student scores
        int[] scores = new int[5];
        for (int i = 0; i < scores.length; i++) 
        {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = input.nextInt();
        }
        
        //Invoke method printtAverage to print average (Q6)
        int[] temp = {10, 20, 30, 40};
        printAverage(temp);

        //Invoke method findHighestScore to get highest value (Q7) 
        double highest = findHighestScore(scores);
        System.out.println("Highest score: " + highest + "\n");

        // 2D array for marks of 3 students and 3 subjects
        int[][] marks = 
        {
            {85, 78, 90},
            {88, 92, 79},
            {75, 80, 85}
        };
        
        //Invoke method sumSubjectMarks to get total mark of the subject (Q9)
        double totalMark = sumSubjectMarks(marks);
        System.out.println("Total Marks: " + totalMark);

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

        // Display all student names (invoke method printStudentInfo: Q8)
        printStudentInfo(students);

        input.close();
    }
    
    //Part A: Question 3
    //public static void printTotal(int... values, String title) { // Invalid ...}
    public static void printTotal (String title, int... values) 
    {
      int total = 0;
      for (int i = 0; i < values.length; i++)
      {
         total = total + values[i];
      } 
    }
    
    //Part B: Question 6
    static void printAverage(int[] number)
    {
      int sum = 0;
      
      for (int i = 0; i < number.length; i++)
      {
         sum += number[i];
      }
      
      double average = (double)sum/number.length;
      System.out.println("\nAverage: " + average);
    }
        
    //Part C: Question 7
    static double findHighestScore(int[] scores)
    {
      double highest = scores[0];
      for (int i = 0; i < scores.length; i++)
      {
         if (scores[i] > highest)
         {
            highest = scores[i];
         }
      }
      return highest;
    }
    
    //Part C: Question 8 
    static void printStudentInfo (Student[] arr)
    {
      for (Student s : arr) 
      {
        System.out.println("Student: " + s.getName());
        System.out.println("Age: " + s.getAge());
      }
    }
    
    //Part C: Question 9
    static double sumSubjectMarks(int[][] marks)
    {
      double sum = 0;
      for (int i = 0; i < marks.length; i++)
      {
         for (int j = 0; j < marks.length; j++)
         {
            sum = sum + marks[i][j];
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
