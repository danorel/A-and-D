package algorithms.quick;

import algorithms.Sort;
import timer.Stopwatch;

import java.util.Comparator;

public class DijkstraQuickSort implements Sort, QuickSortContainer {

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

    @Override
    public Comparable[] quickSort(Comparable[] Array, int lowest, int highest, Comparator comparator) {
        if (highest <= lowest) return null;
        int size = highest - lowest + 1;
        int lt = lowest, gt = highest;
        Comparable v = Array[lowest];
        int i = lowest + 1;
        while (i <= gt) {
            int compareResult = comparator == null ? Array[i].compareTo(v) : comparator.compare(Array[i], v);
            if      (compareResult < 0) swap(Array, lt++, i++);
            else if (compareResult > 0) swap(Array, i, gt--);
            else              i++;
        }
        quickSort(Array, lowest, lt - 1, comparator);
        quickSort(Array, gt + 1, highest, comparator);
        assert isSorted(Array, lowest, highest, comparator);
        return Array;
    }

    private boolean isSorted(Comparable[] Array, Comparator comparator) {
        return isSorted(Array, 0, Array.length - 1, comparator);
    }

    private boolean isSorted(Comparable[] Array, int lowest, int highest, Comparator comparator) {
        for (int index = lowest + 1; index <= highest; index++)
            if (isLess(Array[index], Array[index - 1], comparator)) return false;
        return true;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " *" + time + "*: ";
    }
}
