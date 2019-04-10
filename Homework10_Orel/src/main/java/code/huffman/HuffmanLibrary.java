package code.huffman;

import java.util.HashMap;
import java.util.Map;

public class HuffmanLibrary {
    private HashMap<Character, String> lib;

    public HuffmanLibrary(){
        lib = new HashMap<>();
    }

    public HuffmanLibrary(HashMap<Character, String> library){
        this.lib = library;
    }

    public void add(Map.Entry<Character, String> entry){
        this.lib.put(entry.getKey(), entry.getValue());
    }

    public void add(Character character, String prefix){
        this.lib.put(character, prefix);
    }

    public boolean isValidPrefix(String prefix){
        return getCharacterByValue(prefix) != null;
    }

    public Character getCharacterByPrefix(String prefix){
        return getCharacterByValue(prefix);
    }

    public String getPrefixByCharacter(Character character){
        return this.lib.get(character);
    }

    private Character getCharacterByValue(String prefix){
        for(char character : this.lib.keySet()){
            if(this.lib.get(character).equals(prefix)){
                return character;
            }
        }
        return null;
    }
}
