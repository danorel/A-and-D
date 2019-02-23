package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public interface FileManager {
    static String readFile(String src){
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
            String line;
            while((line = bufferedReader.readLine()) != null){
                content.append(line).append("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return Objects.requireNonNull(content).toString();
    }
}
