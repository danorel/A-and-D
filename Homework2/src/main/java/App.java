public class App {
    public static void main(String[] args) {
        Integer []ints = {5, 4, -5, 15, -1, 0};
        Sorter<Integer> sorter = new Sorter<Integer>();
        sorter.setArray(ints);
        sorter.ShellSort();
        sorter.showArray();
    }
}
