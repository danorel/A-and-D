package file;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface FileManager {

    static String readFile(String src){
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(src));
            String line = null;
            while((line = reader.readLine()) != null){
                result.append(line).append("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return result.toString();
    }

    static void writeFile(String src, String content){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(src));
            writer.write(content);
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static void createFile(String src){
        List<String> path = Arrays.asList(src.split("[/]"));
        StringBuilder rest = new StringBuilder();
        for (String token : path) {
            if (token.equals(path.get(path.size() - 1))) {
                File directory = new File(String.valueOf(rest));
                directory.mkdir();
                File file = new File(rest + "/" + token);
                try {
                    file.createNewFile();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            } else {
                rest.append(token).append("/");
            }
        }
    }
}
