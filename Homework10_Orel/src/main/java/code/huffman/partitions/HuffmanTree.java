package code.huffman.partitions;

public class HuffmanTree implements Comparable<HuffmanTree>{
    private double frequency;

    public HuffmanTree(double frequency){
        this.frequency = frequency;
    }

    public double getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(HuffmanTree tree) {
        return (int) (this.frequency - tree.frequency);
    }
}
