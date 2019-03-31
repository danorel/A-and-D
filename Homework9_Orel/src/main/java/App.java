import graph.Graph;

public class App {
    public static void main(String[] args) {
        int [][] matrix = {
                {1, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
        };
        Graph<Integer> graph = new Graph<>(matrix);
        System.out.println(graph);
    }
}
