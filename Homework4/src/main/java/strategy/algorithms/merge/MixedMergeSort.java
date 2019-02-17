package strategy.algorithms.merge;

import strategy.Sort;
import timer.Timer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MixedMergeSort implements Sort, MergeSortManager {
    private double time;
    private final static int CONSTANT = 500;

    public void sort(Comparable[] Array) {
        Timer timer = new Timer();
        mergeSort(Array, 0, Array.length - 1);
        time = Timer.calculate();
    }

    @Override
    public void mergeSort(Comparable []Array, int leftPosition, int rightPosition){
        if(rightPosition - leftPosition > CONSTANT){
            int middlePosition = ((leftPosition + rightPosition) / 2);
            mergeSort(Array, leftPosition, middlePosition);
            mergeSort(Array,middlePosition + 1, rightPosition);
            merge(Array, leftPosition, middlePosition, rightPosition);
        } else {
            insertionSort(Array, leftPosition, rightPosition);
        }
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

    private void insertionSort(Comparable []Array, int leftPosition, int rightPosition)
    {
        for (int i = leftPosition + 1; i < rightPosition; ++i)
        {
            Comparable key = Array[i];
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
        return "MixedMergeSort |" + time + "|: ";
    }
}
