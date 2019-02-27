package algorithms.merge;

public interface MergeSortManager {
    default Integer[] mergeSort(Integer[] Array, int leftPosition, int rightPosition) {
        if(rightPosition > leftPosition){
            int middlePosition = ((leftPosition + rightPosition) / 2);
            mergeSort(Array, leftPosition, middlePosition);
            mergeSort(Array,middlePosition + 1, rightPosition);
            merge(Array, leftPosition, middlePosition, rightPosition);
        }
        return Array;
    }

    default void merge(Integer[] Array, int leftPosition, int middlePosition, int rightPosition){
        Integer []leftArray = new Integer[(middlePosition + 1) - leftPosition];
        Integer []rightArray = new Integer[rightPosition - middlePosition];
        for(int index = 0; index < (middlePosition + 1) - leftPosition; index++){
            leftArray[index] = Array[leftPosition + index];
        }

        for(int index = 0; index < rightPosition - middlePosition; index++){
            rightArray[index] = Array[middlePosition + 1 + index];
        }

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

    default boolean isLess(Integer first, Integer second){
        return first.compareTo(second) < 0;
    }

    default void exchange(Integer[] Array, int firstPos, int secondPos){
        Integer temp = Array[firstPos];
        Array[firstPos] = Array[secondPos];
        Array[secondPos] = temp;
    }
}
