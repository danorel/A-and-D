package graph.exceptions;

import java.lang.reflect.Constructor;

public class GraphAdjacencyException extends Exception {
    private static final String SIZE_EXCEPTION = "Fatal ERROR! Cannot assemble graph. Size is incorrect!";

    public GraphAdjacencyException(Constructor constructor){
        super(SIZE_EXCEPTION + " (the problem caused in " + constructor.getName() + ")");
    }

    public static String getErrorMessage() {
        return SIZE_EXCEPTION;
    }
}
