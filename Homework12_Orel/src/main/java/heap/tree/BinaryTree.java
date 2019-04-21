package heap.tree;

import java.util.*;

public class BinaryTree<E extends Comparable> implements BinaryTreeManager<E> {
    private Comparable[] source;

    public BinaryTree() {
        this(1);
    }

    public BinaryTree(final int size) {
        this(null, size);
    }

    public BinaryTree(final E data, final int size) {
        if (size <= 0) {
            throw new NullPointerException("Failed to initialize the binary tree! The size of the source equals or less than zero.");
        }
        this.source = new Comparable[size];
        this.source[0] = data;
    }

    @Override
    public void add(final E data) {
        if (data == null) {
            throw new NullPointerException("Error! Trying to add the null element to the binary tree.");
        }
        if (contains(data)) {
            throw new IllegalArgumentException("Error! Such an element with a data presents in the binary tree!");
        } else {
            if (this.source[0] == null) {
                this.source[0] = data;
            } else {
                E[] temp_array = (E[]) Arrays.copyOf(this.source, this.source.length + 1);
                this.source = new Comparable[this.source.length + 1];
                this.source = Arrays.copyOf(temp_array, temp_array.length);
                this.source[this.source.length - 1] = data;
            }
        }
    }

    @Override
    public boolean contains(final E data) {
        if (data == null) {
            throw new NullPointerException("Error! Trying to find the null data in the binary tree!");
        }
        if (this.source.length > 0) {
            if (this.source[0] == data) {
                return true;
            } else {
                return containsRecursive(1, data);
            }
        } else {
            return false;
        }
    }

    private boolean containsRecursive(final int index, final E data) {
        if (index < this.source.length) {
            if (this.source[index] == data) {
                return true;
            } else {
                if (2 * index - 1 < this.source.length) {
                    return containsRecursive(2 * index, data);
                }
                if (2 * index < this.source.length) {
                    return containsRecursive(2 * index + 1, data);
                }
            }
        }
        return false;
    }

    @Override
    public void delete(final E data) {
        if (data == null) {
            throw new NullPointerException("Error! Trying to delete the null element!");
        }
        if (!isEmpty()) {
            int index = indexOf(data);
            if(index == -1){
                throw new NoSuchElementException("Error! The element with data " + data.toString() + " is absent in the binary tree.");
            } else {
                if(2*index + 1 < this.source.length){
                    source[index] = source[2*index + 1];
                }
                if(2*index + 2 < this.source.length){
                    source[index * 2 + 1] = source[2*index + 2];
                }
                int counter = 0;
                while (index * 2 + 2 + counter + 1 < this.source.length) {
                    this.source[index * 2 + 2 + counter] = this.source[index * 2 + 2 + counter + 1];
                    counter++;
                }
                source = cut((E[]) this.source);
            }
        }
    }


    private E[] cut(final E[] array) {
        E[] arr;
        arr = (E[]) new Comparable[this.source.length - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array[i];
        }
        return arr;
    }

    @Override
    public boolean isEmpty() {
        return this.source[0] == null;
    }

    public int indexOf(E data) {
        if (!contains(data)) {
            return -1;
        } else {
            if (this.source[0] == data) {
                return 0;
            } else {
                return indexOfRecursive(1, data);
            }
        }
    }

    private int indexOfRecursive(int index, E data) {
        if (index < this.source.length) {
            if (this.source[index] == data) {
                return index;
            } else {
                if (2 * index - 1 < this.source.length) {
                    return indexOfRecursive(2 * index, data);
                }
                if (2 * index < this.source.length) {
                    return indexOfRecursive(2 * index + 1, data);
                }
            }
        }
        return -1;
    }

    public void asArray(E[] source) {
        this.source = new Comparable[source.length];
        if (source.length > 0) {
            this.source[0] = source[0];
            asArrayRecursive(source, 1);
        } else {
            throw new NullPointerException("Failed to initialize the binary tree! The the source size equals or less than zero.");
        }
    }

    private void asArrayRecursive(E[] source, int index) {
        if (2 * index - 1 < source.length) {
            this.source[2 * index - 1] = source[2 * index - 1];
            asArrayRecursive(source, 2 * index);
        }
        if (2 * index < source.length) {
            this.source[2 * index] = source[2 * index];
            asArrayRecursive(source, 2 * index + 1);
        }
    }

    @Override
    public int size() {
        return source.length;
    }

    @Override
    public E minimum() {
        if(!isEmpty()){
            return obtainAsList()
                    .stream()
                    .max((first, second) -> 0)
                    .get();
        } else {
            throw new NoSuchElementException("Error! There is no elements in the binary tree!");
        }
    }

    @Override
    public E maximum() {
        if(!isEmpty()){
            return obtainAsList()
                    .stream()
                    .max((second, first) -> 0)
                    .get();
        } else {
            throw new NoSuchElementException("Error! There is no elements in the binary tree!");
        }
    }

    @Override
    public List<E> obtainAsList() {
        if(isEmpty()){
            return new ArrayList<>();
        } else {
            ArrayList<E> list = new ArrayList<>();
            list.add((E) this.source[0]);
            obtainAsListRecursive(1, list);
            return list;
        }
    }

    @Override
    public E[] obtainAsArray() {
        return (E[]) this.source;
    }

    private void obtainAsListRecursive(int index, ArrayList<E> list){
        if(index < this.source.length){
            list.add((E) this.source[index]);
            if(2*index - 1 < this.source.length){
                obtainAsListRecursive(2*index, list);
            }
            if(2*index < this.source.length){
                obtainAsListRecursive(2*index + 1, list);
            }
        }
    }


    @Override
    public String toString() {
        return visualise(1, 1, new StringBuilder());
    }

    private String visualise(int index, int level, StringBuilder visualisation) {
        if (index - 1 < this.source.length) {
            visualisation
                    .append(
                            visualiseBorder(level)
                    )
                    .append(
                            "("
                    )
                    .append(
                            this.source[index - 1]
                    )
                    .append(
                            ")"
                    )
                    .append(
                            "\n"
                    );
            if (2 * index - 1 < this.source.length) {
                visualise(2 * index, level + 1, visualisation);
            }
            if (2 * index < this.source.length) {
                visualise(2 * index + 1, level + 1, visualisation);
            }
        }
        return visualisation.toString();
    }

    private String visualiseBorder(int level) {
        StringBuilder border = new StringBuilder();
        for (int iteration = 0; iteration < level; iteration++) {
            border.append("-");
        }
        return border.toString();
    }
}
