package code;

public class HuffmanNode extends HuffmanTree {

    public final HuffmanTree left, right; // subtrees

    public HuffmanNode(HuffmanTree l, HuffmanTree r) {
        //Calling the super  constructor HuffmanTree
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}
