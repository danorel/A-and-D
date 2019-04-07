package alphabet;

import alphabet.exceptions.IllegalArgumentException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Alphabet {
    private HashMap<Character, Double> alphabet;

    private Alphabet(HashMap<Character, Double> alphabet){
        this.alphabet = alphabet;
    }

    public static class Builder{

        private HashMap<Character, Double> alphabet;

        public Builder(){
            alphabet = new HashMap<>();
        }

        public Builder add(Character key, Double percentage){
            alphabet.put(key, percentage);
            return this;
        }

        public Alphabet generate() throws IllegalArgumentException {
            Double result = alphabet
                    .values()
                    .stream()
                    .reduce(0.0, (acc, value) -> acc += value);
            if(Math.round(result) == 100){
                return new Alphabet(alphabet);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public Character getKey(double value){
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

    public Collection<Double> getValueSet(){
        return getAlphabet().values();
    }

    public HashMap<Character, Double> getAlphabet() {
        return alphabet;
    }

    @Override
    public String toString() {
        return alphabet.toString();
    }
}
