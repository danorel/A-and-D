package algorithms.quick;

import algorithms.Sort;
import timer.Stopwatch;

import java.util.Comparator;


public class DefaultQuickSort implements Sort, QuickSortContainer {
    private double time;

    @Override
    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        if(Array.length > 0){
            Stopwatch timer = new Stopwatch();
            Array = quickSort(Array, 0, Array.length - 1, comparator);
            time = Stopwatch.evaluateTime();
        }
        return Array;
    }

    public String toString(){
        return getClass().getSimpleName() + " *" + time + "*: ";
    }
}
