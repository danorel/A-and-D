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
            heapify(Array, Array.length, index);
        }
        for(int index = Array.length - 1; index >= 0; index--){
            exchange(Array, index, 0);
            heapify(Array, index, 0);
        }
        time = Stopwatch.evaluateTime();
        return Array;
    }

    private void heapify(Comparable []Array, int size, int root) {
        int largest = root;
        int leftPosition = 2 * root + 1;
        int rightPosition = 2 * root + 2;

        if(leftPosition < size){
            largest = leftPosition;
        }

        if(rightPosition < size){
            largest = rightPosition;
        }

        if(largest != root){
            exchange(Array, largest, root);
            heapify(Array, size, largest);
        }
    }

    @Override
    public String toString() {
        return "HeapSort |" + time + "|: ";
    }
}
