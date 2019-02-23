package algorithms.merge;

import algorithms.SortAbility;
import timer.Stopwatch;

public class DefaultMergeSort implements SortAbility, MergeSortManager{

    private double time;

    public Comparable[] sort(Comparable[] Array) {
        Stopwatch timer = new Stopwatch();
        mergeSort(Array, 0, Array.length - 1);
        time = Stopwatch.evaluateTime();
        return Array;
    }

    @Override
    public String toString() {
        return "DefaultMergeSort |" + time + "|: ";
    }
}