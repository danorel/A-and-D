package dev.homework;

public class StudentsGradesGeneric<T extends Number> implements GradesGenericGenerator {

    private Number[] studentsGrades;
    private int studentsAmount = 0;
    private Number average = 0;
    private static final int MAX = 100;
    private static final int MIN = 0;

    public StudentsGradesGeneric() {
        studentsGrades = new Number[studentsAmount + 1];
    }

    public boolean add(T grade) {
        if(grade.doubleValue() > MAX || grade.doubleValue() < MIN){
            return false;
        } else {
            studentsGrades[studentsAmount++] = grade;
            Number []copy = studentsGrades;
            studentsGrades = new Number[copy.length + 1];
            for(int index = 0; index < copy.length; index++){
                studentsGrades[index] = copy[index];
            }
            return true;
        }
    }

    public double getAverage() {
        average = 0;
        for(int index = 0; index < getStudentsAmount(); index++){
            average = average.doubleValue() + studentsGrades[index].doubleValue();
        }
        average = average.doubleValue() / getStudentsAmount();
        return average.doubleValue();
    }

    public int getAmountPerfectStudents(){
        int counter = 0;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index].doubleValue() >= 91){
                counter++;
            }
        }
        return counter;
    }

    public int getAmountGoodStudents(){
        int counter = 0;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index].doubleValue() >= 71 && studentsGrades[index].doubleValue() <= 90){
                counter++;
            }
        }
        return counter;
    }

    public int getAmountNiceStudents(){
        int counter = 0;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index].doubleValue() >= 60 && studentsGrades[index].doubleValue() <= 70){
                counter++;
            }
        }
        return counter;
    }

    public int getGradesGreaterThanAverage() {
        int counter = 0;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index].doubleValue() > getAverage()){
                counter++;
            }
        }
        return counter;
    }

    public int getGradesSmallerThanAverage() {
        int counter = 0;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index].doubleValue() < getAverage()){
                counter++;
            }
        }
        return counter;
    }

    public double getMaximum() {
        double MAX = Integer.MIN_VALUE;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index].doubleValue() > MAX) MAX = studentsGrades[index].doubleValue();
        }
        return MAX;
    }

    public double getMinimum() {
        double MIN = Integer.MAX_VALUE;
        for(int index = 0; index < getStudentsAmount(); index++){
            if(studentsGrades[index].doubleValue() < MIN) MIN = studentsGrades[index].doubleValue();
        }
        return MIN;
    }

    public int getStudentsAmount() {
        return studentsAmount;
    }

    public void showGrades() {
        for(int index = 0; index < getStudentsAmount(); index++){
            System.out.print(studentsGrades[index] + " ");
        }
    }

    public String toString() {
        String grades = "";
        for(int index = 0; index < getStudentsAmount(); index++){
            grades += studentsGrades[index] + " ";
        }
        return grades;
    }
}