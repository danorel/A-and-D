package heap;

import heap.exceptions.BTInitException;

public class Heap<T extends Comparable<T>> implements HeapManager<T>{

    private BinaryTree<T> tree  = null;
    private boolean isMinHeap   = true;

    public Heap(boolean isMinHeap){
        try {
            tree = new BinaryTree<>();
        } catch (BTInitException exception) {
            exception.printStackTrace();
        }
        this.isMinHeap = isMinHeap;
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
        if(isMinHeap){

        } else {

        }
    }

    private void MaxHeapify(int position){

    }

    private void MinHeapify(int position){
        int largest = position;
        int left    = 2*position - 1;
        int right   = 2*position;
        if(this.tree.)
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
