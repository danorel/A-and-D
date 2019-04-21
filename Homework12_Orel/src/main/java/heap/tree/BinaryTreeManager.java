package heap.tree;

import java.util.List;

public interface BinaryTreeManager<E>{
    boolean contains(final E data);
    void add(final E data);
    void delete(final E data);
    boolean isEmpty();
    int size();
    E minimum();
    E maximum();
    List<E> obtainAsList();
    E [] obtainAsArray();
}
