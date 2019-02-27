package algorithms.quick;

import algorithms.Sort;
import timer.Stopwatch;

import java.util.Comparator;

public class MixedQuickSort implements Sort, QuickSortContainer, InsertionQuickSortContainer {

    private static final int CONSTANT = 1000;
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
    public boolean isLess(Comparable first, Comparable second, Comparator comparator) {
        if(comparator == null){
            return first.compareTo(second) < 0;
        } else {
            return comparator.compare(first, second) < 0;
        }
    }

    @Override
    public Comparable[] quickSort(Comparable[] Array, int lowest, int highest, Comparator comparator) {
        if (highest <= lowest) return null;
        int size = highest - lowest + 1;
        if (size < CONSTANT) // insertion quickSort if small
            insertionSort(Array, lowest, highest, comparator);
        else // quicksort if large
        {
            int lt = lowest, gt = highest;
            Comparable v = Array[lowest];
            int i = lowest + 1;
            while (i <= gt) {
                int compareResult = Array[i].compareTo(v);
                if      (compareResult < 0) swap(Array, lt++, i++);
                else if (compareResult > 0) swap(Array, i, gt--);
                else i++;
            }
            quickSort(Array, lowest, lt - 1, comparator);
            quickSort(Array, gt + 1, highest, comparator);
            assert isSorted(Array, lowest, highest, comparator);
        }
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
