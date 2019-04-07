import alphabet.Alphabet;
import alphabet.exceptions.IllegalArgumentException;
import code.huffman.HuffmanCode;
import code.huffman.HuffmanTree;
import code.decoder.HuffmanDecoder;
import code.encoder.HuffmanEncoder;
import code.huffman.HCAlphabetInitException;
import tree.exceptions.BTInitException;
import tree.exceptions.BTNullPointerException;

public class App {
    public static void main(String[] args) throws IllegalArgumentException, BTInitException, BTNullPointerException, HCAlphabetInitException {
        HuffmanCode code = new HuffmanCode();
        /*
        code.define(
                new Alphabet.Builder()
                        .add('c', 15)
                        .add('d', 8)
                        .add('a', 12)
                        .add('b', 40)
                        .add('e', 25)
                        .generate()
        );
        */

        code.define("More than a thousand words...");
        HuffmanTree tree = code.generateHT();
        code.visualize(tree, new StringBuilder());

        /*
        HuffmanDecoder decoder = new HuffmanDecoder();
        decoder.setupLibrary(code.getLibrary());
        System.out.println();
        System.out.println(decoder.decode("101001000100000"));

        HuffmanEncoder encoder = new HuffmanEncoder();
        encoder.setupLibrary(code.getLibrary());
        System.out.println();
        System.out.println(encoder.encode("bee"));
        */
    }
}
