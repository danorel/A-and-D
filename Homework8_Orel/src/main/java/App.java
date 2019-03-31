import lists.exceptions.IllegalStateException;
import lists.exceptions.NoSuchElementException;
import lists.exceptions.NullPointerException;
import queue.Queue;

import java.lang.reflect.Field;
import java.util.EmptyStackException;

public class App {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(10, true);
        System.out.println(queue);
        System.out.println("Is queue empty? Result: " + queue.empty());
        try {
            System.out.println("Adding the element? Result: " + queue.add(14));
            System.out.println("Offering the element? Result: " + queue.offer(10));
        } catch (NullPointerException | IllegalStateException exception) {
            exception.printStackTrace();
        }
        try {
            System.out.println("Polling the element: " + queue.poll());
        } catch (EmptyStackException exception){
            exception.printStackTrace();
        }
        System.out.println("Queue: " + queue);
        try {
            System.out.println("Adding the element? Result: " + queue.add(5));
            System.out.println("Offering the element? Result: " + queue.offer(11));
            System.out.println("Offering the element? Result: " + queue.offer(16));
        } catch (NullPointerException | IllegalStateException exception) {
            exception.printStackTrace();
        }
        System.out.println("Queue: " + queue);
        try {
            System.out.println("Queue peek: " + queue.peek());
        } catch (EmptyStackException exception) {
            exception.printStackTrace();
        }
        try {
            System.out.println("Popping the queue element " + queue.element());
        } catch (EmptyStackException | NoSuchMethodException | NoSuchElementException exception) {
            exception.printStackTrace();
        }
        System.out.println("Queue after popping func: " + queue);
        try {
            System.out.println("Queue position of number 16 is: " + queue.search(16));
        } catch (EmptyStackException | NoSuchMethodException | NoSuchElementException exception) {
            exception.printStackTrace();
        }
        System.out.println("Is queue empty? Result: " + queue.empty());
        queue.nullify();
        System.out.println("Queue after nullify: " + queue);
        try {
            System.out.println("Trying to get the peek: " + queue.element());
        } catch (NoSuchElementException | NoSuchMethodException exception ) {
            exception.printStackTrace();
        }
    }
}
