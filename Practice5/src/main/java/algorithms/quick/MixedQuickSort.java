package algorithms.quick;

import algorithms.SortAbility;
import timer.Stopwatch;

public class MixedQuickSort implements SortAbility, QuickSortManager {

    private static final int CONSTANT = 1000;
    private double time;

    @Override
    public Integer[] sort(Integer[] Array) {
        Stopwatch timer = new Stopwatch();
        quickSort(Array, 0, Array.length - 1);
        time = Stopwatch.evaluateTime();
        return Array;
    }

    public void quickSort(Integer[] Array, int lowest, int highest) {
        if (highest <= lowest) return;
        int size = highest - lowest + 1;
        if (size < CONSTANT) // insertion quickSort if small
            insertionSort(Array, lowest, highest);
        else // quicksort if large
        {
            int lt = lowest, gt = highest;
            Integer v = Array[lowest];
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


    public static void insertionSort(Integer[] Array, int leftPosition, int rightPosition) {
        int in, out;
        //  sorted on left of out
        for (out = leftPosition + 1; out <= rightPosition; out++) {
            Integer temp = Array[out]; // remove marked item
            in = out; // start shifts at out
            // until one is smaller,
            while (in > leftPosition && Array[in - 1].compareTo( temp) >= 0) {
                Array[in] = Array[in - 1]; // shift item to right
                --in; // go left one position
            }
            Array[in] = temp; // insert marked item
        }
    }

    private static boolean less(Integer first, Integer second) {
        return first.compareTo(second) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Integer[] Array, int firstPosition, int secondPosition) {
        Integer swap = Array[firstPosition];
        Array[firstPosition] = Array[secondPosition];
        Array[secondPosition] = swap;
    }

    private static boolean isSorted(Integer[] Array) {
        return isSorted(Array, 0, Array.length - 1);
    }

    private static boolean isSorted(Integer[] Array, int lowest, int highest) {
        for (int index = lowest + 1; index <= highest; index++)
            if (less(Array[index], Array[index - 1])) return false;
        return true;
    }

    @Override
    public String toString() {
        return "MixedQuickSort |" + time + "|: ";
    }
}
