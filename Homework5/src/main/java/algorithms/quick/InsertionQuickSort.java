package algorithms.quick;

import algorithms.Sort;
import timer.Stopwatch;

import java.util.Comparator;

public class InsertionQuickSort implements Sort, QuickSortContainer, InsertionQuickSortContainer{

    private double time;
    private static final int CONSTANT = 500;

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
    public Comparable[] quickSort(Comparable[] Array, int leftPosition, int rightPosition, Comparator comparator) {
        int size = rightPosition - leftPosition + 1;
        if (size < CONSTANT) // insertion sort if small
            insertionSort(Array, leftPosition, rightPosition, comparator);
        else // quickSort if large
        {
            Comparable median = medianOf3(Array, leftPosition, rightPosition, comparator);
            int partition = partitionIt(Array, leftPosition, rightPosition, median, comparator);
            quickSort(Array, leftPosition, partition - 1, comparator);
            quickSort(Array, partition + 1, rightPosition, comparator);
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

    public Comparable medianOf3(Comparable[] Array, int leftPosition, int rightPosition, Comparator comparator) {
        if(comparator == null){
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
        } else {
            int middlePosition = (leftPosition + rightPosition) / 2;
            // order left & center
            if (comparator.compare(Array[leftPosition], Array[middlePosition]) > 0)
                swap(Array, leftPosition, middlePosition);
            // order left & right
            if (comparator.compare(Array[leftPosition], Array[rightPosition]) > 0)
                swap(Array, leftPosition, rightPosition);
            // order center & right
            if (comparator.compare(Array[middlePosition], Array[rightPosition]) > 0)
                swap(Array, middlePosition, rightPosition);
            swap(Array, middlePosition, rightPosition - 1);
            return Array[rightPosition - 1];
        }
    }

    public int partitionIt(Comparable []Array, int leftPosition, int rightPosition, Comparable pivot, Comparator comparator) {
        int leftPtr = leftPosition; // right of first elem
        int rightPtr = rightPosition - 1; // left of pivot
        while (true) {
            if(comparator == null){
                //find bigger
                while (Array[++leftPtr].compareTo(pivot) < 0);
                //find smaller
                while (Array[--rightPtr].compareTo(pivot) > 0);
            } else {
                //find bigger
                while (comparator.compare(Array[++leftPtr], pivot) < 0);
                //find smaller
                while (comparator.compare(Array[--rightPtr], pivot) > 0);
            }
            if (leftPtr >= rightPtr) // if pointers cross, partition done
                break;
            else
                swap(Array, leftPtr, rightPtr);
        }
        swap(Array, leftPtr, rightPosition - 1); // restore pivot
        return leftPtr; // return pivot location
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " *" + time + "*: ";
    }
}
