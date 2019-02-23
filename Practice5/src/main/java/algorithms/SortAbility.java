package algorithms;
/*
    Basic sort functionality:
    sort method is a basic method for such algorithms:
    - Bubble Sort
    - Comb Sort
    - Heap Sort
    - Insertion Sort
    - Selection Sort
    - Shell Sort
*/
public interface SortAbility<T extends Comparable>{
    T[] sort(T[] Array);
}
