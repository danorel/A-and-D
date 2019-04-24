package heap.bt;

import heap.bt.exceptions.BTDuplicateException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryTree<T extends Comparable>{
    private Element root;

    public BinaryTree(){

    }

    public BinaryTree(T element){
        if(element == null){
            throw new NullPointerException(
                    "Error! Trying to add the null element to the binary tree."
            );
        } else {
            root = new Element(element);
        }
    }

    public void add(T element) throws BTDuplicateException {
        if(element == null){
            throw new NullPointerException(
                    "Error! Trying to add the null element to the binary tree."
            );
        }
        if(root == null){
            root = new Element(element);
        } else {
            addRecursive(root, element);
        }
    }

    private void addRecursive(Element node, T element) throws BTDuplicateException {
        if(node != null){
            if(element.compareTo(node.element) < 0){
                if(node.left != null){
                    addRecursive(node.left, element);
                } else {
                    node.left = new Element(element);
                }

            } else if(element.compareTo(node.element) > 0){
                if(node.right != null){
                    addRecursive(node.right, element);
                } else {
                    node.right = new Element(element);
                }
            } else {
                throw new BTDuplicateException();
            }
        }
    }

    public boolean contains(T element){
        if(element == null){
            throw new NullPointerException(
                    "Error! Trying to search for the null element in the binary tree."
            );
        }
        if(!containsRecursive(root, element)){
            return false;
        } else {
            return true;
        }
    }

    private boolean containsRecursive(Element node, T element){
        if(node != null){
            if(node.element.compareTo(element) == 0){
                return true;
            } else {
                if(element.compareTo(node.element) < 0){
                    return containsRecursive(node.left, element);
                } else {
                    return containsRecursive(node.right, element);
                }
            }
        }
        return false;
    }

    public T remove(T element){
        if(element == null){
            throw new NullPointerException(
                    "Error! Trying to remove the null element in the binary tree."
            );
        }
        if(root == null){
            throw new NullPointerException(
                    "Error! Could not delete the elements from the empty binary tree."
            );
        }
        if(root.left == null && root.right == null){
            if(element == root.element){
                root = null;
            } else {
                throw new NoSuchElementException(
                        "Error! Trying to remove non-existing elements in the binary tree."
                );
            }
        }
        T leftValue = removeRecursive(root.left, root, element);
        T rightValue = removeRecursive(root.right, root, element);
        if(leftValue == null && rightValue == null){
            throw new NoSuchElementException(
                    "Error! Trying to remove non-existing elements in the binary tree."
            );
        } else {
            return element;
        }
    }

    private T removeRecursive(Element node, Element ancestor, T element){
        if(node != null){
            if(element.compareTo(node.element) == 0){
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
                    node.element = min;
                    return removeRecursive(node.right, node, min);
                }
                return element;
            } else if(element.compareTo(node.element) < 0){
                return removeRecursive(node.left, node, element);
            } else {
                return removeRecursive(node.right, node, element);
            }
        }
        return null;
    }

    public T findMinimum(){
        return findMinimumRecursive(root);
    }

    private T findMinimumRecursive(Element element){
        if(element != null){
            if(element.left != null){
                return findMinimumRecursive(element.left);
            } else {
                return element.element;
            }
        }
        return null;
    }

    public List<T> getDataInAscOrder(){
        return getDataInAscOrderRecursive(root, new ArrayList<>());
    }

    private List<T> getDataInAscOrderRecursive(Element element, List<T> list){
        if(element != null){
            if(element.left != null){
                getDataInAscOrderRecursive(element.left, list);
            }
            list.add(element.element);
            if(element.right != null){
                getDataInAscOrderRecursive(element.right, list);
            }
        }
        return list;
    }

    public List<T> getDataInDescOrder(){
        List<T> list = getDataInAscOrderRecursive(root, new ArrayList<>());
        list.sort(Comparator.reverseOrder());
        return list;
    }

    public void asArray(T []array) throws BTDuplicateException {
        if(array.length > 0){
            buildByArray(array, 0, root);
        }
    }

    private void buildByArray(T[] array, int index, Element element){
        if(index < array.length){
            element = new Element(array[index]);
            if(2*index < array.length){
                buildByArray(array, 2*index + 1, element.left);
            }
            if(2*index + 1 < array.length){
                buildByArray(array, 2*index + 2, element.right);
            }
        }
    }

    public T[] getArray(){
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
        return root == null;
    }

    public int size(){
        return sizeRecursive(root, 0);
    }

    private int sizeRecursive(Element element, int counter){
        if(element != null){
            counter++;
            if(element.left != null){
                counter = sizeRecursive(element.left, counter);
            }
            if(element.right != null){
                counter = sizeRecursive(element.right, counter);
            }
        }
        return counter;
    }

    private String visualisation(Element element, int level, StringBuilder content){
        if(element != null){
            content
                    .append(borders(level))
                    .append("[")
                    .append(element.element)
                    .append("]")
                    .append("\n");
            if(element.left != null){
                visualisation(element.left, level + 1, content);
            }
            if(element.right != null){
                visualisation(element.right, level + 1, content);
            }
        }
        return content.toString();
    }

    private String borders(int level){
        StringBuilder borders = new StringBuilder();
        for(int index = 0; index < level; index++){
            borders.append("-");
        }
        return borders.toString();
    }

    @Override
    public String toString() {
        return visualisation(root, 1, new StringBuilder());
    }

    private class Element implements Comparable<Element> {
        private Element left, right;
        private T element;

        public Element(T data){
            this.element = data;
            this.left  = null;
            this.right = null;
        }

        public int compareTo(Element element) {
            return this.element.compareTo(element);
        }

        @Override
        public String toString() {
            return String.format(
                    "<%s>", this.element
            );
        }
    }
}
