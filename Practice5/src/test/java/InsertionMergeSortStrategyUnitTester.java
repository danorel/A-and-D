import algorithms.merge.InsertionMergeSort;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tools.FileManager;
import tools.StringToIntegerConverter;

public class InsertionMergeSortStrategyUnitTester {
    private static Strategy strategy;

    @BeforeClass
    public static void defineInsertionMergeSortStrategy(){
        strategy = new Strategy();
        strategy.setSortStrategy(new InsertionMergeSort());
    }

    @Test
    public void sort(){
        Assert.assertEquals(StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("output.txt")), strategy.sort(StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("input.txt"))));
    }
}
