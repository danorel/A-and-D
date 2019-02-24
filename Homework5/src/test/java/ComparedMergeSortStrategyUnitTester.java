import algorithms.merge.ComparedMergeSort;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tools.FileManager;
import tools.StringToIntegerConverter;

public class ComparedMergeSortStrategyUnitTester {
    private static Strategy strategy;

    @BeforeClass
    public static void defineComparedMergeSortStrategy(){
        strategy = new Strategy();
        strategy.setSortStrategy(new ComparedMergeSort());
    }

    @Test
    public void sort(){
        Assert.assertEquals(StringToIntegerConverter.convert(FileManager.readFile("output.txt")), strategy.sort(StringToIntegerConverter.convert(FileManager.readFile("input.txt"))));
    }
}

