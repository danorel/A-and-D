package algorithms;

import timer.Stopwatch;

public class SelectionSort implements SortAbility, BasicSortFunctionality {

    private double time;

    @Override
    public Integer[] sort(Integer[] Array) {
        if(Array.length > 0){
            Stopwatch timer = new Stopwatch();
            Integer min = Array[0];
            boolean isChanged = false;
            int current_index = 0;
            for(int current = 0; current < Array.length; current++){
                for(int index = current; index < Array.length; index++){
                    if(isLess(min, Array[index])){
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
            time = Stopwatch.evaluateTime();
        }
        return Array;
    }

    @Override
    public String toString() {
        return "SelectionSort |" + time + "|: ";
    }
}
