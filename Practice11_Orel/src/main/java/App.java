import bt.BinaryTree;
import bt.exceptions.BTDuplicateException;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws BTDuplicateException {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(15);
        tree.add(10);
        tree.add(5);
        tree.add(20);
        tree.add(-3);
        tree.add(7);
        System.out.println(tree);
        System.out.println("Does the tree contain -4 as element? Answer: " + tree.contains(-4));
        tree.remove(10);
        System.out.println("Tree after deleting the element: ");
        System.out.println(tree);
        System.out.println("Data in the descending order: ");
        ArrayList<Integer> dataInDescOrder =
                (ArrayList<Integer>) tree.getDataInDescOrder();
        dataInDescOrder
                .forEach(System.out::println);
        System.out.println("Data in the ascending order: ");
        ArrayList<Integer> dataInAscOrder =
                (ArrayList<Integer>) tree.getDataInAscOrder();
        dataInAscOrder
                .forEach(System.out::println);
    }
}
