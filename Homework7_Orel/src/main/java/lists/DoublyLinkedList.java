package lists;

import algorithm.HeapSort;

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

    public void removeTAIL(){
        if(TAIL.previous != null){
            TAIL = TAIL.previous;
            TAIL.next = null;
            counter--;
        } else {
            System.err.println("Can't remove the TAIL! Its' previous element is null");
        }
    }

    public void removeHEAD(){
        if(HEAD.next != null){
            HEAD = HEAD.next;
            HEAD.previous = null;
            counter--;
        } else {
            System.err.println("Can't remove the HEAD! Its' next element is null");
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

    public T[] getArrayFromList(){
        if(HEAD.value != null){
            Comparable []Array = new Comparable[size()];
            Node TEMP = HEAD;
            for(int index = 0; index < size(); index++){
                Array[index] = TEMP.value;
                TEMP = TEMP.next;
            }
            return (T[]) Array;
        } else {
            return (T[]) new Comparable[0];
        }
    }

    public void appendArrayToList(T[] Array){
        for(int index = 0; index < Array.length; index++){
            add(Array[index]);
        }
    }

    public void restructureList(){
        HeapSort sort = new HeapSort();
        T[] sortedListVariables = (T[]) sort.sort(getArrayFromList());
        removeDoublyLinkedList();
        appendArrayToList(sortedListVariables);
    }

    public void showDoublyLinkedList(){
        Node TEMP = HEAD;
        while(TEMP != null){
            System.out.print(TEMP.value + " <-> ");
            TEMP = TEMP.next;
        }
        System.out.print("null");
    }

    public int size(){
        return counter;
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
    }
}
