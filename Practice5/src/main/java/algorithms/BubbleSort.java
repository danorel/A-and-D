package algorithms;

import timer.Stopwatch;

public class BubbleSort implements SortAbility, BasicSortFunctionality {

    private double time;

    @Override
    public Integer[] sort(Integer[] Array) {
        Stopwatch timer = new Stopwatch();
        for(int iIteration = 0; iIteration < Array.length; iIteration++){
            for(int jIteration = 0; jIteration < Array.length - 1; jIteration++){
                if(isLess(Array[jIteration], Array[jIteration + 1])){
                    exchange(Array, jIteration + 1, jIteration);
                }
             }
        }
        time = Stopwatch.evaluateTime();
        return Array;
    }

    @Override
    public String toString() {
        return "BubbleSort |" + time + "|: ";
    }
}
