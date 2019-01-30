public class Sorter<T extends Comparable> implements SorterGenerator {
    private T []Array;

    public void setArray(T[] array) {
        Array = array;
    }

    public void insertionSort(){
        for(int index = 1; index < Array.length; index++){
            int iteration = index;
            for(int counter = index - 1; counter > -1; counter--){
                if(isLess(Array[iteration], (Array[counter]))){
                    exchange(Array, iteration, counter);
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
                if(isLess(Array[innerIndex + (int)distance], Array[innerIndex])){
                    exchange(Array, innerIndex, innerIndex + (int)distance);
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
                    if(isLess(temp, Array[innerIndex - distance])){
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

    public void showArray(){
        for(int index = 0; index < Array.length; index++){
            System.out.print(Array[index] + " ");
        }
    }

    private int getShellSortCoefficient(int coefficient){
        return coefficient / 2;
    }

    private boolean isLess(Comparable first, Comparable second){
        return first.compareTo(second) < 0;
    }

    private void exchange(Comparable []Array, int fPos, int sPos){
        Comparable temp = Array[fPos];
        Array[fPos] = Array[sPos];
        Array[sPos] = temp;
    }
}


