package heap;

public class HeapSort {

    public static String[] sort(String[] Array) {
        if(Array.length > 0){
            for (int index = (Array.length / 2) - 1; index >= 0; index--){
                heapify(Array, Array.length, index);
            }
            for (int index = Array.length - 1; index >= 0; index--){
                swap(Array, index, 0);
                heapify(Array, index, 0);
            }
            return Array;
        } else {
            return Array;
        }
    }


    private static void heapify(String []Array, int size, int basis){
        int biggest = basis;
        int leftPos = 2 * basis + 1;
        int rightPos = 2 * basis + 2;
        if (leftPos < size && less(Array[biggest], Array[leftPos])){
            biggest = leftPos;
        }
        if (rightPos < size && less(Array[biggest], Array[rightPos])){
            biggest = rightPos;
        }
        if (biggest != basis){
            swap(Array, biggest, basis);
            heapify(Array, size, biggest);
        }
    }

    private static void swap(String[] Array, int fPos, int sPos){
        String temp = Array[fPos];
        Array[fPos] = Array[sPos];
        Array[sPos] = temp;
    }

    private static boolean less(String first, String second){
        return first.compareTo(second) < 0;
    }
}
