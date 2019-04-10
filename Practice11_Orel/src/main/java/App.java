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
        System.out.println("Does the tree contain -3 as element? Answer: " + tree.contains(-3));
        System.out.println(tree.remove(5));
        System.out.println(tree);
        ArrayList<Integer> list =
                (ArrayList<Integer>) tree.getDataInDescOrder();
        list
                .forEach(System.out::println);
    }
}
