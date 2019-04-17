import heap.BinaryTree;
import heap.exceptions.BTInitException;

import java.security.InvalidAlgorithmParameterException;

public class App {
    public static void main(String[] args) throws BTInitException, InvalidAlgorithmParameterException {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.createInAscOrder(new Integer[]{11, -5, 4, 3, 1, 7});
        System.out.println(tree);
        tree.createInDescOrder(new Integer[]{11, -5, 4, 3, 1, 7});
        System.out.println(tree);
        tree.replace(4, 5);
        System.out.println(tree);
        tree.add(87);
        System.out.println(tree);
        tree.add(-4);
        System.out.println(tree);
        tree.add(95);
        System.out.println(tree);
    }
}
