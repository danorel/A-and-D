package sorters.algorithms;

import sorters.Sort;

import java.util.Comparator;

public class SelectionSort implements Sort {

    public void sort(Comparable[] Array) {
        sort(Array, null, "ASC");
    }

    public void sort(Comparable[] Array, Comparator comparator) {
        sort(Array, comparator, "ASC");
    }

    public void sort(Comparable[] Array, Comparator comparator, String order) {
        Comparable min = Array[0];
        boolean isChanged = false;
        int current_index = 0;
        for(int current = 0; current < Array.length; current++){
            for(int index = current; index < Array.length; index++){
                if(isLess(Array[index], min, comparator, order)){
                    min = Array[index];
                    current_index = index;
                    isChanged = true;
                }
            }
            if(isChanged){
                exchange(Array, current_index, current);
                isChanged = false;
            }
            if(current != Array.length - 1){
                min = Array[current + 1];
            }
        }
    }
}
