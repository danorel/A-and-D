package alphabet;

import alphabet.exceptions.IllegalArgumentException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Alphabet {
    private HashMap<Character, Integer> alphabet;

    private Alphabet(HashMap<Character, Integer> alphabet){
        this.alphabet = alphabet;
    }

    public static class Builder{

        private HashMap<Character, Integer> alphabet;

        public Builder(){
            alphabet = new HashMap<>();
        }

        public Builder add(Character key, Integer percentage){
            alphabet.put(key, percentage);
            return this;
        }

        public Alphabet generate() throws IllegalArgumentException {
            AtomicInteger summary = new AtomicInteger();
            Integer result = alphabet
                    .values()
                    .stream()
                    .reduce(0, (acc, value) -> acc += value);
            if(result.equals(100)){
                return new Alphabet(alphabet);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public Character getKey(int value){
        char character = ' ';
        for(char ch : this.alphabet.keySet()){
            if(this.alphabet.get(ch) == value){
                character = ch;
                break;
            }
        }
        return character;
    }

    public Set<Character> getKeySet(){
        return getAlphabet().keySet();
    }

    public Collection<Integer> getValueSet(){
        return getAlphabet().values();
    }

    public HashMap<Character, Integer> getAlphabet() {
        return alphabet;
    }

    @Override
    public String toString() {
        return alphabet.toString();
    }
}
