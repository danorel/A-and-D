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
}
