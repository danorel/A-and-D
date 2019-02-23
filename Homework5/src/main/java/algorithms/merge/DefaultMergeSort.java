package algorithms.merge;

import algorithms.SortAbility;
import timer.Stopwatch;

import java.util.Comparator;

public class DefaultMergeSort implements SortAbility, MergeSortManager{

    private double time;

    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
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