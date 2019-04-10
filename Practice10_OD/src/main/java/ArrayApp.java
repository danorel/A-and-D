import tree.array.BinaryTree;
import tree.array.exceptions.BTInitException;
import tree.array.exceptions.BTNullPointerException;

public class ArrayApp {
    public static void main(String[] args) throws BTInitException, BTNullPointerException {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.asArray(
                new Integer[]{5, 7, -1, 3, 2, 1}
        );
        System.out.println(tree);
        tree.add(6);
        System.out.println(tree);
        tree.add(9);
        System.out.println(tree);

        System.out.println(tree.isEmpty());
        System.out.println(tree.getIndex(-1));
        System.out.println(tree.size());
        System.out.println(tree.getIndex(11));

        tree.delete(7);
        System.out.println(tree);

    }
}
