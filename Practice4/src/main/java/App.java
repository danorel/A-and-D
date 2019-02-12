import data.DataGenerator;
import file.FileManager;
import strategy.Strategy;

public class App {
    public static void main(String[] args) {
        FileManager.createFile("data/data.txt");
        FileManager.createFile("data/results.txt");
        final Integer []Array = DataGenerator.generate(1024);
        Strategy<Integer> strategy = new Strategy<>();
        FileManager.writeFile("data/data.txt", strategy.getAlgorithmsRuntimeData(Array));
        FileManager.writeFile("data/results.txt", strategy.getAlgorithmsRuntimeTable(Array));
    }
}
