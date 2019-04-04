package code.exception;

public class AlphabetInitException extends Exception {
    private final static StringBuilder INIT_EXCEPTION =
            new StringBuilder(
                    "Error! Cannot construct the algorithm due to the lack of the alphabet. Define the alphabet firstly!"
            );

    public AlphabetInitException(){
        super(INIT_EXCEPTION.toString());
    }
}
