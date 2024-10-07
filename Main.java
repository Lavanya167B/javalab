import java.util.Scanner;

class Subject {
    int subjectMarks, credits, grade;

    public Subject() {
        this.subjectMarks = 0;
        this.credits = 0;
        this.grade = 0;
    }

    public void setMarksAndCredits(int marks, int credits) {
        this.subjectMarks = marks;
        this.credits = credits;
        calculateGrade();
    }

    private void calculateGrade() {
        if (subjectMarks > 100) {
            System.out.println("Error: Marks cannot exceed 100.");
            this.grade = -1;
        } else if (subjectMarks < 40) {
            this.grade = 0; // Fail
        } else if (subjectMarks >= 90) {
            this.grade = 10;
        } else if (subjectMarks >= 80) {
            this.grade = 9;
        } else if (subjectMarks >= 70) {
            this.grade = 8;
        } else if (subjectMarks >= 60) {
            this.grade = 7;
        } else if (subjectMarks >= 50) {
            this.grade = 6;
        } else {
            this.grade = 5; // Pass
        }
    }
}

class Student {
    String name, usn;
    double SGPA;
    Subject[] subjects;
    Scanner s;

    public Student() {
        subjects = new Subject[8];
        for (int i = 0; i < subjects.length; i++) {
            subjects[i] = new Subject();
        }
        s = new Scanner(System.in);
    }

    public void getStudentDetails() {
        System.out.print("Enter USN: ");
        usn = s.next();
        System.out.print("Enter Name: ");
        name = s.next();
    }

    public void getMarks() {
        for (int i = 0; i < subjects.length; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            int marks = s.nextInt();
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            int credits = s.nextInt();
            subjects[i].setMarksAndCredits(marks, credits);
        }
    }

    public void computeSGPA() {
        double totalPoints = 0.0;
        int totalCredits = 0;

        for (Subject subject : subjects) {
            if (subject.grade != -1) { // Only consider valid grades
                totalPoints += subject.grade * subject.credits;
                totalCredits += subject.credits;
            }
        }

        SGPA = totalCredits == 0 ? 0 : totalPoints / totalCredits; // Avoid division by zero
    }

    public void displayResult() {
        System.out.printf("\nStudent Details:\nUSN: %s\nName: %s\nSGPA: %.2f\n", usn, name, SGPA);
    }

    public void closeScanner() {
        s.close();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        
        Student[] students = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nEntering details for student " + (i + 1));
            students[i] = new Student();
            students[i].getStudentDetails();
            students[i].getMarks();
            students[i].computeSGPA();
            students[i].displayResult();
        }

        scanner.close(); 
    }
}
