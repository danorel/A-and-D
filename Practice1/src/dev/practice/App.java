package dev.practice;

public interface App {
    static void main(String[] args) {
        StudentsGrades studentsGrades = new StudentsGrades();
        studentsGrades.add(71);
        studentsGrades.add(77);
        studentsGrades.add(85);
        studentsGrades.add(100);
        System.out.println("GradesGenerator amount: " + studentsGrades.getStudentsAmount());
        System.out.println("GradesGenerator MAX grade: " + studentsGrades.getMaximum());
        System.out.println("GradesGenerator MIN grade: " + studentsGrades.getMinimum());
        System.out.println("GradesGenerator average score: " + studentsGrades.getAverage());
        System.out.println("GradesGenerator amount greater than average: " + studentsGrades.getGradesGreaterThanAverage());
        System.out.println("GradesGenerator amount smaller than average: " + studentsGrades.getGradesSmallerThanAverage());
        System.out.println("Perfect students amount is " + studentsGrades.getAmountPerfectStudents());
        System.out.println("Good students amount is " + studentsGrades.getAmountGoodStudents());
        System.out.println("Nice students amount is " + studentsGrades.getAmountNiceStudents());
        System.out.println("GradesGenerator grades: " + studentsGrades);
    }
}
