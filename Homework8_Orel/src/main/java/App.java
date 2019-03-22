import lists.exceptions.IllegalStateException;
import lists.exceptions.NoSuchElementException;
import lists.exceptions.NullPointerException;
import queue.Queue;

import java.lang.reflect.Field;

public class App {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(10, true);

        System.out.println(queue);

        try {
            queue.add(6);
            queue.add(1);
            queue.add(3);
            queue.add(2);
            queue.add(4);
            queue.add(7);
            queue.add(8);
            System.out.println(queue);
            System.out.println(queue.search(3));
            queue.poll();
            System.out.println(queue);
        } catch (NullPointerException | IllegalStateException | NoSuchMethodException | NoSuchElementException exception) {
            exception.printStackTrace();
        }
    }
}
