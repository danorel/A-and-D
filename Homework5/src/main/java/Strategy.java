import algorithms.SortAbility;

import java.util.ArrayList;
import java.util.Comparator;

public class Strategy<T extends Comparable>{
    private Comparator comparator;
    private SortAbility sortStrategy;

    public T[] sort(T []Array){
        return (T[]) sortStrategy.sort(Array);
    }

    public T[] sort(T []Array, Comparator comparator) {
        return (T []) sortStrategy.sort(Array, comparator);
    }

    public Strategy setSortComparator(Comparator comparator){
        this.comparator = comparator;
        return this;
    }

    public Strategy setSortStrategy(SortAbility sortStrategy) {
        this.sortStrategy = sortStrategy;
        return this;
    }

    public Comparator getComparator() {
        return comparator;
    }

    public SortAbility getSortStrategy(){
        return sortStrategy;
    }
}
