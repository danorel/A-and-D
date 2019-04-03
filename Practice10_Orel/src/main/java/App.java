import tree.BinaryTree;
import tree.exceptions.NullPointerException;

import java.util.Arrays;
import java.util.Objects;

public class App {
    public static void main(String[] args) throws NullPointerException, CloneNotSupportedException {
        Integer []array = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
        BinaryTree<Integer> tree = new BinaryTree<>(0);
        tree.asBT(array);
        System.out.println("The total amount of leaves is " + tree.getLeafAmount());
        System.out.println(tree);

        BinaryTree<Integer> copy_tree = null;
        copy_tree = tree.clone(tree);
        System.out.println(Objects.requireNonNull(copy_tree).hashCode());
        System.out.println(Objects.requireNonNull(tree).hashCode());
        System.out.println(copy_tree.equals(tree));

        copy_tree.asBT(new Integer[]{5, 1, 2, 3, 4});
        System.out.println(copy_tree.equals(tree));
        System.out.println(copy_tree);

        System.out.println(copy_tree);
        System.out.println(copy_tree.getLeafAmount());

        System.out.println(Arrays.toString(copy_tree.asArray(copy_tree.getROOT())));
    }
}
