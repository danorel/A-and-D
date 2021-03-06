import algorithms.quick.DefaultQuickSort;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tools.FileManager;
import tools.StringToIntegerConverter;

public class DefaultQuickSortStrategyUnitTester {
    private static Strategy strategy;

    @BeforeClass
    public static void defineDefaultQuickSortSortStrategy(){
        strategy = new Strategy();
        strategy.setSortStrategy(new DefaultQuickSort());
    }

    @Test
    public void sort(){
        Assert.assertEquals(StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("output.txt")), strategy.sort(StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("input.txt"))));
    }
}
