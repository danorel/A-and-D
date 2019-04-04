package tree.exceptions;

public class NullPointerException extends Exception {
    private static final String NULL_EXCEPTION = "Error! Trying to return the null element";

    public NullPointerException(){
        super(NULL_EXCEPTION);
    }
}
