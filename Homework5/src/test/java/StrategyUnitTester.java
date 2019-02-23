import algorithms.*;
import algorithms.merge.ComparedMergeSort;
import algorithms.merge.DefaultMergeSort;
import algorithms.merge.InsertionMergeSort;
import algorithms.merge.MixedMergeSort;
import algorithms.quick.DefaultQuickSort;
import algorithms.quick.DijkstraQuickSort;
import algorithms.quick.InsertionQuickSort;
import algorithms.quick.MixedQuickSort;
import books.Book;
import books.comparators.BookAuthorComparator;
import books.comparators.BookPageComparator;
import books.comparators.BookPriceComparator;
import books.comparators.BookTitleComparator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.Assert.*;

public class StrategyUnitTester {
    private Book []books;
    private Strategy<Book> strategy;
    private ArrayList<SortAbility> sortContainer;
    private ArrayList<Comparator> sortComparators;

    @Before
    public void setUp() throws Exception {
        sortContainer = new ArrayList<>();
        sortContainer.add(new BubbleSort());
        sortContainer.add(new CombSort());
        sortContainer.add(new HeapSort());
        sortContainer.add(new InsertionSort());
        sortContainer.add(new SelectionSort());
        sortContainer.add(new ShellSort());
        sortContainer.add(new DefaultQuickSort());
        sortContainer.add(new DijkstraQuickSort());
        sortContainer.add(new InsertionQuickSort());
        sortContainer.add(new MixedQuickSort());
        sortContainer.add(new ComparedMergeSort());
        sortContainer.add(new DefaultMergeSort());
        sortContainer.add(new InsertionMergeSort());
        sortContainer.add(new MixedMergeSort());

        sortComparators = new ArrayList<>();
        sortComparators.add(new BookTitleComparator());
        sortComparators.add(new BookAuthorComparator());
        sortComparators.add(new BookPriceComparator());
        sortComparators.add(new BookPageComparator());

        this.strategy = new Strategy();
        strategy.setSortStrategy(new InsertionSort());

        books = new Book[5];
        books[0] = new Book("E", "K", 7, 99.99);
        books[1] = new Book("A", "J", 17, 5.99);
        books[2] = new Book("P", "Q", 5, 11.99);
        books[3] = new Book("O", "H", 14, 99.99);
        books[4] = new Book("J", "R", 2, 8.99);
    }

    @Test
    public void sort() {
        for(SortAbility sort : sortContainer){
            strategy.setSortStrategy(sort);
            for(Comparator comparator : sortComparators){
                Assert.assertEquals(new Strategy<Book>().setSortStrategy(sort).sort(books, comparator), strategy.sort(books, comparator));
            }
        }
    }

    @Test
    public void setSortStrategy() {
        for(SortAbility sort : sortContainer){
            strategy.setSortStrategy(sort);
        }
    }
}