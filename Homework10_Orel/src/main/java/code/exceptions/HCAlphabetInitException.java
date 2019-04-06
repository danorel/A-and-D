package code.exceptions;

public class HCAlphabetInitException extends Exception {
    private static final StringBuilder INIT_EXCEPTION =
            new StringBuilder(
                    "Error! Cannot make any acts without the alphabet defining."
            );

    public HCAlphabetInitException(){
        super(INIT_EXCEPTION.toString());
    }

    @Override
    public String getMessage() {
        return INIT_EXCEPTION.toString();
    }
}
