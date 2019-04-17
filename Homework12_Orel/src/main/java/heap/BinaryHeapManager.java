package heap;

interface BinaryHeapManager<T extends Comparable<T>>{
    boolean isEmpty();
    int size();
    boolean contains();
    void add(T data);
    T peak();
    T remove();
}
