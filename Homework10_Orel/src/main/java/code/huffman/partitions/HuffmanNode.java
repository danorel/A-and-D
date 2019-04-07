package code.huffman;

public class HuffmanNode extends HuffmanTree {
    private final HuffmanTree left, right;

    public HuffmanNode(HuffmanTree left, HuffmanTree right){
        super(left.getFrequency() + right.getFrequency());
        this.left = left;
        this.right = right;
    }

    public HuffmanTree getLeft() {
        return left;
    }

    public HuffmanTree getRight() {
        return right;
    }
}