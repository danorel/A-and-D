package algorithms;

import timer.Stopwatch;

import java.util.Comparator;

public class ShellSort implements SortAbility, BasicSortFunctionality {

    private double time;

    @Override
    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        Stopwatch timer = new Stopwatch();
        int outerIndex, innerIndex;
        int distance = Array.length / 2;
        while(distance > 0){
            for(outerIndex = distance; outerIndex < Array.length; outerIndex++){
                Comparable temp = Array[outerIndex];
                for(innerIndex = outerIndex; innerIndex >= distance; innerIndex -= distance){
                    if(isLess(comparator, Array[innerIndex - distance], temp)){
                        Array[innerIndex] = Array[innerIndex - distance];
                    } else {
                        break;
                    }
                }
                Array[innerIndex] = temp;
            }
            distance = getShellSortCoefficient(distance);
        }
        time = Stopwatch.evaluateTime();
        return Array;
    }

    private int getShellSortCoefficient(int coefficient){
        return coefficient / 2;
    }

    @Override
    public String toString() {
        return "ShellSort |" + time + "|: ";
    }
}
