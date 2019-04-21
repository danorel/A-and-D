package heap;

interface BinaryHeapManager<T extends Comparable<T>>{
    boolean isEmpty();
    int size();
    boolean contains(T data);
    void add(T data);
    T peak();
    T remove(T data);
    void buildAsMinHeap();
    void buildAsMaxHeap();
}
