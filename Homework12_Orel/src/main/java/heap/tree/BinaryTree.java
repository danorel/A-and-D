package heap.tree;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryTree<E> implements BinaryTreeManager<E> {
    private Object[] array;

    public BinaryTree() {
        this(1);
    }

    public BinaryTree(final int size) {
        this(null, size);
    }

    public BinaryTree(final E data, final int size) {
        if (size <= 0) {
            throw new NullPointerException("Failed to initialize the array! The input size equals or less than zero.");
        }
        this.array = new Object[size];
        this.array[0] = data;
    }

    @Override
    public void add(final E data) {
        if (data == null) {
            throw new NullPointerException("Error! Trying to add the null element to the binary tree.");
        }
        if (contains(data)) {
            throw new IllegalArgumentException("Error! Such an element with a data presents in the binary tree!");
        } else {
            if (this.array[0] == null) {
                this.array[0] = data;
            } else {
                E[] temp_array = (E[]) Arrays.copyOf(this.array, this.array.length + 1);
                this.array = new Object[this.array.length + 1];
                this.array = Arrays.copyOf(temp_array, temp_array.length);
                this.array[this.array.length - 1] = data;
            }
        }
    }

    @Override
    public boolean contains(final E data) {
        if (data == null) {
            throw new NullPointerException("Error! Trying to find the null data in the binary tree!");
        }
        if (this.array.length > 0) {
            if (this.array[0] == data) {
                return true;
            } else {
                return containsRecursive(1, data);
            }
        } else {
            return false;
        }
    }

    private boolean containsRecursive(final int index, final E data) {
        if (index < this.array.length) {
            if (this.array[index] == data) {
                return true;
            } else {
                if (2 * index - 1 < this.array.length) {
                    return containsRecursive(2 * index, data);
                }
                if (2 * index < this.array.length) {
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
                if(2*index + 1 < this.array.length){
                    array[index] = array[2*index + 1];
                }
                if(2*index + 2 < this.array.length){
                    array[index * 2 + 1] = array[2*index + 2];
                }
                int counter = 0;
                while (index * 2 + 2 + counter + 1 < this.array.length) {
                    this.array[index * 2 + 2 + counter] = this.array[index * 2 + 2 + counter + 1];
                    counter++;
                }
                array = cut((E[]) this.array);
            }
        }
    }


    private E[] cut(final E[] array) {
        E[] arr;
        arr = (E[]) new Object[this.array.length - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array[i];
        }
        return arr;
    }

    @Override
    public boolean isEmpty() {
        return this.array[0] == null;
    }

    public int indexOf(E data) {
        if (!contains(data)) {
            return -1;
        } else {
            if (this.array[0] == data) {
                return 0;
            } else {
                return indexOfRecursive(1, data);
            }
        }
    }

    private int indexOfRecursive(int index, E data) {
        if (index < this.array.length) {
            if (this.array[index] == data) {
                return index;
            } else {
                if (2 * index - 1 < this.array.length) {
                    return indexOfRecursive(2 * index, data);
                }
                if (2 * index < this.array.length) {
                    return indexOfRecursive(2 * index + 1, data);
                }
            }
        }
        return -1;
    }

    public void asArray(E[] array) {
        this.array = new Object[array.length];
        if (array.length > 0) {
            this.array[0] = array[0];
            asArrayRecursive(array, 1);
        } else {
            throw new NullPointerException("Failed to initialize the array! The input size equals or less than zero.");
        }
    }

    private void asArrayRecursive(E[] array, int index) {
        if (2 * index - 1 < array.length) {
            this.array[2 * index - 1] = array[2 * index - 1];
            asArrayRecursive(array, 2 * index);
        }
        if (2 * index < array.length) {
            this.array[2 * index] = array[2 * index];
            asArrayRecursive(array, 2 * index + 1);
        }
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public String toString() {
        return visualise(1, 1, new StringBuilder());
    }

    private String visualise(int index, int level, StringBuilder visualisation) {
        if (index - 1 < this.array.length) {
            visualisation
                    .append(
                            visualiseBorder(level)
                    )
                    .append(
                            "("
                    )
                    .append(
                            this.array[index - 1]
                    )
                    .append(
                            ")"
                    )
                    .append(
                            "\n"
                    );
            if (2 * index - 1 < this.array.length) {
                visualise(2 * index, level + 1, visualisation);
            }
            if (2 * index < this.array.length) {
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
