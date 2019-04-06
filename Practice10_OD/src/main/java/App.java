import tree.BinaryTree;
import tree.exceptions.BTIllegalArgumentException;
import tree.exceptions.BTNoSuchElementException;
import tree.exceptions.BTNullPointerException;

public class App {
    public static void main(String[] args) throws BTNullPointerException, BTIllegalArgumentException, BTNoSuchElementException {
        BinaryTree<Integer> tree = new BinaryTree<>(3);
        System.out.println("-------");
        tree.add(1, 3);
        tree.add(5, 1);
        tree.add(-3, 1);
        tree.add(6, 3);
        tree.add(7, 6);
        tree.add(4, 6);
        System.out.print(tree);
        System.out.println("-------");
        System.out.println();
        System.out.println("-------");
        tree.remove(7);
        System.out.print(tree);
        System.out.println("-------");
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("Node with data 9 is present? Answer: " + tree.search(9));
        System.out.println("Node with data 5 is present? Answer: " + tree.search(5));
        System.out.println("------------------------------------------");
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("The amount of nodes in the binary tree is: " + tree.getNodeAmount());
        System.out.println("--------------------------------------------");
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Is the binary tree empty? Answer: " + tree.isEmpty());
        System.out.println("---------------------------------------");
        System.out.println();
    }
}
