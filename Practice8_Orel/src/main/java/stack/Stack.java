package stack;

import lists.DoublyLinkedList;
import lists.exceptions.EmptyStackException;

public class Stack<T extends Comparable>{
    private DoublyLinkedList<T> list;

    public <E extends T>Stack(){
        list = (DoublyLinkedList<T>) new DoublyLinkedList<E>();
    }

    public T push(T item){
        list.add(item);
        return item;
    }

    public T pop() throws EmptyStackException, NoSuchMethodException {
        T value = (T) list.removeTAIL();
        if(value == null) throw new EmptyStackException(Stack.class.getMethod("pop"));
        return value;
    }

    public T peek() throws EmptyStackException, NoSuchMethodException {
        T value = (T) list.getTailValue();
        if(value == null) throw new EmptyStackException(Stack.class.getMethod("peek"));
        return value;
    }

    public boolean empty(){
        try{
            if(list.getTailValue() != null){
                return false;
            }
        } catch (NullPointerException exception){
            return true;
        }
        return true;
    }

    public int search(T o) throws EmptyStackException, NoSuchMethodException {
        if(getList().getHEAD().getValue() == null){
            System.out.println("-1");
            throw new EmptyStackException(Stack.class.getMethod("search", Comparable.class));
        }
        int counter = 1;
        DoublyLinkedList.Node TEMP = getList().getHEAD();
        while (TEMP == getList().getTAIL() || hasNext(TEMP)){
            if(TEMP.getValue().equals(o)){
                return counter;
            } else {
                if(TEMP == getList().getTAIL()){
                    break;
                }
                TEMP = getList().moveToNext(TEMP);
                counter++;
            }
        }
        return -1;
    }

    private boolean hasNext(DoublyLinkedList.Node node){
        return node != getList().getTAIL();
    }

    public void nullify(){
        list.removeDoublyLinkedList();
    }

    public DoublyLinkedList<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
