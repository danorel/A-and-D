package strategy.algorithms.quick;

import strategy.Sort;
import timer.Timer;

public class DijkstraQuickSort implements Sort {

    private double time;

    @Override
    public void sort(Comparable[] Array) {
        Timer timer = new Timer();
        quickSort(Array, 0, Array.length - 1);
        time = Timer.calculate();
    }

    private void quickSort(Comparable[] Array, int lowest, int highest) {
        if (highest <= lowest) return;
        int size = highest - lowest + 1;
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
        return "DijkstraQuickSort |" + time + "|: ";
    }
}
