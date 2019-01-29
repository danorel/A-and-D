package dev.homework;

public class App {
    public static void main(String[] args) {
        StudentsGradesGeneric < Double > studentsGrades = new StudentsGradesGeneric < > ();
        studentsGrades.add(61.4);
        studentsGrades.add(85.75);
        studentsGrades.add(94.43);
        studentsGrades.add(-10.0);
        System.out.println(studentsGrades);
        System.out.println("Average score: " + studentsGrades.getAverage());
        System.out.println("Students amount: " + studentsGrades.getStudentsAmount());
        System.out.println("Amount of good students: " + studentsGrades.getAmountGoodStudents());
        System.out.println("Amount of nice students: " + studentsGrades.getAmountNiceStudents());
        System.out.println("Amount of perfect students: " + studentsGrades.getAmountPerfectStudents());
        System.out.println("Maximum score: " + studentsGrades.getMaximum());
        System.out.println("Minimum score: " + studentsGrades.getMinimum());
        System.out.println("Amount of students, whose grade smaller than average: " + studentsGrades.getGradesSmallerThanAverage());
        System.out.println("Amount of students, whose grade greater than average: " + studentsGrades.getGradesGreaterThanAverage());
    }
}