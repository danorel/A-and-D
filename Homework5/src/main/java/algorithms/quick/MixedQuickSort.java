package algorithms.quick;

import algorithms.SortAbility;
import timer.Stopwatch;

import java.util.Comparator;

public class MixedQuickSort implements SortAbility, QuickSortManager {

    private static final int CONSTANT = 1000;
    private double time;

    @Override
    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        Stopwatch timer = new Stopwatch();
        quickSort(Array, 0, Array.length - 1);
        time = Stopwatch.evaluateTime();
        return Array;
    }

    public void quickSort(Comparable[] Array, int lowest, int highest) {
        if (highest <= lowest) return;
        int size = highest - lowest + 1;
        if (size < CONSTANT) // insertion quickSort if small
            insertionSort(Array, lowest, highest);
        else // quicksort if large
        {
            int lt = lowest, gt = highest;
            Comparable v = Array[lowest];
            int i = lowest + 1;
            while (i <= gt) {
                int compareResult = Array[i].compareTo(v);
                if      (compareResult < 0) exch(Array, lt++, i++);
                else if (compareResult > 0) exch(Array, i, gt--);
                else              i++;
            }
            quickSort(Array, lowest, lt - 1);
            quickSort(Array, gt + 1, highest);
            assert isSorted(Array, lowest, highest);
        }
    }


    public static void insertionSort(Comparable[] Array, int leftPosition, int rightPosition) {
        int in, out;
        //  sorted on left of out
        for (out = leftPosition + 1; out <= rightPosition; out++) {
            Comparable temp = Array[out]; // remove marked item
            in = out; // start shifts at out
            // until one is smaller,
            while (in > leftPosition && Array[in - 1].compareTo( temp) >= 0) {
                Array[in] = Array[in - 1]; // shift item to right
                --in; // go left one position
            }
            Array[in] = temp; // insert marked item
        }
    }

    private static boolean less(Comparable first, Comparable second) {
        return first.compareTo(second) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] Array, int firstPosition, int secondPosition) {
        Object swap = Array[firstPosition];
        Array[firstPosition] = Array[secondPosition];
        Array[secondPosition] = swap;
    }

    private static boolean isSorted(Comparable[] Array) {
        return isSorted(Array, 0, Array.length - 1);
    }

    private static boolean isSorted(Comparable[] Array, int lowest, int highest) {
        for (int index = lowest + 1; index <= highest; index++)
            if (less(Array[index], Array[index - 1])) return false;
        return true;
    }

    @Override
    public String toString() {
        return "MixedQuickSort |" + time + "|: ";
    }
}
