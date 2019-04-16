package heap;

public interface HeapManager<T>{
    boolean isEmpty();
    int size();
    boolean contains(T data);
    void add(T data);
    T peek();
    T remove();
}
