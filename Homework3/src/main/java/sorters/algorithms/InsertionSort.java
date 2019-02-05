package sorters.algorithms;

import sorters.Sort;

import java.util.Comparator;

public class InsertionSort implements Sort {

    public void sort(Comparable[] Array) {
        for(int index = 1; index < Array.length; index++){
            int iteration = index;
            for(int counter = index - 1; counter > -1; counter--){
                if(isLess(Array[iteration], (Array[counter]), null, "ASC")){
                    exchange(Array, iteration, counter);
                    iteration--;
                } else {
                    break;
                }
            }
        }
    }

    public void sort(Comparable[] Array, Comparator comparator) {
        for(int index = 1; index < Array.length; index++){
            int iteration = index;
            for(int counter = index - 1; counter > -1; counter--){
                if(isLess(Array[iteration], (Array[counter]), comparator, "ASC")){
                    exchange(Array, iteration, counter);
                    iteration--;
                } else {
                    break;
                }
            }
        }
    }

    public void sort(Comparable[] Array, Comparator comparator, String order) {
        for(int index = 1; index < Array.length; index++){
            int iteration = index;
            for(int counter = index - 1; counter > -1; counter--){
                if(isLess(Array[iteration], (Array[counter]), comparator, order)){
                    exchange(Array, iteration, counter);
                    iteration--;
                } else {
                    break;
                }
            }
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
