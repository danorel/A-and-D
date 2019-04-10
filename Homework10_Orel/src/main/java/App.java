import alphabet.exceptions.IllegalArgumentException;
import code.decoder.exceptions.DecoderLibraryInitException;
import code.encoder.exceptions.EncoderLibraryInitException;
import code.huffman.HuffmanCode;
import code.huffman.partitions.HuffmanTree;
import code.decoder.HuffmanDecoder;
import code.encoder.HuffmanEncoder;
import code.huffman.exceptions.HCAlphabetInitException;
import tree.exceptions.BTInitException;
import tree.exceptions.BTNullPointerException;

public class App {
    public static void main(String[] args) throws IllegalArgumentException, BTInitException, BTNullPointerException, HCAlphabetInitException, DecoderLibraryInitException, EncoderLibraryInitException {
        HuffmanCode code = new HuffmanCode();
        /*
        code.defineAlphabetByCase(
                new Alphabet.Builder()
                        .add('c', 15)
                        .add('d', 8)
                        .add('a', 12)
                        .add('b', 40)
                        .add('e', 25)
                        .generate()
        );
        */

        code.defineAlphabetByCase("More than a thousand words...");
        HuffmanTree tree = code.generateHuffmanTree();
        code.constructHuffmanCode(tree, new StringBuilder());

        HuffmanDecoder decoder = new HuffmanDecoder();
        decoder.setupLibrary(code.getLibrary());
        System.out.println();
        System.out.println("00000000000100000000001001: " + decoder.decode(
                "00000000000100000000001001"
        ));

        HuffmanEncoder encoder = new HuffmanEncoder();
        encoder.setupLibrary(code.getLibrary());
        System.out.println("Meet Me: " + encoder.encode("Meet Me"));
    }
}
