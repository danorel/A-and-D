package heap;

import heap.bt.BinaryTree;
import heap.bt.exceptions.BTDuplicateException;

public class BinaryHeap<T extends Comparable>{

    private BinaryTree<T> binaryTree;
    private boolean isMinHeap;

    public BinaryHeap(){
        this(false);
    }

    public BinaryHeap(boolean isMinHeap){
        binaryTree = new BinaryTree<>();
        this.isMinHeap = isMinHeap;
    }

    private void generateAsMinHeap() {
        T[] source = binaryTree.getArray();
        for(int layer = source.length / 2; layer >= 0; layer--){
            heapifyMin(source, layer, source.length);
        }
        try {
            binaryTree.asArray(source);
        } catch (BTDuplicateException exception) {
            exception.printStackTrace();
        }
    }

    private void heapifyMin(T []array, int level, int size){
        int ancestor, leftChild, rightChild;
        while (level < size){
            ancestor = level;
            leftChild = 2*level + 1;
            rightChild = 2*level + 2;

            if(leftChild < size && array[leftChild].compareTo(array[ancestor]) < 0){
                ancestor = leftChild;
            }

            if(rightChild < size && array[rightChild].compareTo(array[ancestor]) < 0){
                ancestor = rightChild;
            }

            if(ancestor == level){
                return ;
            }

            swap(array, level, ancestor);
            level = ancestor;
        }
    }

    private void swap(T[] array, int firstPos, int secondPos){
        T temp = array[firstPos];
        array[firstPos] = array[secondPos];
        array[secondPos] = temp;
    }

    private void generateAsMaxHeap() {
        T[] source = binaryTree.getArray();
        for(int layer = source.length / 2; layer >= 0; layer--){
            heapifyMax(source, layer, source.length);
        }
        try {
            binaryTree.asArray(source);
        } catch (BTDuplicateException exception) {
            exception.printStackTrace();
        }
    }

    private void heapifyMax(T []array, int level, int size){
        int ancestor, leftChild, rightChild;
        while (level < size){
            ancestor = level;
            leftChild = 2*level + 1;
            rightChild = 2*level + 2;

            if(leftChild < size && array[leftChild].compareTo(array[ancestor]) > 0){
                ancestor = leftChild;
            }

            if(rightChild < size && array[rightChild].compareTo(array[ancestor]) > 0){
                ancestor = rightChild;
            }

            if(ancestor == level){
                return ;
            }

            swap(array, level, ancestor);

            level = ancestor;
        }
    }

    public boolean isEmpty() {
        return binaryTree.isEmpty();
    }

    public int size() {
        return binaryTree.size();
    }

    public void add(T element) {
        try {
            binaryTree.add(element);
        } catch (BTDuplicateException exception) {
            exception.printStackTrace();
        }
    }

    public void generate(){
        if(isMinHeap){
            generateAsMinHeap();
        } else {
            generateAsMaxHeap();
        }
    }

    public T peek() {
        if(binaryTree.isEmpty()){
            return null;
        } else {
            return binaryTree.getDataInAscOrder().get(0);
        }
    }

    public boolean contains(T element) {
        return binaryTree.contains(element);
    }

    public T remove() {
        if(isEmpty()){
            return null;
        } else {
            return binaryTree.remove(binaryTree.getArray()[0]);
        }
    }

    @Override
    public String toString() {
        return binaryTree.toString();
    }
}
