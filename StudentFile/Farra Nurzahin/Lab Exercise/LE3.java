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
        
        //Part A: Question 1
        double gpa[] = new double[4];
        
        //Part A: Question 2
        int[] points = {90, 85, 88};

        //Part B: Question 4
        int[][] matrix = {  {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                         };
                         
        //Part B: Question 5
        ArrayList<Double> grades = new ArrayList<>();
        
        //Part B: Question 6
        printAverage(new int[] {10, 20, 30, 40});

        //Part C: Question 7, call highest score
        int highest = findHighestScore(scores);
        System.out.println("Highest score: " + highest);

        // 2D array for marks of 3 students and 3 subjects
        int[][] marks = {
            {85, 78, 90},
            {88, 92, 79},
            {75, 80, 85}
        };

        //Part C: Question 9, call sumSubjectMarks
        int totalMarks = sumSubjectMarks(marks);
        System.out.println("Total marks of all subjects: " + totalMarks);

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

        //Part C: Question 8
        printStudentInfo(students);

        input.close();
    }
    
    //Part A: Question 3
    public static void printTotal(String title, int... values) { 
    // ...
    }

    //Part B: Question 6, helper method to printAverage 
    public static void printAverage(int[] numbers){
        int sum=0;
        
        for(int n : numbers){
            sum+=n;
        }
        double average = (double) sum / numbers.length;
        System.out.println("Average: " + average);
    }

    //Part C: Question 7
    public static int findHighestScore(int[] scores){
        int highest = scores[0];
        
        for (int s : scores) {
            if(s > highest){
                highest = s;
            }
        }
        return highest;
    }
    
    //Part C: Question 8
    public static void printStudentInfo(Student[] arr){
        for (Student s: arr){
            System.out.println("Student: " + s.getName() + ", Age: " + s.getAge());
        }
    }
    
    //Part C: Question 9
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
