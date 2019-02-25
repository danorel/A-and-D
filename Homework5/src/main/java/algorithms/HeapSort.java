package algorithms;

import timer.Stopwatch;

import java.util.Comparator;

public class HeapSort implements SortAbility, BasicSortFunctionality {

    private double time;

    @Override
    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        Stopwatch timer = new Stopwatch();
        for(int index = (Array.length / 2) - 1; index >= 0; index--){
            heapify(Array, comparator, Array.length, index);
        }
        for(int index = Array.length - 1; index >= 0; index--){
            exchange(Array, index, 0);
            heapify(Array, comparator, index, 0);
        }
        time = Stopwatch.evaluateTime();
        return Array;
    }

    private void heapify(Comparable []Array, Comparator comparator, int size, int root) {
        int largest = root; // Initialize largest as root
        int left = 2 * root + 1; // left = 2*i + 1
        int right = 2 * root + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < size && isLess(comparator ,Array[left], Array[largest]))
            largest = left;

        // If right child is larger than largest so far
        if (right < size && isLess(comparator, Array[right], Array[largest]))
            largest = right;

        // If largest is not root
        if (largest != root)
        {
            exchange(Array, root, largest);

            // Recursively heapify the affected sub-tree
            heapify(Array, comparator, size, largest);
        }
    }

    @Override
    public String toString() {
        return "HeapSort |" + time + "|: ";
    }
}
