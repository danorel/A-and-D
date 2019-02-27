package algorithms;

import java.util.Comparator;

public class ShellSort implements Sort, DefaultSortingManager {
    @Override
    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        if(Array.length > 0) {
            int inIndex, outIndex;
            int distance = Array.length / 2;
            while (distance > 0){
                for (outIndex = distance; outIndex < Array.length; outIndex++){
                    Comparable temporary = Array[outIndex];
                    for (inIndex = outIndex; inIndex >= distance; inIndex -= distance){
                        if (isLess(temporary, Array[inIndex - distance], comparator)){
                            Array[inIndex] = Array[inIndex - distance];
                        } else {
                            break;
                        }
                    }
                    Array[inIndex] = temporary;
                } distance = shellSortCoefficient(distance);
            }
        }
        return Array;
    }

    private int shellSortCoefficient(int coefficient){
        return coefficient / 2;
    }
}
