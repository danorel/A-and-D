package algorithms.merge;

import algorithms.Sort;
import timer.Stopwatch;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionMergeSort implements Sort, InsertionMergeSortContainer, MergeSortContainer {
    private double time;
    private static final int CONSTANT = 500;

    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        if(Array.length > 0){
            Stopwatch timer = new Stopwatch();
            mergeSort(Array, 0, Array.length - 1, comparator);
            time = Stopwatch.evaluateTime();
        }
        return Array;
    }

    @Override
    public Comparable[] mergeSort(Comparable[] Array, int leftPosition, int rightPosition, Comparator comparator) {
        if(rightPosition - leftPosition > CONSTANT){
            int middlePosition = (leftPosition + rightPosition) / 2;
            mergeSort(Array, leftPosition, middlePosition, comparator);
            mergeSort(Array, middlePosition + 1, rightPosition, comparator);
            merge(Array, leftPosition, ((leftPosition + rightPosition) / 2), rightPosition, comparator);
        } else {
            insertionSort(Array, leftPosition, rightPosition, comparator);
        }
        return Array;
    }

    @Override
    public void merge(Comparable[] Array, int leftPosition, int middlePosition, int rightPosition, Comparator comparator){
        Comparable []leftArray = Arrays.copyOfRange(Array, leftPosition, middlePosition + 1);
        Comparable []rightArray = Arrays.copyOfRange(Array, middlePosition + 1, rightPosition + 1);

        int leftIndex = 0, rightIndex = 0;
        int index = leftPosition;
        while(leftIndex < (middlePosition + 1 - leftPosition) && rightIndex < (rightPosition - middlePosition)){
            if(isLess(leftArray[leftIndex], rightArray[rightIndex], comparator)){
                Array[index++] = leftArray[leftIndex++];
            } else {
                Array[index++] = rightArray[rightIndex++];
            }
        }

        while(leftIndex < (middlePosition + 1) - leftPosition){
            Array[index++] = leftArray[leftIndex++];
        }

        while(rightIndex < rightPosition - middlePosition){
            Array[index++] = rightArray[rightIndex++];
        }
    }

    @Override
    public String toString() {
        return "InsertionMergeSort |" + time + "|: ";
    }
}