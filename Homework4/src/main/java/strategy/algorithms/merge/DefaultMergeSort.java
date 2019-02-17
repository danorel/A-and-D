package strategy.algorithms.merge;

import strategy.Sort;
import timer.Timer;

public class DefaultMergeSort implements Sort, MergeSortManager{

    private double time;

    public void sort(Comparable[] Array) {
        Timer timer = new Timer();
        mergeSort(Array, 0, Array.length - 1);
        time = Timer.calculate();
    }

    @Override
    public String toString() {
        return "DefaultMergeSort |" + time + "|: ";
    }
}