
import java.util.*;

public class ArrayLab {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Part A Q1
        System.out.println("Part A Question 1");
        System.out.println("double gpa[] = new double[4];\n");
        
        //Part A Q2
        System.out.println("Part A Question 2");
        System.out.println("int[] points;\npoints = new int[]{90,85,88};\n");
        
        //Part A Q3
        System.out.println("Part A Question 3");
        System.out.println("public static void printTotal(String title, int... values){\n//...\n}\n");
        
        //Part B Q4
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        
        //Part B Q5
        ArrayList<Double> grades = new ArrayList<>();
        
        //Part B Q6
        printAverage(new int[]{10,20,30,40});
    

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
        
        //Part C Q7
        int highest = findHighestScore(scores);
        System.out.println("Highest score : "+ highest);
        

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
        
        //Part C Q8
        printStudentInfo(students);
        
        //Part C Q9
        int totalMarks = sumSubjectMarks(marks);
        System.out.println("Total subject marks : "+totalMarks);

        input.close();
    }
    
    //Part B Q6
    public static void printAverage(int[] numbers){
        int sum = 0;
        for (int num : numbers){
            sum += num;
        }
        double average = (double) sum/numbers.length;
        System.out.println("Average: "+average);
    }
    
    //Part C Q7
    public static int findHighestScore(int[] scores){
        int highest = scores[0];
        for(int i =1; i<scores.length; i++){
            if(scores[i]>highest){
                highest = scores[i];
            }
        }
        return highest;
    }
    
    //Part C Q8
    public static void printStudentInfo(Student[] arr){
        for(Student s : arr){
            System.out.println("Student : "+ s.getName()+ ", Age : " + s.getAge());
        }
    }
    
    //Part C Q9
    public static int sumSubjectMarks(int[][] marks){
        int total = 0;
        for (int i = 0; i<marks.length; i++){
            for(int j = 0; j<marks[i].length; j++){
                total += marks[i][j];
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
