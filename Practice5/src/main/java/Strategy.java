import algorithms.*;

import java.util.*;

public class Strategy{
    private ArrayList<SortAbility> sortContainer;
    private SortAbility sortStrategy;

    public Integer[] sort(Integer []Array){
        return sortStrategy.sort(Array);
    }

    public Strategy setSortStrategy(SortAbility sortStrategy) {
        this.sortStrategy = sortStrategy;
        return this;
    }
}
