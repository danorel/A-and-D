package file;

import algorithm.MergeSort;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public interface FileManager {
    static String[] readFile(File file){
        StringBuilder content = new StringBuilder();
        if(file.canRead()){
            try {
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(file.getAbsolutePath())
                        );
                String line;
                while((line = reader.readLine()) != null){
                    content.append(line).append("\n");
                }
                reader.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        String []text = (content.toString()).split("\n");
        return text;
    }

    static boolean writeFile(File file, String[] text){
        boolean isValid = false;
        if(file.canWrite()){
            try {
                BufferedWriter writer =
                        new BufferedWriter(
                                new FileWriter(file.getAbsolutePath())
                        );
                for(String line : text){
                    writer.write(line + "\n");
                }
                writer.close();
                isValid = true;
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return isValid;
    }

    static boolean checkIfContains(File file, String line){
        boolean contains = false;
        if(file.canRead()){
            try {
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(file.getAbsolutePath())
                        );
                String currentLine;
                while((currentLine = reader.readLine()) != null){
                    if(currentLine.equals(line)){
                        contains = true;
                        break;
                    }
                }
                reader.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return contains;
    }

    static Integer[][] getPairsInFile(File file, String substring){
        Integer [][]pairs = null;
        int index = 0;
        if(file.canRead()){
            List<String> lines = Arrays.asList(readFile(file));
            /*
                Before allocation of the memory to our array,
                we should know how many words will be seen
                throw our file content.
             */
            int substringCounter = 0;
            for(int line = 0; line < lines.size(); line++){
                String []content = lines.get(line).split(" ");
                for(int word = 0; word < content.length; word++){
                    if(content[word].equals(substring)){
                        substringCounter++;
                    }
                }
            }
            pairs = new Integer[substringCounter][2];
            for(int outer = 0; outer < lines.size(); outer++){
                if(lines.get(outer).contains(substring)){
                    String []substrings = lines.get(outer).split("[,. ]");
                    for(int inner = 0; inner < substrings.length; inner++){
                        if(substrings[inner].equals(substring)){
                            pairs[index][0] = (outer + 1);
                            pairs[index][1] = (inner + 1);
                            index++;
                        }
                    }
                }
            }
        }
        return pairs;
    }

    static void createSameDescSortedFile(File file){
        if(file.canRead()){
            MergeSort algorithm = new MergeSort();
            String []text = readFile(file);
            String []sortedText = algorithm.sortDesc(text);
            File sortedFile = new File(file.getName().split("[.]")[0] + "-sorted-desc.txt");
            try {
                sortedFile.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            writeFile(sortedFile, sortedText);
        }
    }

    static void createSameAscSortedFile(File file){
        if(file.canRead()){
            MergeSort algorithm = new MergeSort();
            String []text = readFile(file);
            String []sortedText = algorithm.sortAsc(text);
            File sortedFile = new File(file.getName().split("[.]")[0] + "-sorted-asc.txt");
            try {
                sortedFile.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            writeFile(sortedFile, sortedText);
        }
    }

    static void substituteFileWith(String filename, String word, String substitution){
        boolean newFileNeeded = false;
        if(new File(filename).exists()){
            List<String> lines = Arrays.asList(readFile(new File(filename)));
            for(String line : lines){
                String []words = line.split("[ ]");
                for(String part : words){
                    if(part.equals(word)){
                        newFileNeeded = true;
                        break;
                    }
                }
                if(newFileNeeded){
                    break;
                }
            }
        }
        if(newFileNeeded){
            File file = new File(filename.split("[.]")[0] + "_substitution.txt");
            try {
                file.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            List<String> lines = Arrays.asList(readFile(new File(filename)));
            for(int outer = 0; outer < lines.size(); outer++){
                List<String> words = Arrays.asList(lines.get(outer).split("[ ]"));
                for(int inner = 0; inner < words.size(); inner++){
                    if(words.get(inner).equals(word)){
                        words.set(inner, substitution);
                    }
                }
                lines.set(outer, words.toString().replaceAll("[\\[,\\]]", ""));
            }

            writeFile(file, (String[]) lines.toArray());
        }
    }
}
