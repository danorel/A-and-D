package algorithms;

import java.util.Comparator;

public class BubbleSort implements Sort, DefaultSortingManager {
    @Override
    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        if(Array.length > 0){
            for (int i = 0; i < Array.length; i++) { //проходимось до кінця масиву
                for (int j = 0; j < Array.length - 1; j++) { //індекс елементів, які порівнюємо і замінюємо
                    if (isLess(Array[j + 1], Array[j], comparator)) {
                        swap(Array, j + 1, j);
                    }
                }
            }
        }
        return Array;
    }
}
