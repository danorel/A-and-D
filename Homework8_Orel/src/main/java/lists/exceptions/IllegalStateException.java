package lists.exceptions;

public class IllegalStateException extends Exception {
    private static final String FULL_QUEUE = "Cannot add the elements to the queue! The queue is already full!";

    public IllegalStateException(Integer value){
        super(FULL_QUEUE + " (the max size of queue is " + value + ")");
    }
}
