package graph.exceptions;

import java.lang.reflect.Constructor;

public class GraphInitException extends Exception {
    private static final String INPUT_EXCEPTION = "Fatal ERROR! Cannot define the graph. The input data is wrong!";

    public GraphInitException(Constructor constructor){
        super(INPUT_EXCEPTION + " (the problem caused in " + constructor.getName() + ")");
    }

    public static String getErrorMessage() {
        return INPUT_EXCEPTION;
    }
}
