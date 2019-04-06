package tree;

import tree.exceptions.BTInitException;
import tree.exceptions.BTIllegalArgumentException;
import tree.exceptions.BTNoSuchElementException;
import tree.exceptions.BTNullPointerException;

public class BinaryTree<T> implements Cloneable {

    private StringBuilder tree      = new StringBuilder();
    private Leaf ROOT               = null;
    private int size                = 0;
    private int hashcode            = 0;

    public BinaryTree(T value) throws BTNullPointerException {
        if(value == null){
            throw new BTNullPointerException();
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

    public boolean search(T value) throws BTNullPointerException {
        boolean isFound = false;
        return search(ROOT, value, isFound);
    }

    private boolean search(Leaf leaf, T value, boolean isFound) throws BTNullPointerException {
        if(leaf != null){
            if(leaf.value.equals(value)){
                return true;
            }
            if(leaf.left != null) {
                isFound = search(leaf.left, value, isFound);
            }
            if(leaf.right != null) {
                isFound = search(leaf.right, value, isFound);
            }
        }
        return isFound;
    }

    public boolean delete(T value) throws BTNullPointerException, BTNoSuchElementException {
        boolean isDeleted = false;
        isDeleted = delete(ROOT.left, ROOT, value, isDeleted);
        isDeleted = delete(ROOT.right, ROOT, value, isDeleted);
        if(isDeleted){
            return isDeleted;
        } else {
            throw new BTNoSuchElementException(value);
        }
    }

    private boolean delete(Leaf leaf, Leaf ancestor, T value, boolean isDeleted) throws BTNullPointerException {
        if(leaf != null){
            if(leaf.value.equals(value)){
                if(leaf.value == null){
                    throw new BTNullPointerException();
                } else {
                    if(leaf.right != null && leaf.left != null){
                        Leaf right_temp = leaf.right;
                        leaf.value = null;
                        leaf.right = null;
                        leaf = leaf.left;
                        Leaf move = leaf;
                        while(move.left != null){
                            move = move.left;
                        }
                        move = right_temp;
                        if(ancestor.left == leaf){
                            ancestor.left.value = null;
                            ancestor.left = null;
                        } else if(ancestor.right == leaf){
                            ancestor.right.value = null;
                            ancestor.right = null;
                        }
                    } else if(leaf.right == null && leaf.left != null){
                        leaf = leaf.left;
                        if(ancestor.left == leaf){
                            ancestor.left.value = null;
                            ancestor.left = leaf;
                        } else if(ancestor.right == leaf){
                            ancestor.right.value = null;
                            ancestor.left = leaf;
                        }
                    } else if (leaf.right != null){
                        leaf = leaf.right;
                        if(ancestor.left == leaf){
                            ancestor.left.value = null;
                            ancestor.left = leaf;
                        } else if(ancestor.right == leaf){
                            ancestor.right.value = null;
                            ancestor.left = leaf;
                        }
                    } else {
                        if(ancestor.left == leaf){
                            ancestor.left.value = null;
                            leaf = null;
                            ancestor.left = null;
                        } else if(ancestor.right == leaf){
                            ancestor.right.value = null;
                            leaf = null;
                            ancestor.left = null;
                        }
                    }
                    return true;
                }
            }
            if(leaf.left != null) {
                isDeleted = delete(leaf.left, leaf, value, isDeleted);
            }
            if(leaf.right != null) {
                isDeleted = delete(leaf.right, leaf, value, isDeleted);
            }
        }
        return isDeleted;
    }

    public boolean addTo(T value, T element) throws BTNoSuchElementException, BTIllegalArgumentException {
        if(!addTo(ROOT, value, element, false)){
            throw new BTNoSuchElementException(value);
        } else {
            return true;
        }
    }

    private boolean addTo(Leaf leaf, T value, T element, boolean isAdded) throws BTIllegalArgumentException {
        if(leaf != null){
            if(leaf.value.equals(value)){
                if(leaf.left == null){
                    leaf.left = new Leaf(element);
                    isAdded = true;
                }
                if(leaf.right == null && !isAdded){
                    leaf.right = new Leaf(element);
                    isAdded = true;
                }
                if(!isAdded){
                    throw new BTIllegalArgumentException();
                }
                return true;
            }
            if(leaf.left != null){
                isAdded = addTo(leaf.left, value, element, isAdded);
            }
            if(leaf.right != null){
                isAdded = addTo(leaf.right, value, element, isAdded);
            }
        }
        return isAdded;
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

    public T[] asArray(Leaf leaf) throws BTNullPointerException {
        size = 0;
        int size = getLeafAmount(leaf);
        Object []array = new Object[size];
        if(array.length > 1){
            array[0] = leaf.value;
        } else {
            throw new BTNullPointerException();
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