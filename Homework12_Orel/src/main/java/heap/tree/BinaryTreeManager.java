package heap.tree;

import java.util.List;

public interface BinaryTreeManager<E>{
    boolean contains(final E data);
    void add(final E data);
    void delete(final E data);
    boolean isEmpty();
    int size();
    List<E> obtainAsList();
    E [] obtainAsArray();
}
