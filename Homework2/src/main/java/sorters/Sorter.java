package sorters;

import java.util.Comparator;

public class Sorter<T extends Comparable> implements SorterGenerator {
    private T []Array;
    private Comparator<Comparable> comparator;

    public Sorter setArray(T[] array) {
        Array = array;
        return this;
    }

    public Sorter setComparator(Comparator comparator){
        this.comparator = comparator;
        return this;
    }

    public Sorter insertionSort(){
        for(int index = 1; index < Array.length; index++){
            int iteration = index;
            for(int counter = index - 1; counter > -1; counter--){
                if(isLess(Array[iteration], (Array[counter])) < 0){
                    exchange(Array, iteration, counter);
                    iteration--;
                } else {
                    break;
                }
            }
        }
        return this;
    }

    public Sorter brushSort(){
        double coefficient = 1.247330950103979;
        double distance = (int) (Array.length / coefficient);
        do{
            for(int innerIndex = 0; innerIndex + distance < Array.length; innerIndex++) {
                if(isLess(Array[innerIndex + (int)distance], Array[innerIndex]) < 0){
                    exchange(Array, innerIndex, innerIndex + (int)distance);
                }
            }
            distance = (distance / coefficient);
        } while(distance > 1);
        return this;
    }

    public Sorter ShellSort(){
        int outerIndex, innerIndex;
        int distance = Array.length / 2;
        while(distance > 0){
            for(outerIndex = distance; outerIndex < Array.length; outerIndex++){
                T temp = Array[outerIndex];
                for(innerIndex = outerIndex; innerIndex >= distance; innerIndex -= distance){
                    if(isLess(temp, Array[innerIndex - distance]) < 0){
                        Array[innerIndex] = Array[innerIndex - distance];
                    } else {
                        break;
                    }
                }
                Array[innerIndex] = temp;
            }
            distance = getShellSortCoefficient(distance);
        }
        return this;
    }

    public Sorter showArray(){
        for(T element : Array){
            System.out.println(element);
        }
        return this;
    }

    private int getShellSortCoefficient(int coefficient){
        return coefficient / 2;
    }

    private int isLess(Comparable firstValue, Comparable secondValue){
        if(comparator == null){
            return firstValue.compareTo(secondValue);
        } else {
            return comparator.compare(firstValue, secondValue);
        }
    }

    private void exchange(Comparable []Array, int firstPosition, int secondPosition){
        Comparable temp = Array[firstPosition];
        Array[firstPosition] = Array[secondPosition];
        Array[secondPosition] = temp;
    }
}