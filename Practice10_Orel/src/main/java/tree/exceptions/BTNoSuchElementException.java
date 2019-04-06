package tree.exceptions;

public class BTNoSuchElementException extends Exception {
    private static final StringBuilder NO_ELEMENT =
            new StringBuilder(
                "Error! Found 0 elements with such a value: "
    );

    public BTNoSuchElementException(Object value){
        super(NO_ELEMENT.toString() + value);
    }
}
