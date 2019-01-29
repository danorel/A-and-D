package dev.practice;

public interface GradesGenerator {
    boolean add(int grade);
    double getAverage();
    int getGradesGreaterThanAverage();
    int getGradesSmallerThanAverage();
    int getMaximum();
    int getMinimum();
    int getStudentsAmount();
}
