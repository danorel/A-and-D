package algorithms;
/*
    Basic sort functionality:
    isLess - compares two Comparable variables and returns the result of their comparing as boolean
    exchange - swaps two variables in the Array in positions first and second
 */
public interface BasicSortFunctionality {
    default boolean isLess(Integer first, Integer second){
        return first.compareTo(second) > 0;
    }

    default void exchange(Integer[] Array, int first, int second){
        Integer temporary = Array[first];
        Array[first] = Array[second];
        Array[second] = temporary;
    }
}
