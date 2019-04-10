package tree.array.exceptions;

public class BTNoSuchElementException extends Exception {
    private static final StringBuilder NO_ELEMENT =
            new StringBuilder(
                    "Error. No such element found in the binary tree with the data: "
            );

    public BTNoSuchElementException(Object data){
        super(NO_ELEMENT.toString() + data.toString());
    }
}
