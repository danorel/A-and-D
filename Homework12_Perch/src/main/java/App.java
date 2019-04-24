import heap.BinaryHeap;

public class App {
    public static void main(String[] args) {
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(false);
        System.out.println("Чи є порожньою купа? " + binaryHeap.isEmpty());
        binaryHeap.add(4);
        binaryHeap.add(10);
        binaryHeap.add(3);
        binaryHeap.add(5);
        binaryHeap.add(11);
        binaryHeap.generate();
        System.out.print(binaryHeap);
        System.out.println("Нинішній розмір купи: " + binaryHeap.size());
        System.out.println("Видалення елементу: " + binaryHeap.remove());
        System.out.print(binaryHeap);
        System.out.println("Нинішня вершина купи: " + binaryHeap.peek());
        System.out.println("Чи є порожньою купа? " + binaryHeap.isEmpty());
        System.out.println("Чи містить купа елемент 12? " + binaryHeap.contains(12));
        System.out.println("Чи містить купа елемент 11? " + binaryHeap.contains(11));
        System.out.println("Розмір купи після видалення елементу: " + binaryHeap.size());
    }
}
