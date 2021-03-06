import algorithms.InsertionSort;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tools.FileManager;
import tools.StringToIntegerConverter;

public class InsertionSortStrategyUnitTester {
    private static Strategy strategy;

    @BeforeClass
    public static void defineInsertionSortStrategy(){
        strategy = new Strategy();
        strategy.setSortStrategy(new InsertionSort());
    }

    @Test
    public void sort(){
        Assert.assertEquals(StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("output.txt")), strategy.sort(StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("input.txt"))));
    }
}
