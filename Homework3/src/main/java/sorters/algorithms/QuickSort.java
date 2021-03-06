package sorters.algorithms;

import sorters.Sort;

import java.util.Comparator;

public class QuickSort implements Sort {

    public void sort(Comparable[] Array) {
        quickSort(Array, 0, Array.length - 1, null, "ASC");
    }

    public void sort(Comparable[] Array, Comparator comparator) {
        quickSort(Array, 0, Array.length - 1, comparator, "ASC");
    }

    public void sort(Comparable[] Array, Comparator comparator, String order) {
        quickSort(Array, 0, Array.length - 1, comparator, order);
    }

    private void quickSort(Comparable []Array, int leftPosition, int rightPosition, Comparator comparator, String order){
        if(rightPosition > leftPosition){
            int pi = generatePartition(Array, leftPosition, rightPosition, comparator, order);
            quickSort(Array, leftPosition, pi - 1, comparator, order);
            quickSort(Array,pi + 1, rightPosition, comparator, order);
        }
    }

    private int generatePartition(Comparable []Array, int leftPosition, int rightPosition, Comparator comparator, String order) {
        Comparable pivot = Array[rightPosition];
        int i = (leftPosition - 1);
        for(int j = leftPosition; j < rightPosition; j++){
            if(isLess(Array[j], pivot, comparator, order)){
                i++;
                exchange(Array, i, j);
            }
        }
        exchange(Array,i + 1, rightPosition);
        return i + 1;
    }
}
