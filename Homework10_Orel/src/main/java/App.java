import alphabet.Alphabet;
import alphabet.exceptions.IllegalArgumentException;
import code.HuffmanCode;
import code.HuffmanTree;
import code.exceptions.HCAlphabetInitException;
import tree.exceptions.BTInitException;
import tree.exceptions.BTNullPointerException;

public class App {
    public static void main(String[] args) throws IllegalArgumentException, BTInitException, BTNullPointerException, HCAlphabetInitException {
        HuffmanCode code = new HuffmanCode();
        code.define(
                new Alphabet.Builder()
                        .add('c', 15)
                        .add('d', 8)
                        .add('a', 12)
                        .add('b', 40)
                        .add('e', 25)
                        .generate()
        );
        HuffmanTree tree = code.generateBT();
        code.print(tree, new StringBuilder());

    }
}
