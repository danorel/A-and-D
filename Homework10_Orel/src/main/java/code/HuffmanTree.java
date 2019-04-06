package code;

public class HuffmanTree implements Comparable<HuffmanTree>{
    private final int frequency;

    public HuffmanTree(final int frequency){
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(HuffmanTree tree) {
        return tree.frequency - this.frequency;
    }
}
