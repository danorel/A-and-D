import heap.BinaryHeap;

public class App {
    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>(false);
        System.out.println("Is current peak empty? Answer: " + heap.isEmpty());
        heap.add(4);
        heap.add(10);
        heap.add(3);
        heap.add(5);
        heap.add(11);
        heap.build();
        System.out.print(heap);
        System.out.println("The size of the heap: " + heap.size());
        System.out.println("Removing the element: " + heap.remove());
        System.out.print(heap);
        System.out.println("The current peak of the heap: " + heap.peek());
        System.out.println("Is current peak empty? Answer: " + heap.isEmpty());
        System.out.println("Is the heap contain element 12? Answer: " + heap.contains(12));
        System.out.println("Is the heap contain element 11? Answer: " + heap.contains(11));
        System.out.println("Heap size after deleting the element: " + heap.size());
    }
}
