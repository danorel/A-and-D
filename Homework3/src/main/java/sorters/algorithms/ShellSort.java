package sorters.algorithms;

import sorters.Sort;

import java.util.Comparator;

public class ShellSort implements Sort {

    public void sort(Comparable[] Array) {
        int outerIndex, innerIndex;
        int distance = Array.length / 2;
        while(distance > 0){
            for(outerIndex = distance; outerIndex < Array.length; outerIndex++){
                Comparable temp = Array[outerIndex];
                for(innerIndex = outerIndex; innerIndex >= distance; innerIndex -= distance){
                    if(isLess(temp, Array[innerIndex - distance], null, "ASC")){
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

    public void sort(Comparable[] Array, Comparator comparator) {
        int outerIndex, innerIndex;
        int distance = Array.length / 2;
        while(distance > 0){
            for(outerIndex = distance; outerIndex < Array.length; outerIndex++){
                Comparable temp = Array[outerIndex];
                for(innerIndex = outerIndex; innerIndex >= distance; innerIndex -= distance){
                    if(isLess(temp, Array[innerIndex - distance], comparator, "ASC")){
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

    private boolean isLess(Comparable first, Comparable second, Comparator comparator, String order){
        if(order.equals("ASC")) {
            if (comparator == null) {
                return first.compareTo(second) < 0;
            } else {
                return comparator.compare(first, second) < 0;
            }
        } else if(order.equals("DESC")){
            if (comparator == null) {
                return first.compareTo(second) > 0;
            } else {
                return comparator.compare(first, second) > 0;
            }
        }
        return false;
    }

    private void exchange(Comparable []Array, int firstPosition, int secondPosition){
        Comparable temp = Array[firstPosition];
        Array[firstPosition] = Array[secondPosition];
        Array[secondPosition] = temp;
    }
}
