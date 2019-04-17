package heap;

import heap.exceptions.BTInitException;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryTree<E extends Comparable<E>>{
    private Comparable [] source;

    public BinaryTree() throws BTInitException {
        this(1);
    }

    public BinaryTree(int size) throws BTInitException {
        this(null, size);
    }

    public BinaryTree(E data, int size) throws BTInitException {
        if(size <= 0){
            throw new BTInitException();
        }
        this.source = new Comparable[size];
        this.source[0] = data;
    }

    public void add(E data) {
        if(data == null){
            throw new NullPointerException(
                    "Error! Trying to add the null element to the binary tree."
            );
        }
        if(this.source[0] == null){
            this.source[0] = data;
        } else {
            addRecursive(data, 1);
        }
    }

    private void addRecursive(E data, int index){
        if(index < source.length){
            if(data.compareTo((E) this.source[index]) < 0){
                if(2*index - 1 >= this.source.length){
                    source = Arrays.copyOf(source, 2*index);
                    source[2*index - 1] = data;
                } else {
                    addRecursive(data, 2 * index);
                }
            }
            if(data.compareTo((E) this.source[index]) > 0){
                if(2*index >= this.source.length){
                    source = Arrays.copyOf(source, 2*index + 1);
                    source[2*index] = data;
                } else {
                    addRecursive(data, 2 * index + 1);
                }
            }
        }
    }

    public int size(){
        return source.length;
    }

    public boolean isEmpty(){
        return source.length == 0;
    }

    public int positionOf(E data){
        for(int index = 0; index < source.length; index++){
            if(source[index].equals(data)){
                return index;
            }
        }
        return -1;
    }

    public boolean contains(E data){
        return positionOf(data) != -1;
    }

    public void replace(E data, E source) throws InvalidAlgorithmParameterException {
        if(contains(data)){
            int position = positionOf(data);
            if(this.source[position/2].compareTo(source) < 0){
                throw new InvalidAlgorithmParameterException(
                        "Error! Cannot add the element to the binary tree due to the ancestor data would be lesser than the child one!"
                );
            } else if(2*position < size() && this.source[2*position].compareTo(source) > 0){
                throw new InvalidAlgorithmParameterException(
                        "Error! Cannot add the element to the binary tree due to the left child data would be greater than the ancestor one!"
                );
            } else if(2*position + 1 < size() && this.source[2*position + 1].compareTo(source) > 0) {
                throw new InvalidAlgorithmParameterException(
                        "Error! Cannot add the element to the binary tree due to the right child data would be greater than the ancestor one!"
                );
            } else {
                this.source[position] = source;
            }
        } else {
            throw new NoSuchElementException(
                    "Error! Cannot implement the function due to the input element with value " + data.toString() + " doesn't exist in the binary tree!"
            );
        }
    }

    /*
        private void swap(int first, int second){
            Comparable temp = source[first];
            source[first] = source[second];
            source[second] = temp;
        }
    */

    public void createInAscOrder(E []source) throws BTInitException {
        /*
            Sorting the input source in the ascending order
         */
        HeapSort algorithm = new HeapSort();
        algorithm.sortAsc(source);
        this.source = new Comparable[source.length];
        if(source.length > 0){
            this.source[0] = source[0];
            createRecursive(source, 1);
        } else {
            throw new BTInitException();
        }
    }

    public void createInDescOrder(E []source) throws BTInitException {
        /*
            Sorting the input source in the descending order
         */
        HeapSort algorithm = new HeapSort();
        algorithm.sortDesc(source);
        this.source = new Comparable[source.length];
        if(source.length > 0){
            this.source[0] = source[0];
            createRecursive(source, 1);
        } else {
            throw new BTInitException();
        }
    }

    private void createRecursive(E []array, int index){
        if(2*index - 1 < array.length){
            this.source[2*index - 1] = array[2*index - 1];
            createRecursive(array, 2*index);
        }
        if(2*index < array.length){
            this.source[2*index] = array[2*index];
            createRecursive(array, 2*index + 1);
        }
    }

    @Override
    public String toString() {
        return visualise(1, 1, new StringBuilder());
    }

    private String visualise(int index, int level, StringBuilder visualisation){
        if(index - 1 < this.source.length){
            visualisation
                    .append(visualiseAdds('♡', level))
                    .append("[")
                    .append(this.source[index - 1])
                    .append("]")
                    .append("\n");
            if(2*index - 1 < this.source.length){
                visualise(2*index, level + 1, visualisation);
            }
            if(2*index < this.source.length){
                visualise(2*index + 1, level + 1, visualisation);
            }
        }
        return visualisation.toString();
    }

    private String visualiseAdds(char symbol, int layer){
        StringBuilder border = new StringBuilder();
        for(int iteration = 0; iteration < layer; iteration++){
            border.append(symbol);
        }
        return border.toString();
    }
}
