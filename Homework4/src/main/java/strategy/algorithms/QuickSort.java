package strategy.algorithms;

import strategy.Sort;
import timer.Timer;

import java.util.Comparator;

public class QuickSort implements Sort {

    private double time;

    public void sort(Comparable[] Array) {
        Timer timer = new Timer();
        quickSort(Array, 0, Array.length - 1);
        time = Timer.calculate();
    }

    private void quickSort(Comparable []Array, int leftPosition, int rightPosition){
        if(rightPosition > leftPosition){
            int pi = generatePartition(Array, leftPosition, rightPosition);
            quickSort(Array, leftPosition, pi - 1);
            quickSort(Array,pi + 1, rightPosition);
        }
    }

    private int generatePartition(Comparable []Array, int leftPosition, int rightPosition) {
        Comparable pivot = Array[rightPosition];
        int i = (leftPosition - 1);
        for(int j = leftPosition; j < rightPosition; j++){
            if(isLess(Array[j], pivot)){
                i++;
                exchange(Array, i, j);
            }
        }
        exchange(Array,i + 1, rightPosition);
        return i + 1;
    }

    @Override
    public String toString() {
        return "QuickSort |" + time + "|: ";
    }
}
