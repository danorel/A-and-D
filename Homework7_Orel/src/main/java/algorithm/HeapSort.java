package algorithm;

import java.util.Comparator;

public class HeapSort {

    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        if(Array.length > 0){
            for (int index = (Array.length / 2) - 1; index >= 0; index--){
                heapify(Array, Array.length, index, comparator);
            }
            for (int index = Array.length - 1; index >= 0; index--){
                swap(Array, index, 0);
                heapify(Array, index, 0, comparator);
            }
        }
        return Array;
    }

    private void heapify(Comparable []Array, int size, int basis, Comparator comparator){
        int biggest = basis;
        int leftPos = 2 * basis + 1;
        int rightPos = 2 * basis + 2;
        if (leftPos < size && isLess(Array[biggest], Array[leftPos], comparator)){
            biggest = leftPos;
        }
        if (rightPos < size && isLess(Array[biggest], Array[rightPos], comparator)){
            biggest = rightPos;
        }
        if (biggest != basis){
            swap(Array, biggest, basis);
            heapify(Array, size, biggest, comparator);
        }
    }

    private boolean isLess(Comparable first, Comparable second, Comparator comparator){
        if(comparator == null){
            return first.compareTo(second) < 0;
        } else {
            return comparator.compare(first, second) < 0;
        }
    }

    private void swap(Comparable[] Array, int firstPos, int secondPos){
        Comparable temp = Array[firstPos];
        Array[firstPos] = Array[secondPos];
        Array[secondPos] = temp;
    }
}
