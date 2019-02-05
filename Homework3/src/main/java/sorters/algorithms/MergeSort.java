package sorters.algorithms;

import sorters.Sort;

import java.util.Comparator;

public class MergeSort implements Sort {

    public void sort(Comparable[] Array) {
        mergeSort(Array, 0, Array.length - 1, null, "ASC");
    }

    public void sort(Comparable[] Array, Comparator comparator) {
        mergeSort(Array, 0, Array.length - 1, comparator, "ASC");
    }

    public void sort(Comparable[] Array, Comparator comparator, String order) {
        mergeSort(Array, 0, Array.length - 1, comparator, order);
    }

    public void mergeSort(Comparable []Array, int leftPosition, int rightPosition, Comparator comparator, String order) {
        if(rightPosition > leftPosition){
            int middlePosition = ((leftPosition + rightPosition) / 2);
            mergeSort(Array, leftPosition, middlePosition, comparator, order);
            mergeSort(Array,middlePosition + 1, rightPosition, comparator, order);
            merge(Array, leftPosition, middlePosition, rightPosition, comparator, order);
        }
    }

    private void merge(Comparable []Array, int leftPosition, int middlePosition, int rightPosition, Comparator comparator, String order){
        Comparable []leftArray = new Comparable[(middlePosition + 1) - leftPosition];
        Comparable []rightArray = new Comparable[rightPosition - middlePosition];
        for(int index = 0; index < (middlePosition + 1) - leftPosition; index++){
            leftArray[index] = Array[leftPosition + index];
        }

        for(int index = 0; index < rightPosition - middlePosition; index++){
            rightArray[index] = Array[middlePosition + 1 + index];
        }

        int leftIndex = 0, rightIndex = 0;
        int index = leftPosition;
        while(leftIndex < (middlePosition + 1 - leftPosition) && rightIndex < (rightPosition - middlePosition)){
            if(isLess(leftArray[leftIndex], rightArray[rightIndex], comparator, order)){
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

    private boolean isLess(Comparable first, Comparable second, Comparator comparator, String order){
        if(order.equals("ASC")) {
            if (comparator == null) {
                return first.compareTo(second) < 0;
            } else {
                return comparator.compare(first, second) < 0;
            }
        } else if(order.equals("DESC")){
            if (comparator == null) {
                return first.compareTo(second) > 0;
            } else {
                return comparator.compare(first, second) > 0;
            }
        }
        return false;
    }

    private void exchange(Comparable []Array, int firstPosition, int secondPosition){
        Comparable temp = Array[firstPosition];
        Array[firstPosition] = Array[secondPosition];
        Array[secondPosition] = temp;
    }
}