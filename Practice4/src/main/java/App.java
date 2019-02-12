import data.DataGenerator;
import file.FileManager;
import strategy.Strategy;

public class App {
    public static void main(String[] args) {
        FileManager.createFile("data/data.txt");
        final Integer []Array = DataGenerator.generate(1024);
        Strategy<Integer> strategy = new Strategy<>();
        strategy.testAlgorithms(Array, "data/data.txt");
        strategy.getResults("data/data.txt").forEach(System.out::println);
    }
}
