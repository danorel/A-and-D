package algorithms;

import timer.Stopwatch;

public class InsertionSort implements SortAbility, BasicSortFunctionality {

    private double time;

    public Comparable[] sort(Comparable[] Array) {
        Stopwatch timer = new Stopwatch();
        for(int index = 1; index < Array.length; index++){
            int iteration = index;
            for(int counter = index - 1; counter > -1; counter--){
                if(isLess(Array[iteration], (Array[counter]))){
                    exchange(Array, iteration, counter);
                    iteration--;
                } else {
                    break;
                }
            }
        }
        time = Stopwatch.evaluateTime();
        return Array;
    }

    @Override
    public String toString() {
        return "InsertionSort |" + time + "|: ";
    }
}
