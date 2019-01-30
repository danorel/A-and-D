public class Sorter<T extends Comparable> implements SorterGenerator {
    private T[] Array;

    public Sorter bubbleSort(){
        for(int iIndex = 0; iIndex < Array.length; iIndex++){
            for(int jIndex = 0; jIndex < Array.length - 1; jIndex++){
                if(isLess(Array[jIndex + 1], Array[jIndex])){
                    exchange(Array, jIndex + 1, jIndex);
                }
            }
        }
        return this;
    }

    public Sorter selectionSort(){
        Comparable min = Array[0];
        boolean isChanged = false;
        int current_index = 0;
        for(int current = 0; current < Array.length; current++){
            for(int index = current; index < Array.length; index++){
                if(isLess(Array[index], min)){
                    min = Array[index];
                    current_index = index;
                    isChanged = true;
                }
            }
            if(isChanged){
                exchange(Array, current_index, current);
                isChanged = false;
            }
            if(current != Array.length - 1){
                min = Array[current + 1];
            }
        }
        return this;
    }

    public Sorter showArray(){
        for(int index = 0; index < Array.length; index++){
            System.out.print(this.Array[index] + " ");
        }
        return this;
    }

    public Sorter setArray(T[] array) {
        Array = array;
        return this;
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
