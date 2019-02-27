package algorithms.merge;

import java.util.Comparator;

public interface MergeSortContainer {
    default Comparable[] mergeSort(Comparable[] Array, int leftPosition, int rightPosition, Comparator comparator) {
        if(rightPosition > leftPosition){
            int middlePosition = ((leftPosition + rightPosition) / 2);
            mergeSort(Array, leftPosition, middlePosition, comparator);
            mergeSort(Array,middlePosition + 1, rightPosition, comparator);
            merge(Array, leftPosition, middlePosition, rightPosition, comparator);
        }
        return Array;
    }

    default void merge(Comparable[] Array, int leftPosition, int middlePosition, int rightPosition, Comparator comparator){
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

    default boolean isLess(Comparable first, Comparable second, Comparator comparator){
        if(comparator == null){
            return first.compareTo(second) < 0;
        } else {
            return comparator.compare(first, second) < 0;
        }
    }
}
