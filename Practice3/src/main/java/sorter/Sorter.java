package sorter;

import java.util.Comparator;

public class Sorter<T extends Comparable> implements SorterGenerator {
    private T[] Array;
    private Comparator comparator = null;

    public SorterGenerator heapSort() {
        return this;
    }

    public Sorter quickSort(int leftPosition, int rightPosition) {
        if(rightPosition < leftPosition){
            int pi = generatePartition(leftPosition, rightPosition);
            quickSort(leftPosition, pi - 1);
            quickSort(pi + 1, rightPosition);
        }
        return this;
    }

    private int generatePartition(int leftPosition, int rightPosition) {
        T pivot = Array[rightPosition];
        int i = (leftPosition - 1);
        for(int j = leftPosition; j < rightPosition; j++){
            if(isLess(Array[j], pivot)){
                i++;
                exchange(i, j);
            }
        }
        exchange(i + 1, rightPosition);
        return i + 1;
    }

    public Sorter mergeSort(int leftPosition, int rightPosition) {
        if(rightPosition > leftPosition){
            int middlePosition = ((leftPosition + rightPosition) / 2);
            mergeSort(leftPosition, middlePosition);
            mergeSort(middlePosition + 1, rightPosition);
            merge(leftPosition, middlePosition, rightPosition);
        }
        return this;
    }

    private void merge(int leftPosition, int middlePosition, int rightPosition){
        Comparable []leftArray = new Comparable[(middlePosition + 1) - leftPosition];
        Comparable []rightArray = new Comparable[rightPosition - middlePosition];
        for(int index = 0; index < (middlePosition + 1) - leftPosition; index++){
            leftArray[index] = Array[leftPosition + index];
        }

        for(int index = 0; index < rightPosition - middlePosition; index++){
            rightArray[index] = Array[middlePosition + 1 + index];
        }

        int leftIndex = 0, rightIndex = 0;
        int index = leftIndex;
        while(leftIndex < (middlePosition + 1 - leftPosition) && rightIndex < (rightPosition - middlePosition)){
            if(isLess(leftArray[leftIndex], rightArray[rightIndex])){
                Array[index++] = (T) leftArray[leftIndex++];
            } else {
                Array[index++] = (T) rightArray[rightIndex++];
            }
        }

        while(leftIndex < (middlePosition + 1) - leftPosition){
            Array[index++] = (T) leftArray[leftIndex++];
        }

        while(rightIndex < rightPosition - middlePosition){
            Array[index++] = (T) rightArray[rightIndex++];
        }
    }

    private boolean isLess(Comparable first, Comparable second){
        if(comparator == null){
            return first.compareTo(second) < 0;
        } else {
            return comparator.compare(first, second) < 0;
        }
    }

    private void exchange(int firstPosition, int secondPosition) {
        T temp = Array[firstPosition];
        Array[firstPosition] = Array[secondPosition];
        Array[secondPosition] = temp;
    }

    public Sorter showArray(){
        for(T element : Array){
            System.out.println(element);
        }
        return this;
    }

    public Sorter setArray(T[] Array) {
        this.Array = Array;
        return this;
    }

    public Sorter setComparator(Comparator comparator) {
        this.comparator = comparator;
        return this;
    }
}
