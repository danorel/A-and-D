package code.huffman;

import alphabet.Alphabet;
import alphabet.exceptions.IllegalArgumentException;
import code.huffman.exceptions.HCAlphabetInitException;
import code.huffman.partitions.HuffmanLeaf;
import code.huffman.partitions.HuffmanNode;
import code.huffman.partitions.HuffmanTree;
import tree.BinaryTree;
import tree.exceptions.BTInitException;
import tree.exceptions.BTNullPointerException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCode {
    private BinaryTree<HuffmanTree> tree;
    private Alphabet alphabet;
    private HuffmanLibrary library;

    public HuffmanCode() throws BTInitException {
        tree = new BinaryTree<>();
    }

    public void defineAlphabet(Alphabet alphabet){
        this.alphabet = alphabet;
    }

    public void defineAlphabetByCase(String msg) throws IllegalArgumentException {
        int []frequencies = new int[256];
        char []characters = msg.toCharArray();
        for(int index = 0; index < characters.length; index++){
            frequencies[characters[index]]++;
        }
        Alphabet.Builder builder = new Alphabet.Builder();
        int summary = 0;
        Set<Map.Entry<Character, Double>> notNullFrequencies
                = receiveNotNullFrequencies(frequencies).entrySet();
        for(Map.Entry<Character, Double> entry : notNullFrequencies){
            summary += entry.getValue();
        }
        for(Map.Entry<Character, Double> entry : notNullFrequencies){
            builder
                    .add(
                            entry.getKey(), (entry.getValue() / (double)summary) * 100
                    );
        }
        this.alphabet = builder.generate();
    }

    private HashMap<Character, Double> receiveNotNullFrequencies(int []frequencies){
        HashMap<Character, Double> notNullFrequencies
                = new HashMap<>();
        for(int index = 0; index < frequencies.length; index++){
            if(frequencies[index] != 0){
                notNullFrequencies
                        .put((char)index, (double) frequencies[index]);
            }
        }
        return notNullFrequencies;
    }

    public HuffmanTree generateHuffmanTree() throws HCAlphabetInitException, BTInitException, BTNullPointerException {
        if(alphabet == null){
            throw new HCAlphabetInitException();
        } else {
            while(alphabet.getDoubleValuesSet().size() > 0){
                double min = alphabet
                        .getDoubleValuesSet()
                        .stream()
                        .max((first, second) -> (int) (first - second))
                        .get();
                tree.add(new HuffmanLeaf(alphabet.getKey(min), min));
                alphabet
                        .getAlphabet()
                            .remove(alphabet.getKey(min), min);
            }

        }
        return generateHuffmanTreeRecursive();
    }

    private HuffmanTree generateHuffmanTreeRecursive() throws BTInitException, BTNullPointerException {
        while(tree.size() > 2){
            HuffmanTree last = tree.poll();
            HuffmanTree prelast = tree.poll();
            tree.add(new HuffmanNode(last, prelast));
        }
        return tree.poll();
    }

    public void constructHuffmanCode(HuffmanTree tree, StringBuilder prefix){
        this.library = new HuffmanLibrary();
        constructHuffmanCodeRecursive(tree, prefix, this.library);
    }

    private void constructHuffmanCodeRecursive(HuffmanTree tree, StringBuilder prefix, HuffmanLibrary library){
        if(tree instanceof HuffmanLeaf){
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            library.add(leaf.getCharacter(), prefix.toString());
        } else {
            HuffmanNode node = (HuffmanNode) tree;
            prefix.append("0");
            constructHuffmanCodeRecursive(node.getLeft(), prefix, library);
            prefix.deleteCharAt(prefix.length() - 1);

            prefix.append("1");
            constructHuffmanCodeRecursive(node.getRight(), prefix, library);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public void visualizeHuffmanCode(HuffmanTree tree, StringBuilder prefix){
        if(tree instanceof HuffmanLeaf){
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            System.out.println(leaf.getCharacter() + "\t" + leaf.getFrequency() + "\t" + prefix.toString());
        } else {
            HuffmanNode node = (HuffmanNode) tree;
            prefix.append("0");
            visualizeHuffmanCode(node.getLeft(), prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            prefix.append("1");
            visualizeHuffmanCode(node.getRight(), prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public HuffmanLibrary getLibrary() {
        return this.library;
    }
}
