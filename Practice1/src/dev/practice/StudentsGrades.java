package dev.practice;

public class StudentsGrades implements GradesGenerator {
    private int[] studentsGrades;
    private int studentsAmount = 0;
    private double average = 0;
    private static final int MAX = 100;
    private static final int MIN = 0;

    public StudentsGrades(){
        studentsGrades = new int[studentsAmount + 1];
    }

    @Override
    public boolean add(int grade) {
        if (grade > MAX || grade < MIN){
            return false;
        } else {
            studentsGrades[studentsAmount++] = grade;
            int []copy = studentsGrades;
            studentsGrades = new int[copy.length + 1];
            for(int index = 0; index < copy.length; index++){
                studentsGrades[index] = copy[index];
            }
            return true;
        }
    }

    public double getAverage() {
        average = 0;
        for(int index = 0; index < getStudentsAmount(); index++){
            average += studentsGrades[index];
        }
        average = average / getStudentsAmount();
        return average;
    }

    public int getAmountPerfectStudents(){
        int counter = 0;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index] >= 91){
                counter++;
            }
        }
        return counter;
    }

    public int getAmountGoodStudents(){
        int counter = 0;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index] >= 71 && studentsGrades[index] <= 90){
                counter++;
            }
        }
        return counter;
    }

    public int getAmountNiceStudents(){
        int counter = 0;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index] >= 60 && studentsGrades[index] <= 70){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public int getGradesGreaterThanAverage() {
        int counter = 0;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index] > getAverage()){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public int getGradesSmallerThanAverage() {
        int counter = 0;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index] < getAverage()){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public int getMaximum() {
        int MAX = Integer.MIN_VALUE;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index] > MAX) MAX = studentsGrades[index];
        }
        return MAX;
    }

    @Override
    public int getMinimum() {
        int MIN = Integer.MAX_VALUE;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index] < MIN) MIN = studentsGrades[index];
        }
        return MIN;
    }

    @Override
    public int getStudentsAmount() {
        return studentsAmount;
    }

    @Override
    public String toString() {
        String grades = "";
        for(int index = 0; index < getStudentsAmount(); index++){
            grades += studentsGrades[index] + " ";
        }
        return grades;
    }
}
