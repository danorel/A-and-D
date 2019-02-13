import data.DataGenerator;
import file.FileManager;
import strategy.Strategy;

public class App {
    public static void main(String[] args) {
        /*
            Randomly generated data (used class DataGenerator)
         */
        // Testing the array with 32768 elements
        FileManager.createFile("random/data-32768.txt");
        FileManager.createFile("random/results-32768.txt");
        final Integer []RandomArray32768 = DataGenerator.generateRandomData(32768);
        Strategy<Integer> strategy = new Strategy<>();
        FileManager.writeFile("random/data-32768.txt", strategy.getAlgorithmsRuntimeData(RandomArray32768));
        FileManager.writeFile("random/results-32768.txt", strategy.getAlgorithmsRuntimeTable(RandomArray32768));
        // Testing the array with 16384 elements
        FileManager.createFile("random/data-16384.txt");
        FileManager.createFile("random/results-16384.txt");
        final Integer []RandomArray16384 = DataGenerator.generateRandomData(16384);
        FileManager.writeFile("random/data-16384.txt", strategy.getAlgorithmsRuntimeData(RandomArray16384));
        FileManager.writeFile("random/results-16384.txt", strategy.getAlgorithmsRuntimeTable(RandomArray16384));
        // Testing the array with 8192 elements
        FileManager.createFile("random/data-8192.txt");
        FileManager.createFile("random/results-8192.txt");
        final Integer []RandomArray8192 = DataGenerator.generateRandomData(8192);
        FileManager.writeFile("random/data-8192.txt", strategy.getAlgorithmsRuntimeData(RandomArray8192));
        FileManager.writeFile("random/results-8192.txt", strategy.getAlgorithmsRuntimeTable(RandomArray8192));
        // Testing the array with 4096 elements
        FileManager.createFile("random/data-4096.txt");
        FileManager.createFile("random/results-4096.txt");
        final Integer []RandomArray4096 = DataGenerator.generateRandomData(4096);
        FileManager.writeFile("random/data-4096.txt", strategy.getAlgorithmsRuntimeData(RandomArray4096));
        FileManager.writeFile("random/results-4096.txt", strategy.getAlgorithmsRuntimeTable(RandomArray4096));
        // Testing the array with 2048 elements
        FileManager.createFile("random/data-2048.txt");
        FileManager.createFile("random/results-2048.txt");
        final Integer []RandomArray2048 = DataGenerator.generateRandomData(2048);
        FileManager.writeFile("random/data-2048.txt", strategy.getAlgorithmsRuntimeData(RandomArray2048));
        FileManager.writeFile("random/results-2048.txt", strategy.getAlgorithmsRuntimeTable(RandomArray2048));
        // Testing the array with 2048 elements
        FileManager.createFile("random/data-1024.txt");
        FileManager.createFile("random/results-1024.txt");
        final Integer []RandomArray1024 = DataGenerator.generateRandomData(1024);
        FileManager.writeFile("random/data-1024.txt", strategy.getAlgorithmsRuntimeData(RandomArray1024));
        FileManager.writeFile("random/results-1024.txt", strategy.getAlgorithmsRuntimeTable(RandomArray1024));
        /*
            Fully-sorted data
         */
        // Testing the array with 32768 elements
        FileManager.createFile("sorted/data-32768.txt");
        FileManager.createFile("sorted/results-32768.txt");
        final Integer []SortedArray32768 = DataGenerator.generateRandomData(32768);
        FileManager.writeFile("sorted/data-32768.txt", strategy.getAlgorithmsRuntimeData(SortedArray32768));
        FileManager.writeFile("sorted/results-32768.txt", strategy.getAlgorithmsRuntimeTable(SortedArray32768));
        // Testing the array with 16384 elements
        FileManager.createFile("sorted/data-16384.txt");
        FileManager.createFile("sorted/results-16384.txt");
        final Integer []SortedArray16384 = DataGenerator.generateRandomData(16384);
        FileManager.writeFile("sorted/data-16384.txt", strategy.getAlgorithmsRuntimeData(SortedArray16384));
        FileManager.writeFile("sorted/results-16384.txt", strategy.getAlgorithmsRuntimeTable(SortedArray16384));
        // Testing the array with 8192 elements
        FileManager.createFile("sorted/data-8192.txt");
        FileManager.createFile("sorted/results-8192.txt");
        final Integer []SortedArray8192 = DataGenerator.generateRandomData(8192);
        FileManager.writeFile("sorted/data-8192.txt", strategy.getAlgorithmsRuntimeData(SortedArray8192));
        FileManager.writeFile("sorted/results-8192.txt", strategy.getAlgorithmsRuntimeTable(SortedArray8192));
        // Testing the array with 4096 elements
        FileManager.createFile("sorted/data-4096.txt");
        FileManager.createFile("sorted/results-4096.txt");
        final Integer []SortedArray4096 = DataGenerator.generateRandomData(4096);
        FileManager.writeFile("sorted/data-4096.txt", strategy.getAlgorithmsRuntimeData(SortedArray4096));
        FileManager.writeFile("sorted/results-4096.txt", strategy.getAlgorithmsRuntimeTable(SortedArray4096));
        // Testing the array with 2048 elements
        FileManager.createFile("sorted/data-2048.txt");
        FileManager.createFile("sorted/results-2048.txt");
        final Integer []SortedArray2048 = DataGenerator.generateRandomData(2048);
        FileManager.writeFile("sorted/data-2048.txt", strategy.getAlgorithmsRuntimeData(SortedArray2048));
        FileManager.writeFile("sorted/results-2048.txt", strategy.getAlgorithmsRuntimeTable(SortedArray2048));
        // Testing the array with 2048 elements
        FileManager.createFile("sorted/data-1024.txt");
        FileManager.createFile("sorted/results-1024.txt");
        final Integer []SortedArray1024 = DataGenerator.generateRandomData(1024);
        FileManager.writeFile("sorted/data-1024.txt", strategy.getAlgorithmsRuntimeData(SortedArray1024));
        FileManager.writeFile("sorted/results-1024.txt", strategy.getAlgorithmsRuntimeTable(SortedArray1024));
        /*
            Fully-unsorted data
         */
        // Testing the array with 32768 elements
        FileManager.createFile("unsorted/data-32768.txt");
        FileManager.createFile("unsorted/results-32768.txt");
        final Integer []UnsortedArray32768 = DataGenerator.generateRandomData(32768);
        FileManager.writeFile("unsorted/data-32768.txt", strategy.getAlgorithmsRuntimeData(UnsortedArray32768));
        FileManager.writeFile("unsorted/results-32768.txt", strategy.getAlgorithmsRuntimeTable(UnsortedArray32768));
        // Testing the array with 16384 elements
        FileManager.createFile("unsorted/data-16384.txt");
        FileManager.createFile("unsorted/results-16384.txt");
        final Integer []UnsortedArray16384 = DataGenerator.generateRandomData(16384);
        FileManager.writeFile("unsorted/data-16384.txt", strategy.getAlgorithmsRuntimeData(UnsortedArray16384));
        FileManager.writeFile("unsorted/results-16384.txt", strategy.getAlgorithmsRuntimeTable(UnsortedArray16384));
        // Testing the array with 8192 elements
        FileManager.createFile("unsorted/data-8192.txt");
        FileManager.createFile("unsorted/results-8192.txt");
        final Integer []UnsortedArray8192 = DataGenerator.generateRandomData(8192);
        FileManager.writeFile("unsorted/data-8192.txt", strategy.getAlgorithmsRuntimeData(UnsortedArray8192));
        FileManager.writeFile("unsorted/results-8192.txt", strategy.getAlgorithmsRuntimeTable(UnsortedArray8192));
        // Testing the array with 4096 elements
        FileManager.createFile("unsorted/data-4096.txt");
        FileManager.createFile("unsorted/results-4096.txt");
        final Integer []UnsortedArray4096 = DataGenerator.generateRandomData(4096);
        FileManager.writeFile("unsorted/data-4096.txt", strategy.getAlgorithmsRuntimeData(UnsortedArray4096));
        FileManager.writeFile("unsorted/results-4096.txt", strategy.getAlgorithmsRuntimeTable(UnsortedArray4096));
        // Testing the array with 2048 elements
        FileManager.createFile("unsorted/data-2048.txt");
        FileManager.createFile("unsorted/results-2048.txt");
        final Integer []UnsortedArray2048 = DataGenerator.generateRandomData(2048);
        FileManager.writeFile("unsorted/data-2048.txt", strategy.getAlgorithmsRuntimeData(UnsortedArray2048));
        FileManager.writeFile("unsorted/results-2048.txt", strategy.getAlgorithmsRuntimeTable(UnsortedArray2048));
        // Testing the array with 2048 elements
        FileManager.createFile("unsorted/data-1024.txt");
        FileManager.createFile("unsorted/results-1024.txt");
        final Integer []UnsortedArray1024 = DataGenerator.generateRandomData(1024);
        FileManager.writeFile("unsorted/data-1024.txt", strategy.getAlgorithmsRuntimeData(UnsortedArray1024));
        FileManager.writeFile("unsorted/results-1024.txt", strategy.getAlgorithmsRuntimeTable(UnsortedArray1024));
    }
}