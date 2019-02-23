import algorithms.quick.InsertionQuickSort;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tools.FileManager;
import tools.StringToIntegerConverter;

public class InsertionQuickSortStrategyUnitTester {
    private static Strategy strategy;

    @BeforeClass
    public static void defineBubbleSortStrategy(){
        strategy = new Strategy();
        strategy.setSortStrategy(new InsertionQuickSort());
    }

    @Test
    public void sort(){
        Assert.assertEquals(StringToIntegerConverter.convert(FileManager.readFile("output.txt")), strategy.sort(StringToIntegerConverter.convert(FileManager.readFile("input.txt"))));
    }
}
