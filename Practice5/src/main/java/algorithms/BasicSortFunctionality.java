package algorithms;

public interface BasicSortFunctionality {
    default boolean isLess(Comparable first, Comparable second){
        return first.compareTo(second) > 0;
    }

    default void exchange(Comparable[] Array, int first, int second){
        Comparable temporary = Array[first];
        Array[first] = Array[second];
        Array[second] = temporary;
    }
}
