package sorters.algorithms;

import sorters.Sort;

import java.util.Comparator;

public class ShellSort implements Sort {

    public void sort(Comparable[] Array) {
        sort(Array, null, "ASC");
    }

    public void sort(Comparable[] Array, Comparator comparator) {
        sort(Array, comparator, "ASC");
    }

    public void sort(Comparable[] Array, Comparator comparator, String order) {
        int outerIndex, innerIndex;
        int distance = Array.length / 2;
        while(distance > 0){
            for(outerIndex = distance; outerIndex < Array.length; outerIndex++){
                Comparable temp = Array[outerIndex];
                for(innerIndex = outerIndex; innerIndex >= distance; innerIndex -= distance){
                    if(isLess(temp, Array[innerIndex - distance], comparator, order)){
                        Array[innerIndex] = Array[innerIndex - distance];
                    } else {
                        break;
                    }
                }
                Array[innerIndex] = temp;
            }
            distance = getShellSortCoefficient(distance);
        }
    }

    private int getShellSortCoefficient(int coefficient){
        return coefficient / 2;
    }
}
