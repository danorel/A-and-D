package algorithms;

import timer.Stopwatch;

import java.util.Comparator;

public class HeapSort implements SortAbility, BasicSortFunctionality {

    private double time;

    @Override
    public Integer[] sort(Integer[] Array) {
        Stopwatch timer = new Stopwatch();
        for(int index = (Array.length / 2) - 1; index >= 0; index--){
            heapify(Array, Array.length, index);
        }
        for(int index = Array.length - 1; index >= 0; index--){
            exchange(Array, index, 0);
            heapify(Array, index, 0);
        }
        time = Stopwatch.evaluateTime();
        return Array;
    }

    private void heapify(Integer []Array, int size, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && isLess(Array[left], Array[largest]))
            largest = left;

        if (right < size && isLess(Array[right], Array[largest]))
            largest = right;

        if (largest != root)
        {
            exchange(Array, root, largest);
            heapify(Array, size, largest);
        }
    }
    @Override
    public String toString() {
        return "HeapSort |" + time + "|: ";
    }
}
