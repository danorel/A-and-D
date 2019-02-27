package algorithms;

import java.util.Comparator;

public interface DefaultSortingManager {
    default boolean isLess(Comparable first, Comparable second, Comparator comparator){
        if(comparator == null){
            return first.compareTo(second) < 0;
        } else {
            return comparator.compare(first, second) < 0;
        }
    }

    default void swap(Comparable[] Array, int firstPos, int secondPos){
        Comparable temp = Array[firstPos];
        Array[firstPos] = Array[secondPos];
        Array[secondPos] = temp;
    }
}
