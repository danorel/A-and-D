import heap.BinaryHeap;
import heap.tree.BinaryTree;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        System.out.println("Is the bt empty? Answer: " + binaryTree.isEmpty());
        System.out.println("What is the size of the binary tree? Answer: " + binaryTree.size());
        System.out.println("Index of the element 5 in the bt. Answer: " + binaryTree.indexOf(5));
        System.out.println("Does the bt contain element 11? Answer: " + binaryTree.contains(11));
        /*
            Adding some elements to the binary tree
         */
        binaryTree.add(11);
        binaryTree.add(1);
        binaryTree.add(6);
        binaryTree.add(5);
        System.out.print(binaryTree);
        System.out.println("Does the bt contain element 11? Answer: " + binaryTree.contains(11));
        binaryTree.delete(1);
        System.out.print(binaryTree);
        System.out.println("Index of the element 1 in the bt. Answer: " + binaryTree.indexOf(1));
        ArrayList<Integer> list = (ArrayList<Integer>) binaryTree.obtainAsList();
        list
                .forEach(System.out::println);

        System.out.println();

        BinaryHeap<Integer> heap = new BinaryHeap<>(true);
        System.out.println("Is the heap empty? Answer: " + heap.isEmpty());
        heap.add(4);
        heap.add(10);
        heap.add(3);
        heap.add(5);
        heap.add(1);
        System.out.print(heap);
        System.out.println(heap.remove());
        System.out.println(heap);
        System.out.print(heap.peak());
    }
}
