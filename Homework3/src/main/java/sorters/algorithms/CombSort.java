package sorters.algorithms;

import sorters.Sort;

import java.util.Comparator;

public class CombSort implements Sort {

    public void sort(Comparable[] Array) {
        sort(Array, null, "ASC");
    }

    public void sort(Comparable[] Array, Comparator comparator) {
        sort(Array, comparator, "ASC");
    }

    public void sort(Comparable[] Array, Comparator comparator, String order) {
        double coefficient = 1.247330950103979;
        double distance = (int) (Array.length / coefficient);
        do{
            for(int innerIndex = 0; innerIndex + distance < Array.length; innerIndex++) {
                if(isLess(Array[innerIndex + (int)distance], Array[innerIndex], comparator, order)){
                    exchange(Array, innerIndex, innerIndex + (int)distance);
                }
            }
            distance = (distance / coefficient);
        } while(distance > 1);
    }
}
