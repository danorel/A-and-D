package algorithms.quick;

import algorithms.SortAbility;
import timer.Stopwatch;

public class DefaultQuickSort implements SortAbility, QuickSortManager {

    private double time;

    public void sort(Comparable[] Array) {
        Stopwatch timer = new Stopwatch();
        quickSort(Array, 0, Array.length - 1);
        time = Stopwatch.evaluateTime();
    }

    @Override
    public String toString() {
        return "DefaultQuickSort |" + time + "|: ";
    }
}
