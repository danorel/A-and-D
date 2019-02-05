package sorters.algorithms;

import sorters.Sort;

import java.util.Comparator;

public class HeapSort implements Sort {

    public void sort(Comparable[] Array) {
        for(int index = (Array.length / 2) - 1; index >= 0; index--){
            heapify(Array, Array.length, index, null, "ASC");
        }
        for(int index = Array.length - 1; index >= 0; index--){
            exchange(Array, index, 0);
            heapify(Array, index, 0, null, "ASC");
        }
    }

    public void sort(Comparable[] Array, Comparator comparator) {
        for(int index = (Array.length / 2) - 1; index >= 0; index--){
            heapify(Array, Array.length, index, comparator, "ASC");
        }
        for(int index = Array.length - 1; index >= 0; index--){
            exchange(Array, index, 0);
            heapify(Array, index, 0, comparator, "ASC");
        }
    }

    public void sort(Comparable[] Array, Comparator comparator, String order) {
        for(int index = (Array.length / 2) - 1; index >= 0; index--){
            heapify(Array, Array.length, index, comparator, order);
        }
        for(int index = Array.length - 1; index >= 0; index--){
            exchange(Array, index, 0);
            heapify(Array, index, 0, comparator, order);
        }
    }

    private void heapify(Comparable []Array, int size, int root, Comparator comparator, String order) {
        int largest = root;
        int leftPosition = 2 * root + 1;
        int rightPosition = 2 * root + 2;

        if(leftPosition < size && ((comparator == null) ? isLess(Array[largest], Array[leftPosition], null, order) : isLess(Array[largest], Array[leftPosition], comparator, order))){
            largest = leftPosition;
        }

        if(rightPosition < size && ((comparator == null) ? isLess(Array[largest], Array[rightPosition], null, order) : isLess(Array[largest], Array[rightPosition], comparator, order))){
            largest = rightPosition;
        }

        if(largest != root){
            exchange(Array, largest, root);
            heapify(Array, size, largest, comparator, order);
        }
    }

    private boolean isLess(Comparable first, Comparable second, Comparator comparator, String order){
        if(order.equals("ASC")) {
            if (comparator == null) {
                return first.compareTo(second) < 0;
            } else {
                return comparator.compare(first, second) < 0;
            }
        } else if(order.equals("DESC")){
            if (comparator == null) {
                return first.compareTo(second) > 0;
            } else {
                return comparator.compare(first, second) > 0;
            }
        }
        return false;
    }

    private void exchange(Comparable []Array, int firstPosition, int secondPosition){
        Comparable temp = Array[firstPosition];
        Array[firstPosition] = Array[secondPosition];
        Array[secondPosition] = temp;
    }
}
