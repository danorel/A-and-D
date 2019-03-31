package graph;

import graph.exceptions.GraphAdjacencyException;
import graph.exceptions.GraphInitException;
import list.DoublyLinkedList;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class Graph<T extends Integer> {
    private static final Logger LOGGER = Logger.getLogger(Graph.class);

    // Graph vertices structure built by the doubly-l-l
    private DoublyLinkedList<Vertex> vertices;

    // Graph parameters
    private int width       = 0;
    private int height      = 0;
    private int[][] matrix  = null;
    private String type     = null;
    private enum Type { INCIDENCE, ADJACENCY }

    public Graph(int [][] matrix, int width, int height, String type) throws GraphAdjacencyException, GraphInitException, NoSuchMethodException {
        if(width == 0 || height == 0){
            LOGGER.error(GraphInitException.getErrorMessage());
            throw new GraphInitException(Graph.class.getConstructor(int[][].class, int.class, int.class, String.class));
        } else {
            if(type.equals(Type.ADJACENCY.name())){
                if(width != height){
                    LOGGER.error(GraphAdjacencyException.getErrorMessage());
                    throw new GraphAdjacencyException(Graph.class.getConstructor(int[][].class, int.class, int.class, String.class));
                } else {
                    LOGGER.info("The input data is correct! The both parameters are valid. Ready to build the graph by " + Type.ADJACENCY.name() + " matrix.");
                    vertices = new DoublyLinkedList<>();
                    this.type = type;
                    this.matrix = matrix;
                    this.width = width;
                    this.height = height;
                }
            } else if(type.equals(Type.INCIDENCE.name())){
                LOGGER.info("The input data is correct! The both parameters are valid. Ready to build the graph by " + Type.INCIDENCE.name() + " matrix.");
                vertices = new DoublyLinkedList<>();
                this.type = type;
                this.matrix = matrix;
                this.width = width;
                this.height = height;
            }
        }
    }

    public void construct(){
        // Init of the graph is the same for both matrices
        init();
        if(this.type.equals(Type.INCIDENCE.name())){
            for(int outer = 0; outer < height; outer++){
                int []row = this.matrix[outer];
                for(int inner = 0; inner < width; inner++){
                    if(row[inner] == 1){
                        for(int down = 0; down < height; down++){
                            if(matrix[down][inner] == 1 && outer != down){
                                ((Vertex) vertices.get(outer)).neighbours.add((Vertex) vertices.get(down));
                            }
                        }
                    }
                }
            }
            LOGGER.info("The graph was built successfully by the INCIDENCE matrix!");
        } else if(this.type.equals(Type.ADJACENCY.name())){
            for (int outer = 0; outer < height; outer++){
                for(int inner = 0; inner < width; inner++){
                    if(this.matrix[inner][outer] >= 1 && inner != outer){
                        ((Vertex) vertices.get(outer)).neighbours.add((Vertex) vertices.get(inner));
                    }
                }
            }
            LOGGER.info("The graph was built successfully by the ADJACENCY matrix!");
        }
    }

    private void init(){
        for(int index = 0; index < height; index++){
            Vertex vertex = new Vertex(String.valueOf(index + 1));
            vertices.add(vertex);
        }
    }

    @Override
    public String toString() {
        return vertices.toString();
    }

    public static class Builder {
        // default parameters of the incoming matrix
        private int width       = 0;
        private int height      = 0;
        private String type     = "ADJACENCY";
        private int [][]matrix  = null;

        public Builder(int width, int height){
            this.width = width;
            this.height = height;
            matrix = new int[width][height];
        }

        public Builder buildIncidence(int [][]matrix) throws NoSuchMethodException {
            for(int row = 0; row < this.height; row++){
                this.matrix[row] = Arrays.copyOf(matrix[row], this.width);
            }
            String method = Builder.class
                    .getMethod("buildIncidence", int[][].class)
                    .getName();
            this.type = method
                    .substring(method.indexOf('I'))
                    .toUpperCase();
            return this;
        }

        public Builder buildAdjacency(int [][]matrix) throws NoSuchMethodException {
            for(int row = 0; row < this.height; row++){
                this.matrix[row] = Arrays.copyOf(matrix[row], this.width);
            }

            String method = Builder.class
                    .getMethod("buildAdjacency", int[][].class)
                    .getName();
            this.type = method
                    .substring(method.indexOf('A'))
                    .toUpperCase();
            return this;
        }

        public Graph<Integer> build() throws GraphAdjacencyException, GraphInitException, NoSuchMethodException {
            return new Graph<>(matrix, width, height, type);
        }
    }

    private class Vertex implements Comparable<Vertex> {
        DoublyLinkedList<Vertex> neighbours;
        private String name;

        public Vertex(String name){
            neighbours = new DoublyLinkedList<>();
            this.name = name;
        }

        @Override
        public int compareTo(Vertex vertex) {
            return this.neighbours.size() - vertex.neighbours.size();
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Vertex[").append(name).append("]");
            builder.append(": ");
            for(int index = 0; index < neighbours.size(); index++){
                builder.append(((Vertex) neighbours.get(index)).name).append(" ");
            }
            return builder.toString();
        }
    }
}
