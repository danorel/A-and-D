package dev.homework;

public interface GradesGenericGenerator<T extends Number> {
    int getGradesGreaterThanAverage();
    int getGradesSmallerThanAverage();
    int getStudentsAmount();
    double getMinimum();
    double getMaximum();
}
