package sorters;

import java.util.Comparator;

public class Sorter<T extends Comparable> {
    private Sort currentSortStrategy;
    private T[] Array;

    public Sorter setCurrentSortStrategy(Sort currentSortStrategy) {
        this.currentSortStrategy = currentSortStrategy;
        return this;
    }

    public Sorter sort(){
        currentSortStrategy.sort(Array);
        return this;
    }

    public Sorter sort(Comparator comparator){
        currentSortStrategy.sort(Array, comparator);
        return this;
    }

    public Sorter sort(Comparator comparator, String order){
        currentSortStrategy.sort(Array, comparator, order);
        return this;
    }

    public Sorter setArray(T[] array) {
        Array = array;
        return this;
    }

    public void showArray(){
        for(T element : Array){
            System.out.println(element);
        }
    }
}
