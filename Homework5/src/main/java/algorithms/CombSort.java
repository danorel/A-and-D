package algorithms;

import java.util.Comparator;

public class CombSort implements Sort, DefaultSortingManager {
    @Override
    public Comparable[] sort(Comparable[] Array) {
        return sort(Array, null);
    }

    @Override
    public Comparable[] sort(Comparable[] Array, Comparator comparator) {
        if(Array.length > 0){
            double distance = 0;
            double coeff = 1.247330950103979; //фактор зменшення дистанції
            distance = (int)(Array.length / coeff);
            do {
                for (int index = 0; index + distance < Array.length; index++) {
                    if (isLess(Array[index + (int) distance], Array[index], comparator)) {
                        swap(Array, index, index + (int) distance);
                    }
                }
                distance = (distance / coeff);
            }
            while(distance > 1);
        }
        return Array;
    }
}
