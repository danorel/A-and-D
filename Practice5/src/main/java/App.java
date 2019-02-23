import tools.DataGenerator;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Integer[] Array = DataGenerator.generateRandomData(20);
        Arrays.asList(Array)
                .forEach(System.out::println);
    }
}
