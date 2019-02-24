import algorithms.quick.MixedQuickSort;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tools.FileManager;
import tools.StringToIntegerConverter;

public class MixedQuickSortStrategyUnitTester {
    private static Strategy strategy;

    @BeforeClass
    public static void defineMixedQuickSortStrategy(){
        strategy = new Strategy();
        strategy.setSortStrategy(new MixedQuickSort());
    }

    @Test
    public void sort(){
        Assert.assertEquals(StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("output.txt")), strategy.sort(StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("input.txt"))));
    }
}
