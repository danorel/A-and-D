package algorithms.merge;

import algorithms.SortAbility;
import timer.Stopwatch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ComparedMergeSort implements SortAbility, MergeSortManager {

    private double time;

    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        Stopwatch timer = new Stopwatch();
        mergeSort(Array, 0, Array.length - 1);
        time = Stopwatch.evaluateTime();
        return Array;
    }

    @Override
    public void merge(Comparable[] Array, int leftPosition, int middlePosition, int rightPosition){
        Comparable []leftArray = Arrays.copyOfRange(Array, leftPosition, middlePosition + 1);
        Comparable []rightArray = Arrays.copyOfRange(Array, middlePosition + 1, rightPosition + 1);

        if(isLess(leftArray[leftArray.length - 1], rightArray[0])){
            Array = new Comparable[leftArray.length + rightArray.length];
            join(Array, leftArray);
            join(Array, rightArray);
        } else {
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
    }

    private void join(Comparable []Array, Comparable []part){
        int amount = countNonNull(Array);
        for(int index = amount, pointer = 0; index < amount + part.length; index++, pointer++){
            Array[index] = part[pointer];
        }
    }

    private int countNonNull(Comparable []Array){
        List<Comparable> values = Objects.requireNonNull(Arrays.stream(Array))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return values.size();
    }

    @Override
    public String toString() {
        return "ComparedMergeSort |" + time + "|: ";
    }
}
