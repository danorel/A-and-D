import file.FileManager;

import java.io.File;
import java.util.*;

public class App {
    public static void main(String[] args) {
        File input = new File("input.txt");
        List<String> list = Arrays.asList(FileManager.readFile(input));
        list
                .forEach(System.out::println);
        File output = new File("output.txt");
        FileManager.writeFile(output, (String[]) list.toArray());
        System.out.println(FileManager.checkIfContains(output, "I love very muuuuuch Olia Perch."));

        Integer [][]pairs = FileManager.getPairsInFile(output, "love");
        for(int row = 0; row < pairs.length; row++){
            System.out.println(pairs[row][0] + "->" + pairs[row][1]);
        }

        FileManager.createSameDescSortedFile(output);
        FileManager.createSameAscSortedFile(output);

        FileManager.substituteFileWith("output.txt", "love", "dear");
    }
}
