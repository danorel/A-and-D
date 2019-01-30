public class Sorter<T extends Number> {
    private T[] Array;

    public void bubbleSort(){
        for(int iIndex = 0; iIndex < Array.length; iIndex++){
            for(int jIndex = 0; jIndex < Array.length - 1; jIndex++){
                if(Array[jIndex].doubleValue() > Array[jIndex + 1].doubleValue()){
                    Number temp = Array[jIndex].doubleValue();
                    Array[jIndex] = Array[jIndex + 1];
                    Array[jIndex + 1] = (T) temp;
                }
            }
        }
    }

    public void selectionSort(){
        Number min = Double.MAX_VALUE;
        int current_index = 0;
        for(int current = 0; current < Array.length; current++){
            for(int index = current; index < Array.length; index++){
                if(Array[index].doubleValue() < min.doubleValue()){
                    min = Array[index].doubleValue();
                    current_index = index;
                }
            }
            Number temp = Array[current_index];
            Array[current_index] = Array[current];
            Array[current] = (T) temp;
            min = Double.MAX_VALUE;
        }
    }

    public void showArray(){
        for(int iIndex = 0; iIndex < Array.length; iIndex++){
            System.out.print(this.Array[iIndex] + " ");
        }
    }

    public void setArray(T[] array) {
        Array = array;
    }
}
