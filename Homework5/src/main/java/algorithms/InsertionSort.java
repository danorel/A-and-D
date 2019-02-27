package algorithms;

import java.util.Comparator;

public class InsertionSort implements Sort, DefaultSortingManager {
    @Override
    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        if(Array.length > 0) {
            for(int index = 1; index < Array.length; index++){
                int step = index;
                for(int count = index - 1; count > -1; count--){
                    if(isLess(Array[step], (Array[count]), comparator)){
                        swap(Array, step, count);
                        step--;
                    } else {
                        break;
                    }
                }
            }
        }
        return Array;
    }
}
