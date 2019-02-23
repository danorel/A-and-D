package algorithms;

import timer.Stopwatch;

import java.util.Comparator;

public class CombSort implements SortAbility, BasicSortFunctionality {

    private double time;

    @Override
    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        Stopwatch timer = new Stopwatch();
        double coefficient = 1.247330950103979;
        double distance = (int) (Array.length / coefficient);
        do{
            for(int innerIndex = 0; innerIndex + distance < Array.length; innerIndex++) {
                if(isLess(comparator, Array[innerIndex], Array[innerIndex + (int)distance])){
                    exchange(Array, innerIndex, innerIndex + (int)distance);
                }
            }
            distance = (distance / coefficient);
        } while(distance > 1);
        time = Stopwatch.evaluateTime();
        return Array;
    }

    @Override
    public String toString() {
        return "CombSort |" + time + "|: ";
    }
}
