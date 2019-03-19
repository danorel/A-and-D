import lists.exceptions.EmptyStackException;
import stack.Stack;

public class App {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
//        try {
//            stack.pop();
//        } catch (EmptyStackException | NoSuchMethodException exception) {
//            exception.printStackTrace();
//        }
        stack.push(11);
        stack.push(16);
        stack.nullify();
//        try {
//            stack.peek();
//        } catch (EmptyStackException | NoSuchMethodException exception) {
//            exception.printStackTrace();
//        }
        System.out.println(stack.empty());
        try {
            System.out.println(stack.search(5));
        } catch (EmptyStackException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }
        System.out.println(stack);

    }
}
