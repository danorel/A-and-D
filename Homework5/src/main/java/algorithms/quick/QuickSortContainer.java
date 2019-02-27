package algorithms.quick;

import java.util.Comparator;

public interface QuickSortContainer {

    default Comparable[] quickSort(Comparable[] Array, int leftPosition, int rightPosition, Comparator comparator){
        if(rightPosition > leftPosition){
            int pi = generatePartition(Array, leftPosition, rightPosition, comparator);
            quickSort(Array, leftPosition, pi - 1, comparator);
            quickSort(Array,pi + 1, rightPosition, comparator);
        }
        return Array;
    }

    default int generatePartition(Comparable[] Array, int leftPosition, int rightPosition, Comparator comparator) {
        Comparable pivot = Array[rightPosition];
        int i = (leftPosition - 1);
        for(int j = leftPosition; j < rightPosition; j++){
            if(isLess(Array[j], pivot, comparator)){
                i++;
                swap(Array, i, j);
            }
        }
        swap(Array,i + 1, rightPosition);
        return i + 1;
    }

    default void swap(Comparable[] Array, int firstPos, int secondPos){
        Comparable temp = Array[firstPos];
        Array[firstPos] = Array[secondPos];
        Array[secondPos] = temp;
    }

    default boolean isLess(Comparable first, Comparable second, Comparator comparator){
        if(comparator == null) {
            return first.compareTo(second) < 0;
        } else {
            return comparator.compare(first, second) < 0;
        }
    }
}
