package algorithms.merge;

import java.util.Comparator;
/*
    Допоміжний інтерфейс для класів InsertionMergeSort та MixedMergeSort,
    що використовують у своєму коді функцію сортування вставкою.
 */
public interface InsertionMergeSortContainer {
    default void insertionSort(Comparable[] Array, int left, int right, Comparator comparator) {
        int in, out;
        //  sorted on left of out
        for (out = left + 1; out <= right; out++) {
            Comparable temp = Array[out]; // remove marked item
            in = out; // start shifts at out
            // until one is smaller,
            while (in > left && comparator == null ? Array[in - 1].compareTo( temp) >= 0 : comparator.compare(Array[in - 1], temp) >= 0) {
                Array[in] = Array[in - 1]; // shift item to right
                --in; // go left one position
            }
            Array[in] = temp; // insert marked item
        }
    }
}
