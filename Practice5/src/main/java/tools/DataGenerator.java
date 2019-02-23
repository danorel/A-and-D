package tools;

public interface DataGenerator {
    static Integer[] generateRandomData(int amount){
        Integer[] Array = new Integer[amount];
        for(int index = 0; index < Array.length; index++){
            Array[index] = (int)(Math.random() * 100);
        }
        return Array;
    }
}
