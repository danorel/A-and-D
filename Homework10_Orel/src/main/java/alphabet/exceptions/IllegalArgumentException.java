package alphabet.exceptions;

public class IllegalArgumentException extends Exception {
    private static final StringBuilder ILLEGAL_ARGUMENTS =
            new StringBuilder(
                    "Error! The percentage of the alphabet possibilities must be 100%!"
            );

    public IllegalArgumentException(){
        super(ILLEGAL_ARGUMENTS.toString());
    }
}
