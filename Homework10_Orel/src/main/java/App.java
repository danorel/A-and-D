import alphabet.Alphabet;
import code.HuffmanCode;
import code.exception.AlphabetInitException;
import code.exception.EncodeException;
import tree.exceptions.IllegalArgumentException;

public class App {
    public static void main(String[] args) throws IllegalArgumentException, AlphabetInitException, EncodeException {
        HuffmanCode code = new HuffmanCode();
        code.define(
                new Alphabet.Builder()
                        .add("c", 15)
                        .add("d", 8)
                        .add("a", 12)
                        .add("b", 40)
                        .add("e", 25)
                        .generate()
        );


        /*
        String message = "dabbbec";
        code.defineByCase(message);
        HuffmanTree huffmanTree = code.buildTree();
        code.printCodes(huffmanTree, new StringBuffer());
        */
    }
}
