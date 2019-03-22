package lists;

import com.sun.javafx.binding.StringFormatter;

public class DoublyLinkedList<T extends Comparable> {
    private Node HEAD;
    private Node TAIL;
    private int counter = 0;

    public DoublyLinkedList(){
        HEAD = new Node(null);
        TAIL = HEAD;
        counter++;
    }

    public DoublyLinkedList(T value){
        HEAD = new Node(value);
        TAIL = HEAD;
        counter++;
    }

    public void add(T value){
        if(HEAD.value != null){
            TAIL.next = new Node(value);
            Node TEMP = TAIL;
            TAIL = TAIL.next;
            TAIL.previous = TEMP;
            TAIL.next = null;
            counter++;
        } else {
            HEAD.value = value;
        }
    }

    public void addHEAD(T value){
        Node TEMP = new Node(value);
        Node CURRENT = HEAD;
        HEAD = TEMP;
        HEAD.next = CURRENT;
        HEAD.previous = null;
        counter++;
    }

    public Comparable removeTAIL() {
        Comparable value = null;
        if(TAIL != HEAD){
            value = TAIL.value;
            TAIL = TAIL.previous;
            TAIL.next = null;
            counter--;
        } else {
            HEAD.value = null;
        }
        return value;
    }

    public void removeHEAD(){
        if(HEAD.next != null){
            HEAD = HEAD.next;
            HEAD.previous = null;
            counter--;
        } else {
            HEAD.value = null;
        }
    }

    public void removeDoublyLinkedList(){
        while(HEAD.next != null){
            TAIL = TAIL.previous;
            TAIL.next = null;
            counter--;
        }
        HEAD.value = null;
    }

    public void removeNodeWithKey(T value){
        boolean isNotOperatedLastNode = true;
        Node TEMP = TAIL;
        Node FIX;
        do {
            if(TEMP.previous == null){
                isNotOperatedLastNode = false;
            }
            if(TEMP.previous != null && TEMP.value == value){
                FIX = TEMP.next;
                TEMP = TEMP.previous;
                TEMP.next = FIX;
                counter--;
                break;
            } else if(TEMP.previous == null) {
                removeHEAD();
                break;
            } else {
                TEMP = TEMP.previous;
            }
        } while(isNotOperatedLastNode);
    }

    public Node moveToNext(Node node){
        return node = node.next;
    }

    public void appendArrayToList(T[] Array){
        for(int index = 0; index < Array.length; index++){
            add(Array[index]);
        }
    }

    public int getNodePosition(T value){
        int counter = 1;
        boolean isFound = false;
        Node TEMP = HEAD;
        while(TEMP == TAIL || TEMP.next != null){
            if(TEMP.value == value){
                isFound = true;
                break;
            } else {
                if(TEMP == TAIL){
                    break;
                }
                counter++;
                TEMP = TEMP.next;
            }
        }
        return isFound ? counter : -1;
    }

    public Comparable getTailValue() throws NullPointerException{
        T value = null;
        if(TAIL.value != null){
            value = TAIL.value;
        }
        return value;
    }

    public int size(){
        return counter;
    }

    public Node getHEAD(){
        return HEAD;
    }

    public Node getTAIL(){
        return TAIL;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node TEMP = HEAD;
        builder.append("null<->");
        while(TEMP.next != null){
            builder.append(TEMP.value).append("<->");
            TEMP = TEMP.next;
        }
        builder.append(getTailValue()).append("<->");
        builder.append("null");
        return StringFormatter.format(
            "%s", builder.toString()
        ).getValue();
    }

    public class Node{
        private T value;
        private Node next;
        private Node previous;

        public Node(T value){
            this.value = value;
            this.next = null;
            this.previous = null;
        }

        public T getValue() {
            return value;
        }
    }
}
