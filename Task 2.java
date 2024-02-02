package codsoft;
import java.util.Scanner;

public class grade {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int numberOfSubjects = scanner.nextInt();

        int totalMarks = 0;
        int maxMarksPerSubject = 100;

        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in Subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();


            if (marks < 0 || marks > maxMarksPerSubject) {
                System.out.println("Invalid input! Marks should be between 0 and 100.");
                i--; 
                continue;
            }

            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / (numberOfSubjects * maxMarksPerSubject) * 100;

        char grade = calculateGrade(averagePercentage);

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
