package algorithm;

import com.sun.javafx.binding.StringFormatter;
import timer.Stopwatch;

import java.util.Arrays;

public class MergeSort implements SortAbility{

    private double workingTime;

    @Override
    public String[] sortAsc(String[] Array) {
        if(Array.length > 0){
            Stopwatch.beginEvaluation();
            mergeSort(Array, 0, Array.length - 1, true);
            workingTime = Stopwatch.calculate();
        }
        return Array;
    }

    @Override
    public String[] sortDesc(String[] Array) {
        if(Array.length > 0){
            Stopwatch.beginEvaluation();
            mergeSort(Array, 0, Array.length - 1, false);
            workingTime = Stopwatch.calculate();
        }
        return Array;
    }

    private void mergeSort(String []Array, int leftPos, int rightPos, boolean type){
        if(rightPos > leftPos){
            int middlePos = ((rightPos + leftPos) / 2);
            mergeSort(Array, leftPos, middlePos, type);
            mergeSort(Array, middlePos + 1, rightPos, type);
            merge(Array, leftPos, middlePos, rightPos, type);
        }
    }

    private void merge(String []Array, int leftPos, int middlePos, int rightPos, boolean type){
        String []firstPart = Arrays.copyOfRange(Array, leftPos, middlePos + 1);
        String []secondPart = Arrays.copyOfRange(Array, middlePos + 1, rightPos + 1);

        int firstPartIndex = 0;
        int secondPartIndex = 0;
        int mainIndex = leftPos;
        while((firstPartIndex < firstPart.length) && (secondPartIndex < secondPart.length)){
            if(type ? firstPart[firstPartIndex].compareTo(secondPart[secondPartIndex]) < 0 : firstPart[firstPartIndex].compareTo(secondPart[secondPartIndex]) > 0){
                Array[mainIndex++] = firstPart[firstPartIndex++];
            } else {
                Array[mainIndex++] = secondPart[secondPartIndex++];
            }
        }

        while(firstPartIndex < firstPart.length){
            Array[mainIndex++] = firstPart[firstPartIndex++];
        }

        while(secondPartIndex < secondPart.length){
            Array[mainIndex++] = secondPart[secondPartIndex++];
        }
    }

    @Override
    public String toString() {
        return StringFormatter.format(
               "%s : %s", getClass().getSimpleName(), getWorkingTime()
        ).getValue();
    }

    public double getWorkingTime() {
        return workingTime;
    }
}
