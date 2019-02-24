import algorithms.quick.InsertionQuickSort;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tools.FileManager;
import tools.StringToIntegerConverter;

public class InsertionQuickSortStrategyUnitTester {
    private static Strategy strategy;

    @BeforeClass
    public static void defineInsertionQuickSortStrategy(){
        strategy = new Strategy();
        strategy.setSortStrategy(new InsertionQuickSort());
    }

    @Test
    public void sort(){
        Assert.assertEquals(StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("output.txt")), strategy.sort(StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("input.txt"))));
    }
}
