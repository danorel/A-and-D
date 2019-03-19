package lists.exceptions;

import java.lang.reflect.Method;

public class NoSuchElementException extends Exception {
    private static final String EMPTY_QUEUE = "The queue is empty, there are no elements in it! ";
    
    public NoSuchElementException(Method method){
        super(EMPTY_QUEUE + "(the problem in method " + method.getName()
        + ")");
    }
}
