package algorithms.merge;

import algorithms.SortAbility;
import timer.Stopwatch;

import java.util.Arrays;

public class InsertionMergeSort implements SortAbility, MergeSortManager {
    private double time;
    private static final int CONSTANT = 500;

    public Integer[] sort(Integer[] Array) {
        Stopwatch timer = new Stopwatch();
        mergeSort(Array, 0, Array.length - 1);
        time = Stopwatch.evaluateTime();
        return Array;
    }

    @Override
    public Integer[] mergeSort(Integer[] Array, int leftPosition, int rightPosition) {
        if(rightPosition - leftPosition > CONSTANT){
            int middlePosition = (leftPosition + rightPosition) / 2;
            mergeSort(Array, leftPosition, middlePosition);
            mergeSort(Array, middlePosition + 1, rightPosition);
            merge(Array, leftPosition, ((leftPosition + rightPosition) / 2), rightPosition);
        } else {
            insertionSort(Array, leftPosition, rightPosition);
        }
        return Array;
    }

    @Override
    public void merge(Integer[] Array, int leftPosition, int middlePosition, int rightPosition){
        Integer []leftArray = Arrays.copyOfRange(Array, leftPosition, middlePosition + 1);
        Integer []rightArray = Arrays.copyOfRange(Array, middlePosition + 1, rightPosition + 1);

        int leftIndex = 0, rightIndex = 0;
        int index = leftPosition;
        while(leftIndex < (middlePosition + 1 - leftPosition) && rightIndex < (rightPosition - middlePosition)){
            if(isLess(leftArray[leftIndex], rightArray[rightIndex])){
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

    private void insertionSort(Integer []Array, int leftPosition, int rightPosition)
    {
        for (int i = leftPosition + 1; i < rightPosition; ++i)
        {
            Integer key = Array[i];
            int j = i - 1;
            while (j >= leftPosition && isLess(key, Array[j]))
            {
                Array[j + 1] = Array[j];
                j = j - 1;
            }
            Array[j + 1] = key;
        }
    }

    @Override
    public String toString() {
        return "InsertionMergeSort |" + time + "|: ";
    }
}
