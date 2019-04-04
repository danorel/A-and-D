package code.exception;

public class EncodeException extends Exception {
    private static final StringBuilder ENCODE_ERROR =
            new StringBuilder(
                    "Fatal error! Trying to use both of the encoding algorithms!"
            );

    public EncodeException(){
        super(ENCODE_ERROR.toString());
    }
}
