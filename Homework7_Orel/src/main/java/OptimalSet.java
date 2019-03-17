import lists.DoublyLinkedList;

import java.util.Objects;

public class OptimalSet<T extends Comparable>{
    private DoublyLinkedList<T> list;
    private String title;

    public OptimalSet(String title){
        this.title = title;
        list = new DoublyLinkedList<>();
    }

    public void insert(T variable, OptimalSet A){
        if(!member(variable, A)){
            A.getSet().add(variable);
            A.getSet().restructureList();
        }
    }

    public void union(OptimalSet A, OptimalSet B, OptimalSet C){
        T[] ArrayFromSetA = (T[]) A.getSet().getArrayFromList();
        T[] ArrayFromSetB = (T[]) B.getSet().getArrayFromList();
        for(int index = 0; index < ArrayFromSetA.length; index++){
            C.getSet().add(ArrayFromSetA[index]);
        }
        for(int index = 0; index < ArrayFromSetA.length; index++){
            if(!member(ArrayFromSetB[index], C)){
                C.getSet().add(ArrayFromSetB[index]);
            }
        }
        C.getSet().restructureList();
    }

    public void intersection(OptimalSet A, OptimalSet B, OptimalSet C){
        T[] ArrayFromSetA = (T[]) A.getSet().getArrayFromList();
        T[] ArrayFromSetB = (T[]) B.getSet().getArrayFromList();
        for(int index = 0; index < ArrayFromSetA.length; index++){
            if(member(ArrayFromSetA[index], B)){
                C.getSet().add(ArrayFromSetA[index]);
            }
        }
        for(int index = 0; index < ArrayFromSetA.length; index++){
            if(member(ArrayFromSetB[index], A) && !member(ArrayFromSetB[index], C)){
                C.getSet().add(ArrayFromSetB[index]);
            }
        }
        C.getSet().restructureList();
    }


    public void difference(OptimalSet A, OptimalSet B, OptimalSet C){
        T[] ArrayFromSetA = (T[]) A.getSet().getArrayFromList();
        T[] ArrayFromSetB = (T[]) B.getSet().getArrayFromList();
        for(int index = 0; index < ArrayFromSetA.length; index++){
            if(!member(ArrayFromSetA[index], B)){
                C.getSet().add(ArrayFromSetA[index]);
            }
        }
        C.getSet().restructureList();
    }

    public void merge(OptimalSet A, OptimalSet B, OptimalSet C){
        boolean isIntersected = false;
        T[] ArrayFromSetA = (T[]) A.getSet().getArrayFromList();
        T[] ArrayFromSetB = (T[]) B.getSet().getArrayFromList();
        for(int index = 0; index < ArrayFromSetA.length; index++){
            if(member(ArrayFromSetA[index], B)){
                isIntersected = true;
                break;
            }
        }
        if(!isIntersected){
            union(A, B, C);
            C.getSet().restructureList();
        }
    }

    public void makeNull(OptimalSet A){
        A.getSet().removeDoublyLinkedList();
    }

    public boolean member(Comparable variable, OptimalSet A){
        T[] ArrayFromSet = (T[]) A.getSet().getArrayFromList();
        for(int index = 0; index < ArrayFromSet.length; index++){
            if(ArrayFromSet[index].compareTo(variable) == 0){
                return true;
            }
        }
        return false;
    }


    public boolean delete(Comparable variable, OptimalSet A){
        if(member(variable, A)) {
            A.getSet().removeNodeWithKey(variable);
            A.getSet().restructureList();
            return true;
        } else {
            return false;
        }
    }

    public void assign(OptimalSet A, OptimalSet B){
        makeNull(A);
        A.union(B, B, A);
        A.getSet().restructureList();
    }

    public Comparable min(OptimalSet A){
        T[] ArrayFromSet = (T[]) A.getSet().getArrayFromList();
        Comparable min = ArrayFromSet.length != 0 ? ArrayFromSet[0] : null;
        for(int index = 0; index < ArrayFromSet.length; index++){
            if(ArrayFromSet[index].compareTo(min) < 0){
                min = ArrayFromSet[index];
            }
        }
        return Objects.requireNonNull(min);
    }

    public Comparable max(OptimalSet A){
        T[] ArrayFromSet = (T[]) A.getSet().getArrayFromList();
        Comparable max = ArrayFromSet.length != 0 ? ArrayFromSet[0] : null;
        for(int index = 0; index < ArrayFromSet.length; index++){
            if(ArrayFromSet[index].compareTo(max) > 0){
                max = ArrayFromSet[index];
            }
        }
        return Objects.requireNonNull(max);
    }

    public boolean equal(OptimalSet A, OptimalSet B){
        boolean isEqual = true;
        if(A.getSet().size() != B.getSet().size()){
            isEqual = false;
        } else {
            T[] ArrayFromSetA = (T[]) A.getSet().getArrayFromList();
            T[] ArrayFromSetB = (T[]) B.getSet().getArrayFromList();
            for(int index = 0; index < ArrayFromSetA.length; index++){
                if(member(ArrayFromSetA[index], A) && !member(ArrayFromSetA[index], B)){
                    isEqual = false;
                }
            }
        }
        return isEqual;
    }

    private int getAmountIn(OptimalSet A){
        return A.getSet().size();
    }

    public String find(OptimalSet[]sets, Comparable variable){
        boolean isIntersected = false;
        for(int outer = 0; outer < sets.length; outer++){
            T[] ArrayFromSetA = (T[]) sets[outer].getSet().getArrayFromList();
            for(int inner = 0; inner < sets.length; inner++){
                if(outer != inner){
                    for(int index = 0; index < ArrayFromSetA.length; index++){
                        if(member(ArrayFromSetA[index], sets[outer]) && member(ArrayFromSetA[index], sets[inner])){
                            isIntersected = true;
                            break;
                        }
                    }
                }
                if(isIntersected){
                    break;
                }
            }
            if(isIntersected){
                break;
            }
        }
        if(!isIntersected){
            for(int outer = 0; outer < sets.length; outer++){
                if(member(variable, sets[outer])){
                    return sets[outer].toString();
                }
            }
        }
        return "None";
    }

    public String showSetVariables(OptimalSet A){
        T[] ArrayFromSetA = (T[]) A.getSet().getArrayFromList();
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        for(int index = 0; index < ArrayFromSetA.length; index++){
            builder.append(ArrayFromSetA[index]).append(" ");
        }
        builder.append(" }");
        return builder.toString();
    }

    public T[] getValuesSet(OptimalSet A){
        return (T[]) A.getSet().getArrayFromList();
    }

    public DoublyLinkedList getSet() {
        return list;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
