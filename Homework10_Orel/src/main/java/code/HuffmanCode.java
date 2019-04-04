package code;

import alphabet.Alphabet;
import code.exception.AlphabetInitException;
import code.exception.EncodeException;
import tree.BinaryTree;
import tree.exceptions.NullPointerException;

import java.util.*;

public class HuffmanCode {

    private BinaryTree<HuffmanTree> tree;
    private PriorityQueue<HuffmanTree> priorityQueue;
    private Alphabet alphabet;
    private StringBuilder text;
    private int[] frequencies;

    public HuffmanCode(){
        tree = new BinaryTree<>();
        priorityQueue = new PriorityQueue<>();
        text = new StringBuilder();
    }

    public HuffmanCode define(Alphabet alphabet){
        this.alphabet = alphabet;
        return this;
    }

    public HuffmanCode defineByCase(String text){
        this.text = new StringBuilder();
        append(text);
        this.frequencies = new int[256];
        for (char ch : this.text.toString().toCharArray())
            frequencies[ch]++;
        return this;
    }

    public void build() throws AlphabetInitException, EncodeException, NullPointerException {
        if(alphabet == null && this.frequencies == null){
            throw new AlphabetInitException();
        } else if(alphabet != null && this.frequencies == null){
            /*
            ArrayList<Integer> weights = new ArrayList<>(alphabet.getAlphabet().values());
            Collections.sort(weights);

            while(priorityQueue.size() > 1){
                HuffmanTree first = priorityQueue.poll();
                HuffmanTree second = priorityQueue.poll();

                priorityQueue.offer(new HuffmanNode(first, second));
            }
            */
            while(priorityQueue.size() > 1){
                HuffmanTree first = tree.poll();
                HuffmanTree second = tree.poll();

                tree.offer(new HuffmanNode(first, second));
            }
        } else if(alphabet == null) {
            /*
            AtomicInteger counter = new AtomicInteger();
            Integer summary = Arrays.asList(frequencies)
                    .stream()
                    .filter(frequency -> frequency > 0)
                    .reduce(0, (storage, frequency) -> storage += frequency);
            List<Integer> filled_frequencies = Arrays.asList(frequencies)
                    .stream()
                    .filter(frequency -> {
                        if(frequency > 0){
                            alphabet.getAlphabet().put(Character.getName(counter.get()), ((int)((double)((double)frequency / summary)) * 100));
                        }
                        counter.getAndIncrement();
                        return frequency > 0;
                    })
                    .collect(Collectors.toList());
            */
        } else {
            throw new EncodeException();
        }
    }

    public HuffmanTree buildTree() {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < frequencies.length; i++)
            if (frequencies[i] > 0)
                trees.offer(new HuffmanLeaf(frequencies[i], (char)i));

        assert trees.size() > 0;
        // loop until there is only one priorityQueue left
        while (trees.size() > 1) {
            // two trees with least frequency
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    public void printCodes(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;

            // traverse left
            prefix.append('0');
            //prefix = prefix + "0";
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    /*
    public boolean decode(){
        return false;
    }

    public String encode(){

        return
    }
    */

    public HuffmanCode append(String text){
        this.text.append(text);
        return this;
    }

    public void update(){
        this.text.delete(0, this.text.toString().length());
    }

    @Override
    public String toString() {
        return text.toString();
    }
}
