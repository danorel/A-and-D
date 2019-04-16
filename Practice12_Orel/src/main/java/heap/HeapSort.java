package heap;

public class HeapSort {

    public Comparable[] sortAsc(Comparable[] source){
        if(source.length > 0){
            for (int index = (source.length / 2) - 1; index >= 0; index--){
                heapify(source, source.length, index, true);
            }
            for (int index = source.length - 1; index >= 0; index--){
                swap(source, index, 0);
                heapify(source, index, 0, true);
            }
        }
        return source;
    }

    public Comparable[] sortDesc(Comparable[] source){
        if(source.length > 0){
            for (int index = (source.length / 2) - 1; index >= 0; index--){
                heapify(source, source.length, index, false);
            }
            for (int index = source.length - 1; index >= 0; index--){
                swap(source, index, 0);
                heapify(source, index, 0, false);
            }
        }
        return source;
    }

    private void heapify(Comparable []source, int length, int basis, boolean isAscSorting){
        int biggest = basis;
        int leftPos = 2 * basis + 1;
        int rightPos = 2 * basis + 2;
        if(isAscSorting){
            if (leftPos < length && isLess(source[biggest], source[leftPos])){
                biggest = leftPos;
            }
            if (rightPos < length && isLess(source[biggest], source[rightPos])){
                biggest = rightPos;
            }
        } else {
            if (leftPos < length && !isLess(source[biggest], source[leftPos])){
                biggest = leftPos;
            }
            if (rightPos < length && !isLess(source[biggest], source[rightPos])){
                biggest = rightPos;
            }
        }
        if (biggest != basis){
            swap(source, biggest, basis);
            heapify(source, length, biggest, isAscSorting);
        }
    }

    private boolean isLess(Comparable first, Comparable second){
        return first.compareTo(second) < 0;
    }

    private void swap(Comparable[] Array, int firstPos, int secondPos){
        Comparable temp = Array[firstPos];
        Array[firstPos] = Array[secondPos];
        Array[secondPos] = temp;
    }
}
