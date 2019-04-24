package heap;

import heap.bt.BinaryTree;
import heap.bt.exceptions.BTDuplicateException;

public class BinaryHeap<T extends Comparable> implements BinaryHeapManager<T> {

    private BinaryTree<T> tree;
    private boolean isMinHeap;

    public BinaryHeap(){
        this(false);
    }

    public BinaryHeap(boolean isMinHeap){
        tree = new BinaryTree<>();
        this.isMinHeap = isMinHeap;
    }

    private void buildAsMinHeap() {
        T[] source = tree.obtainAsArray();
        for(int layer = source.length / 2; layer >= 0; layer--){
            heapifyMin(source, layer, source.length);
        }
        try {
            tree.asArray(source);
        } catch (BTDuplicateException exception) {
            exception.printStackTrace();
        }
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
        try {
            tree.asArray(source);
        } catch (BTDuplicateException exception) {
            exception.printStackTrace();
        }
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
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public void add(T data) {
        try {
            tree.add(data);
        } catch (BTDuplicateException exception) {
            exception.printStackTrace();
        }
    }

    public void build(){
        if(isMinHeap){
            buildAsMinHeap();
        } else {
            buildAsMaxHeap();
        }
    }

    @Override
    public T peek() {
        if(tree.isEmpty()){
            return null;
        } else {
            return tree.getDataInAscOrder().get(0);
        }
    }

    @Override
    public boolean contains(T data) {
        return tree.contains(data);
    }

    @Override
    public T remove() {
        if(isEmpty()){
            return null;
        } else {
            return tree.remove(tree.obtainAsArray()[0]);
        }
    }

    @Override
    public String toString() {
        return visualize(tree.obtainAsArray(), 0, 1, new StringBuilder());
    }

    private String visualize(T []source, int index, int level, StringBuilder content){
        if(index < source.length){
            content
                    .append(countLevels(level))
                    .append("(")
                    .append(source[index])
                    .append(")")
                    .append("\n");
            if(2*index < source.length) {
                visualize(source, 2 * index + 1, level + 1, content);
            }
            if(2*index + 1 < source.length){
                    visualize(source, 2*index + 2, level + 1, content);
            }
        }
        return content.toString();
    }

    private String countLevels(int level){
        StringBuilder content = new StringBuilder();
        for(int index = 0; index < level; index++){
            content.append("-");
        }
        return content.toString();
    }
}
