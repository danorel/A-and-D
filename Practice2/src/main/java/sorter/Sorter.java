package sorter;

import java.util.Comparator;

public class Sorter<T extends Comparable> implements SorterGenerator {
    private T[] Array;
    private Comparator comparator;

    public Sorter setComparator(Comparator comparator){
        this.comparator = comparator;
        return this;
    }

    public Sorter bubbleSort(){
        for(int iIndex = 0; iIndex < Array.length; iIndex++){
            for(int jIndex = 0; jIndex < Array.length - 1; jIndex++){
                if(isLess(Array[jIndex + 1], Array[jIndex])){
                    exchange(Array, jIndex + 1, jIndex);
                }
            }
        }
        return this;
    }

    public Sorter selectionSort(){
        Comparable min = Array[0];
        boolean isChanged = false;
        int current_index = 0;
        for(int current = 0; current < Array.length; current++){
            for(int index = current; index < Array.length; index++){
                if(isLess(Array[index], min)){
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
        return this;
    }

    public Sorter showArray(){
        for(T element : Array){
            System.out.println(element);
        }
        return this;
    }

    public Sorter setArray(T[] array) {
        Array = array;
        return this;
    }

    private boolean isLess(Comparable first, Comparable second){
        if(comparator == null){
            return first.compareTo(second) < 0;
        } else {
            return comparator.compare(first, second) < 0;
        }
    }

    private void exchange(Comparable []Array, int fPos, int sPos){
        Comparable temp = Array[fPos];
        Array[fPos] = Array[sPos];
        Array[sPos] = temp;
    }
}
