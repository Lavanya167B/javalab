import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Subject {
    int subjectMarks; 
    int credits;      
    int grade;        

    public Subject() {
        this.subjectMarks = 0;
        this.credits = 0;
        this.grade = 0;
    }

    public void calculateGrade() {
        if (subjectMarks > 100) {
            System.out.println("Error: Marks cannot exceed 100.");
            grade = -1; 
        } else if (subjectMarks < 40) {
            grade = 0; 
        } else if (subjectMarks >= 90) {
            grade = 10;
        } else if (subjectMarks >= 80) {
            grade = 9;
        } else if (subjectMarks >= 70) {
            grade = 8;
        } else if (subjectMarks >= 60) {
            grade = 7;
        } else if (subjectMarks >= 50) {
            grade = 6;
        } else {
            grade = 5; 
        }
    }
}

class Student {
    String name;        
    String usn;          
    double SGPA;         
    Subject[] subjects;  
    Scanner s;        

    Student() {
        subjects = new Subject[8]; 
        for (int i = 0; i < subjects.length; i++) {
            subjects[i] = new Subject(); 
        }
        s = new Scanner(System.in);
    }

    public void getStudentDetails() {
        System.out.print("Enter USN: ");
        this.usn = s.nextLine();

        System.out.print("Enter Name: ");
        this.name = s.nextLine();
    }

    public void getMarks() {
        for (int i = 0; i < subjects.length; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            subjects[i].subjectMarks = s.nextInt();

            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            subjects[i].credits = s.nextInt();

            subjects[i].calculateGrade();

            if (subjects[i].grade == -1) { 
                System.out.println("Please re-enter valid marks and credits.");
                i--; 
                continue;
            }
        }
    }

    public void computeSGPA() {
        double totalCredits = 0;
        double totalPoints = 0;

        for (Subject subject : subjects) {
            totalCredits += subject.credits;
            totalPoints += subject.grade * subject.credits; 
        }

        SGPA = totalCredits == 0 ? 0 : totalPoints / totalCredits; 
    }
}

public class sgpa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Student> students = new ArrayList<>();
        
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEntering details for student " + (i + 1));
            Student student = new Student();
            
            student.getStudentDetails();      
            student.getMarks();            
            student.computeSGPA();           
            
            students.add(student);
        }

        // Display all students' details
        System.out.println("\nStudent Details:");
        
        for (Student student : students) {
            System.out.printf("Name: %s\nUSN: %s\nSGPA: %.2f\n", student.name, student.usn, student.SGPA); 
        }
        
        scanner.close();                
    }
}
