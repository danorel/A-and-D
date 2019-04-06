package tree.array.exceptions;

public class BTInitException extends Exception{
    private static final StringBuilder INIT_EXCEPTION =
            new StringBuilder(
                "Failed to initialize the array! The input size equals or less than zero."
            );

    public BTInitException(){
        super(INIT_EXCEPTION.toString());
    }

    @Override
    public String getMessage() {
        return INIT_EXCEPTION.toString();
    }
}
