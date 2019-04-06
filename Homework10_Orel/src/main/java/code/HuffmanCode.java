package code;

import alphabet.Alphabet;
import code.exceptions.HCAlphabetInitException;
import tree.BinaryTree;
import tree.exceptions.BTInitException;
import tree.exceptions.BTNullPointerException;

public class HuffmanCode {
    private Alphabet alphabet;
    private BinaryTree<HuffmanTree> tree;

    public HuffmanCode() throws BTInitException {
        tree = new BinaryTree<>();
    }

    public HuffmanCode define(Alphabet alphabet){
        this.alphabet = alphabet;
        return this;
    }

    public HuffmanTree generateBT() throws HCAlphabetInitException, BTInitException, BTNullPointerException {
        if(alphabet == null){
            throw new HCAlphabetInitException();
        } else {
            while(alphabet.getValueSet().size() > 0){
                int min = alphabet
                        .getValueSet()
                        .stream()
                        .max((first, second) -> (int) (first.longValue() - second.longValue()))
                        .get();
                tree.add(new HuffmanLeaf(min, alphabet.getKey(min)));
                alphabet.getAlphabet().remove(alphabet.getKey(min), min);
            }

        }
        return generateBTRecursive();
    }

    private HuffmanTree generateBTRecursive() throws BTInitException, BTNullPointerException {
        while(tree.size() > 2){
            HuffmanTree last = tree.poll();
            HuffmanTree prelast = tree.poll();

            tree.add(new HuffmanNode(last, prelast));
        }
        return tree.poll();
    }

    public void print(HuffmanTree tree, StringBuilder prefix){
        if(tree instanceof HuffmanLeaf){
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            System.out.println(leaf.getCharacter() + "\t" + leaf.getFrequency() + "\t" + prefix.toString());
        } else {
            HuffmanNode node = (HuffmanNode) tree;
            prefix.append("0");
            print(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            prefix.append("1");
            print(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
