package code.huffman.partitions;

public class HuffmanLeaf extends HuffmanTree {
    private char character;

    public HuffmanLeaf(char character, double frequency){
        super(frequency);
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
