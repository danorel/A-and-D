import algorithms.BubbleSort;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleSortStrategyUnitTester {
    private Strategy strategy;

    @BeforeClass
    public void defineBubbleSortStrategy(){
        strategy = new Strategy();
        strategy.setSortStrategy(new BubbleSort());
    }

    @Test
    public void sort(Comparable[] Array){
        System.out.println(strategy.getAlgorithmsRuntimeTable(Array));
    }

}
