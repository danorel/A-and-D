package heap.bt;

import heap.bt.exceptions.BTDuplicateException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryTree<T extends Comparable>{
    private Node ROOT;

    public BinaryTree(){

    }

    public BinaryTree(T data){
        if(data == null){
            throw new NullPointerException(
                    "Error! Trying to add the null data to the binary tree."
            );
        } else {
            ROOT = new Node(data);
        }
    }

    public void add(T data) throws BTDuplicateException {
        if(data == null){
            throw new NullPointerException(
                    "Error! Trying to add the null data to the binary tree."
            );
        }
        if(ROOT == null){
            ROOT = new Node(data);
        } else {
            addRecursive(ROOT, data);
        }
    }

    private void addRecursive(Node node, T data) throws BTDuplicateException {
        if(node != null){
            if(data.compareTo(node.data) < 0){
                if(node.left != null){
                    addRecursive(node.left, data);
                } else {
                    node.left = new Node(data);
                }

            } else if(data.compareTo(node.data) > 0){
                if(node.right != null){
                    addRecursive(node.right, data);
                } else {
                    node.right = new Node(data);
                }
            } else {
                throw new BTDuplicateException();
            }
        }
    }

    public boolean contains(T data){
        if(data == null){
            throw new NullPointerException(
                    "Error! Trying to search for the null data in the binary tree."
            );
        }
        if(!containsRecursive(ROOT, data)){
            return false;
        } else {
            return true;
        }
    }

    private boolean containsRecursive(Node node, T data){
        if(node != null){
            if(node.data.compareTo(data) == 0){
                return true;
            } else {
                if(data.compareTo(node.data) < 0){
                    return containsRecursive(node.left, data);
                } else {
                    return containsRecursive(node.right, data);
                }
            }
        }
        return false;
    }

    public T remove(T data){
        if(data == null){
            throw new NullPointerException(
                    "Error! Trying to remove the null data in the binary tree."
            );
        }
        if(ROOT == null){
            throw new NullPointerException(
                    "Error! Could not delete the elements from the empty binary tree."
            );
        }
        if(ROOT.left == null && ROOT.right == null){
            if(data == ROOT.data){
                ROOT = null;
            } else {
                throw new NoSuchElementException(
                        "Error! Trying to remove non-existing elements in the binary tree."
                );
            }
        }
        T leftValue = removeRecursive(ROOT.left, ROOT, data);
        T rightValue = removeRecursive(ROOT.right, ROOT, data);
        if(leftValue == null && rightValue == null){
            throw new NoSuchElementException(
                    "Error! Trying to remove non-existing elements in the binary tree."
            );
        } else {
            return data;
        }
    }

    private T removeRecursive(Node node, Node ancestor, T data){
        if(node != null){
            if(data.compareTo(node.data) == 0){
                if(node.left == null && node.right != null){
                    ancestor.right = node.right;
                }
                if(node.left != null && node.right == null){
                    ancestor.left = node.left;
                }
                if(node.left == null && node.right == null){
                    if(ancestor.left == node){
                        ancestor.left = null;
                    }
                    if(ancestor.right == node){
                        ancestor.right = null;
                    }
                }
                if(node.left != null && node.right != null){
                    T min = findMinimumRecursive(node.right);
                    node.data = min;
                    return removeRecursive(node.right, node, min);
                }
                return data;
            } else if(data.compareTo(node.data) < 0){
                return removeRecursive(node.left, node, data);
            } else {
                return removeRecursive(node.right, node, data);
            }
        }
        return null;
    }

    public T findMinimum(){
        return findMinimumRecursive(ROOT);
    }

    private T findMinimumRecursive(Node node){
        if(node != null){
            if(node.left != null){
                return findMinimumRecursive(node.left);
            } else {
                return node.data;
            }
        }
        return null;
    }

    public List<T> getDataInAscOrder(){
        return getDataInAscOrderRecursive(ROOT, new ArrayList<>());
    }

    private List<T> getDataInAscOrderRecursive(Node node, List<T> list){
        if(node != null){
            if(node.left != null){
                getDataInAscOrderRecursive(node.left, list);
            }
            list.add(node.data);
            if(node.right != null){
                getDataInAscOrderRecursive(node.right, list);
            }
        }
        return list;
    }

    public List<T> getDataInDescOrder(){
        List<T> list = getDataInAscOrderRecursive(ROOT, new ArrayList<>());
        list.sort(Comparator.reverseOrder());
        return list;
    }

    public void asArray(T []source) throws BTDuplicateException {
        if(source.length > 0){
            buildByArray(source, 0, ROOT);
        }
    }

    private void buildByArray(T[] source, int index, Node node){
        if(index < source.length){
            node = new Node(source[index]);
            if(2*index < source.length){
                buildByArray(source, 2*index + 1, node.left);
            }
            if(2*index + 1 < source.length){
                buildByArray(source, 2*index + 2, node.right);
            }
        }
    }

    public T[] obtainAsArray(){
        if(isEmpty()){
            return null;
        } else {
            List<T> list = getDataInAscOrder();
            T []source = (T[]) new Comparable[list.size()];
            for(int index = 0; index < source.length; index++){
                source[index] = list.get(index);
            }
            return source;
        }
    }

    public boolean isEmpty(){
        return ROOT == null;
    }

    public int size(){
        return sizeRecursive(ROOT, 0);
    }

    private int sizeRecursive(Node node, int counter){
        if(node != null){
            counter++;
            if(node.left != null){
                counter = sizeRecursive(node.left, counter);
            }
            if(node.right != null){
                counter = sizeRecursive(node.right, counter);
            }
        }
        return counter;
    }

    private String visualisation(Node node, int level, StringBuilder content){
        if(node != null){
            content
                    .append(borders(level))
                    .append("[")
                    .append(node.data)
                    .append("]")
                    .append("\n");
            if(node.left != null){
                visualisation(node.left, level + 1, content);
            }
            if(node.right != null){
                visualisation(node.right, level + 1, content);
            }
        }
        return content.toString();
    }

    private String borders(int level){
        StringBuilder borders = new StringBuilder();
        for(int index = 0; index < level; index++){
            borders.append("+");
        }
        return borders.toString();
    }

    @Override
    public String toString() {
        return visualisation(ROOT, 1, new StringBuilder());
    }

    private class Node implements Comparable<Node> {
        private Node left, right;
        private T data;

        public Node(T data){
            this.data  = data;
            this.left  = null;
            this.right = null;
        }

        public int compareTo(Node node) {
            return this.data.compareTo(node);
        }

        @Override
        public String toString() {
            return String.format(
                    "<%s>", this.data
            );
        }
    }
}
