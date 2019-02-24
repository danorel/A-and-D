package algorithms.quick;

public interface QuickSortManager {

    default void quickSort(Integer[] Array, int leftPosition, int rightPosition){
        if(rightPosition > leftPosition){
            int pi = generatePartition(Array, leftPosition, rightPosition);
            quickSort(Array, leftPosition, pi - 1);
            quickSort(Array,pi + 1, rightPosition);
        }
    }

    default int generatePartition(Integer[] Array, int leftPosition, int rightPosition) {
        Integer pivot = Array[rightPosition];
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

    default boolean isLess(Integer first, Integer second){
        return first.compareTo(second) < 0;
    }

    default void exchange(Integer[] Array, int firstPosition, int secondPosition){
        Integer temp = Array[firstPosition];
        Array[firstPosition] = Array[secondPosition];
        Array[secondPosition] = temp;
    }
}
