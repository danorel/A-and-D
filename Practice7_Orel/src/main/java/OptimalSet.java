public class OptimalSet {
    private Boolean[] set;
    private String title;

    public OptimalSet(String title){
        this.title = title;
        set = new Boolean[100];
        for(int index = 0; index < set.length; index++){
            set[index] = false;
        }
    }

    public void insert(Integer x, OptimalSet A){
        if(!member(x, A)){
            A.getSet()[x] = true;
        }
    }

    public void union(OptimalSet A, OptimalSet B, OptimalSet C){
        for(int index = 0; index < A.getSet().length; index++){
            if(member(index, A) || member(index, B)){
                C.insert(index, C);
            }
        }
    }

    public void intersection(OptimalSet A, OptimalSet B, OptimalSet C){
        for(int index = 0; index < A.getSet().length; index++){
            if(member(index, A) && member(index, B)){
                C.insert(index, C);
            }
        }
    }

    public void difference(OptimalSet A, OptimalSet B, OptimalSet C){

        for(int index = 0; index < A.getSet().length; index++){
            if(member(index, A) && !member(index, B)){
                C.insert(index, C);
            }
        }
    }

    public void merge(OptimalSet A, OptimalSet B, OptimalSet C){
        boolean isIntersected = false;
        for(int index = 0; index < A.getSet().length; index++){
            if(member(index, A) && member(index, B)){
                isIntersected = true;
                break;
            }
        }
        if(!isIntersected){
            union(A, B, C);
        }
    }

    public void makeNull(OptimalSet A){
        for(int index = 0; index < A.getSet().length; index++){
            A.getSet()[index] = false;
        }
    }

    public boolean member(Integer variable, OptimalSet A){
        return A.getSet()[variable];
    }

    public boolean delete(Integer variable, OptimalSet A){
        if(member(variable, A)) {
            A.getSet()[variable] = false;
            return true;
        } else {
            return false;
        }
    }

    public void assign(OptimalSet A, OptimalSet B){
        makeNull(A);
        for(int index = 0; index < A.getSet().length; index++){
            if(member(index, B)){
                A.insert(index, A);
            }
        }
    }

    public Integer min(OptimalSet A){
        for(int index = 0; index < A.getSet().length; index++){
            if(member(index, A)){
                return index;
            }
        }
        return -1;
    }

    public Integer max(OptimalSet A){
        for(int index = A.getSet().length - 1; index > -1; index--){
            if(member(index, A)){
                return index;
            }
        }
        return -1;
    }

    public boolean equal(OptimalSet A, OptimalSet B){
        boolean isEqual = true;
        if(getAmountIn(A) != getAmountIn(B)){
            isEqual = false;
        } else {
            for(int index = 0; index < A.getSet().length; index++ ){
                if((member(index, A) && !member(index, B)) ||(!member(index, A) && member(index, B))){
                    isEqual = false;
                    break;
                }
            }
        }
        return isEqual;
    }

    private int getAmountIn(OptimalSet A){
        int amount = 0;
        for(int index = 0; index < A.getSet().length; index++){
            if(A.member(index, A)){
                amount++;
            }
        }
        return amount;
    }

    public String find(OptimalSet []sets, Integer x){
        boolean isIntersected = false;
        for(int outer = 0; outer < sets.length; outer++){
            for(int inner = 0; inner < sets.length; inner++){
                if(outer != inner){
                    for(int index = 0; index < sets[inner].getSet().length; index++){
                        if(member(index, sets[outer]) && member(index, sets[inner])){
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
                if(member(x, sets[outer])){
                    return sets[outer].toString();
                }
            }
        }
        return null;
    }

    public String showSetVariables(OptimalSet A){
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        for(int index = 0; index < A.getSet().length; index++){
            if(member(index, A)){
                builder.append(index).append(" ");
            }
        }
        builder.append(" }");
        return builder.toString();
    }

    public Integer[] getIntegerSet(OptimalSet A){
        Integer[] integers = new Integer[getSetLength(A)];
        int pointer = 0;
        for(int index = 0; index < getSet().length; index++){
            if(member(index, A)){
                integers[pointer++] = index;
            }
        }
        return integers;
    }

    public Integer getSetLength(OptimalSet A){
        int counter = 0;
        for(int index = 0; index < getSet().length; index++){
            if(member(index, A)){
                counter++;
            }
        }
        return counter;
    }

    public Boolean[] getSet() {
        return set;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
