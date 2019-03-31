import lists.exceptions.EmptyStackException;
import stack.Stack;

public class App {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Is stack empty? Result: " + stack.empty());
        System.out.println("Adding the element " + stack.push(14));
        System.out.println("Adding the element " + stack.push(10));
        try {
            System.out.println("Popping the element: " + stack.pop());
        } catch (EmptyStackException | NoSuchMethodException exception){
            exception.printStackTrace();
        }
        System.out.println("Stack: " + stack);
        System.out.println("Adding the element " + stack.push(5));
        System.out.println("Adding the element " + stack.push(11));
        System.out.println("Adding the element " + stack.push(16));
        System.out.println("Stack: " + stack);
        try {
            System.out.println("Stack peek: " + stack.peek());
        } catch (EmptyStackException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }
        try {
            System.out.println("Popping the stack element " + stack.pop());
        } catch (EmptyStackException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }
        System.out.println("Stack after popping func: " + stack);
        try {
            System.out.println("Stack position of number 16 is: " + stack.search(16));
        } catch (EmptyStackException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }
        System.out.println("Is stack empty? Result: " + stack.empty());
        stack.nullify();
        System.out.println("Stack after nullify: " + stack);
        System.out.println("Is stack empty? Result: " + stack.empty());
        try {
            System.out.println("Stack peek: " + stack.peek());
        } catch (EmptyStackException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }
    }
}
