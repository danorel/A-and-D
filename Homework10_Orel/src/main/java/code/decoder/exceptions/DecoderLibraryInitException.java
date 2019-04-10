package code.decoder.exceptions;

public class DecoderLibraryInitException extends Exception {
    private static final StringBuilder LIBRARY_INIT =
            new StringBuilder(
                "Fatal error! The working library was not defined. Setup the library firstly!"
            );

    public DecoderLibraryInitException(){
        super(LIBRARY_INIT.toString());
    }

    @Override
    public String getMessage() {
        return LIBRARY_INIT.toString();
    }
}
