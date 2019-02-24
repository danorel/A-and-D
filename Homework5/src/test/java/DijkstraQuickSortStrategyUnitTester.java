import algorithms.quick.DijkstraQuickSort;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tools.FileManager;
import tools.StringToIntegerConverter;

public class DijkstraQuickSortStrategyUnitTester {
    private static Strategy strategy;

    @BeforeClass
    public static void defineDijkstraQuickSortStrategy(){
        strategy = new Strategy();
        strategy.setSortStrategy(new DijkstraQuickSort());
    }

    @Test
    public void sort(){
        Assert.assertEquals(StringToIntegerConverter.convert(FileManager.readFile("output.txt")), strategy.sort(StringToIntegerConverter.convert(FileManager.readFile("input.txt"))));
    }
}
