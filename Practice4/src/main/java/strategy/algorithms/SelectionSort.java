package strategy.algorithms;

import strategy.Sort;
import timer.Timer;

import java.util.Comparator;

public class SelectionSort implements Sort {

    private double time;

    public void sort(Comparable[] Array) {
        Timer timer = new Timer();
        Comparable min = Array[0];
        boolean isChanged = false;
        int current_index = 0;
        for(int current = 0; current < Array.length; current++){
            for(int index = current; index < Array.length; index++){
                if(isLess(Array[index], min)){
                    min = Array[index];
                    current_index = index;
                    isChanged = true;
                }
            }
            if(isChanged){
                exchange(Array, current_index, current);
                isChanged = false;
            }
            if(current != Array.length - 1){
                min = Array[current + 1];
            }
        }
        time = Timer.calculate();
    }

    @Override
    public String toString() {
        return "SelectionSort |" + time + "|: ";
    }
}
