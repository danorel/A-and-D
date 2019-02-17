package data;

public class DataGenerator {
    static public Integer[] generateRandomData(Integer amount){
        Integer []Array = new Integer[amount];
        for(int index = 0; index < amount; index++){
            Array[index] = (int)(Math.random() * Integer.MAX_VALUE);
        }
        return Array;
    }

    static public Integer[] generateSortedData(Integer amount){
        Integer []Array = new Integer[amount];
        for(int index = 0; index < amount; index++){
            Array[index] = index;
        }
        return Array;
    }

    static public Integer[] generateUnsortedData(Integer amount){
        Integer []Array = new Integer[amount];
        for(int index = 0, value = amount; index < amount; index++, value--){
            Array[index] = value;
        }
        return Array;
    }

    static public Integer[] generateSameData(Integer amount){
        Integer []Array = new Integer[amount];
        for(int index = 0, value = amount; index < amount; index++, value--){
            Array[index] = 0;
        }
        return Array;
    }
}
