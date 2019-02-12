package data;

public class DataGenerator {
    static public Integer[] generate(Integer amount){
        Integer []Array = new Integer[amount];
        for(int index = 0; index < amount; index++){
            Array[index] = (int)(Math.random() * 100);
        }
        return Array;
    }
}
