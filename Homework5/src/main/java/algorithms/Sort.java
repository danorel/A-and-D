package algorithms;

import java.util.Comparator;

public interface Sort<T extends Comparable>{
    T[] sort(T[] Array);
    T[] sort(T[] Array, Comparator comparator);
}
