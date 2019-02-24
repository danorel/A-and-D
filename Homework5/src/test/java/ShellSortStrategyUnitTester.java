import algorithms.ShellSort;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tools.FileManager;
import tools.StringToIntegerConverter;

public class ShellSortStrategyUnitTester {
    private static Strategy strategy;

    @BeforeClass
    public static void defineShellSortStrategy(){
        strategy = new Strategy();
        strategy.setSortStrategy(new ShellSort());
    }

    @Test
    public void sort(){
        Assert.assertEquals(StringToIntegerConverter.convert(FileManager.readFile("output.txt")), strategy.sort(StringToIntegerConverter.convert(FileManager.readFile("input.txt"))));
    }
}
