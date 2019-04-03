package tree;

import tree.exceptions.BTInitException;
import tree.exceptions.NullPointerException;

import java.util.NoSuchElementException;

public class BinaryTree<T> implements Cloneable {

    private StringBuilder tree      = new StringBuilder();
    private Leaf ROOT               = null;
    private int size                = 0;
    private int hashcode            = 0;

    public BinaryTree(T value) throws NullPointerException {
        if(value == null){
            throw new NullPointerException();
        } else {
            ROOT = new Leaf(value);
        }
    }

    public BinaryTree(T []array) throws BTInitException {
        if(array.length == 0){
            throw new BTInitException();
        } else {
            asBT(array);
        }
    }

    public void asBT(T []array){
        if(array.length > 0){
            ROOT = new Leaf(array[0]);
            buildBT(ROOT, 1, array);
        }
    }

    private void buildBT(Leaf leaf, int index, T []array){
        if(leaf != null){
            if(2*index - 1 < array.length) {
                leaf.left = new Leaf(array[2*index - 1]);
                buildBT(leaf.left, 2 * index, array);
            }
            if(2*index < array.length) {
                leaf.right = new Leaf(array[2*index]);
                buildBT(leaf.right, 2 * index + 1, array);
            }
        }
    }

    public boolean search(T value) throws NullPointerException {
        return search(ROOT, value);
    }

    private boolean search(Leaf leaf, T value) throws NullPointerException {
        if(leaf != null){
            if(leaf.value.equals(value)){
                return true;
            }
            if(leaf.left != null) {
                search(leaf.left, value);
            }
            if(leaf.right != null) {
                search(leaf.right, value);
            }
        }
        return false;
    }

    public boolean delete(T value) throws NullPointerException {
        return delete(ROOT, value);
    }

    public boolean delete(Leaf leaf, T value) throws NullPointerException {
        if(leaf != null){
            if(leaf.value.equals(value)){
                if(leaf.value == null){
                    throw new NullPointerException();
                } else {
                    if(leaf.right != null && leaf.left != null){
                        Leaf left_temp = leaf.left;
                        Leaf right_temp = leaf.right;
                        leaf = left_temp;
                        Leaf temp = leaf;
                        while(temp.left != null){
                            temp = temp.left;
                        }
                        temp.left = right_temp;
                    } else if(leaf.right == null && leaf.left != null){
                        leaf = leaf.left;
                    } else if (leaf.right != null){
                        leaf = leaf.right;
                    } else {
                        leaf = null;
                    }
                    return true;
                }
            }
            if(leaf.left != null) {
                return delete(leaf.left, value);
            }
            if(leaf.right != null) {
                return delete(leaf.right, value);
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return ROOT == null;
    }

    public int getLeafAmount(){
        size = 0;
        return getLeafAmount(ROOT);
    }

    private int getLeafAmount(Leaf leaf){
        if(leaf != null){
            size++;
            if(leaf.left != null){
                getLeafAmount(leaf.left);
            }
            if(leaf.right != null){
                getLeafAmount(leaf.right);
            }
        }
        return size;
    }

    public T[] asArray(Leaf leaf) throws NullPointerException {
        size = 0;
        int size = getLeafAmount(leaf);
        Object []array = new Object[size];
        if(array.length > 1){
            array[0] = leaf.value;
        } else {
            throw new NullPointerException();
        }
        return asArray(leaf, 1, array);
    }

    private T[] asArray(Leaf leaf, int index, Object []array){
        if(leaf != null){
            if(2*index - 1 < array.length && leaf.left != null){
                array[2*index - 1] = leaf.left.value;
                asArray(leaf.left, 2*index, array);
            }
            if(2*index < array.length && leaf.right != null){
                array[2*index] = leaf.right.value;
                asArray(leaf.right, 2*index + 1, array);
            }
        }
        return (T[]) array;
    }

    public void showBT(){
        showBT(ROOT, 1);
    }

    private void showBT(Leaf leaf, int layer){
        if(leaf != null){
            for(int times = 0; times < layer; times++){
                System.out.print("-");
            }
            System.out.println("(" + leaf.value + ")");
            if(leaf.right != null || leaf.left != null){
                if(leaf.left != null){
                    showBT(leaf.left, layer + 1);
                }
                if(leaf.right != null){
                    showBT(leaf.right, layer + 1);
                }
            }
        }
    }

    @Override
    public int hashCode() {
        hashcode += tree.hashCode() + ROOT.hashCode();
        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof BinaryTree)){
            return false;
        }

        BinaryTree tree = (BinaryTree) obj;

        return (tree.tree.toString().equals(this.tree.toString())
                &&
               tree.ROOT == this.ROOT
                &&
               tree.size == this.size
                &&
               tree.hashCode() == this.hashCode()
        );
    }

    public BinaryTree<T> clone(BinaryTree tree) throws CloneNotSupportedException {
        return (BinaryTree<T>) tree.clone();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        tree = new StringBuilder();
        generateView(ROOT, 1);
        return tree.toString();
    }

    public Leaf getROOT() {
        return ROOT;
    }

    private void generateView(Leaf leaf, int layer){
        if(leaf != null){
            for(int times = 0; times < layer; times++){
                tree.append("-");
            }
            tree.append("(").append(leaf.value).append(")").append("\n");
            if(leaf.right != null || leaf.left != null){
                if(leaf.left != null){
                    generateView(leaf.left, layer + 1);
                }
                if(leaf.right != null){
                    generateView(leaf.right, layer + 1);
                }
            }
        }
    }

    private class Leaf {
        private T value     = null;
        private Leaf left   = null;
        private Leaf right  = null;

        public Leaf(T value){
            this.value = value;
        }
    }
}