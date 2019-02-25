import character.Character;

public class App {
    public static void main(String[] args) {
        Character ch = new Character('a');
        System.out.println(ch.ord(ch));
        System.out.println(ch.chr(65));
        System.out.println(ch.chr(ch.ord(ch)));
        System.out.println(ch.ord(ch.chr(65)));
        System.out.println(ch.succ(ch));
        System.out.println(ch.pred(ch));
    }
}
