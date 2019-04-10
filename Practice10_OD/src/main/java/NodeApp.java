import tree.node.BinaryTree;
import tree.node.exceptions.BTIllegalArgumentException;
import tree.node.exceptions.BTNoSuchElementException;
import tree.node.exceptions.BTNullPointerException;

public class NodeApp {
    public static void main(String[] args) throws BTNullPointerException, BTIllegalArgumentException, BTNoSuchElementException, CloneNotSupportedException {
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
        System.out.println("-----------------------------------------------");
        System.out.println("Cloning all the elements from the tree to clone");
        BinaryTree<Integer> tree_clone = tree.clone(tree);
        System.out.println(tree_clone);
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Are the trees equal? Answer: " + tree_clone.equals(tree));
        System.out.println("---------------------------------");

        System.out.println("------------------------------------------");
        System.out.println("Removing the data 1 from binary tree: " + tree_clone.remove(6));
        System.out.println("------------------------------------------");
        System.out.println();
        System.out.println("-------");
        System.out.print(tree_clone);
        System.out.println("-------");
    }
}
