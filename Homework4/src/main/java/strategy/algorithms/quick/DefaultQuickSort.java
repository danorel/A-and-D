package strategy.algorithms.quick;

import strategy.Sort;
import timer.Timer;

public class DefaultQuickSort implements Sort, QuickSortManager{

    private double time;

    public void sort(Comparable[] Array) {
        Timer timer = new Timer();
        quickSort(Array, 0, Array.length - 1);
        time = Timer.calculate();
    }

    @Override
    public String toString() {
        return "DefaultQuickSort |" + time + "|: ";
    }
}
