import heap.BinaryTree;
import heap.exceptions.BTInitException;

public class App {
    public static void main(String[] args) throws BTInitException {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.createInAscOrder(new Integer[]{11, -5, 4, 3, 1, 7});
        System.out.println(tree);
        tree.createInDescOrder(new Integer[]{11, -5, 4, 3, 1, 7});
        System.out.println(tree);
    }
}
