package heap;

import heap.tree.BinaryTree;

import java.util.NoSuchElementException;

public class BinaryHeap<T extends Comparable<T>> implements BinaryHeapManager<T> {
    private BinaryTree<T> tree;

    public BinaryHeap(){
        tree = new BinaryTree<>();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean contains(T data) {
        return tree.contains(data);
    }

    @Override
    public void add(T data) {
        tree.add(data);
    }

    @Override
    public T peak() {

        return ;
    }

    @Override
    public T remove(T data) {
        if(isEmpty()){
            throw new NoSuchElementException("Error! Cannot remove the element with such data. The heap is empty!");
        } else {
            tree.delete(data);
            return tree.obtainAsArray()[tree.indexOf(data)];
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
