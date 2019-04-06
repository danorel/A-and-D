package tree.node.exceptions;

public class BTNullPointerException extends Exception {
    private static final String NULL_EXCEPTION = "Error! Trying to add/return the null element to the binary tree.";

    public BTNullPointerException(){
        super(NULL_EXCEPTION);
    }
}
