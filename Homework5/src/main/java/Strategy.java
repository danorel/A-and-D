import algorithms.Sort;

import java.util.Comparator;

public class Strategy<T extends Comparable> {
    private Sort sortStrategy;

    /*
        Звичайне сортування елементів масиву без використанням компаратора
     */
    public T[] sortArray(T []Array){
        return (T[]) sortStrategy.sort(Array);
    }

    /*
        Сортування елементів масиву за певною властивістю з використанням компаратора
     */
    public T[] sortArray(T []Array, Comparator comparator) { return (T[]) sortStrategy.sort(Array, comparator);}

    /*
        Встановлення стратегії сортування (бульбашкове, гребінцем, тощо)
     */
    public Strategy setSortStrategy(Sort sortStrategy) {
        this.sortStrategy = sortStrategy;
        return this;
    }
}
