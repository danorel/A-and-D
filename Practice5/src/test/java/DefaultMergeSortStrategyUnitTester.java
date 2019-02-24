import algorithms.merge.DefaultMergeSort;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tools.FileManager;
import tools.StringToIntegerConverter;

public class DefaultMergeSortStrategyUnitTester {
    private static Strategy strategy;

    @BeforeClass
    public static void defineDefaultMergeSortStrategy(){
        strategy = new Strategy();
        strategy.setSortStrategy(new DefaultMergeSort());
    }

    @Test
    public void sort(){
        Assert.assertEquals(StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("output.txt")), strategy.sort(StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("input.txt"))));
    }
}
