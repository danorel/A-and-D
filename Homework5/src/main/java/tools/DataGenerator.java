package tools;
/*
    Data generator - the input of the main function is the
    amount of data to generate, the output - the array of such data.
    Just a way to fill the file content with numbers.
 */
public interface DataGenerator {
    static Integer[] generateRandomData(int amount){
        Integer[] Array = new Integer[amount];
        for(int index = 0; index < Array.length; index++){
            Array[index] = (int)(Math.random() * 100);
        }
        return Array;
    }
}
