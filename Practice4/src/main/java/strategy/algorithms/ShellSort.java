package strategy.algorithms;

import strategy.Sort;
import timer.Timer;

public class ShellSort implements Sort {

    private double time;

    public void sort(Comparable[] Array) {
        Timer timer = new Timer();
        int outerIndex, innerIndex;
        int distance = Array.length / 2;
        while(distance > 0){
            for(outerIndex = distance; outerIndex < Array.length; outerIndex++){
                Comparable temp = Array[outerIndex];
                for(innerIndex = outerIndex; innerIndex >= distance; innerIndex -= distance){
                    if(isLess(temp, Array[innerIndex - distance])){
                        Array[innerIndex] = Array[innerIndex - distance];
                    } else {
                        break;
                    }
                }
                Array[innerIndex] = temp;
            }
            distance = getShellSortCoefficient(distance);
        }
        time = Timer.calculate();
    }

    private int getShellSortCoefficient(int coefficient){
        return coefficient / 2;
    }

    @Override
    public String toString() {
        return "ShellSort |" + time + "|: ";
    }
}
