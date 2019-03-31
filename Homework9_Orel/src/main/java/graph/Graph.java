package graph;

import list.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graph<T extends Integer> {
    private DoublyLinkedList<DoublyLinkedList<T>> list;
    private DoublyLinkedList row;
    private int height, width;
    private Map<Integer, Integer> vertexes;

    public Graph(int [][] matrix){
        vertexes = new HashMap<>();
        list = new DoublyLinkedList<>();
        width = matrix[0].length;
        height = matrix.length;
        for(int [] row : matrix){
            this.row = new DoublyLinkedList();
            for(int value : row){
                this.row.add(value);
            }
            this.list.add(this.row);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int index = 0; index < height; index++){
            for(int outer = 0; outer < height; outer++){
                row = (DoublyLinkedList) list.get(outer);
                if(row.get(outer).equals(1)){
                    for(int inner = 0; inner < height; inner++){
                        DoublyLinkedList<Integer> nextRow = (DoublyLinkedList<Integer>) list.get(inner);
                        if(nextRow != row && !(inner >= height) && nextRow.get(outer).equals(row.get(outer)) ){
                            vertexes.put(index, inner + 1);
                        }
                    }
                }
            }
        }
        for(int vertex = 1; vertex < list.size(); vertex++){
            builder.append("Vertex ").append(vertex).append(" has neighbours: ");
            for(int index = 0; index < vertexes.size(); index++){
                if(vertexes.get(index).equals(vertex)){
                    builder.append(vertexes.get(index)).append(" ");
                }
            }
            builder.append("\n");
        }
        Set<Integer> keys = vertexes.keySet();
        for(int vertex = 1; vertex < list.size(); vertex++){
            builder.append("Vertex ").append(vertex).append(" has neighbours: ");
            for(Integer key : keys){
                if(key.equals(vertex)){
                    builder.append(key);
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
