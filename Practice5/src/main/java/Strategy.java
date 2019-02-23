import algorithms.*;

import java.util.*;

public class Strategy<T extends Comparable>{
    private ArrayList<SortAbility> sortContainer;
    private SortAbility sortStrategy;

    public T[] sort(T []Array){
        return (T[]) sortStrategy.sort(Array);
    }

    public Strategy setSortStrategy(SortAbility sortStrategy) {
        this.sortStrategy = sortStrategy;
        return this;
    }
}
