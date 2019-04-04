package alphabet;

import tree.exceptions.IllegalArgumentException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Alphabet {
    private HashMap<String, Integer> alphabet;

    private Alphabet(HashMap<String, Integer> alphabet){
        this.alphabet = alphabet;
    }

    public HashMap<String, Integer> getAlphabet() {
        return alphabet;
    }

    public static class Builder{

        private HashMap<String, Integer> alphabet;

        public Builder(){
            alphabet = new HashMap<>();
        }

        public Builder add(String key, Integer percentage){
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

    @Override
    public String toString() {
        return alphabet.toString();
    }
}
