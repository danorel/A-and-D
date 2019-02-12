package strategy.algorithms;

import strategy.Sort;
import timer.Timer;

public class CombSort implements Sort {

    private double time;

    public void sort(Comparable[] Array) {
        Timer timer = new Timer();
        double coefficient = 1.247330950103979;
        double distance = (int) (Array.length / coefficient);
        do{
            for(int innerIndex = 0; innerIndex + distance < Array.length; innerIndex++) {
                if(isLess(Array[innerIndex + (int)distance], Array[innerIndex])){
                    exchange(Array, innerIndex, innerIndex + (int)distance);
                }
            }
            distance = (distance / coefficient);
        } while(distance > 1);
        time = Timer.calculate();
    }

    @Override
    public String toString() {
        return "CombSort |" + time + "|: ";
    }
}
