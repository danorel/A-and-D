package strategy.algorithms;

import strategy.Sort;
import timer.Timer;

import java.util.Comparator;

public class BubbleSort implements Sort {

    private double time;

    public void sort(Comparable[] Array) {
        Timer timer = new Timer();
        for(int iIteration = 0; iIteration < Array.length; iIteration++){
            for(int jIteration = 0; jIteration < Array.length - 1; jIteration++){
                if(isLess(Array[jIteration + 1], Array[jIteration])){
                    exchange(Array, jIteration + 1, jIteration);
                }
             }
        }
        time = Timer.calculate();
    }

    @Override
    public String toString() {
        return "BubbleSort |" + time + "|: ";
    }
}
