package algorithms.quick;

import algorithms.SortAbility;
import timer.Stopwatch;

public class InsertionQuickSort implements SortAbility, QuickSortManager {

    private double time;
    private static final int CONSTANT = 500;

    @Override
    public Integer[] sort(Integer[] Array) {
        Stopwatch timer = new Stopwatch();
        quickSort(Array, 0, Array.length - 1);
        time = Stopwatch.evaluateTime();
        return Array;
    }

    public void quickSort(Integer[] Array, int leftPosition, int rightPosition) {
        int size = rightPosition - leftPosition + 1;
        if (size < CONSTANT) // insertion sort if small
            insertionSort(Array, leftPosition, rightPosition);
        else // quickSort if large
        {
            Integer median = medianOf3(Array, leftPosition, rightPosition);
            int partition = partitionIt(Array, leftPosition, rightPosition, median);
            quickSort(Array, leftPosition, partition - 1);
            quickSort(Array, partition + 1, rightPosition);
        }
    }

    public Integer medianOf3(Integer[] Array, int leftPosition, int rightPosition) {
        int middlePosition = (leftPosition + rightPosition) / 2;
        // order left & center
        if (Array[leftPosition].compareTo( Array[middlePosition]) > 0)
            swap(Array, leftPosition, middlePosition);
        // order left & right
        if (Array[leftPosition].compareTo(Array[rightPosition]) > 0)
            swap(Array, leftPosition, rightPosition);
        // order center & right
        if (Array[middlePosition].compareTo( Array[rightPosition]) > 0)
            swap(Array, middlePosition, rightPosition);
        swap(Array, middlePosition, rightPosition - 1);
        return Array[rightPosition - 1];
    }

    public void swap(Integer[] Array, int firstPosition, int secondPosition) {
        Integer temp = Array[firstPosition];
        Array[firstPosition] = Array[secondPosition];
        Array[secondPosition] = temp;
    }

    public int partitionIt(Integer Array[], int leftPosition, int rightPosition, Integer pivot) {
        int leftPtr = leftPosition; // right of first elem
        int rightPtr = rightPosition - 1; // left of pivot
        while (true) {
            //find bigger
            while (Array[++leftPtr].compareTo(pivot) < 0);
            //find smaller
            while (Array[--rightPtr].compareTo(pivot)>0);
            if (leftPtr >= rightPtr) // if pointers cross, partition done
                break;
            else
                swap(Array, leftPtr, rightPtr);
        }
        swap(Array, leftPtr, rightPosition - 1); // restore pivot
        return leftPtr; // return pivot location
    }

    private void insertionSort(Integer[] Array, int left, int right) {
        int in, out;
        //  sorted on left of out
        for (out = left + 1; out <= right; out++) {
            Integer temp = Array[out]; // remove marked item
            in = out; // start shifts at out
            // until one is smaller,
            while (in > left && Array[in - 1].compareTo( temp) >= 0) {
                Array[in] = Array[in - 1]; // shift item to right
                --in; // go left one position
            }
            Array[in] = temp; // insert marked item
        }
    }

    @Override
    public String toString() {
        return "InsertionQuickSort |" + time + "|: ";
    }
}
