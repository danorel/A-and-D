import algorithms.BubbleSort;
import tools.FileManager;
import tools.StringToIntegerConverter;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Integer[] Array = StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("input.txt"));
        Arrays.asList(Array)
                .forEach(System.out::println);
        Integer[] SortedArray = StringToIntegerConverter.convertAsIntegerArray(FileManager.readFile("output.txt"));
        System.out.println();
        Arrays.asList(SortedArray)
                .forEach(System.out::println);
        System.out.println();
        Strategy strategy = new Strategy();
        strategy.setSortStrategy(new BubbleSort());
        Array = strategy.sort(Array);
        for(int index = 0; index < Array.length; index++){
            if(!Array[index].equals(SortedArray[index])){
                System.out.println("Failed!");
                break;
            }
        }
    }
}
