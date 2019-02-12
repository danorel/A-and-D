package strategy.algorithms;

import strategy.Sort;
import timer.Timer;

public class HeapSort implements Sort {

    private double time;

    public void sort(Comparable[] Array) {
        Timer timer = new Timer();
        for(int index = (Array.length / 2) - 1; index >= 0; index--){
            heapify(Array, Array.length, index);
        }
        for(int index = Array.length - 1; index >= 0; index--){
            exchange(Array, index, 0);
            heapify(Array, index, 0);
        }
        time = Timer.calculate();
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
