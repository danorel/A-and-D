import algorithms.*;
import algorithms.merge.ComparedMergeSort;
import algorithms.merge.DefaultMergeSort;
import algorithms.merge.InsertionMergeSort;
import algorithms.merge.MixedMergeSort;
import algorithms.quick.DefaultQuickSort;
import algorithms.quick.DijkstraQuickSort;
import algorithms.quick.InsertionQuickSort;
import algorithms.quick.MixedQuickSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tools.StringToIntegerConverter;

import java.util.ArrayList;

public class StrategyUnitTester {
    private Strategy strategy;
    private ArrayList<SortAbility> sortStrategy;
    /*
        Creating the two types of array:
        - Array with 0 elements
        - Filled Array with some values
     */
    private Integer [] Array0 = {};
    private Integer [] Array6 = {
            6, 4, 0, -3, 11, 2
    };
    private Integer [] Array20 = {
            7, 14, 95, 73, 69, 28, 87, 59, 31, 88,
            50, 9, 13, 13, 64, 79, 54, 96, 28, 67
    };

    @Before
    public void setUp() throws Exception {
        /*
            The library of all the sorting algorithms
         */
        sortStrategy = new ArrayList<>();
        sortStrategy.add(new BubbleSort());
        sortStrategy.add(new CombSort());
        sortStrategy.add(new HeapSort());
        sortStrategy.add(new InsertionSort());
        sortStrategy.add(new SelectionSort());
        sortStrategy.add(new ShellSort());
        sortStrategy.add(new DefaultQuickSort());
        sortStrategy.add(new DijkstraQuickSort());
        sortStrategy.add(new InsertionQuickSort());
        sortStrategy.add(new MixedQuickSort());
        sortStrategy.add(new ComparedMergeSort());
        sortStrategy.add(new DefaultMergeSort());
        sortStrategy.add(new InsertionMergeSort());
        sortStrategy.add(new MixedMergeSort());

        strategy = new Strategy();
    }

    @Test
    public void sort() {
        for(SortAbility sort : sortStrategy){
            strategy.setSortStrategy(sort);
            Assert.assertEquals(StringToIntegerConverter.convertAsIntegerArray("-3 0 2 4 6 11"), strategy.sort(Array6));
            Assert.assertEquals(StringToIntegerConverter.convertAsIntegerArray(" "), strategy.sort(Array0));
            Assert.assertEquals(StringToIntegerConverter.convertAsIntegerArray("7 9 13 13 14 28 28 31 50 54 59 64 67 69 73 79 87 88 95 96"), strategy.sort(Array20));
        }
    }

    @Test
    public void setSortStrategy() {
        for(SortAbility sort : sortStrategy){
            strategy.setSortStrategy(sort);
        }
    }
}