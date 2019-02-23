package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    A way to transform the file content (string numbers in the file)
    into the array of integers
*/
public interface StringToIntegerConverter {
    static Integer[] convert(String content){
        List<String> strNumbers = Arrays.asList(content.split("\n"));
        List<Integer> intNumbers = new ArrayList<>();
        Integer []Array = new Integer[strNumbers.size()];
        for(String number : strNumbers){
            intNumbers.add(Integer.valueOf(number));
        }
        for(int index = 0; index < intNumbers.size(); index++){
            Array[index] = intNumbers.get(index);
        }
        return Array;
    }
}
