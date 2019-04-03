package generator;

public class DataGenerator{
    public <E extends Number> E[] generateRandomData(int amount){
        Number []Array = new Number[amount];
        for(int index = 0; index < amount; index++){
            Array[index] = (int)(Math.random() * Short.MAX_VALUE);
        }
        return (E[]) Array;
    }

    public static Integer[] generateIntegerRandomData(int amount){
        Integer []Array = new Integer[amount];
        for(int index = 0; index < amount; index++){
            Array[index] = (int)(Math.random() * Integer.MAX_VALUE);
        }
        return Array;
    }

    public static Double[] generateDoubleRandomData(int amount){
        Double []Array = new Double[amount];
        for(int index = 0; index < amount; index++){
            Array[index] = (Math.random() * Double.MAX_VALUE);
        }
        return Array;
    }
}
