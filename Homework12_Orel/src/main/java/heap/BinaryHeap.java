package heap;

import heap.tree.BinaryTree;

import java.util.NoSuchElementException;

public class BinaryHeap<T extends Comparable<T>> implements BinaryHeapManager<T> {
    private BinaryTree<T> tree  = null;
    private boolean asMinHeap   = false;

    public BinaryHeap(){
        tree = new BinaryTree<>();
    }

    public BinaryHeap(boolean asMinHeap){
        tree = new BinaryTree<>();
        this.asMinHeap = asMinHeap;
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
        if(asMinHeap){
            buildAsMinHeap();
        } else {
            buildAsMaxHeap();
        }
    }

    @Override
    public void buildAsMinHeap() {
        T[] source = tree.obtainAsArray();
        for(int layer = source.length / 2 - 1; layer >= 0; layer--){
            heapifyMin(source, layer, source.length);
        }
        tree.asArray(source);
    }

    private void heapifyMin(T []source, int layer, int length){
        int parent, left, right;
        while (layer < length){
            parent = layer;
            left = 2*parent + 1;
            right = 2*parent + 2;

            if(left < length && source[left].compareTo(source[parent]) > 0){
                parent = left;
            }

            if(right < left && source[right].compareTo(source[parent]) > 0){
                parent = right;
            }

            if(parent == layer){
                return ;
            }

            swap(source, layer, parent);

            layer = parent;
        }
    }

    private void swap(T[] source, int first, int second){
        T temp = source[first];
        source[first] = source[second];
        source[second] = temp;
    }

    @Override
    public void buildAsMaxHeap() {
        T[] source = tree.obtainAsArray();
        for(int layer = source.length / 2; layer >= 0; layer++){
            heapifyMax(source, layer);
        }
        tree.asArray(source);
    }

    private void heapifyMax(T []source, int layer){

    }

    @Override
    public T peak() {
        if(asMinHeap){
            T minimum = tree.minimum();
            remove(minimum);
            return minimum;
        } else {
            T maximum = tree.maximum();
            remove(maximum);
            return maximum;
        }
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
        return tree.toString();
    }
}
