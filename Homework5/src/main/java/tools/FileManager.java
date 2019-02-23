package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/*
    The main purpose of this class is to read the content
    (in such case - the string numbers in the file) and return
    the whole content as string
 */

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
