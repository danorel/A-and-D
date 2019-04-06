package tree;

import tree.exceptions.BTIllegalArgumentException;
import tree.exceptions.BTNoSuchElementException;
import tree.exceptions.BTNullPointerException;

public class BinaryTree<E extends Comparable> implements Cloneable {
    private Node ROOT;

    public BinaryTree() {
        ROOT = new Node(null);
    }

    public BinaryTree(E data) throws BTNullPointerException {
        if(data == null){
            throw new BTNullPointerException();
        } else {
            ROOT = new Node(data);
        }
    }

    public boolean add(E data, E to) throws BTNullPointerException, BTIllegalArgumentException, BTNoSuchElementException {
        if(data == null){
            throw new BTNullPointerException();
        }
        if(!addRecursive(ROOT, data, to, false)){
            throw new BTNoSuchElementException(to);
        } else {
            return true;
        }
    }

    private boolean addRecursive(Node node, E data, E to, boolean isAdded) throws BTIllegalArgumentException, BTNoSuchElementException {
        if(node != null){
            if(node.data.equals(to)){
                if(node.left != null && node.right != null){
                    throw new BTIllegalArgumentException();
                }
                if(data.compareTo(node.data) <= 0){
                    if(node.left != null){
                        throw new BTIllegalArgumentException();
                    } else {
                        node.left = new Node(data);
                    }
                } else {
                    if(node.right != null){
                        throw new BTIllegalArgumentException();
                    } else {
                        node.right = new Node(data);
                    }
                }
                isAdded = true;
            } else {
                if(node.left != null){
                    isAdded = addRecursive(node.left, data, to, isAdded);
                }
                if(node.right != null){
                    isAdded = addRecursive(node.right, data, to, isAdded);
                }
            }
        }
        return isAdded;
    }

    public boolean remove(E data) throws BTNullPointerException, BTNoSuchElementException {
        if(data == null){
            throw new BTNullPointerException();
        }
        if(ROOT != null && data.equals(ROOT.data)){
            return true;
        } else {
            boolean isRemoved;
            isRemoved = removeRecursive(ROOT.left, ROOT, data, false);
            if(!isRemoved)
                isRemoved = removeRecursive(ROOT.right, ROOT, data, false);
            if(!isRemoved){
                throw new BTNoSuchElementException(data);
            } else {
                return true;
            }
        }
    }

    private boolean removeRecursive(Node node, Node ancestor, E data, boolean isRemoved){
        if(node != null){
            if(data.equals(node.data)){
                node.data = null;
                if(node.left != null && node.right == null){
                    node = node.left;
                }
                if(node.left == null && node.right != null){
                    node = node.right;
                }
                if(node.left != null && node.right != null){
                    Node temp_right = node.right;
                    node = node.left;
                    Node temp = node;
                    while(temp.left != null){
                        temp = temp.left;
                    }
                    temp.left = temp_right;
                } else {
                    if(ancestor.left == node){
                        ancestor.left = null;
                    }
                    if(ancestor.right == node){
                        ancestor.right = null;
                    }
                }
                return true;
            }
            if(node.left != null){
                isRemoved = removeRecursive(node.left, node, data, isRemoved);
            }
            if(node.right != null){
                isRemoved = removeRecursive(node.right, node, data, isRemoved);
            }
        }
        return isRemoved;
    }

    public void removeAll(){
        if(!isEmpty()){
            removeAllRecursive(ROOT.left, ROOT);
            removeAllRecursive(ROOT.right, ROOT);
            ROOT.data = null;
            ROOT = null;
        }
    }

    private void removeAllRecursive(Node node, Node ancestor){
        if(node != null){
            if(node.left != null){
                removeAllRecursive(node.left, node);
            }
            if(node.right != null){
                removeAllRecursive(node.right, node);
            }
            node.data = null;
            if(node.left != null && node.right == null){
                node = node.left;
            }
            if(node.left == null && node.right != null){
                node = node.right;
            }
            if(node.left != null && node.right != null){
                Node temp_right = node.right;
                node = node.left;
                Node temp = node;
                while(temp.left != null){
                    temp = temp.left;
                }
                temp = temp_right;
            }
            if(node.left == null && node.right == null){
                if(ancestor.left == node){
                    ancestor.left = null;
                }
                if(ancestor.right == node){
                    ancestor.right = null;
                }
            }
        }
    }

    public boolean search(E data) throws BTNullPointerException {
        if(data == null){
            throw new BTNullPointerException();
        }
        return searchRecursive(ROOT, data, false);
    }

    private boolean searchRecursive(Node node, E data, boolean isFound){
        if(node != null){
            if(data.equals(node.data)){
                return true;
            }
            if(node.left != null){
                isFound = searchRecursive(node.left, data, isFound);
            }
            if(node.right != null){
                isFound = searchRecursive(node.right, data, isFound);
            }
        }
        return isFound;
    }

    public int getNodeAmount(){
        return getNodeAmountRecursive(ROOT, 0);
    }

    private int getNodeAmountRecursive(Node node, int amount){
        if(node != null){
            amount++;
            if(node.left != null){
                amount = getNodeAmountRecursive(node.left, amount);
            }
            if(node.right != null){
                amount = getNodeAmountRecursive(node.right, amount);
            }
        }
        return amount;
    }

    public boolean isEmpty(){
        return ROOT == null;
    }

    public BinaryTree<E> clone(BinaryTree<E> tree) throws CloneNotSupportedException {
        return (BinaryTree<E>) tree.clone();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return (
                this.ROOT.hashCode()
                );
    }

    @Override
    public String toString() {
        return visualise(ROOT, new StringBuilder(), 1);
    }

    private String visualise(Node node, StringBuilder output, int level){
        if(node != null){
            output
                    .append(
                        visualiseBorder(level)
                    )
                    .append(
                            "("
                    )
                    .append(
                            node.data.toString()
                    )
                    .append(
                            ")"
                    )
                    .append("\n");
            if(node.left != null){
                visualise(node.left, output, level + 1);
            }
            if(node.right != null){
                visualise(node.right, output, level + 1);
            }
        }
        return output.toString();
    }

    private String visualiseBorder(int times){
        StringBuilder border = new StringBuilder();
        for(int iteration = 0; iteration < times; iteration++){
            border.append("-");
        }
        return border.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof BinaryTree)){
            return false;
        }
        BinaryTree<E> binaryTree = (BinaryTree<E>) obj;
        return (
                binaryTree.hashCode() == this.hashCode()
                &&
                binaryTree.ROOT == this.ROOT
                &&
                binaryTree.toString().equals(this.toString())
        );
    }

    private class Node<T>{
        private T data;
        private Node left    = null;
        private Node right   = null;
        private int hashcode = 0;

        public Node(T data){
            this.data = data;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Node)){
                return false;
            }
            Node node = (Node) obj;
            return node.data.equals(this.data);
        }

        @Override
        public int hashCode() {
            this.hashcode = (
                    left.hashcode + right.hashcode + data.hashCode()
                    );
            return this.hashcode;
        }

        @Override
        public String toString() {
            return this.data.toString();
        }
    }
}
