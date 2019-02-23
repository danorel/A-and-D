package algorithms.quick;

import algorithms.SortAbility;
import timer.Stopwatch;

public class DefaultQuickSort implements SortAbility, QuickSortManager {

    private double time;

    public Comparable[] sort(Comparable[] Array) {
        Stopwatch timer = new Stopwatch();
        quickSort(Array, 0, Array.length - 1);
        time = Stopwatch.evaluateTime();
        return Array;
    }

    @Override
    public String toString() {
        return "DefaultQuickSort |" + time + "|: ";
    }
}
