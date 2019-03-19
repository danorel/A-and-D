package lists.exceptions;

public class NullPointerException extends Exception {
    private static final String NULL_ADDING_EXCEPTION = "Cannot add the null to the queue! (restriction in the constructor permission)";

    public NullPointerException(){
        super(NULL_ADDING_EXCEPTION);
    }
}
