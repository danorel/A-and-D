import heap.tree.BinaryTree;

public class App {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        System.out.println(binaryTree.isEmpty());
        System.out.println(binaryTree.size());
        System.out.println(binaryTree.indexOf(5));
    }
}
