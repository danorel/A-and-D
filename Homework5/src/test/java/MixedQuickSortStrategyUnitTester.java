import algorithms.HeapSort;
import algorithms.quick.MixedQuickSort;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MixedQuickSortStrategyUnitTester {
    private static Strategy strategy;
    private Integer [] Array0 = {};
    private Integer [] Array6 = {
            6, 4, 0, -3, 11, 2
    };
    private Integer [] Array20 = {
            7, 14, 95, 73, 69, 28, 87, 59, 31, 88,
            50, 9, 13, 13, 64, 79, 54, 96, 28, 67
    };

    @BeforeClass
    public static void defineMixedQuickSortStrategy(){
        strategy = new Strategy();
        strategy.setSortStrategy(new MixedQuickSort());
    }

    @Test
    public void sort(){
        Strategy defaultStrategy = new Strategy();
        defaultStrategy.setSortStrategy(new HeapSort());
        Assert.assertEquals(defaultStrategy.sortArray(Array0), strategy.sortArray(Array0));
        Assert.assertEquals(defaultStrategy.sortArray(Array6), strategy.sortArray(Array6));
        Assert.assertEquals(defaultStrategy.sortArray(Array20), strategy.sortArray(Array20));
    }
}
