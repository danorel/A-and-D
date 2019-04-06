package tree.exceptions;

public class BTNullPointerException extends Exception {
    private static final String NULL_EXCEPTION = "Error! Trying to return the null element";

    public BTNullPointerException(){
        super(NULL_EXCEPTION);
    }
}
