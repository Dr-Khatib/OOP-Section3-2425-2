import java.util.*;

class ArrayLab {

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
        

        //Question 4
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

        //Question 5
        ArrayList<Double> grades = new ArrayList<>();

        //Question 6
        printAverage(new int[]{10, 20, 30, 40});


        // Array of Student objects
        Student[] students = new Student[3];
        students[0] = new Student("Ali", 20);
        students[1] = new Student("Siti", 21);
        students[2] = new Student("Raj", 19);

        

        //Question 7
        findHighestScore(scores);

        //Question 8
        printStudentInfo(students);

        //Question 9
        sumSubjectMarks(marks);


        input.close();
    }


    

    //Question 1
    static double gpa[] = new double[4]; // Line to fix

    //Question 2
    static int[] points = new int[] {90, 85, 88}; // Line to fix

    //Question 3
    public static void printTotal(int[] values, String title) { // Invalid
        // ...
    }

    //Question 6 cont...
    public static void printAverage(int[] values) {
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        double average = (double) sum / values.length;
        System.out.println("Average of 10, 20, 30, 40 is " + average);
    }

    //Question 7 cont...
    public static void findHighestScore(int[] scores) {
        int high = scores[0];
        for (int s : scores) {
            if (s > high) {
                high = s;
            }
        }
        System.out.println("Highest score: " + high);
    }
    //Question 8 cont...
    static void printStudentInfo(Student[] students) {
        for (Student s : students) {
            System.out.println("Name: " + s.getName() + ", Age: " + s.getAge());
        }
    }

    //Question 9 cont...
    public static void sumSubjectMarks(int[][] marks) {
      int sum = 0;
      for (int[] row : marks){
        for (int mark : row){
          sum += mark;
        }
      }  
      System.out.println("Sum of marks: " + sum);
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
