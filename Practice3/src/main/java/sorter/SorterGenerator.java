package sorter;

public interface SorterGenerator<T extends Comparable> {
    SorterGenerator quickSort(int leftPosition, int rightPosition);
    SorterGenerator mergeSort(int leftPosition, int rightPosition);
    SorterGenerator heapSort();
}
