package strategy.algorithms.quick;

public interface QuickSortManager {

    default void quickSort(Comparable[] Array, int leftPosition, int rightPosition){
        if(rightPosition > leftPosition){
            int pi = generatePartition(Array, leftPosition, rightPosition);
            quickSort(Array, leftPosition, pi - 1);
            quickSort(Array,pi + 1, rightPosition);
        }
    }

    default int generatePartition(Comparable []Array, int leftPosition, int rightPosition) {
        Comparable pivot = Array[rightPosition];
        int i = (leftPosition - 1);
        for(int j = leftPosition; j < rightPosition; j++){
            if(isLess(Array[j], pivot)){
                i++;
                exchange(Array, i, j);
            }
        }
        exchange(Array,i + 1, rightPosition);
        return i + 1;
    }

    default boolean isLess(Comparable first, Comparable second){
        return first.compareTo(second) < 0;
    }

    default void exchange(Comparable[] Array, int firstPosition, int secondPosition){
        Comparable temp = Array[firstPosition];
        Array[firstPosition] = Array[secondPosition];
        Array[secondPosition] = temp;
    }
}
