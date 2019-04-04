package tree.exceptions;

public class IllegalArgumentException extends Exception {
    private static final StringBuilder ILLEGAL_ADDING =
            new StringBuilder(
                    "Error! Cannot add the element to the binary tree! All the spots of the ancestor are not empty"
    );

    public IllegalArgumentException(){
        super(ILLEGAL_ADDING.toString());
    }
}
