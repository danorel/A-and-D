package algorithms;

import java.util.Comparator;

public class SelectionSort implements Sort, DefaultSortingManager {

    @Override
    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        if(Array.length > 0){
            int currentIndex = 0;
            Comparable min = Array[0]; //мінімальне число масиву
            boolean isSwapped = false;
            for (int currentNumber = 0; currentNumber < Array.length; currentNumber++) {
                for (int index = currentNumber; index < Array.length; index++) {
                    if (isLess(Array[index], min, comparator)) { //порівнюємо елемент під індексом index з мінімальним
                        min = Array[index];
                        currentIndex = index;
                        isSwapped = true;
                    }
                }
                if (isSwapped) {
                    swap(Array, currentIndex, currentNumber);
                    isSwapped = false;
                }
                if (currentNumber != Array.length - 1) {
                    min = Array[currentNumber + 1];
                }
            }
        }
        return Array;
    }
}

