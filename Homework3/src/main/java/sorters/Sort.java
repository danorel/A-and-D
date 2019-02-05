package sorters;

import java.util.Comparator;

public interface Sort<T extends Comparable>{
    void sort(T []Array);
    void sort(T []Array, Comparator comparator);
    void sort(T []Array, Comparator comparator, String order);
}
