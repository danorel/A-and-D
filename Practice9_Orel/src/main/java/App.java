import graph.Graph;
import graph.exceptions.GraphAdjacencyException;
import graph.exceptions.GraphInitException;

public class App {
    public static void main(String[] args) {
        /*
            Building the graph by the ADJACENCY matrix
         */
        /*
        int [][] matrix = {
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0}
        };
        try {
            Graph<Integer> graph = new Graph.Builder(matrix[0].length, matrix.length)
                    .buildAdjacency(matrix)
                    .build();
            graph.construct();
            System.out.println(graph);
        } catch (GraphAdjacencyException | NoSuchMethodException | GraphInitException exception) {
            exception.printStackTrace();
        }
        */

        /*
            Building the graph by the INCIDENCE matrix
         */
        /*
        int [][] matrix = {
                {1, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1}
        };
        try {
            Graph<Integer> graph = new Graph.Builder(matrix[0].length, matrix.length)
                    .buildIncidence(matrix)
                    .build();
            graph.construct();
            System.out.println(graph);
        } catch (GraphAdjacencyException | NoSuchMethodException | GraphInitException exception) {
            exception.printStackTrace();
        }
        */

        /*
            Building the graph by the null matrix with help of Adjacency matrix
        */
        /*
        int [][] matrix = {

        };
        try {
            Graph<Integer> graph = new Graph.Builder(0, matrix.length)
                    .buildAdjacency(matrix)
                    .build();
            graph.construct();
            System.out.println(graph);
        } catch (GraphAdjacencyException | NoSuchMethodException | GraphInitException exception) {
            exception.printStackTrace();
        }
        */

        /*
            Building the graph by the null matrix with help of Incidence matrix
         */
        /*
        int [][] matrix = {

        };
        try {
            Graph<Integer> graph = new Graph.Builder(0, matrix.length)
                    .buildIncidence(matrix)
                    .build();
            graph.construct();
            System.out.println(graph);
        } catch (GraphAdjacencyException | NoSuchMethodException | GraphInitException exception) {
            exception.printStackTrace();
        }
        */
    }
}
