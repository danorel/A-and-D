package heap;

interface BinaryHeapManager<T extends Comparable>{
    boolean isEmpty();
    int size();
    void add(T data);
    T peek();
    boolean contains(T data);
    T remove();
}
