package sorters.algorithms;

import sorters.Sort;

import java.util.Comparator;

public class InsertionSort implements Sort {

    public void sort(Comparable[] Array) {
        sort(Array, null, "ASC");
    }

    public void sort(Comparable[] Array, Comparator comparator) {
        sort(Array, comparator, "ASC");
    }

    public void sort(Comparable[] Array, Comparator comparator, String order) {
        for(int index = 1; index < Array.length; index++){
            int iteration = index;
            for(int counter = index - 1; counter > -1; counter--){
                if(isLess(Array[iteration], (Array[counter]), comparator, order)){
                    exchange(Array, iteration, counter);
                    iteration--;
                } else {
                    break;
                }
            }
        }
    }
}
