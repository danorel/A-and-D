package character;

public class Character {
    private char value;

    public Character(char value){
        this.value = value;
    }

    public int ord(Character ch){
        return (int) ch.getValue();
    }

    public Character chr(int ch){
        return new Character((char) ch);
    }

    public Character succ(Character ch){
        return chr(ord(ch) + 1);
    }

    public Character pred(Character ch){
        return chr(ord(ch) - 1);
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
