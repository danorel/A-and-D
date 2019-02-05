package sorters.algorithms;

import sorters.Sort;

import java.util.Comparator;

public class BubbleSort implements Sort {

    public void sort(Comparable[] Array) {
        for(int iIteration = 0; iIteration < Array.length; iIteration++){
            for(int jIteration = 0; jIteration < Array.length - 1; jIteration++){
                if(isLess(Array[jIteration + 1], Array[jIteration], null, "ASC")){
                    exchange(Array, jIteration + 1, jIteration);
                }
            }
        }
    }

    public void sort(Comparable[] Array, Comparator comparator) {
        for(int iIteration = 0; iIteration < Array.length; iIteration++){
            for(int jIteration = 0; jIteration < Array.length - 1; jIteration++){
                if(isLess(Array[jIteration + 1], Array[jIteration], comparator,"ASC")){
                    exchange(Array, jIteration + 1, jIteration);
                }
            }
        }
    }

    public void sort(Comparable[] Array, Comparator comparator, String order) {
        for(int iIteration = 0; iIteration < Array.length; iIteration++){
            for(int jIteration = 0; jIteration < Array.length - 1; jIteration++){
                if(isLess(Array[jIteration + 1], Array[jIteration], comparator, order)){
                    exchange(Array, jIteration + 1, jIteration);
                }
            }
        }
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
