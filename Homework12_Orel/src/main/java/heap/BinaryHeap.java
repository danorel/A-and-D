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

    private void buildAsMinHeap() {
        T[] source = tree.obtainAsArray();
        for(int layer = source.length / 2; layer >= 0; layer--){
            heapifyMin(source, layer, source.length);
        }
        tree.asArray(source);
    }

    private void heapifyMin(T []source, int layer, int length){
        int parent, left, right;
        while (layer < length){
            parent = layer;
            left = 2*layer + 1;
            right = 2*layer + 2;

            if(left < length && source[left].compareTo(source[parent]) < 0){
                parent = left;
            }

            if(right < length && source[right].compareTo(source[parent]) < 0){
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

    private void buildAsMaxHeap() {
        T[] source = tree.obtainAsArray();
        for(int layer = source.length / 2; layer >= 0; layer--){
            heapifyMax(source, layer, source.length);
        }
        tree.asArray(source);
    }

    private void heapifyMax(T []source, int layer, int length){
        int parent, left, right;
        while (layer < length){
            parent = layer;
            left = 2*layer + 1;
            right = 2*layer + 2;

            if(left < length && source[left].compareTo(source[parent]) > 0){
                parent = left;
            }

            if(right < length && source[right].compareTo(source[parent]) > 0){
                parent = right;
            }

            if(parent == layer){
                return ;
            }

            swap(source, layer, parent);

            layer = parent;
        }
    }

    @Override
    public T peak() {
        if(asMinHeap){
            return tree.minimum();
        } else {
            return tree.minimum();
        }
    }

    @Override
    public T remove() {
        if(isEmpty()){
            throw new NoSuchElementException("Error! Cannot remove the element with such data. The heap is empty!");
        } else {
            T root = tree.obtainAsArray()[0];
            tree.delete(root);
            return root;
        }
    }

    @Override
    public String toString() {
        return tree.toString();
    }
}
