package algorithms.merge;

import algorithms.Sort;
import timer.Stopwatch;

import java.util.Comparator;

public class DefaultMergeSort implements Sort, MergeSortContainer {

    private double time;

    @Override
    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        if(Array.length > 0){
            Stopwatch timer = new Stopwatch();
            Array = mergeSort(Array, 0, Array.length - 1, comparator);
            time = Stopwatch.evaluateTime();
        }
        return Array;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +  "* " + time + "*: ";
    }
}