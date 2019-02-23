package algorithms;

import java.util.Comparator;

/*
    Basic sort functionality:
    isLess - compares two Comparable variables and returns the result of their comparing as boolean
    exchange - swaps two variables in the Array in positions first and second
 */
public interface BasicSortFunctionality {
    default void exchange(Comparable[] Array, int first, int second){
        Comparable temporary = Array[first];
        Array[first] = Array[second];
        Array[second] = temporary;
    }

    default boolean isLess(Comparator comparator, Comparable first, Comparable second){
        if(comparator != null){
            return comparator.compare(first, second) > 0;
        } else {
            return first.compareTo(second) > 0;
        }
    }
}
