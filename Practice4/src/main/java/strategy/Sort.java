package strategy;

public interface Sort<T extends Comparable>{
    void sort(T[] Array);

    default boolean isLess(Comparable first, Comparable second){
        return first.compareTo(second) < 0;
    }

    default void exchange(Comparable[] Array, int firstPosition, int secondPosition){
        Comparable temp = Array[firstPosition];
        Array[firstPosition] = Array[secondPosition];
        Array[secondPosition] = temp;
    }

}
