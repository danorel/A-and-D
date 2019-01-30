public class Sorter<T extends Number> implements SorterGenerator {
    private T []Array;

    public void setArray(T[] array) {
        Array = array;
    }

    public void insertionSort(){
        for(int index = 1; index < Array.length; index++){
            int iteration = index;
            for(int counter = index - 1; counter > -1; counter--){
                if(Array[iteration].doubleValue() < Array[counter].doubleValue()){
                    T temp = Array[iteration];
                    Array[iteration] = Array[counter];
                    Array[counter] = temp;
                    iteration--;
                } else {
                    break;
                }
            }
        }
    }

    public void brushSort(){
        double distance = 0;
        double coefficient = 1.247330950103979;
        distance = (int) (Array.length / coefficient);
        do{
            for(int innerIndex = 0; innerIndex + distance < Array.length; innerIndex++) {
                if(Array[innerIndex + (int)distance].doubleValue() < Array[innerIndex].doubleValue()){
                    T temp = Array[innerIndex];
                    Array[innerIndex] = Array[innerIndex + (int)distance];
                    Array[innerIndex + (int)distance] = temp;
                }
            }
            distance = (distance / coefficient);
        } while(distance > 1);
    }

    public void ShellSort(){
        int outerIndex, innerIndex;
        int distance = Array.length / 2;
        while(distance > 0){
            for(outerIndex = distance; outerIndex < Array.length; outerIndex++){
                T temp = Array[outerIndex];
                for(innerIndex = outerIndex; innerIndex >= distance; innerIndex -= distance){
                    if(temp.doubleValue() < Array[innerIndex - distance].doubleValue()){
                        Array[innerIndex] = Array[innerIndex - distance];
                    } else {
                        break;
                    }
                }
                Array[innerIndex] = temp;
            }
            distance = getShellSortCoefficient(distance);
        }
    }

    private int getShellSortCoefficient(int coefficient){
        return coefficient / 2;
    }

    public void showArray(){
        for(int index = 0; index < Array.length; index++){
            System.out.print(Array[index].doubleValue() + " ");
        }
    }
}


