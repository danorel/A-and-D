import algorithms.HeapSort;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tools.FileManager;
import tools.StringToIntegerConverter;

public class HeapSortStrategyUnitTester {
    private static Strategy strategy;

    @BeforeClass
    public static void defineBubbleSortStrategy(){
        strategy = new Strategy();
        strategy.setSortStrategy(new HeapSort());
    }

    @Test
    public void sort(){
        Assert.assertEquals(StringToIntegerConverter.convert(FileManager.readFile("output.txt")), strategy.sort(StringToIntegerConverter.convert(FileManager.readFile("input.txt"))));
    }
}