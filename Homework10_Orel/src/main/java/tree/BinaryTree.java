package tree;

import tree.exceptions.BTInitException;
import tree.exceptions.BTNullPointerException;

import java.util.Arrays;

public class BinaryTree<E>{
    private Object []array;

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
        this.array = new Object[size];
        this.array[0] = data;
    }

    public void add(E data) throws BTInitException, BTNullPointerException {
        if(data == null){
            throw new BTNullPointerException();
        }
        E []temp_array = (E[]) Arrays.copyOf(this.array, this.array.length + 1);
        temp_array[temp_array.length - 1] = data;
        asArray(temp_array);
    }

    public E poll() throws BTInitException {
        E value = (E) this.array[this.array.length - 1];
        E []temp_array = (E[]) Arrays.copyOf(this.array, this.array.length - 1);
        asArray(temp_array);
        return value;
    }

    public int size(){
        return this.array.length;
    }

    public void asArray(E []array) throws BTInitException {
        this.array = new Object[array.length];
        if(array.length > 0){
            this.array[0] = array[0];
            asArrayRecursive(array, 1);
        } else {
            throw new BTInitException();
        }
    }

    private void asArrayRecursive(E []array, int index){
        if(2*index - 1 < array.length){
            this.array[2*index - 1] = array[2*index - 1];
            asArrayRecursive(array, 2*index);
        }
        if(2*index < array.length){
            this.array[2*index] = array[2*index];
            asArrayRecursive(array, 2*index + 1);
        }
    }

    @Override
    public String toString() {
        return visualise(1, 1, new StringBuilder());
    }

    private String visualise(int index, int level, StringBuilder visualisation){
        if(index - 1 < this.array.length){
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
            if(2*index - 1 < this.array.length){
                visualise(2*index, level + 1, visualisation);
            }
            if(2*index < this.array.length){
                visualise(2*index + 1, level + 1, visualisation);
            }
        }
        return visualisation.toString();
    }

    private String visualiseBorder(int level){
        StringBuilder border = new StringBuilder();
        for(int iteration = 0; iteration < level; iteration++){
            border.append("-");
        }
        return border.toString();
    }
}
