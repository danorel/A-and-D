package algorithms.quick;

import java.util.Comparator;
/*
    Допоміжний інтерфейс для класів InsertionQuickSort та MixedQuickSort,
    що використовують у своєму коді функцію сортування вставкою.
 */
public interface InsertionQuickSortContainer {
    default void insertionSort(Comparable[] Array, int left, int right, Comparator comparator) {
        int in, out;
        //  sorted on left of out
        for (out = left + 1; out <= right; out++) {
            Comparable temp = Array[out]; // remove marked item
            in = out; // start shifts at out
            // until one is smaller,
            while (in > left && isLess(Array[in - 1],  temp, comparator)) {
                Array[in] = Array[in - 1]; // shift item to right
                --in; // go left one position
            }
            Array[in] = temp; // insert marked item
        }
    }

    /*
        Якщо ж компаратор відсутній
        (можливе сортування звичайного масиву чисел (Integer, Double, etc))
        то сортувати звичайним порівнянням елементів first та second.
        Якщо ж компаратор != null, використати його
        функцію compare що порівнює об'єкти за певною властивістю
     */
    default boolean isLess(Comparable first, Comparable second, Comparator comparator) {
        if(comparator == null){
            return first.compareTo(second) < 0;
        } else {
            return comparator.compare(first, second) < 0;
        }
    }
}
