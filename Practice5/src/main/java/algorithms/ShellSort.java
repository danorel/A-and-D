package algorithms;

import timer.Stopwatch;

public class ShellSort implements SortAbility, BasicSortFunctionality {

    private double time;

    @Override
    public Integer[] sort(Integer[] Array) {
        Stopwatch timer = new Stopwatch();
        int outerIndex, innerIndex;
        int distance = Array.length / 2;
        while(distance > 0){
            for(outerIndex = distance; outerIndex < Array.length; outerIndex++){
                Integer temp = Array[outerIndex];
                for(innerIndex = outerIndex; innerIndex >= distance; innerIndex -= distance){
                    if(isLess(Array[innerIndex - distance], temp)){
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
