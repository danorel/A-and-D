package lists;

public class SinglyLinkedList<T>{

    private Node HEAD;
    private Node TAIL;
    private int counter = 0;

    public SinglyLinkedList(){
        HEAD = new Node(null);
        TAIL = HEAD;
        counter++;
    }

    public SinglyLinkedList(T value){
        HEAD = new Node(value);
        TAIL = HEAD;
        counter++;
    }

    public void add(T value){
        TAIL.next = new Node(value);
        TAIL = TAIL.next;
        counter++;
    }

    public void addHEAD(T value){
        Node TEMP = new Node(value);
        Node CURRENT = HEAD;
        HEAD = TEMP;
        HEAD.next = CURRENT;
        counter++;
    }

    public void removeList(){
        HEAD.next = null;
    }

    public void removeHEAD(){
        if(HEAD.next != null){
            HEAD = HEAD.next;
            counter--;
        } else {
            System.err.println("Fatal ERROR! Can't remove the head!");
        }
    }

    public void showLinkedList(){
        Node temp = HEAD;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.print("null");
    }

    public int size(){
        return counter;
    }

    class Node {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }
}
