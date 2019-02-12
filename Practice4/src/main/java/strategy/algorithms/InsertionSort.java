package strategy.algorithms;

import strategy.Sort;
import timer.Timer;

import java.util.Comparator;

public class InsertionSort implements Sort {

    private double time;

    public void sort(Comparable[] Array) {
        Timer timer = new Timer();
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
        time = Timer.calculate();
    }

    @Override
    public String toString() {
        return "InsertionSort |" + time + "|: ";
    }
}
