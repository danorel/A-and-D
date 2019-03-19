package lists.exceptions;

import java.lang.reflect.Method;

public class EmptyStackException extends Exception {
    private static final String EMPTY_STACK = "There is no element in stack ";

    public EmptyStackException(Method method){
        super(EMPTY_STACK + "(the problem in method " + method.getName()
        + ")");
    }
}
