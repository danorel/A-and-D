package bt.exceptions;

public class BTDuplicateException extends Exception{
    private static final StringBuilder DUPLICATE =
            new StringBuilder(
                    "Error. This element already exists in the binary tree."
            );

    public BTDuplicateException(){
        super(DUPLICATE.toString());
    }
}
