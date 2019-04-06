package code;

public class HuffmanLeaf extends HuffmanTree {
    private char character;

    public HuffmanLeaf(int frequency, char character) {
        super(frequency);
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
